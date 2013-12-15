package com.alipay.simplehbase.util;

/**
 * CompareUtil.
 * 
 * @author xinzhi
 * */
public class CompareUtil {

    /**
     * compare one and other.
     * 
     * @return a negative integer, zero, or a positive integer as object one is
     *         less than, equal to, or greater than the object other.
     * */
    public static int compare(Object one, Object other) {
        Comparable cOne = (Comparable) one;
        return cOne.compareTo(other);
    }

    private CompareUtil() {
    }
}
