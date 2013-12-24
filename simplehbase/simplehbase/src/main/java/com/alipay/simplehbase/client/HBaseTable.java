package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * simpleHbase POJO-Hbase mapping config.
 * 
 * <pre>
 * Applied on POJO type.
 * The family of HBaseColumn will override HBaseTable's family.
 * </pre>
 * 
 * @author xinzhi
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseTable {

    /**
     * default family name.
     * 
     * @return default family.
     */
    public String defaultFamily() default "";
}
