package com.alipay.simplehbase.hbase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Append;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Increment;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.RowLock;
import org.apache.hadoop.hbase.client.RowMutations;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch.Call;
import org.apache.hadoop.hbase.client.coprocessor.Batch.Callback;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * @author xinzhi.zhang
 * */
public class MockHTable implements HTableInterface {
    private String tableName;

    public MockHTable(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public byte[] getTableName() {
        return Bytes.toBytes(tableName);
    }

    @Override
    public Configuration getConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HTableDescriptor getTableDescriptor() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(Get get) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void batch(List<? extends Row> actions, Object[] results)
            throws IOException, InterruptedException {
        // TODO Auto-generated method stub

    }

    @Override
    public Object[] batch(List<? extends Row> actions) throws IOException,
            InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result get(Get get) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result[] get(List<Get> gets) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result getRowOrBefore(byte[] row, byte[] family) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultScanner getScanner(Scan scan) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultScanner getScanner(byte[] family) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultScanner getScanner(byte[] family, byte[] qualifier)
            throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void put(Put put) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void put(List<Put> puts) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean checkAndPut(byte[] row, byte[] family, byte[] qualifier,
            byte[] value, Put put) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Delete delete) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(List<Delete> deletes) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean checkAndDelete(byte[] row, byte[] family, byte[] qualifier,
            byte[] value, Delete delete) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mutateRow(RowMutations rm) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public Result append(Append append) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result increment(Increment increment) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long incrementColumnValue(byte[] row, byte[] family,
            byte[] qualifier, long amount) throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long incrementColumnValue(byte[] row, byte[] family,
            byte[] qualifier, long amount, boolean writeToWAL)
            throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isAutoFlush() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void flushCommits() throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public RowLock lockRow(byte[] row) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unlockRow(RowLock rl) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public <T extends CoprocessorProtocol> T coprocessorProxy(
            Class<T> protocol, byte[] row) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends CoprocessorProtocol, R> Map<byte[], R> coprocessorExec(
            Class<T> protocol, byte[] startKey, byte[] endKey,
            Call<T, R> callable) throws IOException, Throwable {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends CoprocessorProtocol, R> void coprocessorExec(
            Class<T> protocol, byte[] startKey, byte[] endKey,
            Call<T, R> callable, Callback<R> callback) throws IOException,
            Throwable {
        // TODO Auto-generated method stub

    }

}
