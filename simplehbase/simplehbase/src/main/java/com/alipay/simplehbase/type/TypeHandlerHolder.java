package com.alipay.simplehbase.type;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;

/**
 * TypeHandler实例的Holder类。
 * 
 * @author xinzhi
 * @version $Id: TypeHandlerHolder.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class TypeHandlerHolder {

	/**
	 * TypeHandler的Type -> TypeHandler的实例。
	 * */
	private static ConcurrentMap<String, TypeHandler> typeHandlerCache = new ConcurrentHashMap<String, TypeHandler>();

	/**
	 * 由TypeHandler的Type得到TypeHandler的实例。
	 * 
	 * @param type
	 *            TypeHandler的Type。
	 * @return TypeHandler的实例。
	 * */
	public static TypeHandler findTypeHandler(String type) {

		if (typeHandlerCache.get(type) == null) {
			try {
				Class<?> c = ClassUtil.forName(type);
				typeHandlerCache.putIfAbsent(type,
						(TypeHandler) c.newInstance());
			} catch (Exception e) {
				throw new SimpleHBaseException(e);
			}
		}
		return typeHandlerCache.get(type);
	}
}
