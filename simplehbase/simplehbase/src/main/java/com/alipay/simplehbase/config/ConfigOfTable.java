package com.alipay.simplehbase.config;

/**
 * SimpleHbase的table私有配置项。
 * 
 * @author xinzhi
 * @version $Id: ConfigOfTable.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ConfigOfTable {
    /**
     * SCAN_CACHING。控制SCAN的caching大小。
     * */
    public static final String SCAN_CACHING         = "SCAN_CACHING";
    /**
     * SCAN_CACHING的默认大小。
     * */
    public static final int    SCAN_CACHING_DEFAULT = 50;

    /**
     * DELETE_BATCH。批量删除时，批量的大小。
     * */
    public static final String DELETE_BATCH         = "DELETE_BATCH";
    /**
     * DELETE_BATCH的默认大小。
     * */
    public static final int    DELETE_BATCH_DEFAULT = 20;
}
