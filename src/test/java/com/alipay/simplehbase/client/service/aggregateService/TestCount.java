package com.alipay.simplehbase.client.service.aggregateService;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestCount extends MyRecordTestBase {

    @Test
    public void test() {
        putSlim("id=0,name=aaa,age=10");
        putSlim("id=1,name=bbb,age=11");
        putSlim("id=2,name=ccc,age=12");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100));
        Assert.assertTrue(result == 3);
    }

    @Test
    public void testConstants() {
        putSlim("id=0,name=aaa,age=10");
        putSlim("id=1,name=bbb,age=11");
        putSlim("id=2,name=ccc,age=12");

        addHql("count where name greater \"aaa\" and age less \"12\"");
        long result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 1);

        addHql("count where name greater \"bbb\" and age less \"12\"");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 0);

        addHql("count where name greater \"ccc\" and age less \"12\"");
        result = simpleHbaseClient.count(new MyRecordRowKey(0),
                new MyRecordRowKey(100), TestHqlId, null);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void testVar() {
        putSlim("id=0,name=aaa");
        putSlim("id=1,name=bbb");
        putSlim("id=2,name=bbb");

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
