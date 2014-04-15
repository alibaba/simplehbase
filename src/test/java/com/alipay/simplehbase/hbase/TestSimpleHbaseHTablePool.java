package com.alipay.simplehbase.hbase;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;
import org.junit.Test;

import com.alipay.simplehbase.client.SimpleHbaseClient;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class TestSimpleHbaseHTablePool extends MyRecordTestBase {

    @Test
    public void testGet() {

        SimpleHbaseClient client = getSimpleHbaseClientWithSimpleHbasePool(true);

        MyRecord myRecord = new MyRecord();
        myRecord.setId(0);
        myRecord.setName("allen");

        client.putObject(myRecord.rowKey(), myRecord);
        MyRecord myRecord2 = client.findObject(myRecord.rowKey(),
                MyRecord.class);
        Assert.assertEquals(myRecord, myRecord2);
    }

    @Test
    public void testSimpleHbaseHTablePool() throws Exception {
        final String mockTableName = "allen";

        final int[] counter = new int[1];

        SimpleHbaseHTablePool hTablePool = new SimpleHbaseHTablePool(
                HBaseConfiguration.create(), 10, new HTableInterfaceFactory() {

                    @Override
                    public void releaseHTableInterface(HTableInterface table)
                            throws IOException {
                        counter[0]++;
                    }

                    @Override
                    public HTableInterface createHTableInterface(
                            Configuration config, byte[] tableName) {
                        return new MockHTable(mockTableName);
                    };

                }, 1000);

        HTableInterface htable = hTablePool.getTable(mockTableName);

        //return to pool.
        htable.close();
        Assert.assertEquals(0, counter[0]);

        //get table out of pool.
        htable = hTablePool.getTable(mockTableName);

        //no table in pool, no close.
        hTablePool.close();
        Assert.assertEquals(0, counter[0]);

        //can not return to pool, close. 
        htable.close();
        Assert.assertEquals(1, counter[0]);

    }
}
