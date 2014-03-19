package com.alipay.simplehbase.client.rowkey;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.util.EncodingUtil;
import com.alipay.simplehbase.util.Util;

/**
 * BytesRowKey.
 * 
 * @author xinzhi.zhang
 * */
public class BytesRowKey implements RowKey {

    private byte[] key;

    public BytesRowKey(byte[] key) {
        Util.checkNull(key);
        this.key = key;
    }

    @Override
    public byte[] toBytes() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return "BytesRowKey [key=" + EncodingUtil.toHexString(key) + "]";
    }
}
