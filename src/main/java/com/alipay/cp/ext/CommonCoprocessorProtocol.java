package com.alipay.cp.ext;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;

/**
 * CommonCoprocessorProtocol.
 * 
 * @author xinzhi.zhang
 * */
public interface CommonCoprocessorProtocol extends CoprocessorProtocol {

    public static final long VERSION = 345L;

    /**
     * protocol's interface.
     * 
     * <pre>
     * use scan to scan the keyvalues, use handler to handle the keyvalues.
     * </pre>
     * */
    public <T> T handle(KeyValueListHandler<T> handler, Scan scan)
            throws IOException;

}
