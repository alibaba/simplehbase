package com.alipay.simplehbase.config;

public class CreateTestTable {

    public static void main(String[] args) throws Exception {
        Config.deleteTable();
        Config.createTable();
    }
}
