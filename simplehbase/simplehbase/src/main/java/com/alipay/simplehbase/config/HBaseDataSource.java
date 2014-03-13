package com.alipay.simplehbase.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
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
    final private static Logger       log                   = Logger.getLogger(HBaseDataSource.class);
    //----------config--------------
    /**
     * dataSource id.
     * */
    @ConfigAttr
    private String              id;
    /**
     * hbase's config file path, such as hbase zk config file path.
     * */
    @ConfigAttr
    private List<String>        hbaseConfigFilePaths;
    /**
     * hbase's original config map.
     * */
    @ConfigAttr
    private Map<String, String> hbaseConfig;
    /**
     * simplehbase's private config file path.
     * */
    @ConfigAttr
    private String              dataSourceConfigFilePath;
    /**
     * simplehbase's private config map.
     * */
    @ConfigAttr
    private Map<String, String> dataSourceConfig;

    //---------------------------runtime-------------------------
    /**
     * final hbase's config item.
     * */
    private Map<String, String> finalHbaseConfig      = new HashMap<String, String>();
    /**
     * final simplehbase's config item.
     * */
    private Map<String, String> finalDataSourceConfig = new HashMap<String, String>();
    /**
     * hbase Configuration.
     * */
    private Configuration       hbaseConfiguration;
    /**
     * HTablePool.
     * */
    private HTablePool          htablePool;

    /**
     * init dataSource.
     * */
    public void init() {
        try {
            System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                    "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
            System.setProperty("javax.xml.parsers.SAXParserFactory",
                    "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

            parseConfig();
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
        return htablePool.getTable(tableName);
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
     * Parse config.
     * */
    private void parseConfig() {
        try {
            if (hbaseConfigFilePaths != null) {
                for (String filePath : hbaseConfigFilePaths) {
                    finalHbaseConfig
                            .putAll(ConfigUtil.loadConfigFile(filePath));
                }
            }

            if (hbaseConfig != null) {
                finalHbaseConfig.putAll(hbaseConfig);
            }

            hbaseConfiguration = HBaseConfiguration.create();
            for (Map.Entry<String, String> entry : finalHbaseConfig.entrySet()) {
                hbaseConfiguration.set(entry.getKey(), entry.getValue());
            }

            finalDataSourceConfig.putAll(ConfigUtil
                    .loadConfigFile(dataSourceConfigFilePath));
            if (dataSourceConfig != null) {
                finalDataSourceConfig.putAll(dataSourceConfig);
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
        try {
            int hbasePoolSize = ConfigUtil.parsePositiveInt(
                    finalDataSourceConfig, ConfigOfDataSource.HTABLE_POOL_SIZE,
                    ConfigOfDataSource.HTABLE_POOL_SIZE_DEFAULT);

            htablePool = new HTablePool(hbaseConfiguration, hbasePoolSize);
        } catch (Exception e) {
            log.error("initHTablePoolHolder error.", e);
            throw new SimpleHBaseException("initHTablePoolHolder error.", e);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getHbaseConfigFilePaths() {
        return hbaseConfigFilePaths;
    }

    public void setHbaseConfigFilePaths(List<String> hbaseConfigFilePaths) {
        this.hbaseConfigFilePaths = hbaseConfigFilePaths;
    }

    public Map<String, String> getHbaseConfig() {
        return hbaseConfig;
    }

    public void setHbaseConfig(Map<String, String> hbaseConfig) {
        this.hbaseConfig = hbaseConfig;
    }

    public String getDataSourceConfigFilePath() {
        return dataSourceConfigFilePath;
    }

    public void setDataSourceConfigFilePath(String dataSourceConfigFilePath) {
        this.dataSourceConfigFilePath = dataSourceConfigFilePath;
    }

    public Map<String, String> getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(Map<String, String> dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public Configuration getHbaseConfiguration() {
        return hbaseConfiguration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------datasource--------------------------\n");

        StringUtil.append(sb, "#id#", id);
        StringUtil.append(sb, "#hbaseConfigFilePaths#", hbaseConfigFilePaths);
        StringUtil.append(sb, "#hbaseConfig#", hbaseConfig);
        StringUtil.append(sb, "#dataSourceConfigFilePath#",
                dataSourceConfigFilePath);
        StringUtil.append(sb, "#dataSourceConfig#", dataSourceConfig);

        StringUtil.append(sb, "#finalHbaseConfig#", finalHbaseConfig);
        StringUtil.append(sb, "#finalDataSourceConfig#", finalDataSourceConfig);

        sb.append("---------------datasource--------------------------\n");
        return sb.toString();
    }
}
