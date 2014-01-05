package com.alipay.simplehbase.client;

import com.alipay.simplehbase.config.HBaseTableConfig;

/**
 * HBaseTableConfigAware
 * 
 * @author xinzhi.zhang
 * */
public interface HBaseTableConfigAware {

    public HBaseTableConfig getHbaseTableConfig();

    public void setHbaseTableConfig(HBaseTableConfig hbaseTableConfig);
}
