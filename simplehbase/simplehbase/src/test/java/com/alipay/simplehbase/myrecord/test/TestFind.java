package com.alipay.simplehbase.myrecord.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
/**
 * @author xinzhi
 */
public class TestFind extends MyRecordBase {

    @Test
    public void findObject() {

        MyRecord myRecord = mockMyRecord(0);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.putObject(myRecordRowKey, myRecord);
        MyRecord resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);

        Assert.assertTrue(myRecord.equals(resultRecord));
    }

    @Test
    public void findObjectList() {
        addMockRecords(8);

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
        addMockRecords(8);

        MyRecordRowKey startRowKey = new MyRecordRowKey(0);
        MyRecordRowKey endRowKey = new MyRecordRowKey(8);

        List<MyRecord> list = simpleHbaseClient.findObjectList(startRowKey,
                endRowKey, MyRecord.class, 0, 8);
        Assert.assertTrue(list.size() == 8);

        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, 0, 9);
        Assert.assertTrue(list.size() == 8);

        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, 0, 7);
        Assert.assertTrue(list.size() == 7);

        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, 5, 2);
        Assert.assertTrue(list.size() == 2);

        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, 5, 3);
        Assert.assertTrue(list.size() == 3);

        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, 5, 4);
        Assert.assertTrue(list.size() == 3);

    }
}
