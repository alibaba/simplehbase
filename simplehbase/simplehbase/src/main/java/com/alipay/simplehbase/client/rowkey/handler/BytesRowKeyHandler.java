package com.alipay.simplehbase.client.rowkey.handler;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;

public class BytesRowKeyHandler implements RowKeyHandler {

    @Override
    public BytesRowKey convert(byte[] row) {
        return new BytesRowKey(row);
    }
}
