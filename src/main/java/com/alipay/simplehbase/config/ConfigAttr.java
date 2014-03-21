package com.alipay.simplehbase.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Flag to indicate java attribute is a configuration attribute.
 * 
 * @author xinzhi
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface ConfigAttr {
}
