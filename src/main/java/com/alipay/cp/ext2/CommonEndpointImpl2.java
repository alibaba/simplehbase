package com.alipay.cp.ext2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.BaseEndpointCoprocessor;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.ipc.ProtocolSignature;
import org.apache.hadoop.hbase.regionserver.InternalScanner;

import com.alipay.cp.ext.aggr.AggrHandler;
import com.alipay.cp.ext.aggr.AggrResult;

/**
 * The impl of CommonCoprocessorProtocol2.
 * 
 * @author xinzhi.zhang
 * */
public class CommonEndpointImpl2 extends BaseEndpointCoprocessor implements
        CommonCoprocessorProtocol2 {

    protected static Log log = LogFactory.getLog(CommonEndpointImpl2.class);

    @Override
    public ProtocolSignature getProtocolSignature(String protocol,
            long version, int clientMethodsHashCode) throws IOException {
        if (CommonCoprocessorProtocol2.class.getName().equals(protocol)) {
            return new ProtocolSignature(CommonCoprocessorProtocol2.VERSION,
                    null);
        }
        throw new IOException("Unknown protocol: " + protocol);
    }

    @Override
    public byte[] handle(byte[] handler, Scan scan) throws IOException {
        if (handler == null)
            return null;

        AggrHandler aggrHandler = new AggrHandler();
        aggrHandler.readFields(new DataInputStream(new ByteArrayInputStream(
                handler)));

        InternalScanner scanner = ((RegionCoprocessorEnvironment) getEnvironment())
                .getRegion().getScanner(scan);
        List<KeyValue> results = new ArrayList<KeyValue>();
        AggrResult result = aggrHandler.getInitValue();
        try {
            boolean hasMoreRows = false;
            do {
                hasMoreRows = scanner.next(results);
                result = aggrHandler.handle(results, result);
                results.clear();
            } while (hasMoreRows);
        } finally {
            scanner.close();
        }

        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        DataOutput dop = new DataOutputStream(bas);
        result.write(dop);
        return bas.toByteArray();
    }
}