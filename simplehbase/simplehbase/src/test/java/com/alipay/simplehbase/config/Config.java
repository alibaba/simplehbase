package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HTableInterface;

import com.alipay.simplehbase.client.SimpleHbaseAdminClient;
import com.alipay.simplehbase.client.SimpleHbaseAdminClientImpl;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.SimpleHbaseClientFactory;
import com.alipay.simplehbase.client.SimpleHbaseClientImpl;

/**
 * @author xinzhi
 * */
public class Config {

    final public static String                     TableName                         = "MyRecordV04";
    final public static String                     ColumnFamilyName                  = "MyRecordFamily";

    public static String                           TestHqlNodeXmlFile                = "test\\hql\\testHqlNode.xml";
    public static String                           HbaseSiteFile                     = "test\\hbase_site";
    public static String                           ZkConfigFile                      = "test\\zk_conf";
    public static String                           MyRecordXmlFile                   = "test\\hql\\myRecord.xml";

    /**
     * Flag to control table creation.
     * 
     * <pre>
     * run CreateTestTable before set to false. 
     * run DeleteTestTable after running tests when set to false.
     * </pre>
     * 
     * */
    public static boolean                          ShouldDeleteAndCreateTablePerTest = false;

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
        simpleHbaseAdminClient.createTable(tableDescriptor);

    }

    public static void deleteTable() throws Exception {
        simpleHbaseAdminClient.deleteTable(TableName);
    }

    public static void beforeClass() throws Exception {
        if (Config.ShouldDeleteAndCreateTablePerTest) {
            deleteTable();
            createTable();
        }
    }

    public static void afterClass() throws Exception {
        if (Config.ShouldDeleteAndCreateTablePerTest) {
            deleteTable();
        }
    }

    static {
        HBaseDataSource hbaseDataSource = new HBaseDataSource();

        List<String> hbaseConfigFilePaths = new ArrayList<String>();
        //If run on hbase cluster, modify the following config files.
        //If run on hbase stand alone mode, comment out the following config files.
        hbaseConfigFilePaths.add(Config.HbaseSiteFile);
        hbaseConfigFilePaths.add(Config.ZkConfigFile);
        hbaseDataSource.setHbaseConfigFilePaths(hbaseConfigFilePaths);

        // simplehbase config.
        Map<String, String> dataSourceConfig = new HashMap<String, String>();
        dataSourceConfig.put(ConfigOfDataSource.HTABLE_POOL_SIZE, "5");
        hbaseDataSource.setDataSourceConfig(dataSourceConfig);

        hbaseDataSource.init();

        HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
        hbaseTableConfig.setConfigFilePath(MyRecordXmlFile);
        hbaseTableConfig.init();

        SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
        tClient.setHbaseDataSource(hbaseDataSource);
        tClient.setHbaseTableConfig(hbaseTableConfig);

        simpleHbaseClient = SimpleHbaseClientFactory
                .getSimpleHbaseClient(tClient);

        simpleHbaseAdminClient = new SimpleHbaseAdminClientImpl();
        simpleHbaseAdminClient.setHbaseDataSource(simpleHbaseClient
                .getHbaseDataSource());
    }
}
