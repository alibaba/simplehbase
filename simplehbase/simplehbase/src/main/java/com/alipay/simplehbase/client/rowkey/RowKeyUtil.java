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
     * Append rowKey's bytes's by appending ZERO byte at tail.
     * 
     * */
    public static RowKey appendZeroToRowKey(RowKey rowKey) {
        Util.checkRowKey(rowKey);
        byte[] oldKey = rowKey.toBytes();
        byte[] newKey = BytesUtil.merge(oldKey, BytesUtil.ZERO);
        return new BytesRowKey(newKey);
    }
}
