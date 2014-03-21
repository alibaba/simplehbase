package com.alipay.simplehbase.client.service.basicService.hql;

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
public class TestMatchNot extends MyRecordTestBase {

    @Test
    public void testConstants() {
        putSlim("id=0,name=abc");
        putSlim("id=1,name=bca");
        putSlim("id=2,name=cab");

        addHql("select where name notmatch \".*ab.*\"");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);

        Assert.assertTrue(myRecordList.size() == 1);

        addHql("select where name notmatch \"abc\"");
        myRecordList = simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, null);
        Assert.assertTrue(myRecordList.size() == 2);

        addHql("select where name notmatch \"a\"");
        myRecordList = simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, null);
        Assert.assertTrue(myRecordList.size() == 0);
    }

    @Test
    public void testVar() {
        putSlim("id=0,name=abc");
        putSlim("id=1,name=bca");
        putSlim("id=2,name=cab");

        addHql("select where name notmatch #name#");
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", ".*ab.*");
        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 1);

        para.put("name", "abc");
        myRecordList = simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 2);

        para.put("name", "a");
        myRecordList = simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, para);
        Assert.assertTrue(myRecordList.size() == 0);
    }

}
