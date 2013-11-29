package com.alipay.simplehbase.myrecord;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.client.RowKey;

public class MyRecordRowKey implements RowKey {

    private int row;

    public MyRecordRowKey(int row) {
        this.row = row;
    }

    @Override
    public byte[] toBytes() {
        return Bytes.toBytes(row);
    }

    @Override
    public String toString() {
        return "MyRecordRowKey [row=" + row + "]";
    }
}
