package com.alipay.simplehbase.myrecord.test;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
/**
 * @author xinzhi
 */
public class TestPut extends TestMyRecord {

    @Test
    public void putObject() {

        MyRecord myRecord = mockMyRecord(0);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.putObject(myRecordRowKey, myRecord);

        MyRecord myRecord2 = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);

        Assert.assertTrue(myRecord.equals(myRecord2));
    }
}
