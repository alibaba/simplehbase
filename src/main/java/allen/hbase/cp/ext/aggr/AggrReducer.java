package allen.hbase.cp.ext.aggr;

import allen.hbase.cp.ext.ClientReducer;

public class AggrReducer implements ClientReducer<AggrResult, AggrResult> {

	@Override
	public AggrResult getInitValue() {
		return null;
	}

	@Override
	public AggrResult reduce(AggrResult r, AggrResult t) {
		if (r == null)
			return t;
		if (t == null)
			return r;
		r.setCount(r.getCount() + t.getCount());
		int columnSize = r.getColumnSize();
		for (int i = 0; i < columnSize; i++) {
			r.setSum(i, r.getSum(i) + t.getSum(i));
		}
		return r;
	}

}
