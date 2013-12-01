package com.alipay.simplehbase.type;

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
	public void testChar() {
		testConvert(char.class, new Character((char) -300));
		testConvert(Character.class, (char) 11);
		testConvert(Character.class, (char) 256);
		testConvert(Character.class, (char) 0);
	}

	private void testConvert(Class<?> t, Object orig) {
		TypeHandler handler = DefaultTypeHandlers.findDefaultHandler(t);
		byte[] values = handler.toBytes(t, orig);
		Object convertObject = handler.toObject(t, values);
		Assert.assertEquals(orig, convertObject);
	}
}
