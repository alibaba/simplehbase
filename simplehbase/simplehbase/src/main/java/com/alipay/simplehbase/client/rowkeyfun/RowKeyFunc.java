package com.alipay.simplehbase.client.rowkeyfun;

import java.util.List;

import com.alipay.simplehbase.client.RowKey;

/**
 * RowKeyFunc.
 * 
 * @author xinzhi.zhang
 * */
public interface RowKeyFunc {

    /**
     * Convert row key list to one row key.
     * 
     * @param rowKeys rowKeys.
     * @return one row key.
     * */
    public RowKey func(List<RowKey> rowKeys);

    /**
     * Func's name.
     * 
     * @return name.
     * */
    public String funcName();

}
