package com.alipay.simplehbase.config;

/**
 * The private config item of SimpleHbase's htable.
 * 
 * @author xinzhi
 * */
public class ConfigOfTable {
    /**
     * SCAN_CACHING.
     * 
     * <pre>
     * control caching size of scan.
     * </pre>
     * */
    public static final String SCAN_CACHING         = "SCAN_CACHING";
    /**
     * The default value of SCAN_CACHING.
     * */
    public static final int    SCAN_CACHING_DEFAULT = 50;
    /**
     * DELETE_BATCH.
     * 
     * <pre>
     * batch size when do delete.
     * </pre>
     * */
    public static final String DELETE_BATCH         = "DELETE_BATCH";
    /**
     * The default value of DELETE_BATCH.
     * */
    public static final int    DELETE_BATCH_DEFAULT = 20;
}
