package com.alipay.simplehbase.client.service.hbaseMultipleVersionService;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOResult;
import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestPutObjectMV extends MyRecordTestBase {

    @TimeDepend
    @Test
    public void putObjectMV() {
        CreateTestTable.main(null);

        RowKey rowKey = new MyRecordRowKey(1000);

        MyRecord myRecord_1 = parseSlim("id=1000,name=namea,age=1");
        simpleHbaseClient.putObjectMV(rowKey, myRecord_1, new Date());
        sleep(2);

        MyRecord myRecord_2 = parseSlim("id=1000,name=nameb,age=2");
        simpleHbaseClient.putObjectMV(rowKey, myRecord_2, new Date().getTime());
        sleep(2);

        List<SimpleHbaseDOResult<MyRecord>> result = simpleHbaseClient
                .findObjectMV(rowKey, MyRecord.class, null);
        Assert.assertTrue(result.size() == 1);
        Assert.assertEquals(myRecord_2, result.get(0).getT());

        CreateTestTable.main(null);
    }
}
