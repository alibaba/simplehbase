package com.alipay.simplehbase.client.rowkeystringfun;

import com.alipay.simplehbase.client.RowKey;

/**
 * RowKeyStringFunc.
 * 
 * @author xinzhi.zhang
 * */
public interface RowKeyStringFunc {

    /**
     * Convert string text to one row key.
     * 
     * @param text text.
     * @return one row key.
     * */
    public RowKey func(String text);

    /**
     * Func's name.
     * 
     * @return name.
     * */
    public String funcName();
}
