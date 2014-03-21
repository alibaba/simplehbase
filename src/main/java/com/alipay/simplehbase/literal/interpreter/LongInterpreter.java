package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

/**
 * LongInterperter.
 * 
 * @author xinzhi.zhang
 * */
public class LongInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Long.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Long.parseLong(literalValue);
    }
}
