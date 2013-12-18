package com.alipay.simplehbase.myrecord.test.hql.special;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyFatRecord;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.test.MyRecordTestBase;

public class TestBasic extends MyRecordTestBase {

    @Test
    public void testSlim() {
        MyRecord record = parseSlim("id=0,name=allen,age=10,date=2012-01-01,gender=MALE,version=1");
        putRecord(record);
        MyRecord resultRecord = simpleHbaseClient.findObject(record.rowKey(),
                MyRecord.class);
        Assert.assertEquals(record, resultRecord);
    }

    @Test
    public void testFat() {
        MyFatRecord fatRecord = parseFat("id=0,name=allen,age=10,date=2012-01-01,gender=MALE,version=1,fatid=1,fatname=allen2,fatage=11,fatdate=2012-01-02,fatgender=FEMALE,fatversion=2");
        putRecord(fatRecord);
        MyFatRecord resultFatRecord = simpleHbaseClient.findObject(
                fatRecord.rowKey(), MyFatRecord.class);
        Assert.assertEquals(fatRecord, resultFatRecord);
    }

    @Test
    public void testSlimAndFat() {
        MyRecord record = parseSlim("id=0,name=allen,age=10,date=2012-01-01,gender=MALE,version=1");
        putRecord(record);
        MyFatRecord resultFatRecord = simpleHbaseClient.findObject(
                record.rowKey(), MyFatRecord.class);
        Assert.assertEquals(record, resultFatRecord.toSlim());
        Assert.assertEquals(record.toFat(), resultFatRecord);
    }
}
