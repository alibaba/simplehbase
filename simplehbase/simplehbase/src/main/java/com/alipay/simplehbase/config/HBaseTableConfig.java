package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.hql.HBaseQuery;
import com.alipay.simplehbase.util.Util;

/**
 * HbaseTable's config info.
 * 
 * <pre>
 * Including following info.
 * 1 hbaseTableSchema Table's schema.
 * 2 queryMap HQL collection.
 * </pre>
 * 
 * @author xinzhi
 * */
public class HBaseTableConfig {
    /** log. */
    private static Logger                     log              = Logger.getLogger(HBaseTableConfig.class);

    //------------bean config-------------------
    /**
     * Config file.
     * */
    @ConfigAttr
    private String                            configFilePath;

    //------------bean config-------------------
    private HBaseTableSchema                  hbaseTableSchema = new HBaseTableSchema();

    private ConcurrentMap<String, HBaseQuery> queryMap         = new ConcurrentHashMap<String, HBaseQuery>();

    public void init() {
        Util.checkEmptyString(configFilePath);

        try {
            List<HBaseColumnSchema> hbaseColumnSchemas = new ArrayList<HBaseColumnSchema>();
            HBaseTableConfigParser.parseTableSchema(configFilePath,
                    hbaseTableSchema, hbaseColumnSchemas);
            hbaseTableSchema.init(hbaseColumnSchemas);

            List<HBaseQuery> hbaseQueries = HBaseTableConfigParser
                    .parseHBaseQuery(configFilePath);

            addHBaseQueryList(hbaseQueries);

            log.info(this);

        } catch (Exception e) {
            log.error("parseConfig error.", e);
            throw new SimpleHBaseException("parseConfig error.", e);
        }
    }

    /**
     * add hbaseQueryList.
     * */
    public void addHBaseQueryList(List<HBaseQuery> hbaseQueryList) {
        for (HBaseQuery hBaseQuery : hbaseQueryList) {
            queryMap.put(hBaseQuery.getId(), hBaseQuery);
        }
    }

    public String getConfigFilePath() {
        return configFilePath;
    }

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public HBaseTableSchema getHbaseTableSchema() {
        return hbaseTableSchema;
    }

    public Map<String, HBaseQuery> getQueryMap() {
        return queryMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(hbaseTableSchema.toString());
        return sb.toString();
    }
}
