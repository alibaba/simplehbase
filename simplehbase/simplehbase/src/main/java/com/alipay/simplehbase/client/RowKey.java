package com.alipay.simplehbase.client;

/**
 * RowKey对应于hbase的rowkey。
 * 
 * @author xinzhi
 * @version $Id: RowKey.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface RowKey {

    /**
     * 转换对象为byte[]的形式。
     * 
     * @return rowKey的byte[]形式。
     * */
    public byte[] toBytes();
}
