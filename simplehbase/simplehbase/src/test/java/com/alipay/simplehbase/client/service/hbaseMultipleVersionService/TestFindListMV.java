package com.alipay.simplehbase.client.service.hbaseMultipleVersionService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOResult;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

public class TestFindListMV extends MyRecordTestBase {

    @Test
    public void findListMV() {
        sleep(2);
        RowKey rowKey_1 = new MyRecordRowKey(1);

        MyRecord myRecord_1_1 = parseSlim("id=1,name=a,age=1");
        simpleHbaseClient.putObject(rowKey_1, myRecord_1_1);
        sleep(2);

        MyRecord myRecord_1_2 = parseSlim("id=1,name=b,age=2");
        simpleHbaseClient.putObject(rowKey_1, myRecord_1_2);
        sleep(2);

        RowKey rowKey_2 = new MyRecordRowKey(2);
        MyRecord myRecord_2_1 = parseSlim("id=2,name=a,age=1");
        simpleHbaseClient.putObject(rowKey_2, myRecord_2_1);
        sleep(2);

        MyRecord myRecord_2_2 = parseSlim("id=2,name=b,age=2");
        simpleHbaseClient.putObject(rowKey_2, myRecord_2_2);
        sleep(2);

        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setMaxVersions(3);

        List<List<SimpleHbaseDOResult<MyRecord>>> listOfList = simpleHbaseClient
                .findObjectListMV(rowKey_1,
                        RowKeyUtil.increaseRowKey(rowKey_2), MyRecord.class,
                        extInfo);

        Assert.assertTrue(listOfList.size() == 2);

        Assert.assertEquals(myRecord_1_2, listOfList.get(0).get(0).getT());
        Assert.assertEquals(myRecord_1_1, listOfList.get(0).get(1).getT());
        Assert.assertEquals(myRecord_2_2, listOfList.get(1).get(0).getT());
        Assert.assertEquals(myRecord_2_1, listOfList.get(1).get(1).getT());

    }

    @Test
    public void findListMVWithHql() {
        sleep(2);
        RowKey rowKey_1 = new MyRecordRowKey(1);

        MyRecord myRecord_1_1 = parseSlim("id=1,name=a,age=1");
        simpleHbaseClient.putObject(rowKey_1, myRecord_1_1);
        sleep(2);

        MyRecord myRecord_1_2 = parseSlim("id=1,name=b,age=2");
        simpleHbaseClient.putObject(rowKey_1, myRecord_1_2);
        sleep(2);

        RowKey rowKey_2 = new MyRecordRowKey(2);
        MyRecord myRecord_2_1 = parseSlim("id=2,name=a,age=1");
        simpleHbaseClient.putObject(rowKey_2, myRecord_2_1);
        sleep(2);

        MyRecord myRecord_2_2 = parseSlim("id=2,name=b,age=2");
        simpleHbaseClient.putObject(rowKey_2, myRecord_2_2);
        sleep(2);

        QueryExtInfo extInfo = new QueryExtInfo();
        extInfo.setMaxVersions(3);

        addHql("select where name greaterequal \"a\"");

        List<List<SimpleHbaseDOResult<MyRecord>>> listOfList = simpleHbaseClient
                .findObjectListMV(rowKey_1,
                        RowKeyUtil.increaseRowKey(rowKey_2), MyRecord.class,
                        TestHqlId, null, extInfo);

        Assert.assertTrue(listOfList.size() == 2);

        Assert.assertEquals(myRecord_1_2, listOfList.get(0).get(0).getT());
        Assert.assertEquals(myRecord_1_1, listOfList.get(0).get(1).getT());
        Assert.assertEquals(myRecord_2_2, listOfList.get(1).get(0).getT());
        Assert.assertEquals(myRecord_2_1, listOfList.get(1).get(1).getT());

    }

}
