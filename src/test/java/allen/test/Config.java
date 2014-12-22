package allen.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.Coprocessor;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.springframework.core.io.Resource;

import com.alipay.simplehbase.client.SimpleHbaseAdminClient;
import com.alipay.simplehbase.client.SimpleHbaseAdminClientImpl;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.SimpleHbaseClientFactory;
import com.alipay.simplehbase.client.SimpleHbaseClientImpl;
import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;

/**
 * @author xinzhi
 * */
public class Config {

    final public static String                     TableName              = "MyRecordV_Allen3";
    final public static String                     ColumnFamilyName       = "MyRecordFamily";
    final public static String                     SimpleHbaseCpPath      = "hdfs://hbdev-1.alipay.net:9000/corp/jar/simplehbase-1.1.jar";
    final public static String                     SimpleHbaseCpClassName = "com.alipay.cp.ext2.CommonEndpointImpl2";

    final public static String                     TestHqlNodeXmlFile     = "test\\hql\\testHqlNode.xml";
    final public static String                     HbaseSiteFile          = "test\\hbase_site";
    final public static String                     ZkConfigFile           = "test\\zk_conf";
    final public static String                     MyRecordXmlFile        = "test\\hql\\myRecord.xml";

    final public static boolean                    isPerfTestOn           = false;

    private static volatile SimpleHbaseClient      simpleHbaseClient;

    private static volatile SimpleHbaseAdminClient simpleHbaseAdminClient;

    public static SimpleHbaseAdminClient getSimpleHbaseAdminClient() {
        return simpleHbaseAdminClient;
    }

    public static SimpleHbaseClient getSimpleHbaseClient() {
        return simpleHbaseClient;
    }

    public static Configuration getConfiguration() {
        return simpleHbaseClient.getHbaseDataSource().getHbaseConfiguration();
    }

    public static HTableInterface getHTableInterface(String tableName) {
        return simpleHbaseClient.getHbaseDataSource().getHTable(tableName);
    }

    public static void createTable() throws Exception {
        // create new table.
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName);
        tableDescriptor.addFamily(new HColumnDescriptor(ColumnFamilyName));
        tableDescriptor
                .addCoprocessor("org.apache.hadoop.hbase.coprocessor.AggregateImplementation");

        Path jarFilePath = new Path(SimpleHbaseCpPath);
        tableDescriptor.addCoprocessor(SimpleHbaseCpClassName, jarFilePath,
                Coprocessor.PRIORITY_USER, null);
        simpleHbaseAdminClient.createTable(tableDescriptor);

    }

    public static void deleteTable() throws Exception {
        simpleHbaseAdminClient.deleteTable(TableName);
    }

    static {
        HBaseDataSource hbaseDataSource = new HBaseDataSource();

        List<Resource> hbaseConfigResources = new ArrayList<Resource>();
        //If run on hbase cluster, modify the following config files.
        //If run on hbase stand alone mode, comment out the following config files.
        hbaseConfigResources.add(new CachedFileSystemResource(
                Config.HbaseSiteFile));
        hbaseConfigResources.add(new CachedFileSystemResource(
                Config.ZkConfigFile));
        hbaseDataSource.setHbaseConfigResources(hbaseConfigResources);

        hbaseDataSource.init();

        HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
        hbaseTableConfig.setConfigResource(new CachedFileSystemResource(
                MyRecordXmlFile));
        hbaseTableConfig.init();

        SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
        tClient.setHbaseDataSource(hbaseDataSource);
        tClient.setHbaseTableConfig(hbaseTableConfig);

        simpleHbaseClient = SimpleHbaseClientFactory
                .getSimpleHbaseClient(tClient);

        simpleHbaseAdminClient = SimpleHbaseClientFactory.getWrapper(
                SimpleHbaseAdminClient.class, new SimpleHbaseAdminClientImpl());
        simpleHbaseAdminClient.setHbaseDataSource(simpleHbaseClient
                .getHbaseDataSource());
    }
}
