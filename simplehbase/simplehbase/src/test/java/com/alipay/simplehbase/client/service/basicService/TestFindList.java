package com.alipay.simplehbase.client.service.basicService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestFindList extends MyRecordTestBase {

    @Test
    public void findObjectList() {
        putMockSlims(8);

        MyRecordRowKey startRowKey = new MyRecordRowKey(0);
        MyRecordRowKey endRowKey = new MyRecordRowKey(8);
        List<MyRecord> list = simpleHbaseClient.findObjectList(startRowKey,
                endRowKey, MyRecord.class);
        Assert.assertTrue(list.size() == 8);

        endRowKey = new MyRecordRowKey(7);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class);
        Assert.assertTrue(list.size() == 7);
    }

    @Test
    public void findObjectListWithLimit() {
        putMockSlims(8);

        MyRecordRowKey startRowKey = new MyRecordRowKey(0);
        MyRecordRowKey endRowKey = new MyRecordRowKey(8);
        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setLimit(0L, 8L);
        List<MyRecord> list = simpleHbaseClient.findObjectList(startRowKey,
                endRowKey, MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 8);

        extInfo.setLimit(0L, 9L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 8);

        extInfo.setLimit(0L, 7L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 7);

        extInfo.setLimit(5L, 2L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 2);

        extInfo.setLimit(5L, 3L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 3);

        extInfo.setLimit(5L, 4L);
        list = simpleHbaseClient.findObjectList(startRowKey, endRowKey,
                MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 3);

    }
}
