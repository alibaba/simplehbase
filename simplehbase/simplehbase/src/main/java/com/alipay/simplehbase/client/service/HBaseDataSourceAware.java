package com.alipay.simplehbase.client.service;

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

    public HBaseDataSource getHBaseDataSource();

    public void setHBaseDataSource(HBaseDataSource hbaseDataSource);
}
