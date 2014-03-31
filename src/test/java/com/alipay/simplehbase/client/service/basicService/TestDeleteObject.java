package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestDeleteObject extends MyRecordTestBase {
    @Test
    public void deleteObject() {

        putMockSlims(1);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));

        simpleHbaseClient.deleteObject(myRecordRowKey, MyRecord.class);

        Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class));
    }

}