package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * ShortInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class ShortInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Short.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Short.parseShort(literalValue);
    }
}