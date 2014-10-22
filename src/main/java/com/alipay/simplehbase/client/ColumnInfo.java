package com.alipay.simplehbase.client;

import java.lang.reflect.Field;

import org.apache.hadoop.hbase.util.Bytes;
import org.w3c.dom.Node;

import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableSchema;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;
import com.alipay.simplehbase.util.XmlUtil;

/**
 * POJO's field and Hbase table's column mapping info.
 * 
 * @author xinzhi
 * */
public class ColumnInfo {

    /**
     * parse column info from node.
     * */
    static ColumnInfo parseNode(Class<?> type, Node node,
            HBaseTableSchema hbaseTableSchema, String defaultFamily) {
        Util.checkNull(node);
        Util.checkNull(hbaseTableSchema);

        if (!"field".equals(node.getNodeName())) {
            return null;
        }

        String name = XmlUtil.getAttr(node, "name");
        if (StringUtil.isEmptyString(name)) {
            throw new SimpleHBaseException("column info miss name. type = "
                    + type);
        }

        Field field = null;
        try {
            field = type.getDeclaredField(name);
            field.setAccessible(true);
        } catch (Exception e) {
            throw new SimpleHBaseException(
                    "can't find named field in type. type = " + type
                            + " name = " + name, e);
        }

        String qualifier = XmlUtil.getAttr(node, "qualifier");
        if (StringUtil.isEmptyString(qualifier)) {
            //use name as qualifier.
            qualifier = field.getName();
        }

        String family = XmlUtil.getAttr(node, "family");
        if (StringUtil.isEmptyString(family)) {
            family = defaultFamily;
        }
        if (StringUtil.isEmptyString(family)) {
            HBaseColumnSchema hbaseColumnSchema = hbaseTableSchema
                    .findColumnSchema(qualifier);
            family = hbaseColumnSchema.getFamily();
        }

        String isVersioned = XmlUtil.getAttr(node, "isVersioned");

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.family = family;
        columnInfo.familyBytes = Bytes.toBytes(family);
        columnInfo.qualifier = qualifier;
        columnInfo.qualifierBytes = Bytes.toBytes(qualifier);
        columnInfo.isVersioned = "true".equals(isVersioned);

        return columnInfo;
    }

    /**
     * parse column info in air.
     * */
    static ColumnInfo parseInAir(Class<?> type, Field field, String family) {

        Util.checkEmptyString(family);
        //use field name as qualifier.
        String qualifier = field.getName();

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.type = type;
        columnInfo.field = field;
        columnInfo.family = family;
        columnInfo.familyBytes = Bytes.toBytes(family);
        columnInfo.qualifier = qualifier;
        columnInfo.qualifierBytes = Bytes.toBytes(qualifier);

        return columnInfo;

    }

    /**
     * Parse ColumnInfo from POJO's field.
     * 
     * @param type POJO's class type.
     * @param field POJO' field.
     * @return ColumnInfo.
     * */
    static ColumnInfo parse(Class<?> type, Field field) {
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
        columnInfo.isVersioned = (field.getAnnotation(HBaseVersion.class) != null);

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
    /** isVersioned. */
    boolean  isVersioned;

    private ColumnInfo() {
    }

    @Override
    public String toString() {
        return "type=" + type + " field=" + field + " family=" + family
                + " qualifier=" + qualifier + " isVersioned=" + isVersioned;
    }
}