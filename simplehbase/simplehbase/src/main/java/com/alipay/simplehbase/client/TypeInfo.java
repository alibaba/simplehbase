package com.alipay.simplehbase.client;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * POJO和Hbase的映射信息。
 * 
 * @author xinzhi
 * @version $Id: TypeInfo.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class TypeInfo {

    /**
     * 根据POJO的type解析TypeInfo。
     * 
     * @param type POJO的type。
     * @return 解析出的TypeInfo。
     * */
    public static TypeInfo parse(Class<?> type) {
        if (type == null) {
            throw new SimpleHBaseException("type is null.");
        }

        TypeInfo typeInfo = new TypeInfo();
        typeInfo.type = type;

        Field[] fields = type.getDeclaredFields();

        int versionFieldCounter = 0;

        for (Field field : fields) {

            field.setAccessible(true);

            ColumnInfo columnInfo = ColumnInfo.parse(type, field);
            if (columnInfo == null) {
                continue;
            }

            typeInfo.columnInfos.add(columnInfo);

            if (field.isAnnotationPresent(HBaseVersion.class)) {
                typeInfo.versionedColumnInfo = columnInfo;
                versionFieldCounter++;
            }

            typeInfo.families.add(columnInfo.family);
        }

        if (versionFieldCounter > 1) {
            throw new SimpleHBaseException("more than one versioned fields.");
        }

        if (typeInfo.columnInfos.isEmpty()) {
            throw new SimpleHBaseException("columnInfos is empty.");
        }

        return typeInfo;
    }

    /** POJO的type。 */
    private Class<?>         type;
    /** 该POJO的ColumnInfo列表。 */
    private List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
    /** 该POJO的版本号field对应的ColumnInfo,可以为null。 */
    private ColumnInfo       versionedColumnInfo;
    /** 该Type使用的所有family名称。 */
    private Set<String>      families    = new HashSet<String>();

    /**
     * 是否是带版本号的typeInfo。
     * 
     * @return 是否是带版本号的typeInfo。
     * */
    public boolean isVersionedType() {
        return versionedColumnInfo != null;
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

    public Set<String> getFamilies() {
        return families;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        sb.append("type=" + type + "\n");
        sb.append("versionedColumnInfo=" + versionedColumnInfo + "\n");
        sb.append("families=" + families + "\n");
        for (ColumnInfo columnInfo : columnInfos) {
            sb.append(columnInfo + "\n");
        }
        sb.append("-----------------" + getClass()
                + "-----------------------\n");
        return sb.toString();
    }
}
