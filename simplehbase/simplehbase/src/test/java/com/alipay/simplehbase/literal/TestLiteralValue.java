package com.alipay.simplehbase.literal;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.Gender;
import com.alipay.simplehbase.util.DateUtil;

/**
 * @author xinzhi
 */
public class TestLiteralValue {
    @Test
    public void testEnum() {
        Object object = LiteralValueInterpreter.convertToObject(Gender.class, "FEMALE");
        Assert.assertEquals(Gender.FEMALE, object);

        object = LiteralValueInterpreter.convertToObject(Gender.class, "MALE");
        Assert.assertEquals(Gender.MALE, object);
    }

    @Test
    public void testString() {
        Object object = LiteralValueInterpreter.convertToObject(String.class, "abc");
        Assert.assertEquals("abc", object);
    }

    @Test
    public void testDate_0() {
        Date cDate = (Date) LiteralValueInterpreter.convertToObject(Date.class,
                "2013-12-01");
        Date eDate = DateUtil.parse("2013-12-01", DateUtil.DayFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testDate_1() {
        Date cDate = (Date) LiteralValueInterpreter.convertToObject(Date.class,
                "2013-12-01 01:02:03");
        Date eDate = DateUtil.parse("2013-12-01 01:02:03",
                DateUtil.SecondFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testByte() {
        Object object = LiteralValueInterpreter.convertToObject(byte.class, "-1");
        Assert.assertEquals((byte) -1, object);
    }

    @Test
    public void testShort() {
        Object object = LiteralValueInterpreter.convertToObject(short.class, "-1");
        Assert.assertEquals((short) -1, object);
    }

    @Test
    public void testChar() {
        Object object = LiteralValueInterpreter.convertToObject(char.class, "c");
        Assert.assertEquals('c', object);
    }

    @Test
    public void testInteger() {
        Object object = LiteralValueInterpreter.convertToObject(int.class, "-1");
        Assert.assertEquals(-1, object);
    }

    @Test
    public void testLong() {
        Object object = LiteralValueInterpreter.convertToObject(long.class, "-1");
        Assert.assertEquals(-1L, object);
    }

    @Test
    public void testFloat() {
        Object object = LiteralValueInterpreter.convertToObject(float.class, "-1");
        Assert.assertEquals(-1.0F, (Float) object, Float.MIN_VALUE);
    }

    @Test
    public void testDouble() {
        Object object = LiteralValueInterpreter.convertToObject(Double.class, "-1");
        Assert.assertEquals(-1.0D, (Double) object, Double.MIN_VALUE);
    }

    @Test
    public void testBoolean() {
        Object object = LiteralValueInterpreter.convertToObject(Boolean.class, "true");
        Assert.assertEquals(true, object);

        object = LiteralValueInterpreter.convertToObject(Boolean.class, "f");
        Assert.assertEquals(false, object);
    }
}
