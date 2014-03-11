package com.alipay.simplehbase.literal;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.literal.interpreter.*;
import com.alipay.simplehbase.myrecord.Gender;
import com.alipay.simplehbase.util.DateUtil;

/**
 * @author xinzhi
 */
public class TestLiteralValue {
    @Test
    public void testEnum() {
        Object object = new SimpleHbaseRuntimeSetting().interpret(Gender.class,
                "FEMALE");
        Assert.assertEquals(Gender.FEMALE, object);

        object = new SimpleHbaseRuntimeSetting()
                .interpret(Gender.class, "MALE");
        Assert.assertEquals(Gender.MALE, object);
    }

    @Test
    public void testString() {
        Object object = new StringInterpreter().interpret("abc");
        Assert.assertEquals("abc", object);
    }

    @Test
    public void testDate_0() {
        Date cDate = (Date) new DateInterpreter().interpret("2013-12-01");
        Date eDate = DateUtil.parse("2013-12-01", DateUtil.DayFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testDate_1() {
        Date cDate = (Date) new DateInterpreter()
                .interpret("2013-12-01 01:02:03");
        Date eDate = DateUtil.parse("2013-12-01 01:02:03",
                DateUtil.SecondFormat);
        Assert.assertEquals(eDate, cDate);
    }

    @Test
    public void testByte() {
        Object object = new ByteInterpreter().interpret("-1");
        Assert.assertEquals((byte) -1, object);
    }

    @Test
    public void testShort() {
        Object object = new ShortInterpreter().interpret("-1");
        Assert.assertEquals((short) -1, object);
    }

    @Test
    public void testChar() {
        Object object = new CharInterpreter().interpret("c");
        Assert.assertEquals('c', object);
    }

    @Test
    public void testInteger() {
        Object object = new IntegerInterpreter().interpret("-1");
        Assert.assertEquals(-1, object);
    }

    @Test
    public void testLong() {
        Object object = new LongInterpreter().interpret("-1");
        Assert.assertEquals(-1L, object);
    }

    @Test
    public void testFloat() {
        Object object = new FloatInterpreter().interpret("-1");
        Assert.assertEquals(-1.0F, (Float) object, Float.MIN_VALUE);
    }

    @Test
    public void testDouble() {
        Object object = new DoubleInterpreter().interpret("-1");
        Assert.assertEquals(-1.0D, (Double) object, Double.MIN_VALUE);
    }

    @Test
    public void testBoolean() {
        Object object = new BooleanInterpreter().interpret("true");
        Assert.assertEquals(true, object);

        object = new BooleanInterpreter().interpret("f");
        Assert.assertEquals(false, object);
    }
}
