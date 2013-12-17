package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordBase;
/**
 * @author xinzhi
 */
public class TestOr extends MyRecordBase {

    @Test
    public void testConstants() {
        put("id=0,name=aaa,age=10");
        put("id=1,name=bbb,age=11");
        put("id=2,name=ccc,age=12");

        String hql = "select where name greater \"aaa\" or age less \"12\"";

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);

        Assert.assertTrue(myRecordList.size() == 3);

        hql = "select where name greater \"bbb\" or age less \"12\"";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 3);

        hql = "select where name greater \"ccc\" or age less \"12\"";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 2);
    }

    @Test
    public void testVar() {
        put("id=0,name=aaa,age=10");
        put("id=1,name=bbb,age=11");
        put("id=2,name=ccc,age=12");

        String hql = "select where name greater #name# or age less #age#";
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", "aaa");
        para.put("age", 12L);

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 3);

        para.put("name", "bbb");
        para.put("age", 12L);
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 3);

        para.put("name", "ccc");
        para.put("age", 12L);
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 2);

    }
}
