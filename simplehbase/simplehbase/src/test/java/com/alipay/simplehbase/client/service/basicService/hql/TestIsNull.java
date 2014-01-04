package com.alipay.simplehbase.client.service.basicService.hql;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

public class TestIsNull extends MyRecordTestBase {

    @Test
    public void testIsNull() {
        putSlim("id=0,name=aaa");
        putSlim("id=1");
        putSlim("id=2");

        addHql("select where name isnull");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);

        Assert.assertTrue(myRecordList.size() == 2);
    }

}
