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
        put("id=0,name=aaa,age=10");
        put("id=1,name=bbb,age=11");
        put("id=2,name=ccc,age=12");

        String hql = "count name greater \"aaa\" and age less \"12\"";
        long result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 1);

        hql = "count name greater \"bbb\" and age less \"12\"";
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 0);

        hql = "count name greater \"ccc\" and age less \"12\"";
        result = simpleHbaseClient.countByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), hql, null);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void testVar() {
        put("id=0,name=aaa");
        put("id=1,name=bbb");
        put("id=2,name=bbb");

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
