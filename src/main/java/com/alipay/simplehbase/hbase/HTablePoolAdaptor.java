package com.alipay.simplehbase.hbase;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * HTablePoolAdaptor.
 * 
 * <pre>
 * Adapt HTablePool to HTablePoolService.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public class HTablePoolAdaptor implements HTablePoolService {

    private HTablePool hTablePool;

    public HTablePoolAdaptor(HTablePool hTablePool) {

        Util.checkNull(hTablePool);

        this.hTablePool = hTablePool;
    }

    @Override
    public HTableInterface getTable(String tableName) {
        return hTablePool.getTable(tableName);
    }

    @Override
    public HTableInterface getTable(byte[] tableName) {
        return hTablePool.getTable(tableName);
    }

    @Override
    public void close() {
        try {
            hTablePool.close();
        } catch (IOException e) {
            throw new SimpleHBaseException(e);
        }
    }
}
