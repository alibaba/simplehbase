package allen.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;

import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import com.alipay.simplehbase.util.Util;
import allen.studyhbase.HbaseTestBase;
import allen.test.Config;

/**
 * @author xinzhi
 */
public class TestGetAndScanPerf extends HbaseTestBase {

    private static Log log = LogFactory.getLog(TestGetAndScanPerf.class);

    @Test
    public void testGetAndScanPerf() throws Exception {
        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes("2"));
        table.put(put);

        int loopSize = 1;
        if (Config.isPerfTestOn) {
            loopSize = 100;
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            Get get = new Get(rowKey_ForTest);
            get.addColumn(ColumnFamilyNameBytes, QName1);
            table.get(get);
        }
        long end = System.currentTimeMillis();
        long getTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            Scan scan = new Scan(rowKey_ForTest, rowKey_ForTest);
            scan.setCaching(20);
            scan.addColumn(ColumnFamilyNameBytes, QName1);
            ResultScanner resultScanner = table.getScanner(scan);
            while (resultScanner.next() != null) {
            }
            Util.close(resultScanner);
        }
        end = System.currentTimeMillis();
        long scanTime = end - start;

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("loopSize=" + loopSize + " getTime=" + getTime + " scanTime="
                + scanTime);

        log.info(sb);
    }
}
