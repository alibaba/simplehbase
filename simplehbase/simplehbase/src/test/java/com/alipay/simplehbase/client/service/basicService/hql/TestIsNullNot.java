package com.alipay.simplehbase.client.service.basicService.hql;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestIsNullNot extends MyRecordTestBase {

    @Test
    public void testIsNull() {
        putSlim("id=0,name=aaa");
        putSlim("id=1,name=bbb");
        putSlim("id=2");

        addHql("select where name isnotnull");

        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);
        Assert.assertTrue(myRecordList.size() == 2);
    }

}
