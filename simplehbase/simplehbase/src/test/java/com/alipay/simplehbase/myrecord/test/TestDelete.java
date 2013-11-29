package com.alipay.simplehbase.myrecord.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;

public class TestDelete extends TestMyRecord {
    @Test
    public void deleteObject() {

        addMockRecords(1);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));

        simpleHbaseClient.deleteObject(myRecordRowKey);

        Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));
    }

    @Test
    public void deleteObjectList() {
        addMockRecords(100);

        MyRecordRowKey myRecordRowKey1 = new MyRecordRowKey(0);
        MyRecordRowKey myRecordRowKey2 = new MyRecordRowKey(50);
        MyRecordRowKey myRecordRowKey3 = new MyRecordRowKey(100);

        List<MyRecord> recordList = simpleHbaseClient.findObjectList(
                myRecordRowKey1, myRecordRowKey3, MyRecord.class);
        Assert.assertTrue(recordList.size() == 100);

        simpleHbaseClient.deleteObjectList(myRecordRowKey1, myRecordRowKey2);

        recordList = simpleHbaseClient.findObjectList(myRecordRowKey1,
                myRecordRowKey3, MyRecord.class);

        Assert.assertTrue(recordList.size() == 50);

        simpleHbaseClient.deleteObjectList(myRecordRowKey2, myRecordRowKey3);

        recordList = simpleHbaseClient.findObjectList(myRecordRowKey1,
                myRecordRowKey3, MyRecord.class);
        Assert.assertTrue(recordList.size() == 0);
    }
}