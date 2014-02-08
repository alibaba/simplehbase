package com.alipay.simplehbase.client;

import com.alipay.simplehbase.config.HBaseDataSource;

/**
 * HBaseDataSourceAware
 * 
 * <pre>
 * Client can obtian the HTableInterface from this interface.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface HBaseDataSourceAware {

    public HBaseDataSource getHbaseDataSource();

    public void setHbaseDataSource(HBaseDataSource hbaseDataSource);
}
