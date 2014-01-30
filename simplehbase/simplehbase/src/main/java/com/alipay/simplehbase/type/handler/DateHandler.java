package com.alipay.simplehbase.type.handler;

import java.util.Date;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.type.AbstractTypeHandler;
/**
 * @author xinzhi
 * */
public class DateHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == Date.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		long time = ((Date) value).getTime();
		return Bytes.toBytes(time);
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		long time = Bytes.toLong(bytes);
		return new Date(time);
	}
}
