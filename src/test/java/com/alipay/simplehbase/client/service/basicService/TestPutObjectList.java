package com.alipay.simplehbase.client.service.basicService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestPutObjectList extends MyRecordTestBase {

    @Test
    public void putObjectList() {

        MyRecord[] records = mockSlims(4);
        List<PutRequest<MyRecord>> requestList = new ArrayList<PutRequest<MyRecord>>();
        for (MyRecord myRecord : records) {
            requestList.add(new PutRequest<MyRecord>(myRecord.rowKey(),
                    myRecord));
        }

        simpleHbaseClient.putObjectList(requestList);

        List<MyRecord> resultList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(records.length),
                MyRecord.class);

        for (int i = 0; i < requestList.size(); i++) {
            Assert.assertEquals(records[i], resultList.get(i));
        }

    }
}
