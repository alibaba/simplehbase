package com.alipay.simplehbase.client.service.hbaseMultipleVersionService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOResult;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestFindMV extends MyRecordTestBase {

    @Test
    public void findMV() {
        sleep(2);
        MyRecord myRecord_1 = parseSlim("id=1,name=a,age=1");
        RowKey rowKey = myRecord_1.rowKey();

        List<SimpleHbaseDOResult<MyRecord>> list = simpleHbaseClient
                .findObjectMV(rowKey, MyRecord.class, null);
        Assert.assertTrue(list.size() == 0);

        simpleHbaseClient.putObject(rowKey, myRecord_1);
        sleep(2);

        list = simpleHbaseClient.findObjectMV(rowKey, MyRecord.class, null);
        Assert.assertTrue(list.size() == 1);
        Assert.assertEquals(myRecord_1, list.get(0).getT());

        MyRecord myRecord_2 = parseSlim("id=1,name=b,age=2");
        simpleHbaseClient.putObject(rowKey, myRecord_2);
        sleep(2);

        list = simpleHbaseClient.findObjectMV(rowKey, MyRecord.class, null);
        Assert.assertTrue(list.size() == 1);
        Assert.assertEquals(myRecord_2, list.get(0).getT());

        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setMaxVersions(3);
        list = simpleHbaseClient.findObjectMV(rowKey, MyRecord.class, extInfo);
        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals(myRecord_2, list.get(0).getT());
        Assert.assertEquals(myRecord_1, list.get(1).getT());
    }

    @Test
    public void findMVWithHql() {
        sleep(2);
        MyRecord myRecord_1 = parseSlim("id=1,name=a,age=1");
        RowKey rowKey = myRecord_1.rowKey();

        simpleHbaseClient.putObject(rowKey, myRecord_1);
        sleep(2);

        MyRecord myRecord_2 = parseSlim("id=1,name=b,age=2");
        simpleHbaseClient.putObject(rowKey, myRecord_2);
        sleep(2);

        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setMaxVersions(3);

        addHql("select where name greaterequal \"a\"");
        List<SimpleHbaseDOResult<MyRecord>> list = simpleHbaseClient
                .findObjectMV(rowKey, MyRecord.class, TestHqlId, null, extInfo);

        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals(myRecord_2, list.get(0).getT());
        Assert.assertEquals(myRecord_1, list.get(1).getT());

        //verify rowkey.
        Assert.assertEquals(new BytesRowKey(rowKey.toBytes()), list.get(1)
                .getRowKey());

    }
}
