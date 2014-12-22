package com.alipay.cp.ext2;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;

/**
 * another protocol.
 * 
 * <pre>
 * use some type(byte[]) can be recognized by hbase default setting.
 * </pre>
 * */
public interface CommonCoprocessorProtocol2 extends CoprocessorProtocol {

    public static final long VERSION = 346L;

    /**
     * protocol's interface.
     * */
    public byte[] handle(byte[] handler, Scan scan) throws IOException;

}
