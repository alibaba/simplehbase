package allen.perf;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestScanWithIntelligentScanSize extends MyRecordTestBase {

    private static Log log = LogFactory.getLog(TestPutObjectListPerf.class);

    @Test
    public void scanWithIntelligentScanSize() {

        int testSize = 1;
        int loop = 1;

        if (PerfConfig.isPerfTestOn) {
            testSize = 100;
            loop = 100;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("testSize=" + testSize + " loop=" + loop + " ");

        putMockSlims(testSize);

        QueryExtInfo queryExtInfo = new QueryExtInfo();
        queryExtInfo.setLimit(0, 1);

        sb.append(scanWithIntelligentScanSize(loop, queryExtInfo) + " ");
        sb.append(scan(loop, queryExtInfo) + " ");

        log.info(sb);
    }

    private String scan(int loop, QueryExtInfo queryExtInfo) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            List<MyRecord> list = simpleHbaseClient.findObjectList(
                    RowKeyUtil.START_ROW, RowKeyUtil.END_ROW, MyRecord.class,
                    queryExtInfo);
            Assert.assertEquals(1, list.size());
        }

        long end = System.currentTimeMillis();

        long scanTime = end - start;
        return "scanTime=" + scanTime;
    }

    private String scanWithIntelligentScanSize(int loop,
            QueryExtInfo queryExtInfo) {

        simpleHbaseClient.getSimpleHbaseRuntimeSetting()
                .setIntelligentScanSize(true);

        long start = System.currentTimeMillis();

        for (int i = 0; i < loop; i++) {
            List<MyRecord> list = simpleHbaseClient.findObjectList(
                    RowKeyUtil.START_ROW, RowKeyUtil.END_ROW, MyRecord.class,
                    queryExtInfo);
            Assert.assertEquals(1, list.size());
        }

        long end = System.currentTimeMillis();

        simpleHbaseClient.getSimpleHbaseRuntimeSetting()
                .setIntelligentScanSize(false);

        long scanWithIntelligentScanSizeTime = end - start;
        return "scanWithIntelligentScanSizeTime="
                + scanWithIntelligentScanSizeTime;
    }
}