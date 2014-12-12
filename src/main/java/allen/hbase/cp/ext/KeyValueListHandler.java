package allen.hbase.cp.ext;

import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.io.Writable;

public interface KeyValueListHandler<T> extends Writable {

	public T getInitValue();

	public T handle(List<KeyValue> keyValues, T t);
}
