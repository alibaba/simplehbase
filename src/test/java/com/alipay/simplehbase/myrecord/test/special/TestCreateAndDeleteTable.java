package com.alipay.simplehbase.myrecord.test.special;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import allen.test.Config;

import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestCreateAndDeleteTable extends MyRecordTestBase {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void testCreateAndDelete() throws Exception {
        Config.deleteTable();
        Config.createTable();
    }
}
