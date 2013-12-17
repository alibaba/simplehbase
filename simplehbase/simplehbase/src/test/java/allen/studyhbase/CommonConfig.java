package allen.studyhbase;

import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTablePool;

import com.alipay.simplehbase.config.Config;
import com.alipay.simplehbase.util.ConfigUtil;

/**
 * CommonConfig.
 * */
public class CommonConfig {

    private static HTablePool    pool;
    private static HBaseAdmin    hbaseAdmin;
    private static Configuration conf;

    static {
        try {
            conf = HBaseConfiguration.create();

            Map<String, String> temMap = ConfigUtil
                    .loadConfigFile(Config.HbaseSiteFile);
            for (Map.Entry<String, String> entry : temMap.entrySet()) {
                conf.set(entry.getKey(), entry.getValue());
            }

            temMap = ConfigUtil.loadConfigFile(Config.ZkConfigFile);
            for (Map.Entry<String, String> entry : temMap.entrySet()) {
                conf.set(entry.getKey(), entry.getValue());
            }

            pool = new HTablePool(conf, 50);

            hbaseAdmin = new HBaseAdmin(conf);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public static Configuration getConfiguration() {
        return conf;
    }

    public static HBaseAdmin getHBaseAdmin() {
        return hbaseAdmin;
    }

    public static HTablePool getHTablePool() {
        return pool;
    }
}
