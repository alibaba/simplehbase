package com.alipay.simplehbase.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * simpleHbase's POJO-Hbase mapping.
 * 
 * <pre>
 * Applied on POJO's field.
 * Flag to indicate this field is POJO's version object.
 * The field flagged with HBaseVersion should be flagged with HBaseColumn.
 * One POJO would have 0 or 1 HBaseVersion flagged field.
 * </pre>
 * 
 * @author xinzhi
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseVersion {
}
