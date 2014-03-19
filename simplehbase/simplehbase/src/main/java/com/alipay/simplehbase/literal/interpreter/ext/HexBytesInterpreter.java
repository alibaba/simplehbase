package com.alipay.simplehbase.literal.interpreter.ext;

import com.alipay.simplehbase.literal.AbstractLiteralInterpreter;
import com.alipay.simplehbase.type.ext.HexBytes;

/**
 * HexBytesInterpreter.
 * 
 * @author xinzhi.zhang
 * */
public class HexBytesInterpreter extends AbstractLiteralInterpreter {

    @Override
    public Class getTypeCanInterpret() {
        return HexBytes.class;
    }

    @Override
    protected Object interpret_internal(String literalValue) {
        return new HexBytes(literalValue);
    }
}
