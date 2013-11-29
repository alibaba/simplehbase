package com.alipay.simplehbase.config;

/**
 * SimpleHbase的datasource私有配置项。
 * 
 * @author xinzhi
 * @version $Id: ConfigOfDataSource.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ConfigOfDataSource {
    /**
     * HTABLE_POOL_SIZE。控制HTablePool的大小。大于0。
     * */
    public static final String HTABLE_POOL_SIZE         = "HTABLE_POOL_SIZE";
    /**
     * HTABLE_POOL_SIZE的默认值。
     * */
    public static final int    HTABLE_POOL_SIZE_DEFAULT = 10;
}
