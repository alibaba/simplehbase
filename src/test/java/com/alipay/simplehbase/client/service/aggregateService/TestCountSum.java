package com.alipay.simplehbase.client.service.aggregateService;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.alipay.simplehbase.client.AggregateExtInfo;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestCountSum extends MyRecordTestBase {

    @Before
    public void before() {
        super.before();
        putFat("id=0,name=aaa,age=1,fatage=10");
        putFat("id=1,name=bbb,age=2,fatage=20");
        putFat("id=2,name=ccc,age=4,fatage=30");
    }

    @Test
    public void testCount() {
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), null, null, null);
        Assert.assertTrue(result[0] == 3);
    }

    @Test
    public void testCount_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), null, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
    }

    @Test
    public void testCount_Filter() {
        addHql("countsum ( age ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 2);

    }

    @Test
    public void testCount_Filter_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);
        addHql("countsum ( age ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
    }

    @Test
    public void testWithSum_ZeroResult() {
        addHql("countsum ( age )  ");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(100),
                new MyRecordRowKey(200), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 0);
        Assert.assertTrue(result[1] == 0);
    }

    @Test
    public void testWithSum_OneColumn() {
        addHql("countsum ( age )  ");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 3);
        Assert.assertTrue(result[1] == 7);
    }

    @Test
    public void testWithSum_OneColumn_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);

        addHql("countsum ( age )  ");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
        Assert.assertTrue(result[1] == 1);
    }

    @Test
    public void testWithSum_OneColumn_Filter() {
        addHql("countsum ( age ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 2);
        Assert.assertTrue(result[1] == 6);
    }

    @Test
    public void testWithSum_OneColumn_Filter_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);
        addHql("countsum ( age ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
        Assert.assertTrue(result[1] == 2);
    }

    @Test
    public void testWithSum_TwoColumn() {
        addHql("countsum ( age,fatage )  ");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 3);
        Assert.assertTrue(result[1] == 7);
        Assert.assertTrue(result[2] == 60);
    }

    @Test
    public void testWithSum_TwoColumn_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);

        addHql("countsum ( age,fatage )  ");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
        Assert.assertTrue(result[1] == 1);
        Assert.assertTrue(result[2] == 10);
    }

    @Test
    public void testWithSum_TwoColumn_Filter() {
        addHql("countsum ( age,fatage ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, null);
        Assert.assertTrue(result[0] == 2);
        Assert.assertTrue(result[1] == 6);
        Assert.assertTrue(result[2] == 50);
    }

    @Test
    public void testWithSum_TwoColumn_Filter_Limit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);
        addHql("countsum ( age,fatage ) where name greater \"aaa\" and age less \"13\"");
        long[] result = simpleHbaseClient.countAndSum(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result[0] == 1);
        Assert.assertTrue(result[1] == 2);
        Assert.assertTrue(result[2] == 20);
    }

}
