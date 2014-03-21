package com.alipay.simplehbase.client.rowkey;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author xinzhi
 * */
public class TestBytesRowKey {
    @Test
    public void test() {
        BytesRowKey brk1 = new BytesRowKey(new byte[] { (byte) 1 });
        BytesRowKey brk2 = new BytesRowKey(new byte[] { (byte) 1 });
        Assert.assertEquals(brk1, brk2);
        Assert.assertEquals(brk1.hashCode(), brk2.hashCode());
    }
}
