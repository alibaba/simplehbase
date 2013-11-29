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

import com.alipay.simplehbase.myrecord.Gender;
import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordConstants;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;

public class TestMyRecord {

    protected static SimpleHbaseClient      simpleHbaseClient;
    protected static SimpleHbaseAdminClient simpleHbaseAdminClient;

    private static String                   configFilePath = "test\\myRecord.xml";

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        System.setProperty("javax.xml.parsers.SAXParserFactory",
                "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

        HBaseDataSource hbaseDataSource = new HBaseDataSource();

        List<String> hbaseConfigFilePaths = new ArrayList<String>();
        hbaseConfigFilePaths.add("test\\hbase_site");
        hbaseConfigFilePaths.add("test\\zk_conf");
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

        createTable();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        deleteTable();
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

    private static void createTable() throws Exception {
        // create new table.
        HTableDescriptor tableDescriptor = new HTableDescriptor(
                MyRecordConstants.TableName);

        tableDescriptor.addFamily(new HColumnDescriptor(
                MyRecordConstants.ColumnFamilyName));

        simpleHbaseAdminClient.createTable(tableDescriptor);

    }

    private static void deleteTable() throws Exception {
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
}
