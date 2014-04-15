package com.alipay.simplehbase.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableFactory;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;
import org.apache.hadoop.hbase.client.Increment;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.RowLock;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.PoolMap;
import org.apache.hadoop.hbase.util.PoolMap.PoolType;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseHTablePool.
 * 
 * <pre>
 * Copy from HTablePool, but provides other functions.
 * </pre>
 * 
 * @author xinzhi.zhang
 */
public class SimpleHbaseHTablePool implements HTablePoolService {

    /** log. */
    private static Logger                    log          = Logger.getLogger(SimpleHbaseHTablePool.class);

    private Configuration                    config;

    private int                              maxSize;
    private HTableInterfaceFactory           tableFactory = new HTableFactory();
    //only allow Reusable so far.
    final private PoolType                   poolType     = PoolType.Reusable;

    private PoolMap<String, HTableInterface> tables;

    /**
     * Flush interval when auto flush is false.
     * 
     * <pre>
     * measured in ms.
     * <= 0 means no flush triggered by pool.
     * </pre>
     * */
    private long                             flushInterval;

    private volatile boolean                 closed       = false;

    /**
     * Constructor SimpleHbaseHTablePool.
     * 
     * @param config configuration
     * @param maxSize maximum number of references to keep for each table
     * @param tableFactory table factory
     * @param flushInterval flushInterval
     */
    public SimpleHbaseHTablePool(final Configuration config, int maxSize,
            @Nullable final HTableInterfaceFactory tableFactory,
            long flushInterval) {

        Util.checkNull(config);

        this.config = config;
        this.maxSize = maxSize;
        if (tableFactory != null) {
            this.tableFactory = tableFactory;
        }

        this.tables = new PoolMap<String, HTableInterface>(this.poolType,
                this.maxSize);

        this.flushInterval = flushInterval;

        if (this.flushInterval > 0) {
            Thread flushThread = new FlushThread();
            flushThread.setName("FlushThread");
            flushThread.setDaemon(true);
            flushThread.start();
        }
    }

    private class FlushThread extends Thread {

        @Override
        public void run() {

            log.info("start flush thread.");

            while (true) {
                try {
                    Thread.sleep(flushInterval);

                    if (closed) {
                        break;
                    }

                    for (String tableName : tables.keySet()) {

                        long startTime = System.currentTimeMillis();

                        List<HTableInterface> temTables = new ArrayList<HTableInterface>();

                        for (HTableInterface table = tables.get(tableName); table != null; table = tables
                                .get(tableName)) {
                            temTables.add(table);
                        }

                        for (HTableInterface temTable : temTables) {
                            temTable.flushCommits();
                            tables.put(tableName, temTable);
                        }

                        temTables.clear();

                        long endTime = System.currentTimeMillis();
                        log.warn("flush thread tableName = " + tableName
                                + " time = " + (endTime - startTime) + "ms.");

                    }

                } catch (Throwable e) {
                    log.warn("flush thread warn.", e);
                }
            }

            log.info("end flush thread.");

        }
    }

