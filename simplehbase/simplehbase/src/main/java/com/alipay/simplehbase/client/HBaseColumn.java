package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SimpleHbase POJO field - Hbase table column annotation.
 * 
 * <pre>
 * Applied on POJO's field.
 * The family of @HBaseColumn(if not empty) will override @HBaseTable's family.
 * </pre>
 * 
 * @author xinzhi
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseColumn {

    /**
     * Family name.
     * 
     * @return family.
     */
    public String family() default "";

    /**
     * Qualifier name.
     * 
     * @return qualifier.
     */
    public String qualifier();
}
