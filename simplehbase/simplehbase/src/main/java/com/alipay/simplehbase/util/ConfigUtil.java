package com.alipay.simplehbase.util;

import java.util.Map;

/**
 * ConfigUtil.
 * 
 * @author xinzhi
 * */
public class ConfigUtil {

    /**
     * Return positive integer value by parsing the value with key in config,
     * otherwise returns defaultValue.
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
