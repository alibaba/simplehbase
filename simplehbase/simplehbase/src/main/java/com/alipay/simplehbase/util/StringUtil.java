package com.alipay.simplehbase.util;

import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * StringUtil.
 * 
 * @author xinzhi
 * */
public class StringUtil {

    /**
     * String is null or empty string.
     * */
    public static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * String is NOT null or empty string.
     * */
    public static boolean isNotEmptyString(String str) {
        return !isEmptyString(str);
    }

    /**
     * Check for str is NOT null or empty string.
     * */
    public static void checkEmptyString(String str) {
        if (isEmptyString(str)) {
            throw new SimpleHBaseException("string is null or empty.");
        }
    }

    /**
     * Check string's length.
     * */
    public static void checkLength(String value, int length) {
        if (value.length() != length) {
            throw new SimpleHBaseException("checkLength error. value=" + value
                    + " length=" + length);
        }
    }

    /**
     * Appends msg and value to StringBuiler.
     * */
    public static void append(StringBuilder sb, String msg, Object value) {
        sb.append(msg + "=" + value + "\n");
    }

    /**
     * Appends msg and map to StringBuilder.
     * */
    public static void append(StringBuilder sb, String msg,
            Map<String, String> map) {
        sb.append(msg + "\n");
        if (map != null) {
            for (String key : map.keySet()) {
                sb.append(key + "=" + map.get(key) + "\n");
            }
        }
    }

    /**
     * Appends msg and list to StringBuilder.
     * */
    public static void append(StringBuilder sb, String msg, List<String> list) {
        sb.append(msg + "\n");
        if (list != null) {
            for (String s : list) {
                sb.append(s + "\n");
            }
        }
    }

    private StringUtil() {
    }
}
