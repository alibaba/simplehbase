package com.alipay.simplehbase.client;

import org.apache.hadoop.hbase.HTableDescriptor;

import com.alipay.simplehbase.config.HBaseDataSource;

/**
 * SimpleHbaseAdminClient。
 * 
 * 
 * @author xinzhi
 * @version $Id: SimpleHbaseAdminClient.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface SimpleHbaseAdminClient {

    /**
     * Creates a new table. Synchronous operation.
     */
    public void createTable(HTableDescriptor tableDescriptor);

    /**
     * Deletes a table. Synchronous operation.
     */
    public void deleteTable(final String tableName);

    /**
     * 得到HBaseDataSource。
     * 
     * @return HBaseDataSource。
     * */
    public HBaseDataSource getHBaseDataSource();

    /**
     * 设置HBaseDataSource。
     * 
     * @param hbaseDataSource HBaseDataSource。
     * */
    public void setHBaseDataSource(HBaseDataSource hbaseDataSource);
}
