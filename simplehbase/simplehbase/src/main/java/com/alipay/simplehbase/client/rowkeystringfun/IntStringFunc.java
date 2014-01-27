package com.alipay.simplehbase.client.rowkeystringfun;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.IntRowKey;

public class IntStringFunc implements RowKeyStringFunc {

    @Override
    public RowKey func(String text) {
        int value = Integer.parseInt(text);
        return new IntRowKey(value);
    }

    @Override
    public String funcName() {
        return "intkey";
    }

}
