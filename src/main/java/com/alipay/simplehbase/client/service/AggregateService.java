package com.alipay.simplehbase.client.service;

import java.util.Map;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.core.Nullable;

/**
 * AggregateService.
 * 
 * <pre>
 * Provides aggregate function on hbase table.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface AggregateService {
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
     * Dynamic query to count POJO with range in [startRowKey,endRowKey).
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

}
