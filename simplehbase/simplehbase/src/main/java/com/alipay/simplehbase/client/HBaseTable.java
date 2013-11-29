package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * simpleHbase的POJO-Hbase映射配置类。
 * 
 * <pre>
 * 作用于POJO的type。
 * HBaseColumn配置的family会自动覆盖通过HBaseTable配置的family。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: HBaseTable.java 2013-09-11 上午11:27:31 xinzhi $
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseTable {

    /**
     * default family name。
     * 
     * @return default family。
     */
    public String defaultFamily() default "";
}
