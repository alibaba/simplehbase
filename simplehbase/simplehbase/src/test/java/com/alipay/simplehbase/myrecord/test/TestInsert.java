package com.alipay.simplehbase.myrecord.test;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
/**
 * @author xinzhi
 */
public class TestInsert extends MyRecordBase {

    @Test
    public void insertObject() {
        MyRecord myRecord = mockMyRecord(0);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(1);

        Assert.assertTrue(simpleHbaseClient.insertObject(myRecordRowKey,
                myRecord));
        Assert.assertFalse(simpleHbaseClient.insertObject(myRecordRowKey,
                myRecord));
    }
}
