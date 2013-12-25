package com.alipay.simplehbase.client.rowkey;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.Util;

/**
 * RowKeyUtil.
 * 
 * @author xinzhi.zhang
 * */
public class RowKeyUtil {
    /**
     * Used by scanners, etc when they want to start at the beginning of a
     * region
     */
    public static RowKey START_ROW = new BytesRowKey(new byte[0]);
    /**
     * Last row in a table.
     */
    public static RowKey END_ROW   = new BytesRowKey(new byte[0]);

    /**
     * Increase rowKey's bytes's last byte by 1.
     * 
     * <pre>
     * if each byte is 0xFF, append byte 0 at tail.
     * </pre>
     * */
    public static RowKey increaseRowKey(RowKey rowKey) {
        Util.checkRowKey(rowKey);
        byte[] oldKey = rowKey.toBytes();
        byte[] newKey = BytesUtil.increaseLastByte(oldKey);
        return new BytesRowKey(newKey);
    }
}
