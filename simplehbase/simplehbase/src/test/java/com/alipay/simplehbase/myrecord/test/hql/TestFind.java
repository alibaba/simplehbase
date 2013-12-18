package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

public class TestFind extends MyRecordTestBase {

    @Test
    public void testFind() {

        putSlim("id=0,name=aaa");

        MyRecord myRecord = simpleHbaseClient.findObject(new MyRecordRowKey(0),
                MyRecord.class);

        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());

        String hql = "select where name equal \"aaa\"";
        myRecord = simpleHbaseClient.findObjectByRawHql(new MyRecordRowKey(0),
                MyRecord.class, hql, null);

        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());

        hql = "select where name equal #name#";
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("name", "aaa");
        myRecord = simpleHbaseClient.findObjectByRawHql(new MyRecordRowKey(0),
                MyRecord.class, hql, para);
        Assert.assertEquals(0, myRecord.getId());
        Assert.assertEquals("aaa", myRecord.getName());
    }

}
