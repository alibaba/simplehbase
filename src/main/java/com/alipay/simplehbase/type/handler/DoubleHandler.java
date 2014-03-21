package com.alipay.simplehbase.type.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.type.AbstractTypeHandler;
/**
 * @author xinzhi
 * */
public class DoubleHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == double.class || type == Double.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		return Bytes.toBytes((Double) value);
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		return Bytes.toDouble(bytes);
	}
}
