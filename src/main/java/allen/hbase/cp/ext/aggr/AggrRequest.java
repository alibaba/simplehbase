package allen.hbase.cp.ext.aggr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Writable;

public class AggrRequest implements Writable {

	private List<byte[]> families = new ArrayList<byte[]>();
	private List<byte[]> qualifiers = new ArrayList<byte[]>();

	public AggrRequest() {
	}

	public void add(String family, String qualifier) {
		if (family != null && qualifier != null) {
			this.families.add(Bytes.toBytes(family));
			this.qualifiers.add(Bytes.toBytes(qualifier));
		}
	}

	public int getColumnSize() {
		return families.size();
	}

	public byte[] getFamily(int index) {
		return families.get(index);
	}

	public byte[] getQualifer(int index) {
		return qualifiers.get(index);
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {

		int size = dataInput.readInt();

		for (int i = 0; i < size; i++) {
			families.add(Bytes.toBytes(dataInput.readUTF()));
		}

		for (int i = 0; i < size; i++) {
			qualifiers.add(Bytes.toBytes(dataInput.readUTF()));
		}

	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {

		dataOutput.writeInt(getColumnSize());

		for (byte[] b : families) {
			dataOutput.writeUTF(Bytes.toString(b));
		}

		for (byte[] b : qualifiers) {
			dataOutput.writeUTF(Bytes.toString(b));
		}
	}
}
