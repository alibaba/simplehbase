package com.alipay.cp.ext2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch;

import com.ailpay.cp.ext.aggr.AggrResult;
import com.alipay.cp.ext.ClientReducer;
import com.alipay.cp.ext.KeyValueListHandler;

/**
 * Coprocessor's client.
 * 
 * @author xinzhi.zhang
 * */
public class CpClient2 {

    /**
     * htable to run coprocessor.
     * */
    private HTableInterface table;

    public CpClient2(HTableInterface table) {
        this.table = table;
    }

    /**
     * call the coprocessor.
     * */
    public AggrResult call(final KeyValueListHandler<AggrResult> handler,
            final ClientReducer<AggrResult, AggrResult> reducer, final Scan scan)
            throws Throwable {

        class MyCallBack implements Batch.Callback<byte[]> {
            AggrResult r = reducer.getInitValue();

            AggrResult getAggrResult() {
                return r;
            }

            @Override
            public synchronized void update(byte[] region, byte[] row,
                    byte[] result) {
                try {
                    AggrResult newAggrResult = new AggrResult();
                    newAggrResult.readFields(new DataInputStream(
                            new ByteArrayInputStream(result)));
                    r = reducer.reduce(r, newAggrResult);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        MyCallBack myCallBack = new MyCallBack();

        table.coprocessorExec(CommonCoprocessorProtocol2.class,
                scan.getStartRow(), scan.getStopRow(),
                new Batch.Call<CommonCoprocessorProtocol2, byte[]>() {
                    @Override
                    public byte[] call(CommonCoprocessorProtocol2 instance)
                            throws IOException {
                        ByteArrayOutputStream bas = new ByteArrayOutputStream();
                        DataOutput dop = new DataOutputStream(bas);
                        handler.write(dop);
                        return instance.handle(bas.toByteArray(), scan);
                    }
                }, myCallBack);

        return myCallBack.getAggrResult();
    }
}