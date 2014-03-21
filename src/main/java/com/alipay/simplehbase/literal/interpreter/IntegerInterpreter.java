package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * IntegerInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class IntegerInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Integer.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Integer.parseInt(literalValue);
    }

}
