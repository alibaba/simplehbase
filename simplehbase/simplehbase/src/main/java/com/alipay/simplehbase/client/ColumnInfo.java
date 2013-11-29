package com.alipay.simplehbase.client;

import java.lang.reflect.Field;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.StringUtil;

/**
 * POJO的field和Hbase的列映射信息。
 * 
 * @author xinzhi
 * @version $Id: ColumnInfo.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ColumnInfo {

    /**
     * 从POJO的field解析出ColumnInfo。
     * 
     * @param type POJO的class type。
     * @param field POJO的field。
     * @return 解析出的ColumnInfo。
     * */
    public static ColumnInfo parse(Class<?> type, Field field) {
        String defaultFamily = null;

        HBaseTable hbaseTable = type.getAnnotation(HBaseTable.class);
        if (hbaseTable != null) {
            defaultFamily = hbaseTable.defaultFamily();
        }

        HBaseColumn hbaseColumn = field.getAnnotation(HBaseColumn.class);
        if (hbaseColumn == null) {
            return null;
        }

        String family = hbaseColumn.family();
        String qualifier = hbaseColumn.qualifier();

        if (StringUtil.isEmptyString(family)) {
            family = defaultFamily;
        }

        if (StringUtil.isEmptyString(family)) {
            throw new SimpleHBaseException("family is null or empty. type="
                    + type + " field=" + field);
        }

        if (StringUtil.isEmptyString(qualifier)) {
            throw new SimpleHBaseException("qualifier is null or empty. type="
                    + type + " field=" + field);
        }

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.family = family;
        columnInfo.familyBytes = Bytes.toBytes(family);
        columnInfo.qualifier = qualifier;
        columnInfo.qualifierBytes = Bytes.toBytes(qualifier);

        return columnInfo;
    }

    /** POJO的class type。 */
    Class<?> type;
    /** POJO的field。 */
    Field    field;
    /** hbase的family。 */
    String   family;
    /** hbase的family。 */
    byte[]   familyBytes;
    /** hbase的qualifier。 */
    String   qualifier;
    /** hbase的qualifier。 */
    byte[]   qualifierBytes;

    private ColumnInfo() {
    }

    @Override
    public String toString() {
        return "type=" + type + " field=" + field + " family=" + family
                + " qualifier=" + qualifier;
    }
}