package com.alipay.simplehbase.client.rowkey;

import junit.framework.Assert;

import org.junit.Test;

public class TestStringRowKey {

    @Test
    public void test() {
        StringRowKey srk1 = new StringRowKey("allen");
        StringRowKey srk2 = new StringRowKey("danallen".substring(3));
        Assert.assertEquals(srk1, srk2);
        Assert.assertEquals(srk1.hashCode(), srk2.hashCode());
    }
}
