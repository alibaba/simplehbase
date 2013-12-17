package com.alipay.simplehbase.config;

import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

public class CreateTestTable {

    public static void main(String[] args) throws Exception {
        MyRecordTestBase.deleteTable();
        MyRecordTestBase.createTable();
    }
}
