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

	private static Map<String, Class<?>> nativeClassMap = new HashMap<String, Class<?>>();
	private static Map<String, Class<?>> simpleClassMap = new HashMap<String, Class<?>>();
	private static Map<Class<?>, Class<?>> boxTypeMap = new HashMap<Class<?>, Class<?>>();

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
		return tryConvertToBoxClass(c1) == tryConvertToBoxClass(c2);
	}

	/**
	 * 转换Class c为装箱类型，如果转换不成功，返回原类型。
	 * */
	public static Class<?> tryConvertToBoxClass(Class<?> c) {
		if (boxTypeMap.containsKey(c)) {
			return boxTypeMap.get(c);
		}
		return c;
	}
}
