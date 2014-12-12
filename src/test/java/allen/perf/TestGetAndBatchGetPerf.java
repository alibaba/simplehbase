package allen.perf;

import org.junit.Test;

import allen.test.Config;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestGetAndBatchGetPerf extends MyRecordTestBase {

    @Test
    public void testGetAndBatchGetPerf() {

        int testDataSize = 1;
        if (Config.isPerfTestOn) {
            testDataSize = 2000;
        }
        putMockSlims(testDataSize);

        int[] testGetSizes = new int[] { 1 };
        if (Config.isPerfTestOn) {
            testGetSizes = new int[] { 1, 10, 100, 1000, };
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testGetSizes.length; i++) {

            long start = System.currentTimeMillis();
            for (int j = 0; j < testGetSizes[i]; j++) {
                simpleHbaseClient.findObject(new MyRecordRowKey(j),
                        MyRecord.class);
            }
            long end = System.currentTimeMillis();
            long singleGetTime = end - start;

            start = System.currentTimeMillis();
            simpleHbaseClient.findObjectBatch(rowkeyList(0, testGetSizes[i]),
                    MyRecord.class);
            end = System.currentTimeMillis();
            long batchGetTime = end - start;

            sb.append("\nTestGetAndBatchGetPerf datasize = " + testGetSizes[i]
                    + " singleGetTime=" + singleGetTime + " batchGetTime="
                    + batchGetTime + "\n");
        }

        log.info(sb);
    }
}