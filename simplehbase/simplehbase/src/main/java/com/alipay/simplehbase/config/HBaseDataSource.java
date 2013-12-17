package com.alipay.simplehbase.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ConfigUtil;
import com.alipay.simplehbase.util.StringUtil;

/**
 * HbaseDataSource表示一个hbase数据源。
 * 
 * <pre>
 * 1 配置相关信息：hbase主要有2类配置项：
 * 
 * hbase原生配置项：可以通过配置文件路径hbaseConfigFilePaths或者本对象的属性hbaseConfig来配置。
 * 当key相同时，hbaseConfig的优先级高于hbaseConfigFilePaths。
 * 
 * simpleHbase私有配置项：可以通过配置文件路径dataSourceConfigFilePath或者本对象的属性dataSourceConfig来配置。
 * 当key相同时，dataSourceConfig的优先级高于dataSourceConfigFilePath。
 * 
 * 配置文件的格式：每一行为key=value。
 * 
 * 
 * 2 使用方式：
 * 目前使用HbaseDataSource主要有2种方式:
 *   1 使用spring配置。配置时，应该使用init方法初始化HBaseDataSource。
 *   2 应用设置HBaseDataSource的属性，调用init方法进行初始化。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: HBaseDataSource.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class HBaseDataSource {

    /** log. */
    private static Logger       log                   = Logger.getLogger(HBaseDataSource.class);
    //----------config--------------
    /**
     * dataSource唯一id。
     * */
    @ConfigAttr
    private String              id;
    /**
     * hbase原生配置文件路径。
     * */
    @ConfigAttr
    private List<String>        hbaseConfigFilePaths;
    /**
     * hbase原生配置项。
     * */
    @ConfigAttr
    private Map<String, String> hbaseConfig;
    /**
     * simplehbase的datasource配置文件路径。
     * */
    @ConfigAttr
    private String              dataSourceConfigFilePath;
    /**
     * simplehbase的datasource配置项。
     * */
    @ConfigAttr
    private Map<String, String> dataSourceConfig;

    //---------------------------runtime-------------------------
    /**
     * 最终hbase的配置项。
     * */
    private Map<String, String> finalHbaseConfig      = new HashMap<String, String>();
    /**
     * 最终simplehbase的配置项。
     * */
    private Map<String, String> finalDataSourceConfig = new HashMap<String, String>();

    /**
     * hbase配置。
     * */
    private Configuration       hbaseConfiguration;

    /**
     * HTablePoolHolder。
     * */
    private HTablePoolHolder    htablePoolHolder;

    /**
     * 初始化dataSource。
     * */
    public void init() {
        try {
            parseConfig();
            initHTablePoolHolder();
            log.info(this);
        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * 得到指定表名的HTableInterface。
     * 
     * @param tableName 表名。
     * @return HTableInterface。
     * */
    public HTableInterface getHTable(String tableName) {
        return htablePoolHolder.getHTable(tableName);
    }

    /**
     * 得到一个HBaseAdmin。
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
     * 解析配置项。
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
     * 初始化HTablePoolHolder。
     * */
    private void initHTablePoolHolder() {
        try {
            htablePoolHolder = new HTablePoolHolder();
            htablePoolHolder.init(hbaseConfiguration, finalDataSourceConfig);
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
