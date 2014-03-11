package com.alipay.simplehbase.literal;

import com.alipay.simplehbase.core.NotNullable;
import com.alipay.simplehbase.util.Util;

/**
 * The skeleton implementation of LiteralInterpreter.
 * 
 * @author xinzhi
 * */
abstract public class AbstractLiteralInterpreter implements LiteralInterpreter {

    abstract protected Object interpret_internal(
            @NotNullable String literalValue);

    @NotNullable
    public Object interpret(@NotNullable String literalValue) {

        Util.checkNull(literalValue);
        Object obj = interpret_internal(literalValue);
        Util.checkNull(obj);

        return obj;
    }

}
