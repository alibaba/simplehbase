package com.alipay.simplehbase.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.config.ConfigOfTable;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.type.TypeHandler;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.ConfigUtil;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseClient's skeleton implementation.
 * 
 * @author xinzhi
 * */
abstract public class SimpleHbaseClientBase implements SimpleHbaseClient {
    protected HBaseTableConfig hbaseTableConfig;
    protected HBaseDataSource  dataSource;

    /**
     * Get HTableInterface.
     * */
    protected HTableInterface htableInterface() {
        return dataSource.getHTable(hbaseTableConfig.getHbaseTableSchema()
                .getTableName());
    }

    /**
     * Get AggregationClient.
     * */
    protected AggregationClient aggregationClient() {
        AggregationClient aggregationClient = new AggregationClient(
                dataSource.getHbaseConfiguration());
        return aggregationClient;
    }

    /**
     * Get table name bytes.
     **/
    protected byte[] tableNameBytes() {
        return hbaseTableConfig.getHbaseTableSchema().getTableNameBytes();
    }

    /**
     * Find HBaseColumnSchema by family and qualifier.
     * */
    protected HBaseColumnSchema columnSchema(String family, String qualifier) {
        return hbaseTableConfig.getHbaseTableSchema().findColumnSchema(family,
                qualifier);
    }

    /**
     * Find HBaseColumnSchema by qualifier.
     * */
    protected HBaseColumnSchema columnSchema(String qualifier) {
        return hbaseTableConfig.getHbaseTableSchema().findColumnSchema(
                qualifier);
    }

    /**
     * Find HBaseColumnSchema by qualifier.
     */
    protected HBaseColumnSchema columnSchema() {
        return hbaseTableConfig.getHbaseTableSchema().findOneColumnSchema();
    }

    /**
     * Get scan's caching size.
     * */
    protected int getScanCaching() {
        return ConfigUtil.parsePositiveInt(hbaseTableConfig.getConfigMap(),
                ConfigOfTable.SCAN_CACHING, ConfigOfTable.SCAN_CACHING_DEFAULT);

    }

    /**
     * Get batch size when do delete.
     * */
    protected int getDeleteBatch() {
        return ConfigUtil.parsePositiveInt(hbaseTableConfig.getConfigMap(),
                ConfigOfTable.DELETE_BATCH, ConfigOfTable.DELETE_BATCH_DEFAULT);
    }

    /**
     * Apply family to scan request, to prevent return more family than we need.
     * */
    protected <T> void applyRequestFamily(Class<? extends T> type, Scan scan) {
        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(type);
        Set<String> families = typeInfo.getFamilies();
        for (String s : families) {
            scan.addFamily(Bytes.toBytes(s));
        }
    }

    /**
     * Convert hbase result to SimpleHbaseDOResult.
     * 
     * @param hbaseResult hbase result.
     * @param type POJO type.
     * 
     * @return SimpleHbaseDOResult list, timestamp desc ordered.
     * */
    protected <T> List<SimpleHbaseDOResult<T>> convertToSimpleHbaseDOResult(
            Result hbaseResult, Class<? extends T> type) {

        KeyValue[] keyValues = hbaseResult.raw();
        if (keyValues == null || keyValues.length == 0) {
            return new ArrayList<SimpleHbaseDOResult<T>>();
        }

        TreeMap<Long, T> temMap = new TreeMap<Long, T>(
                Collections.reverseOrder());

        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(type);

        try {
            for (KeyValue keyValue : keyValues) {
                byte[] familyBytes = keyValue.getFamily();
                byte[] qualifierBytes = keyValue.getQualifier();
                byte[] hbaseValue = keyValue.getValue();
                long ts = keyValue.getTimestamp();

                if (!temMap.containsKey(ts)) {
                    temMap.put(ts, type.newInstance());
                }

                ColumnInfo columnInfo = typeInfo.findColumnInfo(
                        Bytes.toString(familyBytes),
                        Bytes.toString(qualifierBytes));

                HBaseColumnSchema hbaseColumnSchema = columnSchema(
                        columnInfo.family, columnInfo.qualifier);

                Class<?> fieldType = columnInfo.field.getType();
                Class<?> schemaType = hbaseColumnSchema.getType();

                if (!ClassUtil.withSameType(fieldType, schemaType)) {
                    throw new SimpleHBaseException(
                            "class does not match. fieldType=" + fieldType
                                    + " schemaType=" + schemaType);
                }

                TypeHandler typeHandler = hbaseColumnSchema.getTypeHandler();
                Object value = typeHandler.toObject(
                        hbaseColumnSchema.getType(), hbaseValue);

                if (value != null) {
                    columnInfo.field.set(temMap.get(ts), value);
                }
            }
        } catch (Exception e) {
            throw new SimpleHBaseException("convert result exception. result="
                    + hbaseResult + " type=" + type, e);
        }

        List<SimpleHbaseDOResult<T>> result = new ArrayList<SimpleHbaseDOResult<T>>();
        for (Long ts : temMap.keySet()) {
            SimpleHbaseDOResult<T> r = new SimpleHbaseDOResult<T>();
            r.setTimestamp(ts);
            r.setT(temMap.get(ts));
            result.add(r);
        }
        return result;
    }

