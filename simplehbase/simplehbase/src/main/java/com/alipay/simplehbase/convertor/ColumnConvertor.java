package com.alipay.simplehbase.convertor;

/**
 * Hbase的列和javaType的value之间的转换器。
 * 
 * @author xinzhi
 * @version $Id: ColumnConvertor.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface ColumnConvertor {

    /**
     * 转换value为hbase的列值。
     * 
     * @param type java的type。
     * @param value java的value。
     * @return hbase的列值。
     * */
    public byte[] toBytes(Class<?> type, Object value);

    /**
     * 转换hbase的列值为java的object。
     * 
     * @param type java的type。
     * @param bytes hbase的列值。
     * @return java的value。
     * */
    public Object toObject(Class<?> type, byte[] bytes);

}
