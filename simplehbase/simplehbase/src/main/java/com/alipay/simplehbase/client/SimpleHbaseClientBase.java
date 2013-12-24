package com.alipay.simplehbase.client;

import java.util.Set;

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
     * Convert hbase result to POJO.
     * 
     * @param result hbase result.
     * @param type POJO type.
     * 
     * @return POJO.
     * */
    protected <T> T convert(Result result, Class<? extends T> type) {

        if (result.isEmpty()) {
            return null;
        }

        try {
            T t = type.newInstance();
            TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(type);
            for (ColumnInfo columnInfo : typeInfo.getColumnInfos()) {

                HBaseColumnSchema hbaseColumnSchema = columnSchema(
                        columnInfo.family, columnInfo.qualifier);

                Class<?> fieldType = columnInfo.field.getType();
                Class<?> schemaType = hbaseColumnSchema.getType();
                if (!ClassUtil.withSameType(fieldType, schemaType)) {
                    throw new SimpleHBaseException(
                            "class does not match. fieldType=" + fieldType
                                    + " schemaType=" + schemaType);
                }

                byte[] hbaseColumnValue = result.getValue(
                        columnInfo.familyBytes, columnInfo.qualifierBytes);

                TypeHandler typeHandler = hbaseColumnSchema.getTypeHandler();
                Object value = typeHandler.toObject(
                        hbaseColumnSchema.getType(), hbaseColumnValue);

                if (value != null) {
                    columnInfo.field.set(t, value);
                }
            }

            return t;
        } catch (Exception e) {
            throw new SimpleHBaseException("convert result exception. result="
                    + result + " type=" + type, e);
        }
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
     * Check for typeInfo is versioned typeInfo.
     * */
    protected void checkVersioned(TypeInfo typeInfo) {

        if (!typeInfo.isVersionedType()) {
            throw new SimpleHBaseException("not a versioned type. typeInfo = "
                    + typeInfo);
        }
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
