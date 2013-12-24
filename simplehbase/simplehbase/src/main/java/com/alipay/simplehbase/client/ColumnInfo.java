package com.alipay.simplehbase.client;

import java.lang.reflect.Field;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.StringUtil;

/**
 * POJO's field and Hbase's column mappping.
 * 
 * @author xinzhi
 * */
public class ColumnInfo {

    /**
     * Parse ColumnInfo from POJO's field.
     * 
     * @param type POJO's class type.
     * @param field POJO' field.
     * @return ColumnInfo.
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

    /** POJO's class type. */
    Class<?> type;
    /** POJO's field. */
    Field    field;
    /** hbase's family. */
    String   family;
    /** hbase's family bytes. */
    byte[]   familyBytes;
    /** hbase's qualifier. */
    String   qualifier;
    /** hbase's qualifier bytes. */
    byte[]   qualifierBytes;

    private ColumnInfo() {
    }

    @Override
    public String toString() {
        return "type=" + type + " field=" + field + " family=" + family
                + " qualifier=" + qualifier;
    }
}