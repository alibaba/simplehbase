package com.alipay.simplehbase.myrecord.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xinzhi
 */
public class TestCreateAndDelete extends MyRecordBase {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void testCreateAndDelete() throws Exception {
        MyRecordBase.deleteTable();
        MyRecordBase.createTable();
    }
}
