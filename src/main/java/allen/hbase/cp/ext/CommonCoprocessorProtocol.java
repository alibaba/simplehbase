package allen.hbase.cp.ext;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.ipc.CoprocessorProtocol;

public interface CommonCoprocessorProtocol extends CoprocessorProtocol {

	public static final long VERSION = 345L;

	public <T> T handle(KeyValueListHandler<T> handler, Scan scan)
			throws IOException;

}
