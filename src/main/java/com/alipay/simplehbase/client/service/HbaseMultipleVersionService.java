package com.alipay.simplehbase.client.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOResult;
import com.alipay.simplehbase.core.Nullable;

/**
 * HbaseMultipleVersionService
 * 
 * <pre>
 * Provides hbase multiple version related service.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface HbaseMultipleVersionService {

    /**
     * Put POJO with timestamp.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * @param timestamp timestamp.
     * */
    public <T> void putObjectMV(RowKey rowKey, T t, long timestamp);

    /**
     * Put POJO with timestamp.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * @param timestamp timestamp.
     * */
    public <T> void putObjectMV(RowKey rowKey, T t, Date timestamp);

    /**
     * Put POJO list with specified timestamp.
     * 
     * @param putRequestList putRequestList.
     * @param timestamp timestamp.
     * */
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList,
            long timestamp);

    /**
     * Put POJO list with specified timestamp.
     * 
     * @param putRequestList putRequestList.
     * @param timestamp timestamp.
     * */
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList,
            Date timestamp);

    /**
     * Put list of POJO with its timestamp.
     * 
     * @param putRequestList putRequestList.
     * */
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList);

    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return SimpleHbaseDOResult list, timestamp desc ordered.
     * */
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return SimpleHbaseDOResult list, timestamp desc ordered.
     * */
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return SimpleHbaseDOResult list of list, sub list is timestamp desc
     *         ordered.
     * */
    public <T> List<List<SimpleHbaseDOResult<T>>> findObjectListMV(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return SimpleHbaseDOResult list of list, sub list is timestamp desc
     *         ordered.
     * */
    public <T> List<List<SimpleHbaseDOResult<T>>> findObjectListMV(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, @Nullable Map<String, Object> para,
            QueryExtInfo queryExtInfo);

}
