package com.alipay.simplehbase.myrecord.test.hql.special;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestSpecial extends MyRecordTestBase {

    //var参数必须有值。
    @Test(expected = SimpleHBaseException.class)
    public void nullParaValue() {
        String hql = "select where name less #name#";
        Map<String, Object> para = new HashMap<String, Object>();
        simpleHbaseClient.findObjectListByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, hql, para);
    }

    //constant参数必须有值。
    @Test(expected = SimpleHBaseException.class)
    public void nullParaConstant() {
        String hql = "select where age less \"\"";
        Map<String, Object> para = new HashMap<String, Object>();
        simpleHbaseClient.findObjectListByRawHql(new MyRecordRowKey(0),
                new MyRecordRowKey(100), MyRecord.class, hql, para);
    }

    //不能处理负数。
    @Test
    public void cannotHandleNegative() {
        putSlim("id=0,age=100");
        putSlim("id=1,age=0");
        putSlim("id=2,age=-100");

        String hql = "select where age greaterequal \"0\"";
        List<MyRecord> myRecordList = simpleHbaseClient.findObjectListByRawHql(
                new MyRecordRowKey(0), new MyRecordRowKey(100), MyRecord.class,
                hql, null);
        //should be 2, but result is 3.
        Assert.assertTrue(myRecordList.size() == 3);
    }
}
