package com.alipay.simplehbase.hbase;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * SimpleHbaseHTableFactory.
 * 
 * <pre>
 * Copy from HTableFactory, but provides more functions.
 * </pre>
 * 
 * @author xinzhi.zhang
 */
public class SimpleHbaseHTableFactory implements HTableInterfaceFactory {

    private boolean         autoFlush = true;
    @Nullable
    private ExecutorService executorService;

    @Override
    public HTableInterface createHTableInterface(Configuration config,
            byte[] tableName) {
        try {
            HTable htable = null;
            if (executorService == null) {
                htable = new HTable(config, tableName);
            } else {
                htable = new HTable(config, tableName, executorService);
            }
            htable.setAutoFlush(autoFlush);
            return htable;
        } catch (IOException ioe) {
            throw new SimpleHBaseException(ioe);
        }
    }

    @Override
    public void releaseHTableInterface(HTableInterface table)
            throws IOException {
        table.close();
    }

    public boolean isAutoFlush() {
        return autoFlush;
    }

    public void setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }
}