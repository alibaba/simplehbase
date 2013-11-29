package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * simpleHbase的POJO-Hbase映射配置类。
 * 
 * <pre>
 * 作用于POJO的field。
 * HBaseColumn配置的family会自动覆盖通过HBaseTable配置的family。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: HBaseColumn.java 2013-09-11 上午11:27:31 xinzhi $
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseColumn {

    /**
     * family name。
     * 
     * @return family。
     */
    public String family() default "";

    /**
     * qualifier name。
     * 
     * @return qualifier。
     */
    public String qualifier();
}
