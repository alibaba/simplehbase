package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;

public class FloatInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Float.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return Float.parseFloat(literalValue);
    }
}