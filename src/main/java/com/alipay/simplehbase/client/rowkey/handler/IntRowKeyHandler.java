package com.alipay.simplehbase.client.rowkey.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.client.rowkey.IntRowKey;

/**
 * @author xinzhi
 */
public class IntRowKeyHandler implements RowKeyHandler {

    @Override
    public IntRowKey convert(byte[] row) {
        return new IntRowKey(Bytes.toInt(row));
    }
}
