package com.alipay.simplehbase.client.service.hbaseMultipleVersionService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;

import com.alipay.simplehbase.client.SimpleHbaseDOResult;
import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestDeleteObjectMV extends MyRecordTestBase {

    private void fillData() {

        MyRecord myRecord_1_1 = parseSlim("id=1,name=myRecord_1_1,age=1");
        simpleHbaseClient.putObjectMV(myRecord_1_1.rowKey(), myRecord_1_1, 1L);
        MyRecord myRecord_1_2 = parseSlim("id=1,name=myRecord_1_2,age=2");
        simpleHbaseClient.putObjectMV(myRecord_1_2.rowKey(), myRecord_1_2, 2L);
        MyRecord myRecord_2_1 = parseSlim("id=2,name=myRecord_2_1,age=3");
        simpleHbaseClient.putObjectMV(myRecord_2_1.rowKey(), myRecord_2_1, 2L);
    }

    @TimeDepend
    @Test
    public void deleteObjectMV() {

        CreateTestTable.main(null);

        fillData();
        QueryExtInfo queryExtInfo = new QueryExtInfo();
        queryExtInfo.setMaxVersions(3);

        List<List<SimpleHbaseDOResult<MyRecord>>> resultList = simpleHbaseClient
                .findObjectListMV(new MyRecordRowKey(1), new MyRecordRowKey(3),
                        MyRecord.class, queryExtInfo);
        assertSize(resultList, 2, 2, 1);

        simpleHbaseClient.deleteObjectMV(new MyRecordRowKey(1), MyRecord.class,
                1L);

        resultList = simpleHbaseClient.findObjectListMV(new MyRecordRowKey(1),
                new MyRecordRowKey(3), MyRecord.class, queryExtInfo);
        assertSize(resultList, 2, 1, 1);

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void deleteObjectMV2() {

        CreateTestTable.main(null);

        fillData();
        QueryExtInfo queryExtInfo = new QueryExtInfo();
        queryExtInfo.setMaxVersions(3);

        List<List<SimpleHbaseDOResult<MyRecord>>> resultList = simpleHbaseClient
                .findObjectListMV(new MyRecordRowKey(1), new MyRecordRowKey(3),
                        MyRecord.class, queryExtInfo);
        assertSize(resultList, 2, 2, 1);

        simpleHbaseClient.deleteObjectMV(new MyRecordRowKey(1), MyRecord.class,
                2L);

        resultList = simpleHbaseClient.findObjectListMV(new MyRecordRowKey(1),
                new MyRecordRowKey(3), MyRecord.class, queryExtInfo);
        assertSize(resultList, 2, 1, 1);

        CreateTestTable.main(null);
    }

    private void assertSize(
            List<List<SimpleHbaseDOResult<MyRecord>>> resultList,
            int totalSize, Integer... subListSize) {
        Assert.assertEquals(totalSize, resultList.size());
        for (int i = 0; i < subListSize.length; i++) {
            Assert.assertEquals(subListSize[i].intValue(), resultList.get(i)
                    .size());
        }
    }
}
