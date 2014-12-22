package com.alipay.cp.ext;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch;

/**
 * Coprocessor's client.
 * 
 * @author xinzhi.zhang
 * */
public class CpClient {

    /**
     * htable to run coprocessor.
     * */
    private HTableInterface table;

    public CpClient(HTableInterface table) {
        this.table = table;
    }

    /**
     * call the coprocessor.
     * */
    public <T, R> R call(final KeyValueListHandler<T> handler,
            final ClientReducer<T, R> reducer, final Scan scan)
            throws Throwable {

        class MyCallBack implements Batch.Callback<T> {
            R r = reducer.getInitValue();

            R getResult() {
                return r;
            }

            @Override
            public synchronized void update(byte[] region, byte[] row, T result) {
                r = reducer.reduce(r, result);
            }
        }

        MyCallBack myCallBack = new MyCallBack();

        try {
            table.coprocessorExec(CommonCoprocessorProtocol.class,
                    scan.getStartRow(), scan.getStopRow(),
                    new Batch.Call<CommonCoprocessorProtocol, T>() {
                        @Override
                        public T call(CommonCoprocessorProtocol instance)
                                throws IOException {
                            return instance.handle(handler, scan);
                        }
                    }, myCallBack);
        } finally {
            table.close();
        }

        return myCallBack.getResult();
    }
}