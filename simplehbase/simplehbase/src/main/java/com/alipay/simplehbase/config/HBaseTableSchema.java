package com.alipay.simplehbase.config;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;

/**
 * HbaseTable's schema.
 * 
 * <pre>
 * Including all meta data of hbase table.
 * </pre>
 * 
 * @author xinzhi
 * */
public class HBaseTableSchema {

    // ------------xml config-------------------
    /**
     * tableName. not null.
     * */
    @ConfigAttr
    private String                                      tableName;
    /**
     * default family. can be null.
     * */
    @ConfigAttr
    private String                                      defaultFamily;

    // ------------runtime-------------------
    /**
     * table name bytes.
     * */
    private byte[]                                      tableNameBytes;

    /**
     * default family bytes.
     * */
    private byte[]                                      defaultFamilyBytes;

    /**
     * Qualifier->Family-> HBaseColumnSchema.
     * */
    private Map<String, Map<String, HBaseColumnSchema>> columnSchemas = new TreeMap<String, Map<String, HBaseColumnSchema>>();

    /**
     * init.
     * */
    public void init(List<HBaseColumnSchema> hbaseColumnSchemas) {

        Util.checkEmptyString(tableName);
        tableNameBytes = Bytes.toBytes(tableName);

        if (StringUtil.isNotEmptyString(defaultFamily)) {
            defaultFamilyBytes = Bytes.toBytes(defaultFamily);
        }

        if (hbaseColumnSchemas.isEmpty()) {
            throw new SimpleHBaseException("no HBaseColumnSchemas.");
        }

        for (HBaseColumnSchema columnSchema : hbaseColumnSchemas) {
            if (StringUtil.isEmptyString(columnSchema.getFamily())) {
                columnSchema.setFamily(defaultFamily);
            }

            columnSchema.init();

            Map<String, HBaseColumnSchema> temMap = columnSchemas
                    .get(columnSchema.getQualifier());
            if (temMap == null) {
                temMap = new TreeMap<String, HBaseColumnSchema>();
                columnSchemas.put(columnSchema.getQualifier(), temMap);
            }

            temMap.put(columnSchema.getFamily(), columnSchema);

        }
    }

    /**
     * Find HBaseColumnSchema by family and qualifier.
     * */
    public HBaseColumnSchema findColumnSchema(String family, String qualifier) {
        Util.checkEmptyString(family);
        Util.checkEmptyString(qualifier);

        return columnSchemas.get(qualifier).get(family);
    }

    /**
     * Find HBaseColumnSchema by qualifier.
     * 
     * <pre>
     * We can use this method if HBaseTableSchema doesn't have more than one family with same qualifier.
     * </pre>
     * */
    public HBaseColumnSchema findColumnSchema(String qualifier) {
        Util.checkEmptyString(qualifier);

        Map<String, HBaseColumnSchema> tem = columnSchemas.get(qualifier);
        if (tem.size() == 1) {
            for (HBaseColumnSchema t : tem.values()) {
                return t;
            }
        }

        throw new SimpleHBaseException(
                "0 or many HBaseColumnSchema with qualifier = " + qualifier);
    }

    /**
     * Find one HBaseColumnSchema by random.
     * */
    public HBaseColumnSchema findOneColumnSchema() {
        for (Map<String, HBaseColumnSchema> t : columnSchemas.values()) {
            for (HBaseColumnSchema hbaseColumnSchema : t.values()) {
                return hbaseColumnSchema;
            }
        }

        throw new SimpleHBaseException("no HBaseColumnSchema found.");
    }

    public String getDefaultFamily() {
        return defaultFamily;
    }

    public void setDefaultFamily(String defaultFamily) {
        this.defaultFamily = defaultFamily;
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

    public byte[] getTableNameBytes() {
        return tableNameBytes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------table--------------------------\n");
        StringUtil.append(sb, "tableName", tableName);
        StringUtil.append(sb, "defaultFamily", defaultFamily);
        for (Map<String, HBaseColumnSchema> tem : columnSchemas.values()) {
            for (HBaseColumnSchema columnSchema : tem.values()) {
                StringUtil.append(sb, "columnSchema", columnSchema);
            }
        }
        sb.append("---------------table--------------------------\n");
        return sb.toString();
    }
}
