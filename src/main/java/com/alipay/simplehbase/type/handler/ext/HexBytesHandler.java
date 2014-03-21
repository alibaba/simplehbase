package com.alipay.simplehbase.type.handler.ext;

import com.alipay.simplehbase.type.AbstractTypeHandler;
import com.alipay.simplehbase.type.ext.HexBytes;

/**
 * HexBytesHandler
 * 
 * @author xinzhi.zhang
 * */
public class HexBytesHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == HexBytes.class;
    }

    @Override
    protected byte[] innerToBytes(Class<?> type, Object value) {
        return ((HexBytes) value).getData();
    }

    @Override
    protected Object innerToObject(Class<?> type, byte[] bytes) {
        return new HexBytes(bytes);
    }
}
