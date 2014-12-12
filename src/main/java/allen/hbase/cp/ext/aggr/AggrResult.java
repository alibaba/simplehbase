package allen.hbase.cp.ext.aggr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class AggrResult implements Writable {
	private AggrRequest aggrRequest;
	private long[] sum;
	private long count;

	public AggrResult() {
	}

	public AggrResult(AggrRequest aggrRequest) {
		this.aggrRequest = aggrRequest;
		sum = new long[aggrRequest.getColumnSize()];
	}

	public int getColumnSize() {
		return aggrRequest.getColumnSize();
	}

	public byte[] getFamily(int index) {
		return aggrRequest.getFamily(index);
	}

	public byte[] getQualifer(int index) {
		return aggrRequest.getQualifer(index);
	}

	public long getSum(int index) {
		return sum[index];
	}

	public void setSum(int index, long value) {
		sum[index] = value;
	}

	// getter and setter.
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {
		int columnSize = dataInput.readInt();

		sum = new long[columnSize];

		for (int i = 0; i < columnSize; i++) {
			sum[i] = dataInput.readLong();
		}

		count = dataInput.readLong();

		aggrRequest = new AggrRequest();

		aggrRequest.readFields(dataInput);
	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {

		dataOutput.writeInt(aggrRequest.getColumnSize());

		for (long v : sum) {
			dataOutput.writeLong(v);
		}

		dataOutput.writeLong(count);

		aggrRequest.write(dataOutput);
	}

}
