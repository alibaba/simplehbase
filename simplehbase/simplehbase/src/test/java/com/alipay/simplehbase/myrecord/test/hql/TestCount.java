package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestCount extends MyRecordTestBase {
    @Test
    public void testConstants() {
        putSlim("id=0,name=aaa,age=10");
        putSlim("id=1,name=bbb,age=11");
        putSlim("id=2,name=ccc,age=12");

        String hql = "count where name greater \"aaa\" and age less \"12\"";
        long result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 1);

        hql = "count where name greater \"bbb\" and age less \"12\"";
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 0);

        hql = "count where name greater \"ccc\" and age less \"12\"";
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void testVar() {
        putSlim("id=0,name=aaa");
        putSlim("id=1,name=bbb");
        putSlim("id=2,name=bbb");

        String hql = "count where name equal #name#";
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", "aaa");
        long result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, para);
        Assert.assertTrue(result == 1);

        para.put("name", "bbb");
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, para);
        Assert.assertTrue(result == 2);

        para.put("name", "ccc");
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, para);
        Assert.assertTrue(result == 0);
    }
}
