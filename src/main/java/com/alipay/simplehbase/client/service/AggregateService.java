package com.alipay.simplehbase.client.service;

import java.util.Map;

import com.alipay.simplehbase.client.AggregateExtInfo;
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
     * Count POJO with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param aggregateExtInfo AggregateExtInfo.
     * 
     * @return count result.
     * */
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable AggregateExtInfo aggregateExtInfo);

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
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para);

    /**
     * Dynamic query to count POJO with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param aggregateExtInfo AggregateExtInfo.
     * 
     * @return count result.
     * */
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para,
            @Nullable AggregateExtInfo aggregateExtInfo);

    /**
     * Count and sum.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * 
     * @return return long array,[count,sum1,sum2,sum3...]
     * */
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey);

    /**
     * Count and sum.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param aggregateExtInfo AggregateExtInfo.
     * 
     * @return return long array,[count,sum1,sum2,sum3...]
     * */
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable AggregateExtInfo aggregateExtInfo);

    /**
     * Count and sum.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return return long array,[count,sum1,sum2,sum3...]
     * */
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para);

    /**
     * Count and sum.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param aggregateExtInfo AggregateExtInfo.
     * 
     * @return return long array,[count,sum1,sum2,sum3...]
     * */
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para,
            @Nullable AggregateExtInfo aggregateExtInfo);
}
