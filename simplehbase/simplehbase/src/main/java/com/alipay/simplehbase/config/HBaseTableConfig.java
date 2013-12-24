package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
 * 2 configMap runtime config.
 * 3 queryMap HQL collection.
 * </pre>
 * 
 * @author xinzhi
 * */
public class HBaseTableConfig {
    /** log. */
    private static Logger           log              = Logger.getLogger(HBaseTableConfig.class);

    //------------bean config-------------------
    /**
     * Config file.
     * */
    @ConfigAttr
    private String                  configFilePath;
    //------------bean config-------------------
    private HBaseTableSchema        hbaseTableSchema = new HBaseTableSchema();
    private Map<String, String>     configMap        = new TreeMap<String, String>();
    private Map<String, HBaseQuery> queryMap         = new TreeMap<String, HBaseQuery>();

    public void init() {
        Util.checkEmptyString(configFilePath);

        try {
            List<HBaseColumnSchema> hbaseColumnSchemas = new ArrayList<HBaseColumnSchema>();
            HBaseTableConfigParser.parseTableSchema(configFilePath,
                    hbaseTableSchema, hbaseColumnSchemas);
            hbaseTableSchema.init(hbaseColumnSchemas);

            HBaseTableConfigParser.parseConfigMap(configFilePath, configMap);

            List<HBaseQuery> hbaseQueries = HBaseTableConfigParser
                    .parseHBaseQuery(configFilePath);
            for (HBaseQuery hBaseQuery : hbaseQueries) {
                queryMap.put(hBaseQuery.getId(), hBaseQuery);
            }

            log.info(this);

        } catch (Exception e) {
            log.error("parseConfig error.", e);
            throw new SimpleHBaseException("parseConfig error.", e);
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

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public Map<String, HBaseQuery> getQueryMap() {
        return queryMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(hbaseTableSchema.toString());
        sb.append("-------------------configMap-----------------------\n");
        for (String key : configMap.keySet()) {
            sb.append(key + "=" + configMap.get(key) + "\n");
        }
        sb.append("-------------------configMap-----------------------\n");
        return sb.toString();
    }
}
