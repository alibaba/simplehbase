package com.alipay.cp.ext;

import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.io.Writable;

/**
 * The handler to handle keyvalues.
 * 
 * @author xinzhi.zhang
 * */
public interface KeyValueListHandler<T> extends Writable {

    /**
     * init value.
     * */
    public T getInitValue();

    /**
     * handle keyvalues.
     * */
    public T handle(List<KeyValue> keyValues, T t);
}
