package com.alipay.simplehbase.literal.interpreter;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;
import com.alipay.simplehbase.util.Util;

/**
 * CharInterperter.
 * 
 * @author xinzhi.zhang
 * */
public class CharInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return Character.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        Util.checkLength(literalValue, 1);
        return literalValue.charAt(0);
    }
}