package com.alipay.simplehbase.type;

/**
 * TypeHandler特定于java的class type,处理和hbase相关的格式转换等工作。
 * 
 * <pre>
 * 一般而言，一个TypeHandler处理一个java class。
 * 处理装箱类型可以放到同一个TypeHandler里面。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: TypeHandler.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface TypeHandler {

	/**
	 * 转换value为hbase的列值。
	 * 
	 * @param type
	 *            java的type。
	 * @param value
	 *            java的value。
	 * @return hbase的列值。
	 * */
	public byte[] toBytes(Class<?> type, Object value);

	/**
	 * 转换hbase的列值为java的object。
	 * 
	 * @param type
	 *            java的type。
	 * @param bytes
	 *            hbase的列值。
	 * @return java的value。
	 * */
	public Object toObject(Class<?> type, byte[] bytes);
}
