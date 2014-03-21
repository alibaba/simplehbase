package com.alipay.simplehbase.util;

import java.util.ArrayList;
import java.util.List;

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
        Util.checkNull(bytes);

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

    /**
     * Sub bytes.
     * */
    public static byte[] subBytes(byte[] bytes, int index, int length) {
        Util.checkNull(bytes);
        Util.check(index >= 0);
        Util.check(length >= 0);
        Util.check(index + length <= bytes.length);

        byte[] result = new byte[length];
        System.arraycopy(bytes, index, result, 0, length);
        return result;
    }

    /**
     * p's index of bytes.
     * */
    public static int index(byte[] bytes, byte[] p) {
        Util.checkNull(bytes);
        Util.checkNull(p);
        Util.check(bytes.length > 0);
        Util.check(p.length > 0);

        for (int i = 0; i + p.length <= bytes.length; i++) {

            boolean match = true;

            for (int j = 0; j < p.length; j++) {
                if (bytes[i + j] != p[j]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return i;
            }

        }

        return -1;
    }

    /**
     * Split bytes on pattern p.
     * */
    public static List<byte[]> split(byte[] bytes, byte[] p) {
        Util.checkNull(bytes);
        Util.checkNull(p);
        Util.check(bytes.length > 0);
        Util.check(p.length > 0);

        List<byte[]> result = new ArrayList<byte[]>();
        byte[] tem = bytes;
        for (int index = index(tem, p); index != -1; index = index(tem, p)) {
            result.add(subBytes(tem, 0, index));
            tem = subBytes(tem, index + p.length, tem.length - index - p.length);
            if (tem.length == 0) {
                break;
            }
        }

        if (tem.length > 0) {
            result.add(tem);
        }

        return result;
    }

    private BytesUtil() {
    }
}