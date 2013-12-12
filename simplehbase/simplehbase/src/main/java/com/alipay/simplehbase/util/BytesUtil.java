package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * 字节工具类。
 * 
 * @author xinzhi
 * @version $Id: BytesUtil.java, v 0.1 2013-9-13 下午03:09:40 xinzhi Exp $
 */
public class BytesUtil {

    /** byte[] ZERO */
    public static final byte[] ZERO = { (byte) 0 };

    /** byte[] ONE */
    public static final byte[] ONE  = { (byte) 1 };

    /**
     * 字节数组合并
     * 
     * @param bytesArray 多个字节数据
     * @return 合并成一个字节数组
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
     * 检查数组长度。
     * */
    public static void checkLength(byte[] values, int length) {
        if (values.length != length) {
            throw new SimpleHBaseException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }
}