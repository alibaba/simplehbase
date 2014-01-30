package com.alipay.simplehbase.client.rowkeytextfun;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;

/**
 * @author xinzhi
 * */
public class StringTextFunc implements RowKeyTextFunc {

    @Override
    public RowKey func(String text) {
        return new StringRowKey(text);
    }

    @Override
    public String funcName() {
        return "stringkey";
    }

}