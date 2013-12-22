package com.alipay.simplehbase.type;

import com.alipay.simplehbase.core.Nullable;

/**
 * Convert java type object to hbase's bytes back and forth.
 * 
 * <pre>
 * In general, one type handler handle one specified java type.
 * A java type and its boxer type can be handled in one type handler.
 * </pre>
 * 
 * @author xinzhi
 * */
public interface TypeHandler {

    /**
     * Convert value to hbase's column.
     * 
     * @param type java's type.
     * @param value java's value.
     * @return hbase's column value.
     * */
    public byte[] toBytes(Class<?> type, @Nullable Object value);

    /**
     * Convert hbase's column to java object.
     * 
     * @param type java object's type.
     * @param bytes hbase's column value.
     * @return java object.
     * */
    public Object toObject(Class<?> type, @Nullable byte[] bytes);
}
