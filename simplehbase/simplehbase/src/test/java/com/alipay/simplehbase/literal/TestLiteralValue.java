package com.alipay.simplehbase.literal;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.Gender;
import com.alipay.simplehbase.util.DateUtil;

public class TestLiteralValue {
    @Test
    public void testEnum() {
        Object object = LiteralValue.convertToObject(Gender.class, "FEMALE");
        Assert.assertEquals(Gender.FEMALE, object);

        object = LiteralValue.convertToObject(Gender.class, "MALE");
        Assert.assertEquals(Gender.MALE, object);
    }

    @Test
    public void testString() {
        Object object = LiteralValue.convertToObject(String.class, "abc");
        Assert.assertEquals("abc", object);
        object = LiteralValue.convertToObject(String.class, "信之");
        Assert.assertEquals("信之", object);
    }

    @Test
    public void testDate_0() {
        Date cDate = (Date) LiteralValue.convertToObject(Date.class,
                "2013-12-01");
        Date eDate = DateUtil.parse("2013-12-01", DateUtil.DayFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testDate_1() {
        Date cDate = (Date) LiteralValue.convertToObject(Date.class,
                "2013-12-01 01:02:03");
        Date eDate = DateUtil.parse("2013-12-01 01:02:03",
                DateUtil.SecondFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testByte() {
        Object object = LiteralValue.convertToObject(byte.class, "-1");
        Assert.assertEquals((byte) -1, object);
    }

    @Test
    public void testShort() {
        Object object = LiteralValue.convertToObject(short.class, "-1");
        Assert.assertEquals((short) -1, object);
    }

    @Test
    public void testChar() {
        Object object = LiteralValue.convertToObject(char.class, "c");
        Assert.assertEquals('c', object);
    }

    @Test
    public void testInteger() {
        Object object = LiteralValue.convertToObject(int.class, "-1");
        Assert.assertEquals(-1, object);
    }

    @Test
    public void testLong() {
        Object object = LiteralValue.convertToObject(long.class, "-1");
        Assert.assertEquals(-1L, object);
    }

    @Test
    public void testFloat() {
        Object object = LiteralValue.convertToObject(float.class, "-1");
        Assert.assertEquals(-1.0F, (Float) object, Float.MIN_VALUE);
    }

    @Test
    public void testDouble() {
        Object object = LiteralValue.convertToObject(Double.class, "-1");
        Assert.assertEquals(-1.0D, (Double) object, Double.MIN_VALUE);
    }

    @Test
    public void testBoolean() {
        Object object = LiteralValue.convertToObject(Boolean.class, "true");
        Assert.assertEquals(true, object);

        object = LiteralValue.convertToObject(Boolean.class, "f");
        Assert.assertEquals(false, object);
    }
}
