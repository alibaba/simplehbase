package com.alipay.simplehbase.config;

/**
 * The private config item of SimpleHbase's datasource.
 * 
 * @author xinzhi
 * */
public class ConfigOfDataSource {
    /**
     * HTABLE_POOL_SIZE.
     * 
     * <pre>
     * HTable pool size.
     * </pre>
     * */
    public static final String HTABLE_POOL_SIZE         = "HTABLE_POOL_SIZE";
    /**
     * The default value of HTABLE_POOL_SIZE.
     * */
    public static final int    HTABLE_POOL_SIZE_DEFAULT = 10;
}
