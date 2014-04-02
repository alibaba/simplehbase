package allen.studyhbase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;

import org.apache.hadoop.hbase.util.Bytes;

import org.junit.Assert;

import org.junit.Test;

import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;
import com.alipay.simplehbase.util.DateUtil;
import com.alipay.simplehbase.util.Util;

/**
 * HbaseBasicOpTest.
 * 
 * <pre>
 * Mock data.
 * 
 * rowKey1 Q1/100L Q2/100L
 * rowKey2 Q1/20L  Q2/200L
 * rowKey3 Q1/NULL Q2/NULL
 * rowKey4                   Q3/"test"
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public class HbaseBasicOpTest extends HbaseTestBase {

    @Test
    public void testDelete() throws Exception {

        Get get = new Get(rowKey1);
        Result result = table.get(get);
        Assert.assertTrue(!result.isEmpty());

        Delete delete = new Delete(rowKey1);
        table.delete(delete);

        get = new Get(rowKey1);
        result = table.get(get);
        Assert.assertTrue(result.isEmpty());

    }

    @Test
    public void testDeleteNotExistRow() throws Exception {
        Delete delete = new Delete(rowKey_NotExist);
        table.delete(delete);
    }

    @TimeDepend
    @Test
    public void testScan_ts_same() throws Exception {

        CreateTestTable.main(null);

        Date ts = DateUtil.parse("2000-01-01", DateUtil.DayFormat);

        Put put = new Put(rowKey_ForTest);

        put.add(ColumnFamilyName, QName1, ts.getTime(), Bytes.toBytes("a"));

        table.put(put);

        Set<String> resultRowKeys = new HashSet<String>();
        Scan scan = new Scan(rowKey_ForTest, rowKey_ForTest);
        scan.setTimeRange(ts.getTime(), ts.getTime());

        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        Util.close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 0);

        CreateTestTable.main(null);
    }

    @Test
    public void testScan_start_end() throws Exception {

        Set<String> resultRowKeys = new HashSet<String>();
        Scan scan = new Scan(rowKey1, rowKey2);
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        Util.close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 1);
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr1));
    }

    @Test
    public void testScan_same_start_end() throws Exception {

        Set<String> resultRowKeys = new HashSet<String>();
        Scan scan = new Scan(rowKey1, rowKey1);
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        Util.close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 1);
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr1));
    }

    @Test
    public void testScan_start() throws Exception {
        Set<String> resultRowKeys = new HashSet<String>();

        Scan scan = new Scan(rowKey1);
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        Util.close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 4);
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr1));
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr2));
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr3));
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr4));
    }

    @Test
    public void testScan_withColumn() throws Exception {
        Set<String> resultRowKeys = new HashSet<String>();

        Scan scan = new Scan(rowKey1);
        scan.addColumn(ColumnFamilyName, QName1);
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        Util.close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 3);
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr1));
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr2));
        Assert.assertTrue(resultRowKeys.contains(rowKeyStr3));

    }

    @Test
    public void testScan_withFilter() throws Exception {
        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyName, QName1, Bytes.toBytes("2"));
        table.put(put);

        List<Filter> filters = new ArrayList<Filter>();
        SingleColumnValueFilter filter1 = new SingleColumnValueFilter(
                ColumnFamilyName, QName1, CompareOp.GREATER,
                new BinaryComparator(Bytes.toBytes("1000")));
        filters.add(filter1);

        SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
                ColumnFamilyName, QName1, CompareOp.LESS, new BinaryComparator(
                        Bytes.toBytes("5000")));

        filters.add(filter2);

        FilterList filterList = new FilterList(filters);

        Scan scan = new Scan();
        scan.setFilter(filterList);

        List<String> resultRowKeys = new ArrayList<String>();
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }
        Util.close(resultScanner);

        Assert.assertEquals(1, resultRowKeys.size());
    }

    @Test
    public void testCheckAndPut() throws Exception {

        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyName, QName1, Bytes.toBytes("a"));
        put.add(ColumnFamilyName, QName2, Bytes.toBytes("b"));

        boolean result = false;

        result = table.checkAndPut(rowKey_ForTest, ColumnFamilyName, QName2,
                Bytes.toBytes("b"), put);
        // check fail, put fail.
        Assert.assertFalse(result);

        result = table.checkAndPut(rowKey_ForTest, ColumnFamilyName, QName2,
                null, put);
        // check ok, put ok.
        Assert.assertTrue(result);

        result = table.checkAndPut(rowKey_ForTest, ColumnFamilyName, QName2,
                null, put);
        // check fail, put fail.
        Assert.assertFalse(result);

        result = table.checkAndPut(rowKey_ForTest, ColumnFamilyName, QName2,
                Bytes.toBytes("b"), put);
        // check ok, put ok.
        Assert.assertTrue(result);
    }

    @Test
    public void testPutAndGet() throws Exception {
        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyName, QName1, Bytes.toBytes("a"));
        put.add(ColumnFamilyName, QName3, null);
        table.put(put);

        Get get = new Get(rowKey_ForTest);
        Result result = table.get(get);

        byte[] q1 = result.getValue(ColumnFamilyName, QName1);
        byte[] q2 = result.getValue(ColumnFamilyName, QName2);
        byte[] q3 = result.getValue(ColumnFamilyName, QName3);

        Assert.assertEquals("a", Bytes.toString(q1));
        // we get null byte array here.
        Assert.assertEquals(null, Bytes.toString(q2));
        // we get empty byte array here. not a null.
        Assert.assertEquals("", Bytes.toString(q3));
    }

    @Test
    public void testGet_NotExistRowKey() throws Exception {
        // get a row doesn't exist.        
        Get get = new Get(rowKey_NotExist);
        Result result = table.get(get);
        Assert.assertTrue(result.isEmpty());
    }

    @TimeDepend
    @Test
    public void testPutMultiVersionSameTime() throws Exception {
        CreateTestTable.main(null);

        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyName, QName1, 1000, Bytes.toBytes("a"));
        put.add(ColumnFamilyName, QName1, 2000, Bytes.toBytes("b"));
        table.put(put);

        Get get = new Get(rowKey_ForTest);
        get.setMaxVersions(10);
        Result result = table.get(get);
        KeyValue[] keyValues = result.raw();
        Assert.assertEquals(2, keyValues.length);
        //have a and b both.
        Assert.assertEquals('a' + 'b', keyValues[0].getValue()[0]
                + keyValues[1].getValue()[0]);

        CreateTestTable.main(null);
    }

    @Test
    public void testPutWithoutColumn() throws Exception {
        Put put = new Put(rowKey_ForTest);
        try {
            table.put(put);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // ignore.
        }
    }
}
