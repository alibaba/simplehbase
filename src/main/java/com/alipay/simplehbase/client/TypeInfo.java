package com.alipay.simplehbase.client;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableSchema;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;
import com.alipay.simplehbase.util.XmlUtil;

/**
 * POJO type and Hbase table mapping info.
 * 
 * @author xinzhi
 * */
public class TypeInfo {

    /**
     * Parse TypeInfo from POJO's type.
     * 
     * @param type POJO's type.
     * @return TypeInfo.
     * */
    public static TypeInfo parse(Class<?> type) {
        Util.checkNull(type);

        TypeInfo typeInfo = new TypeInfo();
        typeInfo.type = type;

        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            ColumnInfo columnInfo = ColumnInfo.parse(type, field);
            if (columnInfo == null) {
                continue;
            }

            typeInfo.columnInfos.add(columnInfo);

        }

        typeInfo.init();

        return typeInfo;
    }

    /**
     * Parse TypeInfo from POJO's type and HBaseTableSchema.
     * */
    public static TypeInfo parseInAir(Class<?> type,
            HBaseTableSchema hbaseTableSchema) {
        Util.checkNull(type);
        Util.checkNull(hbaseTableSchema);

        TypeInfo typeInfo = new TypeInfo();
        typeInfo.type = type;
        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            //don't handle static field.
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            //use field name as qualifier.
            String qualifier = field.getName();
            HBaseColumnSchema hbaseColumnSchema = hbaseTableSchema
                    .findColumnSchema(qualifier);

            ColumnInfo columnInfo = ColumnInfo.parseInAir(type, field,
                    hbaseColumnSchema.getFamily());

            if (columnInfo == null) {
                continue;
            }

            typeInfo.columnInfos.add(columnInfo);

        }

        typeInfo.init();

        return typeInfo;
    }

    /**
     * Parse TypeInfo from Node.
     * */
    public static TypeInfo parseNode(Node node,
            HBaseTableSchema hbaseTableSchema) {
        Util.checkNull(node);
        Util.checkNull(hbaseTableSchema);

        TypeInfo typeInfo = new TypeInfo();

        String typeName = XmlUtil.getAttr(node, "className");
        if (StringUtil.isEmptyString(typeName)) {
            throw new SimpleHBaseException("No class name attr.");
        }

        Class<?> type = ClassUtil.forName(typeName);
        typeInfo.type = type;

        String defaultFamily = XmlUtil.getAttr(node, "defaultFamily");

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node fieldNode = nodeList.item(i);
            ColumnInfo columnInfo = ColumnInfo.parseNode(type, fieldNode,
                    hbaseTableSchema, defaultFamily);
            if (columnInfo == null) {
                continue;
            }
            typeInfo.columnInfos.add(columnInfo);
        }

        typeInfo.init();

        return typeInfo;
    }

    /** POJO's type. */
    private Class<?>                             type;
    /** POJO's ColumnInfo list. */
    private List<ColumnInfo>                     columnInfos    = new ArrayList<ColumnInfo>();
    /** Versioned ColumnInfo, can be null. */
    private ColumnInfo                           versionedColumnInfo;

    /**
     * Qualifier->Family-> ColumnInfo.
     * */
    private Map<String, Map<String, ColumnInfo>> columnInfosMap = new HashMap<String, Map<String, ColumnInfo>>();

    private TypeInfo() {
    }

    /**
     * Init this object.
     * */
    public void init() {

        Util.checkNull(type);
        Util.checkNull(columnInfos);
        Util.check(!columnInfos.isEmpty());

        int versionFieldCounter = 0;

        for (ColumnInfo columnInfo : columnInfos) {

            if (columnInfo.isVersioned) {
                versionFieldCounter++;
                versionedColumnInfo = columnInfo;
            }

            if (!columnInfosMap.containsKey(columnInfo.qualifier)) {
                columnInfosMap.put(columnInfo.qualifier,
                        new HashMap<String, ColumnInfo>());
            }
            columnInfosMap.get(columnInfo.qualifier).put(columnInfo.family,
                    columnInfo);
        }

        if (versionFieldCounter > 1) {
            throw new SimpleHBaseException("more than one versioned fields.");
        }

    }

    /**
     * Is versioned TypeInfo.
     * */
    public boolean isVersionedType() {
        return versionedColumnInfo != null;
    }

    /**
     * Find ColumnInfo by family and qualifier.
     * */
    public ColumnInfo findColumnInfo(String family, String qualifier) {
        Util.checkEmptyString(family);
        Util.checkEmptyString(qualifier);

        return columnInfosMap.get(qualifier).get(family);
    }

    public Class<?> getType() {
        return type;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public ColumnInfo getVersionedColumnInfo() {
        return versionedColumnInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        sb.append("type=" + type + "\n");
        sb.append("versionedColumnInfo=" + versionedColumnInfo + "\n");
        for (ColumnInfo columnInfo : columnInfos) {
            sb.append(columnInfo + "\n");
        }
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        return sb.toString();
    }
}
