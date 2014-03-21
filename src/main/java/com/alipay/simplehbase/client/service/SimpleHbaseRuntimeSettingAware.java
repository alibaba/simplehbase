package com.alipay.simplehbase.client.service;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

/**
 * SimpleHbaseRuntimeSettingAware.
 * 
 * @author xinzhi.zhang
 * */
public interface SimpleHbaseRuntimeSettingAware {

    public SimpleHbaseRuntimeSetting getSimpleHbaseRuntimeSetting();

    public void setSimpleHbaseRuntimeSetting(
            SimpleHbaseRuntimeSetting simpleHbaseRuntimeSetting);
}
