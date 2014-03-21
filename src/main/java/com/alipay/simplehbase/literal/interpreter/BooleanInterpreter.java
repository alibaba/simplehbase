package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * BooleanInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class BooleanInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Boolean.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Boolean.parseBoolean(literalValue);
    }
}