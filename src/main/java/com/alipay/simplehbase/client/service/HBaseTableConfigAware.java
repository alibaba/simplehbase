package com.alipay.simplehbase.client.service;

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
