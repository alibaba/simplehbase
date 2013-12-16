package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.TestMyRecord;

public class TestNotBetween extends TestMyRecord {

    @Test
    public void testConstants() {
        put("id=0,name=aaa");
        put("id=1,name=bbb");
        put("id=2,name=ccc");

        String hql = "select where name notbetween \"aaa\" and \"aaa\" ";

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);

        Assert.assertTrue(myRecordList.size() == 2);

        hql = "select where name notbetween \"aaa\" and \"bbb\" ";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 1);

        hql = "select where name notbetween \"aaa\" and \"ccc\" ";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 0);

        hql = "select where name notbetween \"aaa\" and \"ddd\" ";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 0);

        hql = "select where name notbetween \"bbb\" and \"ddd\" ";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 1);
    }

    @Test
    public void testVar() {
        put("id=0,name=aaa");
        put("id=1,name=bbb");
        put("id=2,name=ccc");

        String hql = "select where name notbetween #start# and #end#";

        Map<String, Object> para = new HashMap<String, Object>();
        para.put("start", "aaa");
        para.put("end", "aaa");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 2);

        para.put("start", "aaa");
        para.put("end", "bbb");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 1);

        para.put("start", "aaa");
        para.put("end", "ccc");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 0);

        para.put("start", "aaa");
        para.put("end", "ddd");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 0);

        para.put("start", "bbb");
        para.put("end", "ddd");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 1);
    }
}
