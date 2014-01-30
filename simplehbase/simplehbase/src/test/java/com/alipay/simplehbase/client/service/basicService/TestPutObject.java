package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;
/**
 * @author xinzhi
 */
public class TestPutObject extends MyRecordTestBase {

    @Test
    public void putObject() {

        MyRecord myRecord = mockSlim(0);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.putObject(myRecordRowKey, myRecord);

        MyRecord myRecord2 = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);

        Assert.assertTrue(myRecord.equals(myRecord2));
    }
}
