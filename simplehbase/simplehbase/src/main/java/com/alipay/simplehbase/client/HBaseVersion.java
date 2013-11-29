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
 * 用于标示该field为POJO的版本号对象。
 * 标示为HBaseVersion的field必须同时标示为HBaseColumn，否则无效。
 * 1个POJO只能有至多1个field使用该标示。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: HBaseVersion.java 2013-09-11 上午11:27:31 xinzhi $
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HBaseVersion {

}
