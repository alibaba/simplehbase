package com.alipay.simplehbase.client.service.aggregateService;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.alipay.simplehbase.client.AggregateExtInfo;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestCount extends MyRecordTestBase {

    @Before
    public void before() {
        super.before();
        putFat("id=0,name=aaa,age=1,fatage=10");
        putFat("id=1,name=bbb,age=2,fatage=20");
        putFat("id=2,name=ccc,age=4,fatage=30");
    }

    @Test
    public void testCount() {
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100));
        Assert.assertTrue(result == 3);
    }

    @Test
    public void testWithLimit() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);

        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), aggregateExtInfo);
        Assert.assertTrue(result == 1);
    }

    @Test
    public void testWithLimit2() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(1);

        addHql("count where name greater \"aaa\" and age less \"13\"");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result == 1);
    }

    @Test
    public void testWithLimit3() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(2);

        addHql("count where name greater \"aaa\" and age less \"13\"");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result == 2);
    }

    @Test
    public void testWithLimit4() {
        AggregateExtInfo aggregateExtInfo = new AggregateExtInfo();
        aggregateExtInfo.setLimit(3);
        addHql("count where name greater \"aaa\" and age less \"13\"");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null, aggregateExtInfo);
        Assert.assertTrue(result == 2);
    }

    @Test
    public void testConstants() {

        addHql("count where name greater \"aaa\" and age less \"4\"");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 1);

        addHql("count where name greater \"bbb\" and age less \"4\"");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 0);

        addHql("count where name greater \"ccc\" and age less \"4\"");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void testVar() {

        putFat("id=2,name=bbb,age=4,fatage=30");

        addHql("count where name equal #name#");
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", "aaa");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, para);
        Assert.assertTrue(result == 1);

        para.put("name", "bbb");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, para);
        Assert.assertTrue(result == 2);

        para.put("name", "ccc");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, para);
        Assert.assertTrue(result == 0);
    }
}
