package com.alipay.simplehbase.myrecord.test.hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.TestMyRecord;

public class TestSpecial extends TestMyRecord {

    //默认值为空字节数组。
    @Test
    public void lessStringVar() {
        put("id=0,name=aaa");
        put("id=1");
        put("id=2,name=ccc");

        String hql = "select where name less #name#";
        Map<String, Object> para = new HashMap<String, Object>();

        para.put("name", "ccc");
        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, para);
        Assert.assertTrue(myRecordList.size() == 2);
    }
}
