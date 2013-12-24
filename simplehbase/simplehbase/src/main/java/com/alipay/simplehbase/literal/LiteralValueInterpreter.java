package com.alipay.simplehbase.literal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.DateUtil;
import com.alipay.simplehbase.util.Util;

/**
 * Literal value interpreter.
 * 
 * @author xinzhi
 * */
public class LiteralValueInterpreter {

    private static List<String> dateFormats = new ArrayList<String>();

    static {
        dateFormats.add(DateUtil.MSFormat);
        dateFormats.add(DateUtil.SecondFormat);
        dateFormats.add(DateUtil.MinuteFormat);
        dateFormats.add(DateUtil.HourFormat);
        dateFormats.add(DateUtil.DayFormat);
    }

    /**
     * Convert literal value to specified java object with type.
     * */
    public static Object convertToObject(Class type, String literalValue) {
        Util.checkNull(type);
        Util.checkNull(literalValue);

        type = ClassUtil.tryConvertToBoxClass(type);

        Object obj = null;

        if (type == String.class) {
            obj = literalValue;
        }

        if (type == Date.class) {
            obj = convertToDate(literalValue);
        }

        if (type == Boolean.class) {
            obj = Boolean.parseBoolean(literalValue);
        }

        if (type == Byte.class) {
            obj = Byte.parseByte(literalValue);
        }

        if (type == Short.class) {
            obj = Short.parseShort(literalValue);
        }

        if (type == Character.class) {
            Util.checkLength(literalValue, 1);
            obj = literalValue.charAt(0);
        }

        if (type == Integer.class) {
            obj = Integer.parseInt(literalValue);
        }

        if (type == Long.class) {
            obj = Long.parseLong(literalValue);
        }

        if (type == Float.class) {
            obj = Float.parseFloat(literalValue);
        }

        if (type == Double.class) {
            obj = Double.parseDouble(literalValue);
        }

        if (type.isEnum()) {
            obj = Enum.valueOf(type, literalValue);
        }

        Util.checkNull(obj);

        return obj;
    }

    private static Date convertToDate(String literalValue) {
        Util.checkEmptyString(literalValue);

        for (String s : dateFormats) {
            Date date = DateUtil.parse(literalValue, s);
            if (date != null) {
                return date;
            }
        }

        throw new SimpleHBaseException("cannot convert to date. literalValue="
                + literalValue);
    }
}
