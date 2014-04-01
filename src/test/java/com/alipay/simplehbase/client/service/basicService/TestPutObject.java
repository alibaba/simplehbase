package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestPutObject extends MyRecordTestBase {

    @Test
    public void putObject() {

        MyRecord myRecord = mockSlim(0);
        RowKey rowKey = myRecord.rowKey();

        simpleHbaseClient.putObject(rowKey, myRecord);

        MyRecord result = simpleHbaseClient.findObject(rowKey, MyRecord.class);

        Assert.assertTrue(myRecord.equals(result));
    }

}
