package allen.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.alipay.simplehbase.client.SimpleHbaseClient;

import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestPutObjectWithOrWithoutAutoFlushPerf {

    private static Log log = LogFactory
                                   .getLog(TestPutObjectWithOrWithoutAutoFlushPerf.class);

    @TimeDepend
    @Test
    public void putObjectWithOrWithoutAutoFlushPerf() {

        CreateTestTable.main(null);

        SimpleHbaseClient clientWithFlush = MyRecordTestBase
                .getSimpleHbaseClientWithSimpleHbasePool(true);

        int[] testSizes = new int[] { 1, };
        if (PerfConfig.isPerfTestOn) {
            testSizes = new int[] { 1, 10, 100, 1000, 2000, 5000, 10000 };
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\nputObjectWithOrWithoutAutoFlushPerf");
        for (int i = 0; i < testSizes.length; i++) {
            int size = testSizes[i];

            MyRecord[] records = new MyRecordTestBase().mockSlims(size);

            long start = System.currentTimeMillis();
            for (int j = 0; j < records.length; j++) {
                clientWithFlush.putObject(records[j].rowKey(), records[j]);
            }
            long end = System.currentTimeMillis();
            long autoFlushPutTime = end - start;
            sb.append("\nsize = " + size + " autoFlushPutTime="
                    + autoFlushPutTime);
        }

        SimpleHbaseClient clientWithoutFlush = MyRecordTestBase
                .getSimpleHbaseClientWithSimpleHbasePool(false, 1000L);

        for (int i = 0; i < testSizes.length; i++) {
            int size = testSizes[i];

            MyRecord[] records = new MyRecordTestBase().mockSlims(size);

            long start = System.currentTimeMillis();
            for (int j = 0; j < records.length; j++) {
                clientWithoutFlush.putObject(records[j].rowKey(), records[j]);
            }
            long end = System.currentTimeMillis();
            long notAutoFlushPutTime = end - start;
            sb.append("\nsize = " + size + " notAutoFlushPutTime="
                    + notAutoFlushPutTime);
        }

        clientWithoutFlush.getHbaseDataSource().getHtablePoolService().close();

        log.info(sb);

        CreateTestTable.main(null);
    }

}