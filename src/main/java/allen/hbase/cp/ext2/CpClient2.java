package allen.hbase.cp.ext2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch;

import allen.hbase.cp.ext.ClientReducer;
import allen.hbase.cp.ext.KeyValueListHandler;
import allen.hbase.cp.ext.aggr.AggrResult;

public class CpClient2 {

    private HTableInterface table;

    public CpClient2(HTableInterface table) {
        this.table = table;
    }

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