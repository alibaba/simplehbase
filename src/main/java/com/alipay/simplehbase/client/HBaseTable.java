package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SimpleHbase POJO-Hbase annotation.
 * 
 * <pre>
 * Can be applied on POJO type.
 * The family of @HBaseColumn(if not empty) will override @HBaseTable's family.
 * </pre>
 * 
 * @author xinzhi
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseTable {

    /**
     * Default family name.
     * 
     * @return default family.
     */
    public String defaultFamily() default "";
}
