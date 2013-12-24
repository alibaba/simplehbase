package com.alipay.simplehbase.type;

import com.alipay.simplehbase.core.Nullable;

/**
 * Convert java type object to hbase's bytes back and forth.
 * 
 * <pre>
 * In general, one type handler handle one specified java type.
 * A java type and its boxer type would be handled in one type handler.
 * </pre>
 * 
 * @author xinzhi
 * */
public interface TypeHandler {

    /**
     * Convert java object to hbase's column bytes.
     * 
     * @param type java's type.
     * @param value java's object.
     * @return hbase's column bytes.
     * */
    public byte[] toBytes(Class<?> type, @Nullable Object value);

    /**
     * Convert hbase's column bytes to java object.
     * 
     * @param type java object's type.
     * @param bytes hbase's column bytes.
     * @return java object.
     * */
    public Object toObject(Class<?> type, @Nullable byte[] bytes);
}
