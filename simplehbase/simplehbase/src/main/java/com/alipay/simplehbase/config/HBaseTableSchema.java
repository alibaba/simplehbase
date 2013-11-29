package com.alipay.simplehbase.config;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.convertor.ColumnConvertor;
import com.alipay.simplehbase.convertor.ColumnConvertorHolder;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.StringUtil;

/**
 * HbaseTable的schema。
 * 
 * <pre>
 * 包含所有hbaseTable的元信息。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: HBaseTableSchema.java 2013-09-11 上午11:27:31 xinzhi $
 * 
 * */
public class HBaseTableSchema {

    //------------constant----------------
    /**
     * Family和Qualifier的连接符。
     **/
    private static final String            FamilyQualifierConnector = "^";

    //------------xml config-------------------
    /**
     * tableName. not null.
     * */
    @ConfigAttr
    private String                         tableName;
    /**
     * 默认的Family。
     * */
    @ConfigAttr
    private String                         defaultFamily;
    /**
     * 默认的columnConvertor的type。
     * */
    @ConfigAttr
    private String                         defaultColumnConvertorType;

    //------------runtime-------------------
    /**
     * 默认的Family。
     * */
    private byte[]                         defaultFamilyBytes;
    /**
     * 默认的columnConvertor。
     * */
    private ColumnConvertor                defaultColumnConvertor;
    /**
     * Family和Qualifier -> HBaseColumnSchema。
     * */
    private Map<String, HBaseColumnSchema> haseColumnSchemas        = new TreeMap<String, HBaseColumnSchema>();

    /**
     * 初始化。
     * */
    public void init(List<HBaseColumnSchema> hbaseColumnSchemas) {

        StringUtil.checkEmptyString(tableName);
        if (StringUtil.isNotEmptyString(defaultFamily)) {
            defaultFamilyBytes = Bytes.toBytes(defaultFamily);
        }

        if (StringUtil.isNotEmptyString(defaultColumnConvertorType)) {
            defaultColumnConvertor = ColumnConvertorHolder
                    .findConvertor(defaultColumnConvertorType);

        }

        if (hbaseColumnSchemas.isEmpty()) {
            throw new SimpleHBaseException("no HBaseColumnSchemas.");
        }

        for (HBaseColumnSchema columnSchema : hbaseColumnSchemas) {
            if (StringUtil.isEmptyString(columnSchema.getFamily())) {
                columnSchema.setFamily(defaultFamily);
            }

            if (StringUtil.isEmptyString(columnSchema.getColumnConvertorType())) {
                columnSchema.setColumnConvertorType(defaultColumnConvertorType);
            }

            columnSchema.init();

            String key = mapKey(columnSchema.getFamily(),
                    columnSchema.getQualifier());
            haseColumnSchemas.put(key, columnSchema);
        }

    }

    /**
     * 根据family和qualifier查找HBaseColumnSchema。
     * */
    public HBaseColumnSchema findColumnSchema(String family, String qualifier) {
        return haseColumnSchemas.get(mapKey(family, qualifier));
    }

    /**
     * 由family和qualifier计算haseColumnSchemas的key值。
     * */
    private String mapKey(String family, String qualifier) {
        return family + FamilyQualifierConnector + qualifier;
    }

    public String getDefaultFamily() {
        return defaultFamily;
    }

    public void setDefaultFamily(String defaultFamily) {
        this.defaultFamily = defaultFamily;
    }

    public String getDefaultColumnConvertorType() {
        return defaultColumnConvertorType;
    }

    public void setDefaultColumnConvertorType(String defaultColumnConvertorType) {
        this.defaultColumnConvertorType = defaultColumnConvertorType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public byte[] getDefaultFamilyBytes() {
        return defaultFamilyBytes;
    }

    public void setDefaultFamilyBytes(byte[] defaultFamilyBytes) {
        this.defaultFamilyBytes = defaultFamilyBytes;
    }

    public ColumnConvertor getDefaultColumnConvertor() {
        return defaultColumnConvertor;
    }

    public void setDefaultColumnConvertor(ColumnConvertor defaultColumnConvertor) {
        this.defaultColumnConvertor = defaultColumnConvertor;
    }

    public Map<String, HBaseColumnSchema> getHaseColumnSchemas() {
        return haseColumnSchemas;
    }

    public void setHaseColumnSchemas(
            Map<String, HBaseColumnSchema> haseColumnSchemas) {
        this.haseColumnSchemas = haseColumnSchemas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------table--------------------------\n");
        StringUtil.append(sb, "tableName", tableName);
        StringUtil.append(sb, "defaultFamily", defaultFamily);
        StringUtil.append(sb, "defaultColumnConvertorType",
                defaultColumnConvertorType);

        for (HBaseColumnSchema columnSchema : haseColumnSchemas.values()) {
            StringUtil.append(sb, "columnSchema", columnSchema);
        }

        sb.append("---------------table--------------------------\n");
        return sb.toString();
    }
}
