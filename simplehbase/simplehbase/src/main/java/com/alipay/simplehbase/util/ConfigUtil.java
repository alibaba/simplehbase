package com.alipay.simplehbase.util;

import java.util.Map;

/**
 * ConfigUtil。
 * 
 * @author xinzhi
 * @version $Id: ConfigUtil.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class ConfigUtil {

    /**
     * 解析config中的key对应的value，解析出错或value小于1则返回defaultValue。
     * 
     * @param config config。
     * @param key key。
     * @param defaultValue defaultValue。
     * @return config中的key对应的value，解析出错或value小于1则返回defaultValue。
     * */
    public static int parsePositiveInt(Map<String, String> config, String key,
            int defaultValue) {
        try {
            String vaule = config.get(key);
            int result = Integer.parseInt(vaule);
            if (result > 0) {
                return result;
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private ConfigUtil() {
    }
}
