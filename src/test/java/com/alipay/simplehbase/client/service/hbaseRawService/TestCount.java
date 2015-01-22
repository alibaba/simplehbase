package com.alipay.simplehbase.client.service.hbaseRawService;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author xinzhi
 * */
public class TestCount extends RawServiceTestBase {

    @Before
    public void before() {
        super.before();
        putFat("id=0,name=aaa,age=1,fatage=10");
        putFat("id=1,name=bbb,age=2,fatage=20");
        putFat("id=2,name=ccc,age=4,fatage=30");
    }

    @Test
    public void testCount() {
        long result = simpleHbaseClient.count(countHql(0, 100));
        Assert.assertTrue(result == 3);
    }

    @Test
    public void testConstants() {
        String hql;
        long result;

        hql = countHql("where name greater \"aaa\" and age less \"4\"", 0, 100);
        result = simpleHbaseClient.count(hql);
        Assert.assertTrue(result == 1);

        hql = countHql("where name greater \"bbb\" and age less \"4\"", 0, 100);
        result = simpleHbaseClient.count(hql);
        Assert.assertTrue(result == 0);

        hql = countHql("where name greater \"ccc\" and age less \"4\"", 0, 100);
        result = simpleHbaseClient.count(hql);
        Assert.assertTrue(result == 0);
    }
}
