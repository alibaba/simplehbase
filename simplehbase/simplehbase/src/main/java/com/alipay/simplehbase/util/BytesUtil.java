package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.core.Nullable;

/**
 * BytesUtil.
 * 
 * @author xinzhi
 */
public class BytesUtil {

    /** Empty bytes. */
    public static final byte[] EMPTY = {};

    /** Bytes [ZERO]. */
    public static final byte[] ZERO  = { (byte) 0 };

    /** Bytes [ONE]. */
    public static final byte[] ONE   = { (byte) 1 };

    /**
     * Merge bytes arrays into one bytes array.
     */
    public static byte[] merge(@Nullable byte[]... bytesArray) {
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

    private BytesUtil() {
    }
}