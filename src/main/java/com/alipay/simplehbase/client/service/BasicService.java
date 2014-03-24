package com.alipay.simplehbase.client.service;

import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOWithKeyResult;
import com.alipay.simplehbase.core.Nullable;

/**
 * BasicService
 * 
 * <pre>
 * Provides basic services.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface BasicService {
    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type);

    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type);

    /**
     * Find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

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
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find object and row key with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type);

    /**
     * Find object and row key with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO and row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO and row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find POJO and row key list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type);

    /**
     * Find POJO and row key list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO and row key list with range in
     * [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO and row key list with range in
     * [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, @Nullable Map<String, Object> para,
            QueryExtInfo queryExtInfo);

    /**
     * Put POJO.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * */
    public <T> void putObject(RowKey rowKey, T t);

    /**
     * Delete POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * */
    public void deleteObject(RowKey rowKey, Class<?> type);

    /**
     * Batch delete POJO list.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * 
     * */
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<?> type);

}
