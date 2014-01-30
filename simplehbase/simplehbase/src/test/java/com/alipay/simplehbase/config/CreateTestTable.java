package com.alipay.simplehbase.config;

public class CreateTestTable {

    public static void main(String[] args) {
        try {
            Config.deleteTable();
            Config.createTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
