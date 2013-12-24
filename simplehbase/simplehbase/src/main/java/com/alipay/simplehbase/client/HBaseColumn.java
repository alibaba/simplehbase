package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * simpleHbase's POJO-Hbase column mapping.
 * 
 * <pre>
 * Applied on POJO's field.
 * The family of HBaseColumn will override HBaseTable's family.
 * </pre>
 * 
 * @author xinzhi
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseColumn {

    /**
     * family name.
     * 
     * @return family.
     */
    public String family() default "";

    /**
     * qualifier name.
     * 
     * @return qualifier.
     */
    public String qualifier();
}
