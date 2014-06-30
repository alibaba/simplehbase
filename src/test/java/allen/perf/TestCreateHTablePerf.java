package allen.perf;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.junit.BeforeClass;
import org.junit.Test;
import com.alipay.simplehbase.config.Config;
import com.alipay.simplehbase.util.ConfigUtil;

/**
 * @author xinzhi.zhang
 * */
public class TestCreateHTablePerf {

    private static Log           log = LogFactory
                                             .getLog(TestCreateHTablePerf.class);
    private static Configuration configuration;

    @BeforeClass
    public static void beforeClass() throws Exception {
        Map<String, String> config = ConfigUtil
                .loadConfigFile(new FileInputStream(Config.ZkConfigFile));

        configuration = HBaseConfiguration.create();
        for (Map.Entry<String, String> entry : config.entrySet()) {
            configuration.set(entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void createHTablePerf() throws Exception {

        int getTableMax = 1;
        if (PerfConfig.isPerfTestOn) {
            getTableMax = 20;
        }

        int poolsize = 5;

        StringBuilder sb = new StringBuilder();
        sb.append("\ncreateHTablePerf size=" + getTableMax);

        getHTableFromNewHTable(getTableMax, sb);
        getHTableFromPool(getTableMax, poolsize, sb);

        log.info(sb);
    }

    private void getHTableFromNewHTable(int getTableMax, StringBuilder sb)
            throws Exception {
        List<HTableInterface> tables = new ArrayList<HTableInterface>();
        for (int i = 0; i < getTableMax; i++) {
            long start = System.currentTimeMillis();
            tables.add(new HTable(configuration, Config.TableName));
            long end = System.currentTimeMillis();
            long createHTableConsumeTime = end - start;
            sb.append("\nnew HTable i = " + i + " createHTableConsumeTime="
                    + createHTableConsumeTime);
        }
        cleanTableAndCloseConnections(tables);
    }

    private void getHTableFromPool(int getTableMax, int poolSize,
            StringBuilder sb) throws Exception {
        List<HTableInterface> tables = new ArrayList<HTableInterface>();
        HTablePool htablePool = new HTablePool(configuration, poolSize);
        for (int i = 0; i < getTableMax; i++) {
            long start = System.currentTimeMillis();
            tables.add(htablePool.getTable(Config.TableName));
            long end = System.currentTimeMillis();
            long createHTableConsumeTime = end - start;
            sb.append("\nhtablePool.getTable i = " + i
                    + " createHTableConsumeTime=" + createHTableConsumeTime);
        }
        cleanTableAndCloseConnections(tables);
        htablePool.close();
    }

    private void cleanTableAndCloseConnections(List<HTableInterface> tables)
            throws Exception {
        for (HTableInterface hTable : tables) {
            hTable.close();
        }

        tables.clear();

        HConnectionManager.deleteAllConnections(true);
    }
}
