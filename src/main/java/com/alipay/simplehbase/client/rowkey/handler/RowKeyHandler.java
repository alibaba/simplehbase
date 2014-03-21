package com.alipay.simplehbase.client.rowkey.handler;

/**
 * Convert hbase's rowkey to rowkey object.
 * 
 * @author xinzhi
 * */
public interface RowKeyHandler {

    /**
     * Convert row key bytes to Object.
     * 
     * @param row hbase row key.
     * @return Object.
     * */
    public Object convert(byte[] row);
}
