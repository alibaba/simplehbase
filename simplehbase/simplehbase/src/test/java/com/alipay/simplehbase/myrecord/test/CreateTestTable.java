package com.alipay.simplehbase.myrecord.test;

public class CreateTestTable {

    public static void main(String[] args) throws Exception {
        MyRecordTestBase.deleteTable();
        MyRecordTestBase.createTable();
    }
}
