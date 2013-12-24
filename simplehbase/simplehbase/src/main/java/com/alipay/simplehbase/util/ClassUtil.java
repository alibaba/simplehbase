package com.alipay.simplehbase.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * ClassUtil.
 * 
 * @author xinzhi
 * */
public class ClassUtil {

    private static Map<String, Class<?>>   nativeClassMap = new HashMap<String, Class<?>>();
    private static Map<String, Class<?>>   simpleClassMap = new HashMap<String, Class<?>>();
    private static Map<Class<?>, Class<?>> boxTypeMap     = new HashMap<Class<?>, Class<?>>();

    static {
        nativeClassMap.put("byte", byte.class);
        nativeClassMap.put("short", short.class);
        nativeClassMap.put("int", int.class);
        nativeClassMap.put("long", long.class);
        nativeClassMap.put("char", char.class);
        nativeClassMap.put("float", float.class);
        nativeClassMap.put("double", double.class);
        nativeClassMap.put("boolean", boolean.class);

        simpleClassMap.put("Byte", Byte.class);
        simpleClassMap.put("Short", Short.class);
        simpleClassMap.put("Int", Integer.class);
        simpleClassMap.put("Long", Long.class);
        simpleClassMap.put("Char", Character.class);
        simpleClassMap.put("Float", Float.class);
        simpleClassMap.put("Double", Double.class);
        simpleClassMap.put("Boolean", Boolean.class);

        simpleClassMap.put("string", String.class);
        simpleClassMap.put("String", String.class);
        simpleClassMap.put("date", Date.class);
        simpleClassMap.put("Date", Date.class);

        boxTypeMap.put(byte.class, Byte.class);
        boxTypeMap.put(short.class, Short.class);
        boxTypeMap.put(int.class, Integer.class);
        boxTypeMap.put(long.class, Long.class);
        boxTypeMap.put(char.class, Character.class);
        boxTypeMap.put(float.class, Float.class);
        boxTypeMap.put(double.class, Double.class);
        boxTypeMap.put(boolean.class, Boolean.class);
    }

    /**
     * Finds class using class name.
     * 
     * <pre>
     * class name would be native type such as int/Int, boolean/Boolean.
     * class name would be ab name, such as string/String,date/Date.
     * class name would be java full class name.
     * </pre>
     * 
     * */
    public static Class<?> forName(String className) {
        Util.checkEmptyString(className);

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
     * Do c1 and c2 have same type.
     * 
     * <pre>
     * try convert boxer type first.
     * </pre>
     * */
    public static boolean withSameType(Class<?> c1, Class<?> c2) {
        Util.checkNull(c1);
        Util.checkNull(c2);

        if (c1 == c2) {
            return true;
        }
        return tryConvertToBoxClass(c1) == tryConvertToBoxClass(c2);
    }

    /**
     * Returns boxer of c or c if c can't be boxed.
     * */
    public static Class<?> tryConvertToBoxClass(Class<?> c) {
        Util.checkNull(c);

        if (boxTypeMap.containsKey(c)) {
            return boxTypeMap.get(c);
        }
        return c;
    }

    private ClassUtil() {
    }
}
