package com.alipay.simplehbase.myrecord.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xinzhi
 */
public class TestCreateAndDelete extends MyRecordTestBase {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void testCreateAndDelete() throws Exception {
        MyRecordTestBase.deleteTable();
        MyRecordTestBase.createTable();
    }
}
