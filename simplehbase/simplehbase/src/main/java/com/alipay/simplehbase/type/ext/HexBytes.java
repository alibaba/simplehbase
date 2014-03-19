package com.alipay.simplehbase.type.ext;

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
    public String toString() {
        return "HexBytes [bytes=" + EncodingUtil.toHexString(data) + "]";
    }

}