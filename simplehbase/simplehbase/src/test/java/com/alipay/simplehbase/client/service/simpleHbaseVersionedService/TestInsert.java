package com.alipay.simplehbase.client.service.simpleHbaseVersionedService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;
/**
 * @author xinzhi
 */
public class TestInsert extends MyRecordTestBase {

    @Test
    public void insertObject() {
        MyRecord myRecord = mockSlim(0);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(1);

        Assert.assertTrue(simpleHbaseClient.insertObject(myRecordRowKey,
                myRecord));
        Assert.assertFalse(simpleHbaseClient.insertObject(myRecordRowKey,
                myRecord));
    }
}
