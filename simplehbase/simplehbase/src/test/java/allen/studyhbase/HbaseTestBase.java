package allen.studyhbase;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class HbaseTestBase {

    protected static Log        log              = LogFactory
                                                         .getLog(HbaseTestBase.class);

    protected static HBaseAdmin hbaseAdmin;
    protected static HTablePool pool;
    protected static String     TableName        = "allen_test";
    protected static byte[]     TableNameBytes   = Bytes.toBytes(TableName);
    protected static byte[]     ColumnFamilyName = Bytes.toBytes("cf");

    protected static String     QNameStr1        = "q1";
    protected static String     QNameStr2        = "q2";
    protected static String     QNameStr3        = "q3";

    protected static byte[]     QName1           = Bytes.toBytes(QNameStr1);
    protected static byte[]     QName2           = Bytes.toBytes(QNameStr2);
    protected static byte[]     QName3           = Bytes.toBytes(QNameStr3);

    protected HTableInterface   table;

    @BeforeClass
    public static void beforeClass() throws Exception {
        hbaseAdmin = CommonConfig.getHBaseAdmin();
        deleteTable();
        createTable();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        deleteTable();
    }

    @Before
    public void before() throws Throwable {
        pool = CommonConfig.getHTablePool();
        table = pool.getTable(TableName);
        fillData();
    }

    @After
    public void after() throws Exception {
        deleteData();
    }

    private static void createTable() throws Exception {

        // create new table.
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName);
        tableDescriptor.addFamily(new HColumnDescriptor(ColumnFamilyName));
        hbaseAdmin.createTable(tableDescriptor);
    }

    private static void deleteTable() throws Exception {
        // delete table if table exist.
        if (hbaseAdmin.tableExists(TableName)) {
            // disable table before delete it.
            if (!hbaseAdmin.isTableDisabled(TableName)) {
                hbaseAdmin.disableTable(TableName);
            }
            hbaseAdmin.deleteTable(TableName);
        }
    }

    String rowKeyStr1 = "allen_test_row1";
    String rowKeyStr2 = "allen_test_row2";
    String rowKeyStr3 = "allen_test_row3";
    String rowKeyStr4 = "allen_test_row4";

    byte[] rowKey1    = Bytes.toBytes(rowKeyStr1);
    byte[] rowKey2    = Bytes.toBytes(rowKeyStr2);
    byte[] rowKey3    = Bytes.toBytes(rowKeyStr3);
    byte[] rowKey4    = Bytes.toBytes(rowKeyStr4);

    /**
     * Fill mockData.
     * 
     * <pre>
     * rowKey1 Q1/100L Q2/100L
     * rowKey2 Q1/20L  Q2/200L
     * rowKey3 Q1/NULL Q2/NULL
     * rowKey4                   Q3/"test"
     * </pre>
     * */
    private void fillData() throws Throwable {

        Put put = new Put(rowKey1);
        put.add(ColumnFamilyName, QName1, Bytes.toBytes(100L));
        put.add(ColumnFamilyName, QName2, Bytes.toBytes(100L));
        table.put(put);

        put = new Put(rowKey2);
        put.add(ColumnFamilyName, QName1, Bytes.toBytes(20L));
        put.add(ColumnFamilyName, QName2, Bytes.toBytes(200L));
        table.put(put);

        // set null case.
        put = new Put(rowKey3);
        put.add(ColumnFamilyName, QName1, null);
        put.add(ColumnFamilyName, QName2, null);
        table.put(put);

        // empty case.
        put = new Put(rowKey4);
        put.add(ColumnFamilyName, QName3, Bytes.toBytes("test"));
        table.put(put);
    }

    private void deleteData() throws Exception {
        try {
            // full scan.
            Scan scan = new Scan();
            ResultScanner resultScanner = table.getScanner(scan);

            List<byte[]> rows = new LinkedList<byte[]>();
            for (Result result = resultScanner.next(); result != null; result = resultScanner
                    .next()) {
                rows.add(result.getRow());
            }

            resultScanner.close();

            for (byte[] row : rows) {
                table.delete(new Delete(row));
                log.info("delete " + Bytes.toString(row));
            }

            // return table to pool.
            table.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
