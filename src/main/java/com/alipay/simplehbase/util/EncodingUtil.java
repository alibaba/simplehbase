package com.alipay.simplehbase.util;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * EncodingUtil.
 * 
 * @author xinzhi.zhang
 * */
public class EncodingUtil {

    private static String[] int2Hex = new String[] { "0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", };

    /**
     * Convert bytes to hex string.
     * */
    public static String toHexString(byte[] bytes) {
        Util.checkNull(bytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(toHexString(b) + " ");
        }
        return sb.toString();
    }

    /**
     * Convert byte to hex string.
     * */
    private static String toHexString(byte b) {

        StringBuilder sb = new StringBuilder();

        int r1 = (b >>> 4) & 0xF;
        sb.append(int2Hex[r1]);
        int r2 = b & 0xF;
        sb.append(int2Hex[r2]);
        return sb.toString();
    }

    /**
     * Convert hex string to bytes.
     * */
    public static byte[] parseBytesFromHexString(String hexStr) {
        Util.checkNull(hexStr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hexStr.length(); i++) {

            char c = hexStr.charAt(i);

            if (c >= '0' && c <= '9') {
                sb.append(c);
                continue;
            }
            if (c >= 'A' && c <= 'F') {
                sb.append(c);
                continue;
            }
            if (c >= 'a' && c <= 'f') {
                sb.append(c);
                continue;
            }

            //only accept 0-9 A-Z a-z, drop other char.
        }

        return parseBytesFromHexString_0(sb.toString());
    }

    private static byte[] parseBytesFromHexString_0(String hexStr) {
        Util.checkNull(hexStr);

        if (hexStr.length() % 2 != 0) {
            throw new SimpleHBaseException("error. hexStr=" + hexStr);
        }

        byte[] result = new byte[hexStr.length() / 2];

        for (int i = 0; i < result.length; i++) {
            String s = hexStr.substring(i * 2, i * 2 + 2);
            int value = Integer.parseInt(s, 16);
            result[i] = (byte) value;
        }
        return result;
    }
}
