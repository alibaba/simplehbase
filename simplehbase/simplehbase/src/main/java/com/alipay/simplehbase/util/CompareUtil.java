package com.alipay.simplehbase.util;

/**
 * CompareUtil。
 * 
 * @author xinzhi
 * @version $Id: CompareUtil.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class CompareUtil {

    /**
     * 比较one和other。
     * */
    public static int compare(Object one, Object other) {
        Comparable cOne = (Comparable) one;
        return cOne.compareTo(other);
    }

    private CompareUtil() {
    }
}
