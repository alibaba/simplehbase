package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.client.rowkey.handler.BytesRowKeyHandler;
import com.alipay.simplehbase.client.rowkey.handler.RowKeyHandler;
import com.alipay.simplehbase.client.rowkey.handler.RowKeyHandlerHolder;
import com.alipay.simplehbase.core.NotNullable;
import com.alipay.simplehbase.core.Nullable;
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
    @NotNullable
    private String                                      tableName;
    /**
     * default family. can be null.
     * */
    @ConfigAttr
    @Nullable
    private String                                      defaultFamily;
    /**
     * rowKeyHandlerName. can be null.
     **/
    @ConfigAttr
    @Nullable
    private String                                      rowKeyHandlerName;

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
     * RowKeyHandler.
     * */
    private RowKeyHandler                               rowKeyHandler;

    /**
     * init.
     * */
    public void init(List<HBaseColumnSchema> hbaseColumnSchemas) {

        Util.checkEmptyString(tableName);
        tableNameBytes = Bytes.toBytes(tableName);

        if (StringUtil.isNotEmptyString(defaultFamily)) {
            defaultFamilyBytes = Bytes.toBytes(defaultFamily);
        }

        if (StringUtil.isEmptyString(rowKeyHandlerName)) {
            rowKeyHandlerName = BytesRowKeyHandler.class.getCanonicalName();
        }

        rowKeyHandler = RowKeyHandlerHolder
                .findRowKeyHandler(rowKeyHandlerName);

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

        HBaseColumnSchema result = columnSchemas.get(qualifier).get(family);

        if (result == null) {
            throw new SimpleHBaseException("no HBaseColumnSchema found.");
        }

        return result;
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
     * Find all HBaseColumnSchemas.
     * */
    public List<HBaseColumnSchema> findAllColumnSchemas() {
        List<HBaseColumnSchema> result = new ArrayList<HBaseColumnSchema>();

        for (Map<String, HBaseColumnSchema> t : columnSchemas.values()) {
            for (HBaseColumnSchema hbaseColumnSchema : t.values()) {
                result.add(hbaseColumnSchema);
            }
        }
        return result;
    }

    /**
     * Find all families.
     * */
    public List<String> findAllFamilies() {
        List<HBaseColumnSchema> list = findAllColumnSchemas();
        Set<String> allFamilies = new HashSet<String>();
        for (HBaseColumnSchema columnSchema : list) {
            allFamilies.add(columnSchema.getFamily());
        }
        return new ArrayList<String>(allFamilies);
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

    public RowKeyHandler getRowKeyHandler() {
        return rowKeyHandler;
    }

    public String getRowKeyHandlerName() {
        return rowKeyHandlerName;
    }

    public void setRowKeyHandlerName(String rowKeyHandlerName) {
        this.rowKeyHandlerName = rowKeyHandlerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------table--------------------------\n");
        StringUtil.append(sb, "tableName", tableName);
        StringUtil.append(sb, "defaultFamily", defaultFamily);
        StringUtil.append(sb, "rowKeyHandlerName", rowKeyHandlerName);
        for (Map<String, HBaseColumnSchema> tem : columnSchemas.values()) {
            for (HBaseColumnSchema columnSchema : tem.values()) {
                StringUtil.append(sb, "columnSchema", columnSchema);
            }
        }
        sb.append("---------------table--------------------------\n");
        return sb.toString();
    }
}
