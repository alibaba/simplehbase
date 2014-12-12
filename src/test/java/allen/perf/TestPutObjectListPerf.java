package allen.perf;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import allen.test.Config;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestPutObjectListPerf extends MyRecordTestBase {

    private static Log log = LogFactory.getLog(TestPutObjectListPerf.class);

    @Test
    public void putObjectListPerf() {

        int[] testSizes = new int[] { 1, };
        if (Config.isPerfTestOn) {
            testSizes = new int[] { 1, 10, 100, 1000, 2000, 5000, 10000 };
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testSizes.length; i++) {
            int size = testSizes[i];

            MyRecord[] records = mockSlims(size);

            long start = System.currentTimeMillis();
            for (int j = 0; j < records.length; j++) {
                simpleHbaseClient.putObject(records[j].rowKey(), records[j]);
            }
            long end = System.currentTimeMillis();
            long singlePutTime = end - start;

            start = System.currentTimeMillis();
            List<PutRequest<MyRecord>> requestList = new ArrayList<PutRequest<MyRecord>>();
            for (MyRecord myRecord : records) {
                requestList.add(new PutRequest<MyRecord>(myRecord.rowKey(),
                        myRecord));
            }

            simpleHbaseClient.putObjectList(requestList);
            end = System.currentTimeMillis();
            long batchPutTime = end - start;

            sb.append("\nputObjectListPerf size = " + size + " singlePutTime="
                    + singlePutTime + " batchPutTime=" + batchPutTime + "\n");
        }

        log.info(sb);
    }
}