package com.alipay.simplehbase.client;

import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.sun.istack.internal.Nullable;

/**
 * SimpleHbaseClient.
 * 
 * <pre>
 * A client interface which can operate on hbase.
 * </pre>
 * 
 * @author xinzhi
 * */
public interface SimpleHbaseClient {

    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type);

    /**
     * Find object with row key.
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
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param hql raw hql.
     * @param para parameter map.
     * 
     * @return POJO.
     * */
    public <T> T findObjectByRawHql(RowKey rowKey, Class<? extends T> type,
            String hql, @Nullable Map<String, Object> para);

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
     * @param startIndex result start index, 0-based.
     * @param length result size.
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, long startIndex, long length);

    /**
     * Dynamic query POJO list with range in [startRowKey,endRowKey).
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
     * Dynamic query POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param startIndex result start index, 0-based.
     * @param length result size.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, long startIndex, long length, String id,
            @Nullable Map<String, Object> para);

    /**
     * Raw query POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param hql raw hql.
     * @param para parameter map.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectListByRawHql(RowKey startRowKey,
            RowKey endRowKey, Class<? extends T> type, String hql,
            @Nullable Map<String, Object> para);

    /**
     * Raw query POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param startIndex result start index, 0-based.
     * @param length result size.
     * @param hql raw hql.
     * @param para parameter map.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectListByRawHql(RowKey startRowKey,
            RowKey endRowKey, Class<? extends T> type, long startIndex,
            long length, String hql, @Nullable Map<String, Object> para);

    /**
     * Count POJO with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * 
     * @return count result.
     * */
    public long count(RowKey startRowKey, RowKey endRowKey);

    /**
     * Dynamic query count POJO with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return count result.
     * */
    public long count(RowKey startRowKey, RowKey endRowKey, String id,
            @Nullable Map<String, Object> para);

    /**
     * Raw query count POJO with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param hql raw hql.
     * @param para parameter map.
     * 
     * @return count result.
     * */
    public long countByRawHql(RowKey startRowKey, RowKey endRowKey, String hql,
            @Nullable Map<String, Object> para);

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
     * */
    public void deleteObject(RowKey rowKey);

    /**
     * Delete POJOList.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * 
     * */
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey);

    //-----------------------Only would be applied on versioned POJO.-----------------------
    /**
     * Insert POJO.
     * 
     * <pre>
     * If POJO's version object is null(data doesn't exist), the insert operation would success.
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

    public HBaseDataSource getHBaseDataSource();

    public void setHBaseDataSource(HBaseDataSource hbaseDataSource);

    public HBaseTableConfig getHbaseTableConfig();

    public void setHbaseTableConfig(HBaseTableConfig hbaseTableConfig);

}
