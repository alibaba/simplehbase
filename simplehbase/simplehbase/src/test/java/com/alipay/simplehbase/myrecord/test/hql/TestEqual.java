package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;
/**
 * @author xinzhi
 */
public class TestEqual extends MyRecordTestBase {

    @Test
    public void testConstants() {
        putSlim("id=0,name=aaa");
        putSlim("id=1,name=bbb");
        putSlim("id=2,name=bbb");

        String hql = "select where name equal \"aaa\"";

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);

        Assert.assertTrue(myRecordList.size() == 1);

        hql = "select where name equal \"bbb\"";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 2);

        hql = "select where name equal \"ccc\"";
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        Assert.assertTrue(myRecordList.size() == 0);
    }

    @Test
    public void testVar() {
        putSlim("id=0,name=aaa");
        putSlim("id=1,name=bbb");
        putSlim("id=2,name=bbb");

        String hql = "select where name equal #name#";
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", "aaa");
        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 1);

        para.put("name", "bbb");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 2);

        para.put("name", "ccc");
        myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 0);
    }

}
