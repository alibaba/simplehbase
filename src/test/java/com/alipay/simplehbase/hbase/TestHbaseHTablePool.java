package com.alipay.simplehbase.hbase;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;
import org.apache.hadoop.hbase.client.HTablePool;

import org.junit.Test;

/**
 * @author xinzhi
 * */
public class TestHbaseHTablePool {

    @Test
    public void testHbaseHTablePool() throws Exception {
        final String mockTableName = "allen";

        final int[] counter = new int[1];

        HTablePool hTablePool = new HTablePool(null, 10,
                new HTableInterfaceFactory() {

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

                });

        HTableInterface htable = hTablePool.getTable(mockTableName);

        //return to pool.
        htable.close();
        Assert.assertEquals(0, counter[0]);

        //get table out of pool.
        htable = hTablePool.getTable(mockTableName);

        //no table in pool, no close.
        hTablePool.close();
        Assert.assertEquals(0, counter[0]);

        //return to pool. 
        htable.close();
        Assert.assertEquals(0, counter[0]);

        //close pool again, close table.
        hTablePool.close();
        Assert.assertEquals(1, counter[0]);
    }

}
