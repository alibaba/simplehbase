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
     * Increase bytes's last byte by 1.
     * 
     * <pre>
     * if each byte is 0xFF, append byte 0 at tail.
     * </pre>
     * */
    public static byte[] increaseLastByte(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return ZERO;
        }

        byte[] result = new byte[bytes.length];
        System.arraycopy(bytes, 0, result, 0, bytes.length);

        for (int i = result.length - 1; i >= 0; i--) {
            if ((result[i] & 0xFF) != 0xFF) {
                result[i] = (byte) ((result[i] & 0xFF) + 1);
                return result;
            }
        }

        return merge(result, ZERO);
    }

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