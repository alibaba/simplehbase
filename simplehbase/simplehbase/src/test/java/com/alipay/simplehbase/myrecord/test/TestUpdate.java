package com.alipay.simplehbase.myrecord.test;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
/**
 * @author xinzhi
 */
public class TestUpdate extends MyRecordBase {

    @Test
    public void updateObjectWithVersion() {
        MyRecord myRecord = mockMyRecord(0);
        myRecord.setVersion(0L);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);
        simpleHbaseClient.insertObject(myRecordRowKey, myRecord);

        // update with wrong version.
        Assert.assertFalse(simpleHbaseClient.updateObjectWithVersion(
                myRecordRowKey, myRecord, new Long(10L)));

        // update version.
        myRecord.setVersion(1L);
        Assert.assertTrue(simpleHbaseClient.updateObjectWithVersion(
                myRecordRowKey, myRecord, new Long(0L)));

    }

    @Test
    public void updateObject() {
        MyRecord myRecord = mockMyRecord(0);
        myRecord.setVersion(0L);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.insertObject(myRecordRowKey, myRecord);
        MyRecord myRecordFromHbase = simpleHbaseClient.findObject(
                myRecordRowKey, MyRecord.class);
        // change version.
        myRecordFromHbase.setVersion(10L);
        Assert.assertFalse(simpleHbaseClient.updateObject(myRecordRowKey,
                myRecordFromHbase, myRecord));

        // change version.
        myRecordFromHbase.setVersion(0L);
        // update version.
        myRecord.setVersion(1L);
        Assert.assertTrue(simpleHbaseClient.updateObject(myRecordRowKey,
                myRecordFromHbase, myRecord));

    }
}
