package com.alipay.simplehbase.client.service.hbaseRawService;

import org.junit.Test;

import junit.framework.Assert;

import com.alipay.simplehbase.config.Config;
import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestPut extends MyRecordTestBase {

    @Test
    public void testPut_Put() {
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);
        MyRecord resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals(null, resultRecord);

        String hql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(hql);

        resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals("allen", resultRecord.getName());
        Assert.assertEquals(30, resultRecord.getAge());
    }

    @TimeDepend
    @Test
    public void testPut_PutTs() {
        CreateTestTable.main(null);

        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(2000);
        MyRecord resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals(null, resultRecord);

        String hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"2000\") ts is \"2000-01-01\" ";
        simpleHbaseClient.put(hql);

        resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals("allen", resultRecord.getName());
        Assert.assertEquals(30, resultRecord.getAge());

        CreateTestTable.main(null);
    }

    @Test
    public void testPut_PutNull() {
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

        MyRecord resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals(null, resultRecord);

        String hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(hql);

        resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals("allen", resultRecord.getName());
        Assert.assertEquals(30, resultRecord.getAge());

        hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"allen\", null ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(hql);

        resultRecord = simpleHbaseClient.findObject(myRecordRowKey,
                MyRecord.class);
        Assert.assertEquals("allen", resultRecord.getName());
        Assert.assertEquals(0, resultRecord.getAge());
    }
}
