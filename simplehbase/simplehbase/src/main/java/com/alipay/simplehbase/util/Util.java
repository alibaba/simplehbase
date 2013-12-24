package com.alipay.simplehbase.util;

import java.io.Closeable;
import java.io.IOException;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * Client Util.
 * 
 * @author xinzhi
 * */
public class Util {

    /**
     * Check boolean is NOT false.
     * */
    public static void check(boolean bool) {
        if (bool == false) {
            throw new SimpleHBaseException("bool is false.");
        }
    }

    /**
     * Check object is NOT null.
     * */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new SimpleHBaseException("obj  is null.");
        }
    }

    /**
     * Check for string is NOT null or empty string.
     * */
    public static void checkEmptyString(String str) {
        if (StringUtil.isEmptyString(str)) {
            throw new SimpleHBaseException("str is null or empty.");
        }
    }

    /**
     * Check the value's length.
     * */
    public static void checkLength(byte[] values, int length) {
        Util.checkNull(values);

        if (values.length != length) {
            throw new SimpleHBaseException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }

    /**
     * Check string's length.
     * */
    public static void checkLength(String value, int length) {
        Util.checkNull(value);

        if (value.length() != length) {
            throw new SimpleHBaseException("checkLength error. value=" + value
                    + " length=" + length);
        }
    }

    /**
     * Check rowKey.
     * 
     * <pre>
     * rowKey is not null.
     * the result of rowKey's toBytes is not null.
     * </pre>
     * 
     * */
    public static void checkRowKey(RowKey rowKey) {
        checkNull(rowKey);

        if (rowKey.toBytes() == null) {
            throw new SimpleHBaseException("rowkey bytes is null. rowKey = "
                    + rowKey);
        }
    }

    /**
     * Close Closeable.
     * */
    public static void close(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            throw new SimpleHBaseException("close closeable exception.", e);
        }
    }

    /**
     * Check for 2 objects have identity type.
     * */
    public static void checkIdentityType(Object one, Object other) {
        checkNull(one);
        checkNull(other);

        if (one.getClass() != other.getClass()) {
            throw new SimpleHBaseException("not same type. one = " + one
                    + " other = " + other);
        }
    }

    private Util() {
    }
}
