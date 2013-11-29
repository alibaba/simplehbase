package com.alipay.simplehbase.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * ClassUtil。
 * 
 * @author xinzhi
 * @version $Id: ClassUtil.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ClassUtil {

    private static Map<String, Class<?>>   nativeClassMap = new HashMap<String, Class<?>>();
    private static Map<String, Class<?>>   simpleClassMap = new HashMap<String, Class<?>>();
    private static Map<Class<?>, Class<?>> sameTypeMap    = new HashMap<Class<?>, Class<?>>();

    static {
        nativeClassMap.put("byte", byte.class);
        nativeClassMap.put("short", short.class);
        nativeClassMap.put("int", int.class);
        nativeClassMap.put("long", long.class);
        nativeClassMap.put("char", char.class);
        nativeClassMap.put("float", float.class);
        nativeClassMap.put("double", double.class);

        simpleClassMap.put("Byte", Byte.class);
        simpleClassMap.put("Short", Short.class);
        simpleClassMap.put("Int", Integer.class);
        simpleClassMap.put("Long", Long.class);
        simpleClassMap.put("Char", Character.class);
        simpleClassMap.put("Float", Float.class);
        simpleClassMap.put("Double", Double.class);

        simpleClassMap.put("string", String.class);
        simpleClassMap.put("String", String.class);
        simpleClassMap.put("date", Date.class);
        simpleClassMap.put("Date", Date.class);

        sameTypeMap.put(byte.class, Byte.class);
        sameTypeMap.put(Byte.class, byte.class);
        sameTypeMap.put(short.class, Short.class);
        sameTypeMap.put(Short.class, short.class);
        sameTypeMap.put(int.class, Integer.class);
        sameTypeMap.put(Integer.class, int.class);
        sameTypeMap.put(long.class, Long.class);
        sameTypeMap.put(Long.class, long.class);
        sameTypeMap.put(char.class, Character.class);
        sameTypeMap.put(Character.class, char.class);
        sameTypeMap.put(float.class, Float.class);
        sameTypeMap.put(Float.class, float.class);
        sameTypeMap.put(double.class, Double.class);
        sameTypeMap.put(Double.class, double.class);
    }

    /**
     * 从className得到class，可以处理native java类型，常用类型缩写。
     * */
    public static Class<?> forName(String className) {

        if (StringUtil.isEmptyString(className)) {
            return null;
        }
        if (nativeClassMap.containsKey(className)) {
            return nativeClassMap.get(className);
        }

        if (simpleClassMap.containsKey(className)) {
            return simpleClassMap.get(className);
        }

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new SimpleHBaseException(e);
        }

    }

    /**
     * C1和C2有同样的类型，装箱类型被认为是相同的。
     * */
    public static boolean sameType(Class<?> c1, Class<?> c2) {
        if (c1 == c2) {
            return true;
        }

        return sameTypeMap.get(c1) == c2;
    }
}
