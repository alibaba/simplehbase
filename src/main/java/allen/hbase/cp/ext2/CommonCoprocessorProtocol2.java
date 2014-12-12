package allen.hbase.cp.ext2;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;

public interface CommonCoprocessorProtocol2 extends CoprocessorProtocol {

    public static final long VERSION = 346L;

    public byte[] handle(byte[] handler, Scan scan) throws IOException;

}
