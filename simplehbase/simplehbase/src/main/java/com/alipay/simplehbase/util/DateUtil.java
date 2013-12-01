package com.alipay.simplehbase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil。
 * 
 * @author xinzhi
 * @version $Id: DateUtil.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class DateUtil {

    public static final String MSFormat     = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String SecondFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String MinuteFormat = "yyyy-MM-dd HH:mm";
    public static final String HourFormat   = "yyyy-MM-dd HH";
    public static final String DayFormat    = "yyyy-MM-dd";

    /**
     * 以format格式解析str为日期，解析失败返回null。
     * */
    public static Date parse(String str, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
        }
        return null;
    }
}
