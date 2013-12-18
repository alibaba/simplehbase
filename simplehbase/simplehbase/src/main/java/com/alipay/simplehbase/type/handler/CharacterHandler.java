package com.alipay.simplehbase.type.handler;

import com.alipay.simplehbase.type.AbstractTypeHandler;
import com.alipay.simplehbase.util.Util;

public class CharacterHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == char.class || type == Character.class;
    }

    @Override
    protected byte[] innerToBytes(Class<?> type, Object value) {
        char c = ((Character) value).charValue();
        byte[] result = new byte[2];
        result[1] = (byte) c;
        result[0] = (byte) (c >>> 8);
        return result;
    }

    @Override
    protected Object innerToObject(Class<?> type, byte[] bytes) {
        Util.checkLength(bytes, 2);

        int c = 0;
        c ^= (bytes[0] & 0xFF);
        c = c << 8;
        c ^= (bytes[1] & 0xFF);
        return (char) c;
    }
}
