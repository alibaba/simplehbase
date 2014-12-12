package allen.hbase.cp.ext.aggr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.util.Bytes;

import allen.hbase.cp.ext.KeyValueListHandler;

public class AggrHandler implements KeyValueListHandler<AggrResult> {

	private AggrRequest aggrRequest;

	public AggrHandler() {
	}

	public AggrHandler(AggrRequest aggrRequest) {
		this.aggrRequest = aggrRequest;
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {
		aggrRequest = new AggrRequest();
		aggrRequest.readFields(dataInput);
	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {
		aggrRequest.write(dataOutput);
	}

	@Override
	public AggrResult getInitValue() {
		AggrResult aggrResult = new AggrResult(aggrRequest);
		return aggrResult;
	}

	@Override
	public AggrResult handle(List<KeyValue> keyValues, AggrResult t) {
		if (keyValues.isEmpty()) {
			return t;
		}

		t.setCount(t.getCount() + 1);

		int columnSize = t.getColumnSize();
		for (int i = 0; i < columnSize; i++) {
			byte[] family = t.getFamily(i);
			byte[] qualifer = t.getQualifer(i);
			for (KeyValue kv : keyValues) {
				if (kv != null) {
					if (Bytes.equals(qualifer, 0, qualifer.length,
							kv.getBuffer(), kv.getQualifierOffset(),
							kv.getQualifierLength())
							&& Bytes.equals(family, 0, family.length,
									kv.getBuffer(), kv.getFamilyOffset(),
									kv.getFamilyLength())) {

						if (kv.getValueLength() == Bytes.SIZEOF_LONG) {
							long tem = Bytes.toLong(kv.getBuffer(),
									kv.getValueOffset());
							t.setSum(i, t.getSum(i) + tem);
						}

					}
				}
			}
		}

		return t;
	}
}
