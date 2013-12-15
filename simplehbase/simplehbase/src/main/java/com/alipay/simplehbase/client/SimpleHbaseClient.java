package com.alipay.simplehbase.client;

import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;

/**
 * SimpleHbaseClient。
 * 
 * <pre>
 * 使用simpleHbase的client。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: SimpleHbaseClient.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface SimpleHbaseClient {

    /**
     * 查找rowKey指定的对象。
     * 
     * @param rowKey rowKey。
     * @param type POJO type。
     * @return POJO。
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type);

    /**
     * 查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type);

    /**
     * 查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @param startIndex 结果开始索引，0-based。
     * @param length 结果列表size限制。
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, long startIndex, long length);

    /**
     * 动态条件id查询，查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @param id 动态语句id。
     * @param para 参数。
     * 
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id, Map<String, Object> para);

    /**
     * 动态条件id查询，查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @param startIndex 结果开始索引，0-based。
     * @param length 结果列表size限制。
     * @param id 动态语句id。
     * @param para 参数。
     * 
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, long startIndex, long length, String id,
            Map<String, Object> para);

    /**
     * 动态条件hql查询，查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @param hql 原生hql。
     * @param para 参数。
     * 
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectListByRawHql(RowKey startRowKey,
            RowKey endRowKey, Class<? extends T> type, String hql,
            Map<String, Object> para);

    /**
     * 动态条件hql查询，查找[startRowKey,endRowKey)范围的POJO对象列表。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * @param type POJO type。
     * @param startIndex 结果开始索引，0-based。
     * @param length 结果列表size限制。
     * @param hql 原生hql。
     * @param para 参数。
     * 
     * @return POJO对象列表。
     * */
    public <T> List<T> findObjectListByRawHql(RowKey startRowKey,
            RowKey endRowKey, Class<? extends T> type, long startIndex,
            long length, String hql, Map<String, Object> para);

    /**
     * Put POJO。
     * 
     * @param rowKey rowKey。
     * @param t POJO。
     * */
    public <T> void putObject(RowKey rowKey, T t);

    /**
     * Delete POJO。
     * 
     * @param rowKey rowKey。
     * */
    public void deleteObject(RowKey rowKey);

    /**
     * Delete POJOList。
     * 
     * @param startRowKey startRowKey。
     * @param endRowKey endRowKey。
     * 
     * */
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey);

    //-----------------------以下方法只适用于带版本号的POJO。-----------------------
    /**
     * 插入POJO。
     * 
     * <pre>
     * rowKey对应的POJO版本为null时(数据不存在)插入成功。
     * </pre>
     * 
     * @param rowKey rowKey。
     * @param t POJO
     * @return 是否插入成功。
     * */
    public <T> boolean insertObject(RowKey rowKey, T t);

    /**
     * 更新POJO。
     * 
     * <pre>
     * oldT中的版本号为老版本号。
     * newT中的版本号为新版本号。
     * </pre>
     * 
     * @param rowKey rowKey。
     * @param oldT oldT。
     * @param newT newT。
     * @return 是否更新成功。
     * */
    public <T> boolean updateObject(RowKey rowKey, T oldT, T newT);

    /**
     * 更新POJO。
     * 
     * @param rowKey rowKey。
     * @param t POJO。
     * @param oldVersion 老版本。
     * @return 是否更新成功。
     * */
    public <T> boolean updateObjectWithVersion(RowKey rowKey, T t,
            Object oldVersion);

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

    /**
     * 得到HBaseTableConfig。
     * 
     * @return HBaseTableConfig。
     * */
    public HBaseTableConfig getHbaseTableConfig();

    /**
     * 设置HBaseTableConfig。
     * 
     * @param hbaseTableConfig HBaseTableConfig。
     * */
    public void setHbaseTableConfig(HBaseTableConfig hbaseTableConfig);

}
