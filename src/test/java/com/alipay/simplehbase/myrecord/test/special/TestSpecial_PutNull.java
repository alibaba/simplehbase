package com.alipay.simplehbase.myrecord.test.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestSpecial_PutNull extends MyRecordTestBase {

    //hbase default to empty bytes.
    @Test
    public void less() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2,name=ccc");

        addHql("select where name less #name#");
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "ccc");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 2);
    }

    @Test
    public void equal() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2,name=ccc");

        addHql("select where name equal #name#");
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 1);
    }

    @Test
    public void notequal() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2,name=ccc");

        addHql("select where name notequal #name#");
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 2);
    }

    @Test
    public void isnull() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2,name=ccc");

        addHql("select where name isnull");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);
        Assert.assertTrue(myRecordList.size() == 1);
    }

    @Test
    public void isnotnull() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2,name=ccc");

        addHql("select where name isnotnull");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);
        Assert.assertTrue(myRecordList.size() == 2);
    }

}
