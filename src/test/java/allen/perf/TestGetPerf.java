package allen.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;

import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import allen.studyhbase.HbaseTestBase;
import allen.test.Config;

/**
 * @author xinzhi
 */
public class TestGetPerf extends HbaseTestBase {

    private static Log log = LogFactory.getLog(TestGetPerf.class);

    @Test
    public void testGetPerf() throws Exception {
        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes("2"));
        table.put(put);

        int loopSize = 1;
        if (Config.isPerfTestOn) {
            loopSize = 100;
        }

        for (int i = 0; i < loopSize; i++) {
            Get get = new Get(rowKey_ForTest);
            get.addColumn(ColumnFamilyNameBytes, QName1);
            long start = System.currentTimeMillis();
            table.get(get);
            long end = System.currentTimeMillis();
            long getTime = end - start;
            log.info("get " + getTime);
        }
    }
}
