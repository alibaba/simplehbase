package com.alipay.simplehbase.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.core.Nullable;

/**
 * ConfigUtil.
 * 
 * @author xinzhi
 * */
public class ConfigUtil {

    /** log. */
    private static Logger log = Logger.getLogger(ConfigUtil.class);

    /**
     * Return positive integer value by parsing the value with key in config,
     * otherwise returns defaultValue.
     * */
    public static int parsePositiveInt(Map<String, String> config, String key,
            int defaultValue) {
        Util.checkNull(config);
        Util.checkEmptyString(key);
        Util.check(defaultValue > 0);

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

    /**
     * Load config file.
     * 
     * */
    public static Map<String, String> loadConfigFile(@Nullable String filePath)
            throws IOException {

        Map<String, String> result = new HashMap<String, String>();
        if (StringUtil.isEmptyString(filePath)) {
            return result;
        }

        LineNumberReader lineNumberReader = null;
        try {
            lineNumberReader = new LineNumberReader(new FileReader(filePath));
            for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader
                    .readLine()) {

                String[] parts = line.split("=");
                if (parts == null || parts.length != 2) {
                    log.warn("wrong config line. file=" + filePath + " line="
                            + line);
                    continue;
                }

                result.put(parts[0], parts[1]);
            }
        } finally {
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
        }

        return result;
    }

    private ConfigUtil() {
    }
}
