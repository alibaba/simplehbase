package com.alipay.simplehbase.type.ext;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.alipay.simplehbase.util.EncodingUtil;
import com.alipay.simplehbase.util.Util;

/**
 * HexBytes.
 * 
 * @author xinzhi
 * */
public class HexBytes {

    private byte[] data;

    public HexBytes(byte[] data) {
        Util.checkNull(data);
        this.data = data;
    }

    public HexBytes(String hexStr) {
        Util.checkNull(hexStr);
        this.data = EncodingUtil.parseBytesFromHexString(hexStr);
    }

    public byte[] getData() {
        return data;
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
        return "HexBytes [bytes=" + EncodingUtil.toHexString(data) + "]";
    }

}