    /**
     * Convert t's field to bytes.
     * */
    protected <T> byte[] convertPOJOFieldToBytes(T t, ColumnInfo columnInfo) {
        try {
            Object value = columnInfo.field.get(t);
            return convertValueToBytes(value, columnInfo);
        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * Convert value to bytes.
     * */
    protected byte[] convertValueToBytes(Object value, ColumnInfo columnInfo) {
        try {
            HBaseColumnSchema hbaseColumnSchema = columnSchema(
                    columnInfo.family, columnInfo.qualifier);

            Class<?> fieldType = columnInfo.field.getType();
            Class<?> schemaType = hbaseColumnSchema.getType();
            if (!ClassUtil.withSameType(fieldType, schemaType)) {
                throw new SimpleHBaseException(
                        "class does not match. fieldType=" + fieldType
                                + " schemaType=" + schemaType);
            }

            TypeHandler typeHandler = hbaseColumnSchema.getTypeHandler();
            return typeHandler.toBytes(fieldType, value);
        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * Convert value to bytes.
     * */
    protected byte[] convertValueToBytes(Object value,
            HBaseColumnSchema hbaseColumnSchema) {

        if (value == null) {
            return null;
        }

        try {
            Class<?> valueType = value.getClass();
            Class<?> schemaType = hbaseColumnSchema.getType();
            if (!ClassUtil.withSameType(valueType, schemaType)) {
                throw new SimpleHBaseException(
                        "class does not match. valueType=" + valueType
                                + " schemaType=" + schemaType);
            }

            TypeHandler typeHandler = hbaseColumnSchema.getTypeHandler();
            return typeHandler.toBytes(valueType, value);
        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }
    }

    /**
     * Check for typeInfo is versioned typeInfo.
     * */
    protected void checkVersioned(TypeInfo typeInfo) {

        if (!typeInfo.isVersionedType()) {
            throw new SimpleHBaseException("not a versioned type. typeInfo = "
                    + typeInfo);
        }
    }

    /**
     * Check for table name.
     * */
    protected void checkTableName(String tableName) {
        Util.checkEquals(tableName, hbaseTableConfig.getHbaseTableSchema()
                .getTableName());
    }

    @Override
    public HTableInterface getTable(String tableName) {
        return dataSource.getHTable(tableName);
    }

    @Override
    public HBaseAdmin getHBaseAdmin() {
        return dataSource.getHBaseAdmin();
    }

    @Override
    public HBaseDataSource getHBaseDataSource() {
        return dataSource;
    }

    @Override
    public void setHBaseDataSource(HBaseDataSource hbaseDataSource) {
        this.dataSource = hbaseDataSource;
    }

    @Override
    public HBaseTableConfig getHbaseTableConfig() {
        return hbaseTableConfig;
    }

    @Override
    public void setHbaseTableConfig(HBaseTableConfig hbaseTableConfig) {
        this.hbaseTableConfig = hbaseTableConfig;
    }
}
