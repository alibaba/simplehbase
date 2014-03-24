package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.SimpleHbaseDOWithKeyResult;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestFindObjectAndKey extends MyRecordTestBase {

    @Test
    public void findObjectAndKey() {

        MyRecord myRecord = mockSlim(0);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        simpleHbaseClient.putObject(myRecordRowKey, myRecord);
        SimpleHbaseDOWithKeyResult<MyRecord> resultRecord = simpleHbaseClient
                .findObjectAndKey(myRecordRowKey, MyRecord.class);

        Assert.assertTrue(myRecord.equals(resultRecord.getT()));
        Assert.assertEquals(new BytesRowKey(myRecordRowKey.toBytes()),
                resultRecord.getRowKey());
    }
}
