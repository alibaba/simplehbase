package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * ByteInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class ByteInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Byte.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Byte.parseByte(literalValue);
    }
}