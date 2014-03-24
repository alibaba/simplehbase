package com.alipay.simplehbase.perf;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestDeletePerf extends MyRecordTestBase {

    @Test
    public void deleteObjectList() {
        int size = 10;
        putMockSlims(size);

        MyRecordRowKey start = new MyRecordRowKey(0);
        MyRecordRowKey end = new MyRecordRowKey(size);

        List<MyRecord> recordList = simpleHbaseClient.findObjectList(start,
                end, MyRecord.class);
        Assert.assertTrue(recordList.size() == size);

        simpleHbaseClient.deleteObjectList(start, end, MyRecord.class);

        recordList = simpleHbaseClient.findObjectList(start, end,
                MyRecord.class);

        Assert.assertTrue(recordList.size() == 0);
    }
}