    @Override
    public HTableInterface getTable(String tableName) {
        if (closed) {
            throw new SimpleHBaseException("pool is closed.");
        }

        // call the old getTable implementation renamed to findOrCreateTable
        HTableInterface table = findOrCreateTable(tableName);
        // return a proxy table so when user closes the proxy, the actual table
        // will be returned to the pool
        try {
            return new PooledHTable(table);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    public HTableInterface getTable(byte[] tableName) {
        if (closed) {
            throw new SimpleHBaseException("pool is closed.");
        }

        return getTable(Bytes.toString(tableName));
    }

    @Override
    public void close() {
        if (closed) {
            return;
        }

        closed = true;

        try {
            for (String tableName : tables.keySet()) {
                closeTablePool(tableName);
            }
            this.tables.clear();
        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * Get a reference to the specified table from the pool.
     * <p>
     * 
     * Create a new one if one is not available.
     * 
     * @param tableName table name
     * @return a reference to the specified table
     * @throws RuntimeException if there is a problem instantiating the HTable
     */
    private HTableInterface findOrCreateTable(String tableName) {
        HTableInterface table = tables.get(tableName);
        if (table == null) {
            table = createHTable(tableName);
        }
        return table;
    }

    /**
     * Puts the specified HTable back into the pool.
     * <p>
     * 
     * If the pool already contains <i>maxSize</i> references to the table, then
     * the table instance gets closed after flushing buffered edits.
     * 
     * @param table table
     */
    private void returnTable(HTableInterface table) throws IOException {
        // this is the old putTable method renamed and made private
        String tableName = Bytes.toString(table.getTableName());

        if (closed) {
            this.tables.remove(tableName, table);
            this.tableFactory.releaseHTableInterface(table);
            return;
        }

        if (tables.size(tableName) >= maxSize) {
            // release table instance since we're not reusing it
            this.tables.remove(tableName, table);
            this.tableFactory.releaseHTableInterface(table);
            return;
        }
        tables.put(tableName, table);
    }

    private HTableInterface createHTable(String tableName) {
        return this.tableFactory.createHTableInterface(config,
                Bytes.toBytes(tableName));
    }

    /**
     * Closes all the HTable instances , belonging to the given table, in the
     * table pool.
     * <p>
     * Note: this is a 'shutdown' of the given table pool and different from
     * {@link #putTable(HTableInterface)}, that is used to return the table
     * instance to the pool for future re-use.
     * 
     * @param tableName
     */
    private void closeTablePool(final String tableName) throws IOException {
        Collection<HTableInterface> tables = this.tables.values(tableName);
        if (tables != null) {
            for (HTableInterface table : tables) {
                this.tableFactory.releaseHTableInterface(table);
            }
        }
        this.tables.remove(tableName);
    }

    /**
     * A proxy class that implements HTableInterface.close method to return the
     * wrapped table back to the table pool
     * 
     */
    class PooledHTable extends HTable {

        private HTableInterface table; // actual table implementation

        public PooledHTable(HTableInterface table) throws IOException {
            super(table.getConfiguration(), table.getTableName());
            this.table = table;
        }

        @Override
        public byte[] getTableName() {
            return table.getTableName();
        }

        @Override
        public Configuration getConfiguration() {
            return table.getConfiguration();
        }

        @Override
        public HTableDescriptor getTableDescriptor() throws IOException {
            return table.getTableDescriptor();
        }

        @Override
        public boolean exists(Get get) throws IOException {
            return table.exists(get);
        }

        @Override
        public void batch(List<? extends Row> actions, Object[] results)
                throws IOException, InterruptedException {
            table.batch(actions, results);
        }

        @Override
        public Object[] batch(List<? extends Row> actions) throws IOException,
                InterruptedException {
            return table.batch(actions);
        }

        @Override
        public Result get(Get get) throws IOException {
            return table.get(get);
        }

        @Override
        public Result[] get(List<Get> gets) throws IOException {
            return table.get(gets);
        }

        @Override
        public Result getRowOrBefore(byte[] row, byte[] family)
                throws IOException {
            return table.getRowOrBefore(row, family);
        }

        @Override
        public ResultScanner getScanner(Scan scan) throws IOException {
            return table.getScanner(scan);
        }

        @Override
        public ResultScanner getScanner(byte[] family) throws IOException {
            return table.getScanner(family);
        }

        @Override
        public ResultScanner getScanner(byte[] family, byte[] qualifier)
                throws IOException {
            return table.getScanner(family, qualifier);
        }

        @Override
        public void put(Put put) throws IOException {
            table.put(put);
        }

        @Override
        public void put(List<Put> puts) throws IOException {
            table.put(puts);
        }

        @Override
        public boolean checkAndPut(byte[] row, byte[] family, byte[] qualifier,
                byte[] value, Put put) throws IOException {
            return table.checkAndPut(row, family, qualifier, value, put);
        }

        @Override
        public void delete(Delete delete) throws IOException {
            table.delete(delete);
        }

        @Override
        public void delete(List<Delete> deletes) throws IOException {
            table.delete(deletes);
        }

        @Override
        public boolean checkAndDelete(byte[] row, byte[] family,
                byte[] qualifier, byte[] value, Delete delete)
                throws IOException {
            return table.checkAndDelete(row, family, qualifier, value, delete);
        }

        @Override
        public Result increment(Increment increment) throws IOException {
            return table.increment(increment);
        }

        @Override
        public long incrementColumnValue(byte[] row, byte[] family,
                byte[] qualifier, long amount) throws IOException {
            return table.incrementColumnValue(row, family, qualifier, amount);
        }

        @Override
        public long incrementColumnValue(byte[] row, byte[] family,
                byte[] qualifier, long amount, boolean writeToWAL)
                throws IOException {
            return table.incrementColumnValue(row, family, qualifier, amount,
                    writeToWAL);
        }

        @Override
        public boolean isAutoFlush() {
            return table.isAutoFlush();
        }

        @Override
        public void flushCommits() throws IOException {
            table.flushCommits();
        }

        /**
         * Returns the actual table back to the pool
         * 
         * @throws IOException
         */
        public void close() throws IOException {
            returnTable(table);
        }

        @Override
        public RowLock lockRow(byte[] row) throws IOException {
            return table.lockRow(row);
        }

        @Override
        public void unlockRow(RowLock rl) throws IOException {
            table.unlockRow(rl);
        }

        @Override
        public <T extends CoprocessorProtocol> T coprocessorProxy(
                Class<T> protocol, byte[] row) {
            return table.coprocessorProxy(protocol, row);
        }

        @Override
        public <T extends CoprocessorProtocol, R> Map<byte[], R> coprocessorExec(
                Class<T> protocol, byte[] startKey, byte[] endKey,
                Batch.Call<T, R> callable) throws IOException, Throwable {
            return table.coprocessorExec(protocol, startKey, endKey, callable);
        }

        @Override
        public <T extends CoprocessorProtocol, R> void coprocessorExec(
                Class<T> protocol, byte[] startKey, byte[] endKey,
                Batch.Call<T, R> callable, Batch.Callback<R> callback)
                throws IOException, Throwable {
            table.coprocessorExec(protocol, startKey, endKey, callable,
                    callback);
        }

        @Override
        public String toString() {
            return "PooledHTable{" + ", table=" + table + '}';
        }

        /**
         * Expose the wrapped HTable to tests in the same package
         * 
         * @return wrapped htable
         */
        HTableInterface getWrappedTable() {
            return table;
        }
    }
}
