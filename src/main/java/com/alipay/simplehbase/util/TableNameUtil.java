package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.TableName;

/**
 * TableNameUtil.
 * 
 * @author xinzhi
 * */
public class TableNameUtil {

    /**
     * Get TableName of fullName.
     * 
     * @param fullName fullName.
     * @return TableName
     * */
    public static TableName getTableName(String fullName) {
        Util.checkEmptyString(fullName);
        return TableName.valueOf(fullName);
    }

    private TableNameUtil() {
    }
}
