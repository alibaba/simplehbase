package allen.studyhbase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.util.Bytes;

import allen.test.Config;
import allen.test.CreateTestTable;

/**
 * @author xinzhi.zhang
 * */
public class HbaseTestBase extends HbaseTest {

    protected static Log log = LogFactory.getLog(HbaseTestBase.class);

    static {
        TableName = Config.TableName;
        TableNameBytes = Bytes.toBytes(TableName);
        ColumnFamilyName = Config.ColumnFamilyName;
        ColumnFamilyNameBytes = Bytes.toBytes(ColumnFamilyName);
    }

    @Override
    protected void initHTable() {
        table = Config.getHTableInterface(TableName);
    }

    @Override
    protected Configuration getConfiguration() {
        return Config.getConfiguration();
    }

    @Override
    protected void recreateTable() {
        CreateTestTable.main(null);
    }

}
