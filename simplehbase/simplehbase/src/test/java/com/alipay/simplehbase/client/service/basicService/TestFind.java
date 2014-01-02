package com.alipay.simplehbase.client.service.basicService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestFind extends MyRecordTestBase {

    @Test
    public void findObject() {

        MyRecord myRecord = mockSlim(0);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.putObject(myRecordRowKey, myRecord);
        MyRecord resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);

        Assert.assertTrue(myRecord.equals(resultRecord));
    }

    @Test
    public void findObjectByHql() {

        putSlim("id=0,name=aaa");

        MyRecord myRecord = simpleHbaseClient.findObject(new MyRecordRowKey(0),
                MyRecord.class);

        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());

        addHql("select where name equal \"aaa\"");
        myRecord = simpleHbaseClient.findObject(new MyRecordRowKey(0),
                MyRecord.class, TestHqlId, null);

        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());

        addHql("select where name equal #name#");
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "aaa");
        myRecord = simpleHbaseClient.findObject(new MyRecordRowKey(0),
                MyRecord.class, TestHqlId, para);
        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());
    }

    @Test
    public void findObjectList() {
        putMockSlims(8);

        MyRecordRowKey startRowKey = new MyRecordRowKey(0);
        MyRecordRowKey endRowKey = new MyRecordRowKey(8);
        List<MyRecord> list = simpleHbaseClient.findObjectList(startRowKey,
                endRowKey, MyRecord.class);
        Assert.assertTrue(list.size() == 8);

        endRowKey = new MyRecordRowKey(7);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class);
        Assert.assertTrue(list.size() == 7);
    }

    @Test
    public void findObjectList2() {
        putMockSlims(8);

        MyRecordRowKey startRowKey = new MyRecordRowKey(0);
        MyRecordRowKey endRowKey = new MyRecordRowKey(8);
        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setLimit(0L, 8L);
        List<MyRecord> list = simpleHbaseClient.findObjectList(startRowKey,
                endRowKey, MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 8);

        extInfo.setLimit(0L, 9L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 8);

        extInfo.setLimit(0L, 7L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 7);

        extInfo.setLimit(5L, 2L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 2);

        extInfo.setLimit(5L, 3L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 3);

        extInfo.setLimit(5L, 4L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 3);

    }
}
