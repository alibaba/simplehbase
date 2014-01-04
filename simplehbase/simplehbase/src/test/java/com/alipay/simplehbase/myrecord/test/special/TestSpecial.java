package com.alipay.simplehbase.myrecord.test.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestSpecial extends MyRecordTestBase {

    //var parameter should have value.
    @Test(expected = SimpleHBaseException.class)
    public void nullParaValue() {
        addHql("select where name less #name#");
        Map<String, Object> para = new HashMap<String, Object>();
        simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, para);
    }

    //constant parameter should have value.
    @Test(expected = SimpleHBaseException.class)
    public void nullParaConstant() {
        addHql("select where age less \"\"");
        Map<String, Object> para = new HashMap<String, Object>();
        simpleHbaseClient.findObjectList(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, TestHqlId, para);
    }

    @Test
    public void cannotHandleNegative() {
        putSlim("id=0,age=100");
        putSlim("id=1,age=0");
        putSlim("id=2,age=-100");

        addHql("select where age greaterequal \"0\"");
        List<MyRecord> myRecordList = simpleHbaseClient.findObjectList(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                TestHqlId, null);
        //should be 2, but result is 3.
        Assert.assertTrue(myRecordList.size() == 3);
    }
}
