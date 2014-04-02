package com.alipay.simplehbase.client.rowkey;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.type.ext.HexBytes;
import com.alipay.simplehbase.util.EncodingUtil;

/**
 * @author xinzhi
 * */
public class TestRowKeyUtil {

    @Test
    public void getEndRowKeyOfPrefix() {
        try {
            RowKeyUtil.getEndRowKeyOfPrefix(null);
            Assert.fail();
        } catch (Exception e) {
            //ignore.
        }

        try {
            RowKeyUtil.getEndRowKeyOfPrefix(new StringRowKey(""));
            Assert.fail();
        } catch (Exception e) {
            //ignore.
        }

        try {
            RowKeyUtil.getEndRowKeyOfPrefix(new BytesRowKey(new HexBytes("FF")
                    .getData()));
            Assert.fail();
        } catch (Exception e) {
            //ignore.
        }

        try {
            RowKeyUtil.getEndRowKeyOfPrefix(new BytesRowKey(new HexBytes(
                    "FF FF").getData()));
            Assert.fail();
        } catch (Exception e) {
            //ignore.
        }

        RowKey endRowKey = RowKeyUtil.getEndRowKeyOfPrefix(new BytesRowKey(
                new HexBytes("FF AB ").getData()));
        Assert.assertEquals("FF AC ",
                EncodingUtil.toHexString(endRowKey.toBytes()));
    }
}
