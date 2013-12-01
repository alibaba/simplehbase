package com.alipay.simplehbase.type;

import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class TestConvert {

	@Test
	public void testByte() {
		testConvert(byte.class, new Byte((byte) -11));
		testConvert(Byte.class, (byte) 11);
		testConvert(Byte.class, (byte) 0);
	}

	@Test
	public void testShort() {
		testConvert(short.class, new Short((byte) -11));
		testConvert(Short.class, (short) 11);
		testConvert(Short.class, (short) 0);
	}

	@Test
	public void testChar() {
		testConvert(char.class, new Character((char) -300));
		testConvert(Character.class, (char) 11);
		testConvert(Character.class, (char) 256);
		testConvert(Character.class, (char) 0);
	}

	@Test
	public void testInteger() {
		testConvert(int.class, new Integer((byte) -11));
		testConvert(Integer.class, (int) 11);
		testConvert(Integer.class, (int) 0);
	}

	@Test
	public void testLong() {
		testConvert(long.class, new Long((byte) -11));
		testConvert(Long.class, (long) 11);
		testConvert(Long.class, (long) 0);
	}

	@Test
	public void testFloat() {
		testConvert(float.class, new Float((float) -11.11));
		testConvert(Float.class, (float) 11.11);
		testConvert(Float.class, (float) 0);
		testConvert(float.class, Float.NaN);
		testConvert(float.class, Float.POSITIVE_INFINITY);
		testConvert(float.class, Float.NEGATIVE_INFINITY);
	}

	@Test
	public void testDouble() {
		testConvert(double.class, new Double((double) -11.11));
		testConvert(Double.class, (double) 11.11);
		testConvert(Double.class, (double) 0);
		testConvert(double.class, Double.NaN);
		testConvert(double.class, Double.POSITIVE_INFINITY);
		testConvert(double.class, Double.NEGATIVE_INFINITY);
	}

	@Test
	public void testBoolean() {
		testConvert(boolean.class, new Boolean("true"));
		testConvert(Boolean.class, true);
		testConvert(Boolean.class, false);
	}

	@Test
	public void testString() {
		testConvert(String.class, "hello");
		testConvert(String.class, "пеж╝");
	}

	@Test
	public void testDate() {
		testConvert(Date.class, new Date());
	}

	private void testConvert(Class<?> t, Object orig) {
		TypeHandler handler = DefaultTypeHandlers.findDefaultHandler(t);
		byte[] values = handler.toBytes(t, orig);
		Object convertObject = handler.toObject(t, values);
		Assert.assertEquals(orig, convertObject);
	}
}
