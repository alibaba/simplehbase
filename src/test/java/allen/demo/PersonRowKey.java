package allen.demo;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.client.RowKey;

/**
 * @author xinzhi
 */
public class PersonRowKey implements RowKey {

    private int row;

    public PersonRowKey(int row) {
        this.row = row;
    }

    @Override
    public byte[] toBytes() {
        return Bytes.toBytes(row);
    }
}
