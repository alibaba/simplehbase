package com.alipay.simplehbase.myrecord.test;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;

import com.alipay.simplehbase.client.SimpleHbaseAdminClient;
import com.alipay.simplehbase.client.SimpleHbaseAdminClientImpl;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.SimpleHbaseClientFactory;
import com.alipay.simplehbase.client.SimpleHbaseClientImpl;
import com.alipay.simplehbase.config.ConfigOfDataSource;
import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.config.Config;

import com.alipay.simplehbase.literal.LiteralValue;
import com.alipay.simplehbase.myrecord.Gender;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordConstants;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;

/**
 * @author xinzhi
 */
public class MyRecordTestBase {

    protected static SimpleHbaseClient      simpleHbaseClient;
    protected static SimpleHbaseAdminClient simpleHbaseAdminClient;

    private static String                   configFilePath                    = Config.MyRecordXmlFile;
    private static boolean                  shouldDeleteAndCreateTablePerTest = Config.ShouldDeleteAndCreateTablePerTest;

    static {
        //        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
        //                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        //        System.setProperty("javax.xml.parsers.SAXParserFactory",
        //                "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

        HBaseDataSource hbaseDataSource = new HBaseDataSource();

        List<String> hbaseConfigFilePaths = new ArrayList<String>();
        //如果是在hbase上跑测试，则修改以下2个配置文件。
        //如果是在hbase standalone模式下跑测试，则注释掉以下2行。
        hbaseConfigFilePaths.add(Config.HbaseSiteFile);
        hbaseConfigFilePaths.add(Config.ZkConfigFile);
        hbaseDataSource.setHbaseConfigFilePaths(hbaseConfigFilePaths);

        // simplehbase config.
        Map<String, String> dataSourceConfig = new HashMap<String, String>();
        dataSourceConfig.put(ConfigOfDataSource.HTABLE_POOL_SIZE, "5");
        hbaseDataSource.setDataSourceConfig(dataSourceConfig);

        hbaseDataSource.init();

        HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
        hbaseTableConfig.setConfigFilePath(configFilePath);
        hbaseTableConfig.init();

        SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
        tClient.setHBaseDataSource(hbaseDataSource);
        tClient.setHbaseTableConfig(hbaseTableConfig);

        simpleHbaseClient = SimpleHbaseClientFactory
                .getSimpleHbaseClient(tClient);

        simpleHbaseAdminClient = new SimpleHbaseAdminClientImpl();
        simpleHbaseAdminClient.setHBaseDataSource(hbaseDataSource);
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        if (shouldDeleteAndCreateTablePerTest) {
            deleteTable();
            createTable();
        }
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (shouldDeleteAndCreateTablePerTest) {
            deleteTable();
        }
    }

    @Before
    public void before() {
        deleteRecords();
    }

    @After
    public void after() {
        deleteRecords();
    }

    private void deleteRecords() {
        MyRecordRowKey start = new MyRecordRowKey(0);
        MyRecordRowKey end = new MyRecordRowKey(Integer.MAX_VALUE);
        simpleHbaseClient.deleteObjectList(start, end);
    }

    public static void createTable() throws Exception {
        // create new table.
        HTableDescriptor tableDescriptor = new HTableDescriptor(
                MyRecordConstants.TableName);

        tableDescriptor.addFamily(new HColumnDescriptor(
                MyRecordConstants.ColumnFamilyName));

        simpleHbaseAdminClient.createTable(tableDescriptor);

    }

    public static void deleteTable() throws Exception {
        simpleHbaseAdminClient.deleteTable(MyRecordConstants.TableName);
    }

    protected static MyRecord mockMyRecord(int id) {
        MyRecord myRecord = new MyRecord();
        myRecord.setId(id);
        myRecord.setName("allen_" + id);
        myRecord.setDate(new Date());
        myRecord.setVersion(0L);
        myRecord.setGender(Gender.MALE);
        return myRecord;
    }

    protected static MyRecord[] mockMyRecords(int size) {
        MyRecord[] myRecords = new MyRecord[size];
        for (int i = 0; i < myRecords.length; i++) {
            myRecords[i] = mockMyRecord(i);
        }
        return myRecords;
    }

    protected static void addMockRecords(int size) {
        MyRecord[] myRecords = mockMyRecords(size);
        for (int i = 0; i < myRecords.length; i++) {
            MyRecordRowKey myRecordRowKey = new MyRecordRowKey(i);
            simpleHbaseClient.putObject(myRecordRowKey, myRecords[i]);
        }
    }

    protected void put(String str) {
        MyRecord myRecord = parseMyRecord(str);
        MyRecordRowKey myRecordRowKey = new MyRecordRowKey(myRecord.getId());
        simpleHbaseClient.putObject(myRecordRowKey, myRecord);
    }

    protected MyRecord parseMyRecord(String str) {

        MyRecord record = new MyRecord();

        String[] parts = str.split("[=,]");

        for (int i = 0; i < parts.length; i += 2) {

            if (parts[i].equals("id")) {
                record.setId((Integer) (LiteralValue.convertToObject(int.class,
                        parts[i + 1])));
                continue;
            }

            if (parts[i].equals("name")) {
                record.setName(parts[i + 1]);
                continue;
            }

            if (parts[i].equals("date")) {
                record.setDate((Date) (LiteralValue.convertToObject(Date.class,
                        parts[i + 1])));
                continue;
            }

            if (parts[i].equals("gender")) {
                record.setGender((Gender) (LiteralValue.convertToObject(
                        Gender.class, parts[i + 1])));
                continue;
            }

            if (parts[i].equals("age")) {
                record.setAge((Long) (LiteralValue.convertToObject(long.class,
                        parts[i + 1])));
                continue;
            }

            if (parts[i].equals("version")) {
                record.setId((Integer) (LiteralValue.convertToObject(int.class,
                        parts[i + 1])));
                continue;
            }

        }

        return record;
    }

}
