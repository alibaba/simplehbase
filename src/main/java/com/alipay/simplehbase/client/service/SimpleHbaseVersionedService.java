package com.alipay.simplehbase.client.service;

import com.alipay.simplehbase.client.RowKey;

/**
 * SimpleHbaseVersionedService.
 * 
 * <pre>
 * SimpleHbaseVersionedService can be used only on JOPO with @HBaseVersion.
 * HBase only provides put operation. 
 * This service can provide insert and update service on hbase.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface SimpleHbaseVersionedService {
    /**
     * Insert POJO.
     * 
     * <pre>
     * If POJO's version object is null(data doesn't exist), the insert operation would be success.
     * </pre>
     * 
     * @param rowKey rowKey.
     * @param t POJO
     * @return whether insert success.
     * */
    public <T> boolean insertObject(RowKey rowKey, T t);

    /**
     * Update POJO.
     * 
     * <pre>
     * oldT's version object is old version.
     * newT's version object is new version.
     * </pre>
     * 
     * @param rowKey rowKey.
     * @param oldT oldT.
     * @param newT newT.
     * @return whether update success.
     * */
    public <T> boolean updateObject(RowKey rowKey, T oldT, T newT);

    /**
     * Update POJO.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * @param oldVersion old version object.
     * @return whether update success.
     * */
    public <T> boolean updateObjectWithVersion(RowKey rowKey, T t,
            Object oldVersion);

}
