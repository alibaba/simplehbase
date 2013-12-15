package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * BytesUtil.
 * 
 * @author xinzhi
 */
public class BytesUtil {

    /** bytes [ZERO] */
    public static final byte[] ZERO = { (byte) 0 };

    /** bytes [ONE] */
    public static final byte[] ONE  = { (byte) 1 };

    /**
     * merge bytes arrays into one bytes array.
     */
    public static byte[] merge(byte[]... bytesArray) {
        byte[] result = new byte[] {};

        if (bytesArray == null) {
            return result;
        }

        for (byte[] bytes : bytesArray) {
            if (bytes == null) {
                continue;
            }
            result = Bytes.add(result, bytes);
        }

        return result;
    }

    /**
     * check the value's length.
     * */
    public static void checkLength(byte[] values, int length) {
        if (values.length != length) {
            throw new SimpleHBaseException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }

    private BytesUtil() {
    }
}