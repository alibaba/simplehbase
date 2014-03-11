package com.alipay.simplehbase.client.rowkeytextfun;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.IntRowKey;

/**
 * @author xinzhi
 * */
public class IntTextFunc implements RowKeyTextFunc {

    @Override
    public RowKey func(String text) {
        int value = Integer.parseInt(text);
        return new IntRowKey(value);
    }

    @Override
    public String funcName() {
        return "intkey";
    }

    @Override
    public String desc() {
        return "use int as rowkey";
    }

}
