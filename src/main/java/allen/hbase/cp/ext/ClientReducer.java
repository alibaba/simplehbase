package allen.hbase.cp.ext;

public interface ClientReducer<T, R> {

	public R getInitValue();

	public R reduce(R r, T t);
}
