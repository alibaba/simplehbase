package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

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
    final private static Logger               log              = Logger.getLogger(HBaseTableConfig.class);

    //------------bean config-------------------
    /**
     * Config resource.
     * */
    @ConfigAttr
    private Resource                          configResource;

    //------------bean config-------------------
    private HBaseTableSchema                  hbaseTableSchema = new HBaseTableSchema();

    private ConcurrentMap<String, HBaseQuery> queryMap         = new ConcurrentHashMap<String, HBaseQuery>();

    public void init() {
        Util.checkNull(configResource);

        try {
            List<HBaseColumnSchema> hbaseColumnSchemas = new ArrayList<HBaseColumnSchema>();
            HBaseTableConfigParser.parseTableSchema(
                    configResource.getInputStream(), hbaseTableSchema,
                    hbaseColumnSchemas);
            hbaseTableSchema.init(hbaseColumnSchemas);

            List<HBaseQuery> hbaseQueries = HBaseTableConfigParser
                    .parseHBaseQuery(configResource.getInputStream());

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

    public Resource getConfigResource() {
        return configResource;
    }

    public void setConfigResource(Resource configResource) {
        this.configResource = configResource;
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
