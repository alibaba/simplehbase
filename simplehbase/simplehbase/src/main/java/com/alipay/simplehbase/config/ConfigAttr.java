package com.alipay.simplehbase.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记一个java对象的attr为一个配置属性。
 * 
 * @author xinzhi
 * @version $Id: ConfigAttr.java 2013-09-11 上午11:27:31 xinzhi $
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface ConfigAttr {
}
