package com.alipay.simplehbase.client.service.basicService;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.SimpleHbaseDOWithKeyResult;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestFindObjectAndKeyBatch extends MyRecordTestBase {

    private void test_findObjectAndKey(List<RowKey> rowKeyList,
            MyRecord... expectedRecords) {

        List<SimpleHbaseDOWithKeyResult<MyRecord>> resultList = simpleHbaseClient
                .findObjectAndKeyBatch(rowKeyList, MyRecord.class);

        Assert.assertTrue(resultList.size() == expectedRecords.length);
        for (int i = 0; i < resultList.size(); i++) {
            if (expectedRecords[i] == null) {
                Assert.assertNull(resultList.get(i));
            } else {
                Assert.assertEquals(expectedRecords[i], resultList.get(i)
                        .getT());
            }
        }
    }

    @Test
    public void findObjectAndKey() {

        MyRecord[] myRecords = mockSlims(10);
        putRecords(myRecords);

        test_findObjectAndKey(rowkeyList(-1), new MyRecord[] { null });
        test_findObjectAndKey(rowkeyList(0), new MyRecord[] { myRecords[0] });
        test_findObjectAndKey(rowkeyList(10), new MyRecord[] { null });

        test_findObjectAndKey(rowkeyList(1, 4, 7), myRecords[1], myRecords[4],
                myRecords[7]);

        test_findObjectAndKey(rowkeyList(-1, 1, 4, 7, 10), null, myRecords[1],
                myRecords[4], myRecords[7], null);

        test_findObjectAndKey(rowkeyList(-1, 4, 4, 4, 10), null, myRecords[4],
                myRecords[4], myRecords[4], null);

    }

}
