package com.alipay.simplehbase.client.service.basicService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestDeleteObjectList extends MyRecordTestBase {

    @Test
    public void deleteObjectList() {

        putMockSlims(10);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);
        Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));

        myRecordRowKey = new MyRecordRowKey(9);
        Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));

        List<RowKey> rowkeyList = rowkeyList(0, 10);

        simpleHbaseClient.deleteObjectList(rowkeyList, MyRecord.class);

        myRecordRowKey = new MyRecordRowKey(0);
        Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));
        myRecordRowKey = new MyRecordRowKey(9);
        Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));
    }

    @Test
    public void deleteObjectList2() {
        putMockSlims(100);

        MyRecordRowKey myRecordRowKey1 = new MyRecordRowKey(0);
        MyRecordRowKey myRecordRowKey2 = new MyRecordRowKey(50);
        MyRecordRowKey myRecordRowKey3 = new MyRecordRowKey(100);

        List<MyRecord> recordList = simpleHbaseClient.findObjectList(
                myRecordRowKey1, myRecordRowKey3, MyRecord.class);
        Assert.assertTrue(recordList.size() == 100);

        simpleHbaseClient.deleteObjectList(myRecordRowKey1, myRecordRowKey2,
                MyRecord.class);

        recordList = simpleHbaseClient.findObjectList(myRecordRowKey1,
                myRecordRowKey3, MyRecord.class);

        Assert.assertTrue(recordList.size() == 50);

        simpleHbaseClient.deleteObjectList(myRecordRowKey2, myRecordRowKey3,
                MyRecord.class);

        recordList = simpleHbaseClient.findObjectList(myRecordRowKey1,
                myRecordRowKey3, MyRecord.class);
        Assert.assertTrue(recordList.size() == 0);
    }
}