package com.alipay.simplehbase.hbase;

import org.apache.hadoop.hbase.client.HTableInterface;

/**
 * HTablePoolService.
 * 
 * @author xinzhi.zhang
 * */
public interface HTablePoolService {

    /**
     * Get a reference to the specified table from the pool.
     * 
     * @param tableName table name
     * @return a reference to the specified table
     */
    public HTableInterface getTable(String tableName);

    /**
     * Get a reference to the specified table from the pool.
     * 
     * @param tableName table name
     * @return a reference to the specified table
     */
    public HTableInterface getTable(byte[] tableName);

    /**
     * Closes all the HTable instances , belonging to all tables in the table
     * pool.
     * <p/>
     * Note: this is a 'shutdown' of all the table pools.
     */
    public void close();
}
