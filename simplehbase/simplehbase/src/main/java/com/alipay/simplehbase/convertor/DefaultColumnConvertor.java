package com.alipay.simplehbase.convertor;

import java.util.Date;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * 默认的ColumnConvertor。
 * 
 * <pre>
 * 可以处理以下类型：
 * boolean,Boolean (1 byte 存储)
 * int,Integer (4 bytes 存储)
 * long,Long (8 bytes 存储)
 * String (utf-8 存储)
 * Date (8 bytes 存储)
 * Enum (name按照utf-8存储)
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: DefaultColumnConvertor.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class DefaultColumnConvertor implements ColumnConvertor {

    @Override
    public byte[] toBytes(Class<?> type, Object value) {
        if (value == null) {
            return null;
        }

        if (type == boolean.class || type == Boolean.class) {
            return Bytes.toBytes((Boolean) value);
        }

        if (type == int.class || type == Integer.class) {
            return Bytes.toBytes((Integer) value);
        }

        if (type == long.class || type == Long.class) {
            return Bytes.toBytes((Long) value);
        }

        if (type == String.class) {
            return Bytes.toBytes((String) value);
        }
        if (type == Date.class) {
            long time = ((Date) value).getTime();
            return Bytes.toBytes(time);

        }

        if (type.isEnum()) {
            String name = ((Enum<?>) value).name();
            return Bytes.toBytes(name);
        }

        throw new SimpleHBaseException("not support now. value=" + value
                + " type=" + type);
    }

    //TODO allen [simplehbase] 看看有没有IDE不报警的实现方式。
    @Override
    public Object toObject(Class type, byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        if (type == boolean.class || type == Boolean.class) {
            return Bytes.toBoolean(bytes);
        }

        if (type == int.class || type == Integer.class) {
            return Bytes.toInt(bytes);
        }
        if (type == long.class || type == Long.class) {
            return Bytes.toLong(bytes);
        }
        if (type == String.class) {
            return Bytes.toString(bytes);
        }
        if (type == Date.class) {
            long time = Bytes.toLong(bytes);
            return new Date(time);
        }

        if (type.isEnum()) {
            String name = Bytes.toString(bytes);
            return Enum.valueOf(type, name);
        }

        throw new SimpleHBaseException("not support now. type=" + type);
    }

}
