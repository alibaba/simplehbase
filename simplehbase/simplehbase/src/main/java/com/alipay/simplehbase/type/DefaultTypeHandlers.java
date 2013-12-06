package com.alipay.simplehbase.type;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alipay.simplehbase.type.handler.*;
import com.alipay.simplehbase.util.ClassUtil;

/**
 * Ä¬ÈÏµÄTypeHandler¡£
 * 
 * @author xinzhi
 * @version $Id: DefaultTypeHandlers.java 2013-09-11 ÉÏÎç11:27:31 xinzhi $
 * */
public class DefaultTypeHandlers {
    private static EnumHandler                enumHandler     = new EnumHandler();
    private static Map<Class<?>, TypeHandler> defaultHandlers = new HashMap<Class<?>, TypeHandler>();

    static {
        defaultHandlers.put(String.class, new StringHandler());
        defaultHandlers.put(Date.class, new DateHandler());

        defaultHandlers.put(Boolean.class, new BooleanHandler());

        defaultHandlers.put(Character.class, new CharacterHandler());

        defaultHandlers.put(Byte.class, new ByteHandler());
        defaultHandlers.put(Short.class, new ShortHandler());
        defaultHandlers.put(Integer.class, new IntegerHandler());
        defaultHandlers.put(Long.class, new LongHandler());
        defaultHandlers.put(Float.class, new FloatHandler());
        defaultHandlers.put(Double.class, new DoubleHandler());
    }

    public static TypeHandler findDefaultHandler(Class<?> type) {
        type = ClassUtil.tryConvertToBoxClass(type);

        if (type.isEnum()) {
            return enumHandler;
        }

        return defaultHandlers.get(type);
    }
}
