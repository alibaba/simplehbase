package allen.hbase.cp.ext;

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

public class CommonEndpointImpl extends BaseEndpointCoprocessor implements
		CommonCoprocessorProtocol {

	protected static Log log = LogFactory.getLog(CommonEndpointImpl.class);

	@Override
	public ProtocolSignature getProtocolSignature(String protocol,
			long version, int clientMethodsHashCode) throws IOException {
		if (CommonCoprocessorProtocol.class.getName().equals(protocol)) {
			return new ProtocolSignature(CommonCoprocessorProtocol.VERSION,
					null);
		}
		throw new IOException("Unknown protocol: " + protocol);
	}

	@Override
	public <T> T handle(KeyValueListHandler<T> handler, Scan scan)
			throws IOException {

		InternalScanner scanner = ((RegionCoprocessorEnvironment) getEnvironment())
				.getRegion().getScanner(scan);
		List<KeyValue> results = new ArrayList<KeyValue>();
		T t = handler.getInitValue();
		try {
			boolean hasMoreRows = false;
			do {
				hasMoreRows = scanner.next(results);
				t = handler.handle(results, t);
				results.clear();
			} while (hasMoreRows);
		} finally {
			scanner.close();
		}
		return t;
	}
}