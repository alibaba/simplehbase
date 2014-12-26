package allen.studyhbase;

import java.io.Closeable;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;

/**
 * @author xinzhi.zhang
 * */
public abstract class HbaseTest {

    protected static Log             log                  = LogFactory
                                                                  .getLog(HbaseTest.class);

    protected static HTableInterface table;

    protected static String          TableName;
    protected static byte[]          TableNameBytes;
    protected static String          ColumnFamilyName;
    protected static byte[]          ColumnFamilyNameBytes;

    protected String                 QNameStr1            = "q1";
    protected String                 QNameStr2            = "q2";
    protected String                 QNameStr3            = "q3";

    protected byte[]                 QName1               = Bytes.toBytes(QNameStr1);
    protected byte[]                 QName2               = Bytes.toBytes(QNameStr2);
    protected byte[]                 QName3               = Bytes.toBytes(QNameStr3);

    protected String                 rowKeyStr1           = "allen_test_row01";
    protected String                 rowKeyStr2           = "allen_test_row02";
    protected String                 rowKeyStr3           = "allen_test_row03";
    protected String                 rowKeyStr4           = "allen_test_row04";
    protected String                 rowKeyStr5           = "allen_test_row05";
    protected String                 rowKeyStr6           = "allen_test_row06";
    protected String                 rowKeyStr7           = "allen_test_row07";
    protected String                 rowKeyStr8           = "allen_test_row08";

    protected byte[]                 rowKey1              = Bytes.toBytes(rowKeyStr1);
    protected byte[]                 rowKey2              = Bytes.toBytes(rowKeyStr2);
    protected byte[]                 rowKey3              = Bytes.toBytes(rowKeyStr3);
    protected byte[]                 rowKey4              = Bytes.toBytes(rowKeyStr4);
    protected byte[]                 rowKey5              = Bytes.toBytes(rowKeyStr5);
    protected byte[]                 rowKey6              = Bytes.toBytes(rowKeyStr6);
    protected byte[]                 rowKey7              = Bytes.toBytes(rowKeyStr7);
    protected byte[]                 rowKey8              = Bytes.toBytes(rowKeyStr8);

    protected byte[]                 rowKey_NotExist      = Bytes.toBytes("NotExistRowKey");
    protected byte[]                 rowKey_ForTest       = Bytes.toBytes("RowKey_ForTest");
    protected byte[]                 QName_NotExistColumn = Bytes.toBytes("NotExistColumn");

    protected abstract Configuration getConfiguration();

    protected abstract void initHTable();

    protected abstract void recreateTable();

    @Before
    public void before() throws Throwable {
        initHTable();
        deleteData();
        fillData();
    }

    @After
    public void after() throws Exception {
        deleteData();
        close(table);
    }

    /**
     * <pre>
     * rowkey          f/q1            f/q2           f/q3 
     * 1               1                2
     * 2               4                8
     * 3               16
     * 4                                32
     * 5               64               NULL
     * 6               NULL             128
     * 7               NULL             NULL
     * 8                                              "test"
     * </pre>
     * */
    private void fillData() throws Throwable {

        Put put = new Put(rowKey1);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes(1L));
        put.add(ColumnFamilyNameBytes, QName2, Bytes.toBytes(2L));
        table.put(put);

        put = new Put(rowKey2);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes(4L));
        put.add(ColumnFamilyNameBytes, QName2, Bytes.toBytes(8L));
        table.put(put);

        put = new Put(rowKey3);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes(16L));
        table.put(put);

        put = new Put(rowKey4);
        put.add(ColumnFamilyNameBytes, QName2, Bytes.toBytes(32L));
        table.put(put);

        // set null case.
        put = new Put(rowKey5);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes(64L));
        put.add(ColumnFamilyNameBytes, QName2, null);
        table.put(put);

        put = new Put(rowKey6);
        put.add(ColumnFamilyNameBytes, QName1, null);
        put.add(ColumnFamilyNameBytes, QName2, Bytes.toBytes(128L));
        table.put(put);

        put = new Put(rowKey7);
        put.add(ColumnFamilyNameBytes, QName1, null);
        put.add(ColumnFamilyNameBytes, QName2, null);
        table.put(put);

        // empty case.
        put = new Put(rowKey8);
        put.add(ColumnFamilyNameBytes, QName3, Bytes.toBytes("test"));
        table.put(put);
    }

    /**
     * Delte all the data in table.
     * */
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

            close(resultScanner);

            for (byte[] row : rows) {
                table.delete(new Delete(row));
                log.info("delete " + Bytes.toString(row));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            throw new RuntimeException("close closeable exception.", e);
        }
    }

    protected AggregationClient getAggregationClient() {
        AggregationClient aggregationClient = new AggregationClient(
                getConfiguration());
        return aggregationClient;
    }

    protected Date parse(String str, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            //ignore.
        }
        return null;
    }

    protected void applyDefaultFilter(Scan scan) {
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
                ColumnFamilyNameBytes, QName1, CompareOp.GREATER_OR_EQUAL,
                new BinaryComparator(Bytes.toBytes(4L)));
        scan.setFilter(filter);
    }

    protected void applyDefaultFilterList(Scan scan) {

        List<Filter> filters = new ArrayList<Filter>();

        SingleColumnValueFilter filter1 = new SingleColumnValueFilter(
                ColumnFamilyNameBytes, QName1, CompareOp.GREATER,
                new BinaryComparator(Bytes.toBytes(1L)));
        filters.add(filter1);

        SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
                ColumnFamilyNameBytes, QName2, CompareOp.EQUAL,
                new BinaryComparator(Bytes.toBytes(32L)));
        filters.add(filter2);

        FilterList filterList = new FilterList(filters);

        scan.setFilter(filterList);
    }
}
