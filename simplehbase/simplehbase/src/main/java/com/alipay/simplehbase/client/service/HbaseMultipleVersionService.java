package com.alipay.simplehbase.client.service;

import java.util.Date;

import com.alipay.simplehbase.client.RowKey;

/**
 * HbaseMultipleVersionService
 * 
 * <pre>
 * Provides hbase multiple version related service.
 * </pre>
 * */
public interface HbaseMultipleVersionService {

    /**
     * Put POJO with timestamp.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * @param timestamp timestamp.
     * */
    public <T> void putObject(RowKey rowKey, T t, long timestamp);

    /**
     * Put POJO with timestamp.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * @param timestamp timestamp.
     * */
    public <T> void putObject(RowKey rowKey, T t, Date timestamp);

}
