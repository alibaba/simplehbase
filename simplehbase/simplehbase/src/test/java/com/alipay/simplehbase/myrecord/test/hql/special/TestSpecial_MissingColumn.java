package com.alipay.simplehbase.myrecord.test.hql.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyFatRecord;

import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestSpecial_MissingColumn extends MyRecordTestBase {

    @Test
    public void less() {
        putSlim("id=0");
        putFat("id=1,fatname=aaa");
        putFat("id=2,fatname=bbb");

        String hql = "select where fatname less #name#";
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "ccc");

        List<MyFatRecord> myRecordList = simpleHbaseClient
                .findObjectListByRawHql(new MyRecordRowKey(0),
                        new MyRecordRowKey(100), MyFatRecord.class, hql, para);
        Assert.assertTrue(myRecordList.size() == 2);
    }

    @Test
    public void equal() {
        putSlim("id=0");
        putFat("id=1,fatname=aaa");
        putFat("id=2,fatname=bbb");

        String hql = "select where fatname equal #name#";
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "");

        List<MyFatRecord> myRecordList = simpleHbaseClient
                .findObjectListByRawHql(new MyRecordRowKey(0),
                        new MyRecordRowKey(100), MyFatRecord.class, hql, para);
        Assert.assertTrue(myRecordList.size() == 0);
    }

    @Test
    public void notequal() {
        putSlim("id=0");
        putFat("id=1,fatname=aaa");
        putFat("id=2,fatname=bbb");

        String hql = "select where fatname notequal #name#";
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "");

        List<MyFatRecord> myRecordList = simpleHbaseClient
                .findObjectListByRawHql(new MyRecordRowKey(0),
                        new MyRecordRowKey(100), MyFatRecord.class, hql, para);
        Assert.assertTrue(myRecordList.size() == 2);
    }

    @Test
    public void isnull() {
        putSlim("id=0");
        putFat("id=1,fatname=aaa");
        putFat("id=2,fatname=bbb");

        String hql = "select where fatname isnull";

        List<MyFatRecord> myRecordList = simpleHbaseClient
                .findObjectListByRawHql(new MyRecordRowKey(0),
                        new MyRecordRowKey(100), MyFatRecord.class, hql, null);
        Assert.assertTrue(myRecordList.size() == 0);
    }

    @Test
    public void isnotnull() {
        putSlim("id=0");
        putFat("id=1,fatname=aaa");
        putFat("id=2,fatname=bbb");

        String hql = "select where fatname isnotnull";

        List<MyFatRecord> myRecordList = simpleHbaseClient
                .findObjectListByRawHql(new MyRecordRowKey(0),
                        new MyRecordRowKey(100), MyFatRecord.class, hql, null);
        Assert.assertTrue(myRecordList.size() == 2);
    }
}
