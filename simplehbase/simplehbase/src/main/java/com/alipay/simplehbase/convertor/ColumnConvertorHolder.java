package com.alipay.simplehbase.convertor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;

/**
 * ColumnConvertor实例的Holder类。
 * 
 * @author xinzhi
 * @version $Id: ColumnConvertorHolder.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ColumnConvertorHolder {

    /**
     * ColumnConvertor的Type -> ColumnConvertor的实例。
     * */
    private static ConcurrentMap<String, ColumnConvertor> convertorCache = new ConcurrentHashMap<String, ColumnConvertor>();

    /**
     * 由ColumnConvertor的Type得到ColumnConvertor的实例。
     * 
     * @param type ColumnConvertor的Type。
     * @return ColumnConvertor的实例。
     * */
    public static ColumnConvertor findConvertor(String type) {

        if (convertorCache.get(type) == null) {
            try {
                Class<?> c = ClassUtil.forName(type);
                convertorCache.putIfAbsent(type,
                        (ColumnConvertor) c.newInstance());
            } catch (Exception e) {
                throw new SimpleHBaseException(e);
            }
        }
        return convertorCache.get(type);
    }
}
