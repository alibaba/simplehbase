package com.alipay.simplehbase.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author xinzhi.zhang
 * */
public class ExceptionUtil {

    /**
     * Get Exception msg.
     * */
    public static String getExceptionMsg(Exception ex) {
        StringBuilder sb = new StringBuilder();
        if (ex != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            sb.append(sw.toString());
        }
        return sb.toString();
    }
}
