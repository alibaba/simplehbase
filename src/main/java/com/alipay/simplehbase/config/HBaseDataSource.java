package com.alipay.simplehbase.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.hbase.HTablePoolAdaptor;
import com.alipay.simplehbase.hbase.HTablePoolService;
import com.alipay.simplehbase.hbase.SimpleHbaseHTablePool;
import com.alipay.simplehbase.util.ConfigUtil;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;

/**
 * HbaseDataSource represent one hbase data source.
 * 
 * @author xinzhi
 * */
public class HBaseDataSource {

    /** log. */
    final private static Logger    log              = Logger.getLogger(HBaseDataSource.class);
    //----------config--------------
    /**
     * dataSource id.
     * */
    @ConfigAttr
    private String                 id;
    /**
     * hbase's config resources, such as hbase zk config.
     * */
    @ConfigAttr
    private List<Resource>         hbaseConfigResources;

    /**
     * Config the htablepool impl.
     * 
     * <pre>
     * "SimpleHbaseHTablePool" -> SimpleHbaseHTablePool
     * "HTablePool" -> HTablePool
     * 
     * default to HTablePool.
     * </pre>
     * */
    @Nullable
    @ConfigAttr
    private String                 htablePoolType;

    @ConfigAttr
    private int                    poolMaxSize      = 10;

    @ConfigAttr
    @Nullable
    private HTableInterfaceFactory tableFactory;

    /**
     * Only used with SimpleHbaseHTablePool.
     * */
    @ConfigAttr
    private long                   flushInterval    = -1L;

    //---------------------------runtime-------------------------
    /**
     * final hbase's config item.
     * */
    private Map<String, String>    finalHbaseConfig = new HashMap<String, String>();

    /**
     * hbase Configuration.
     * */
    private Configuration          hbaseConfiguration;

    /** PoolType */
    private PoolType               poolType         = PoolType.HTablePool;

    /**
     * HTablePoolService
     * 
     * <pre>
     * user can provide customized HTablePoolService.
     * </pre>
     * */
    private HTablePoolService      htablePoolService;

    /**
     * init dataSource.
     * */
    public void init() {
        try {

            System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                    "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
            System.setProperty("javax.xml.parsers.SAXParserFactory",
                    "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

            if ("SimpleHbaseHTablePool".equals(htablePoolType)) {
                poolType = PoolType.SimpleHbaseHTablePool;
            }

            initHbaseConfiguration();

            initHtablePool();

            log.info(this);

        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * Get HTableInterface by table Name.
     * 
     * @param tableName tableName.
     * @return HTableInterface.
     * */
    public HTableInterface getHTable(String tableName) {
        Util.checkEmptyString(tableName);
        return htablePoolService.getTable(tableName);
    }

    /**
     * Get one HBaseAdmin.
     * */
    public HBaseAdmin getHBaseAdmin() {
        try {
            return new HBaseAdmin(hbaseConfiguration);
        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * init HbaseConfiguration
     * */
    private void initHbaseConfiguration() {
        try {
            if (hbaseConfigResources != null) {
                for (Resource resource : hbaseConfigResources) {
                    finalHbaseConfig.putAll(ConfigUtil.loadConfigFile(resource
                            .getInputStream()));
                }
            }

            hbaseConfiguration = HBaseConfiguration.create();
            for (Map.Entry<String, String> entry : finalHbaseConfig.entrySet()) {
                hbaseConfiguration.set(entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            log.error("parseConfig error.", e);
            throw new SimpleHBaseException("parseConfig error.", e);
        }
    }

    /**
     * Initial HTablePool.
     * */
    private void initHtablePool() {
        //user can provide the htablePoolService.
        if (htablePoolService != null) {
            return;
        }

        try {
            switch (poolType) {

                case HTablePool:
                    htablePoolService = new HTablePoolAdaptor(new HTablePool(
                            hbaseConfiguration, poolMaxSize, tableFactory));
                    break;

                case SimpleHbaseHTablePool:
                    htablePoolService = new SimpleHbaseHTablePool(
                            hbaseConfiguration, poolMaxSize, tableFactory,
                            flushInterval);
                    break;

                default:
                    throw new SimpleHBaseException("can not init pool.");
            }
        } catch (Exception e) {
            log.error("initHtablePool error.", e);
            throw new SimpleHBaseException("initHtablePool error.", e);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Configuration getHbaseConfiguration() {
        return hbaseConfiguration;
    }

    public List<Resource> getHbaseConfigResources() {
        return hbaseConfigResources;
    }

    public void setHbaseConfigResources(List<Resource> hbaseConfigResources) {
        this.hbaseConfigResources = hbaseConfigResources;
    }

    public String getHtablePoolType() {
        return htablePoolType;
    }

    public void setHtablePoolType(String htablePoolType) {
        this.htablePoolType = htablePoolType;
    }

    public int getPoolMaxSize() {
        return poolMaxSize;
    }

    public void setPoolMaxSize(int poolMaxSize) {
        this.poolMaxSize = poolMaxSize;
    }

    public HTableInterfaceFactory getTableFactory() {
        return tableFactory;
    }

    public void setTableFactory(HTableInterfaceFactory tableFactory) {
        this.tableFactory = tableFactory;
    }

    public long getFlushInterval() {
        return flushInterval;
    }

    public void setFlushInterval(long flushInterval) {
        this.flushInterval = flushInterval;
    }

    public HTablePoolService getHtablePoolService() {
        return htablePoolService;
    }

    public void setHtablePoolService(HTablePoolService htablePoolService) {
        this.htablePoolService = htablePoolService;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------datasource--------------------------\n");
        StringUtil.append(sb, "#id#", id);
        StringUtil.append(sb, "#finalHbaseConfig#", finalHbaseConfig);
        sb.append("---------------datasource--------------------------\n");
        return sb.toString();
    }

    /**
     * PoolType.
     * */
    private static enum PoolType {
        HTablePool, SimpleHbaseHTablePool;
    }
}
