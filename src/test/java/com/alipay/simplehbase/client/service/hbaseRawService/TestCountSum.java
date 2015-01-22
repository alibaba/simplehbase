package com.alipay.simplehbase.client.service.hbaseRawService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author xinzhi
 */
public class TestCountSum extends RawServiceTestBase {

    @Before
    public void before() {
        super.before();
        putFat("id=0,name=aaa,age=1,fatage=10");
        putFat("id=1,name=bbb,age=2,fatage=20");
        putFat("id=2,name=ccc,age=4,fatage=30");
    }

    @Test
    public void testWithSum_ZeroResult() {
        String hql = countsumHql("( age ) ", "", 100, 200);
        long[] result = simpleHbaseClient.countAndSum(hql);
        Assert.assertTrue(result[0] == 0);
        Assert.assertTrue(result[1] == 0);
    }

    @Test
    public void testWithSum_OneColumn() {
        String hql = countsumHql("( age ) ", "", 0, 100);
        long[] result = simpleHbaseClient.countAndSum(hql);
        Assert.assertTrue(result[0] == 3);
        Assert.assertTrue(result[1] == 7);
    }

    @Test
    public void testWithSum_OneColumn_Filter() {

        String hql = countsumHql("( age ) ",
                "where name greater \"aaa\" and age less \"13\"", 0, 100);
        long[] result = simpleHbaseClient.countAndSum(hql);

        Assert.assertTrue(result[0] == 2);
        Assert.assertTrue(result[1] == 6);
    }

    @Test
    public void testWithSum_TwoColumn() {
        String hql = countsumHql("( age,fatage )", "", 0, 100);
        long[] result = simpleHbaseClient.countAndSum(hql);

        Assert.assertTrue(result[0] == 3);
        Assert.assertTrue(result[1] == 7);
        Assert.assertTrue(result[2] == 60);
    }

    @Test
    public void testWithSum_TwoColumn_Filter() {
        String hql = countsumHql("( age,fatage )",
                "where name greater \"aaa\" and age less \"13\"", 0, 100);
        long[] result = simpleHbaseClient.countAndSum(hql);

        Assert.assertTrue(result[0] == 2);
        Assert.assertTrue(result[1] == 6);
        Assert.assertTrue(result[2] == 50);
    }

}
