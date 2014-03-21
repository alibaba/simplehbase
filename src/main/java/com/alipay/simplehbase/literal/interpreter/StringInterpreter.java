package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * StringInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class StringInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return String.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return literalValue;
    }
}
