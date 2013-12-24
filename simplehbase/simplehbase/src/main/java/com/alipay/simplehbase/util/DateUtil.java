package com.alipay.simplehbase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil.
 * 
 * @author xinzhi
 * */
public class DateUtil {

    public static final String MSFormat     = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String SecondFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String MinuteFormat = "yyyy-MM-dd HH:mm";
    public static final String HourFormat   = "yyyy-MM-dd HH";
    public static final String DayFormat    = "yyyy-MM-dd";

    /**
     * Returns date by parsing string with specified format, or null if parsing
     * fails.
     * */
    public static Date parse(String str, String format) {
        Util.checkEmptyString(str);
        Util.checkEmptyString(format);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            //ignore.
        }
        return null;
    }
}
