package com.alipay.simplehbase.type;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * TypeHandler的骨架实现。
 * 
 * @author xinzhi
 * @version $Id: AbstractTypeHandler.java 2013-09-11 上午11:27:31 xinzhi $
 * */
abstract public class AbstractTypeHandler implements TypeHandler {

    /**
     * 该Handler是否处理该java的class type。
     * */
    abstract protected boolean aboutToHandle(Class<?> type);

    abstract protected byte[] innerToBytes(Class<?> type, @Nullable Object value);

    abstract protected Object innerToObject(Class<?> type,
            @Nullable byte[] bytes);

    @Override
    public byte[] toBytes(Class<?> type, @Nullable Object value) {
        Util.checkNull(type);

        if (!aboutToHandle(type)) {
            throw new SimpleHBaseException("wrong type to handle. type = "
                    + type);
        }

        if (value == null) {
            return null;
        }

        return innerToBytes(type, value);
    }

    @Override
    public Object toObject(Class<?> type, @Nullable byte[] bytes) {
        Util.checkNull(type);

        if (!aboutToHandle(type)) {
            throw new SimpleHBaseException("wrong type to handle. type = "
                    + type);
        }

        if (bytes == null || bytes.length == 0) {
            return null;
        }

        return innerToObject(type, bytes);
    }

}
