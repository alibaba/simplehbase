package allen.studyhbase;

import java.util.TreeSet;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;

import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author xinzhi.zhang
 * */
public class TestHbaseOp extends HbaseTestBase {

    @Test
    public void testPut_WithoutColumn() throws Exception {
        Put put = new Put(rowKey_ForTest);
        try {
            table.put(put);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            // ignore.
        }
    }

    @Test
    public void testGet_NotExistRow() throws Exception {
        // get a row doesn't exist.
        Get get = new Get(rowKey_NotExist);
        Result result = table.get(get);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testGet_Normal_Null_Empty() throws Exception {
        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes("a"));
        put.add(ColumnFamilyNameBytes, QName3, null);
        table.put(put);

        Get get = new Get(rowKey_ForTest);
        Result result = table.get(get);

        byte[] q1 = result.getValue(ColumnFamilyNameBytes, QName1);
        byte[] q2 = result.getValue(ColumnFamilyNameBytes, QName2);
        byte[] q3 = result.getValue(ColumnFamilyNameBytes, QName3);

        Assert.assertEquals("a", Bytes.toString(q1));
        // we get null byte array here.
        Assert.assertEquals(null, Bytes.toString(q2));
        // we get empty byte array here. not a null.
        Assert.assertEquals("", Bytes.toString(q3));

    }

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
    public void testDelete_NotExistRow() throws Exception {
        Delete delete = new Delete(rowKey_ForTest);
        table.delete(delete);
    }

    private void testScan(Scan scan, int expectedSize, String... rowKeys)
            throws Exception {
        log.info("testScan");
        TreeSet<String> resultRowKeys = new TreeSet<String>();
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            log.info("result = " + result);
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }
        close(resultScanner);

        log.info("resultRowKeys size = " + resultRowKeys.size() + " detail = "
                + resultRowKeys);

        Assert.assertTrue(resultRowKeys.size() == expectedSize);
        if (expectedSize > 0) {
            for (String key : rowKeys) {
                Assert.assertTrue(resultRowKeys.contains(key));
            }
        }
        log.info("testScan Done");
    }

    @Test
    public void testScan() throws Exception {
        testScan(new Scan(rowKey1, rowKey2), 1, rowKeyStr1);
        testScan(new Scan(rowKey1, rowKey1), 1, rowKeyStr1);
        testScan(new Scan(rowKey5, (byte[]) null), 4, rowKeyStr5, rowKeyStr6,
                rowKeyStr7, rowKeyStr8);
    }

    @Test
    public void testScan_withColumn() throws Exception {

        Scan scan = new Scan(rowKey1);
        scan.addColumn(ColumnFamilyNameBytes, QName1);
        testScan(scan, 6, rowKeyStr1, rowKeyStr2, rowKeyStr3, rowKeyStr5,
                rowKeyStr6, rowKeyStr7);
    }

    @Test
    public void testScan_withColumn_NonExistColumn() throws Exception {

        Scan scan = new Scan(rowKey1);
        scan.addColumn(ColumnFamilyNameBytes, QName_NotExistColumn);
        testScan(scan, 0, (String[]) null);
    }

    @Test
    public void testScan_withFamily() throws Exception {

        Scan scan = new Scan(rowKey1);
        scan.addFamily(ColumnFamilyNameBytes);
        testScan(scan, 8, rowKeyStr1, rowKeyStr2, rowKeyStr3, rowKeyStr4,
                rowKeyStr5, rowKeyStr6, rowKeyStr7, rowKeyStr8);
    }

    private void testScan_Filter(byte[] qualifer, int expectedSize,
            String... rowKeys) throws Exception {

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        applyDefaultFilter(scan);
        testScan(scan, expectedSize, rowKeys);
    }

    private void testScan_FilterList(byte[] qualifer, int expectedSize,
            String... rowKeys) throws Exception {

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        applyDefaultFilterList(scan);
        testScan(scan, expectedSize, rowKeys);
    }

    @Test
    public void testFilter_one_column() throws Exception {

        testScan_Filter(QName1, 3, rowKeyStr2, rowKeyStr3, rowKeyStr5);
        testScan_Filter(QName2, 6, rowKeyStr1, rowKeyStr2, rowKeyStr4,
                rowKeyStr5, rowKeyStr6, rowKeyStr7);
        testScan_Filter(QName_NotExistColumn, 0);
    }

    @Test
    public void testFilter_one_column_family() throws Exception {
        Scan scan = new Scan();
        scan.addFamily(ColumnFamilyNameBytes);
        applyDefaultFilter(scan);
        testScan(scan, 5, rowKeyStr2, rowKeyStr3, rowKeyStr4, rowKeyStr5,
                rowKeyStr8);
    }

    @Test
    public void testFilter_two_column() throws Exception {
        testScan_FilterList(QName1, 3, rowKeyStr2, rowKeyStr3, rowKeyStr5);
        testScan_FilterList(QName2, 1, rowKeyStr4);
        testScan_FilterList(QName_NotExistColumn, 0);
    }

    @Test
    public void testFilter_two_column__family() throws Exception {
        Scan scan = new Scan();
        scan.addFamily(ColumnFamilyNameBytes);
        applyDefaultFilterList(scan);
        testScan(scan, 3, rowKeyStr3, rowKeyStr4, rowKeyStr8);
    }

    private void testFilter_filterIfMissing(boolean filterIfMissing,
            byte[] qualifer, int expectedSize, String... rowKeys)
            throws Exception {
        Scan scan = new Scan(rowKey4, rowKey4);
        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
                ColumnFamilyNameBytes, QName1, CompareOp.GREATER_OR_EQUAL,
                new BinaryComparator(Bytes.toBytes(4L)));
        filter.setFilterIfMissing(filterIfMissing);
        scan.setFilter(filter);
        testScan(scan, expectedSize, rowKeys);
    }

    private void testFilter_filterIfMissing_family(boolean filterIfMissing,
            int expectedSize, String... rowKeys) throws Exception {
        Scan scan = new Scan(rowKey4, rowKey4);
        scan.addFamily(ColumnFamilyNameBytes);
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
                ColumnFamilyNameBytes, QName1, CompareOp.GREATER_OR_EQUAL,
                new BinaryComparator(Bytes.toBytes(4L)));
        filter.setFilterIfMissing(filterIfMissing);
        scan.setFilter(filter);
        testScan(scan, expectedSize, rowKeys);
    }

    @Test
    public void testFilter_filterIfMissing() throws Exception {
        testFilter_filterIfMissing(false, QName1, 0);
        testFilter_filterIfMissing(true, QName1, 0);
        testFilter_filterIfMissing(false, QName2, 1, rowKeyStr4);
        testFilter_filterIfMissing(true, QName2, 0);

    }

    @Test
    public void testFilter_filterIfMissing_family() throws Exception {
        testFilter_filterIfMissing_family(false, 1, rowKeyStr4);
        testFilter_filterIfMissing_family(true, 0);
    }

    @Test
    public void testCheckAndPut() throws Exception {
        byte[] rowKey = rowKey_ForTest;
        Put put = new Put(rowKey);
        put.add(ColumnFamilyNameBytes, QName1, Bytes.toBytes("a"));
        put.add(ColumnFamilyNameBytes, QName2, Bytes.toBytes("b"));

        boolean result = false;

        result = table.checkAndPut(rowKey, ColumnFamilyNameBytes, QName2,
                Bytes.toBytes("b"), put);
        // check fail, put fail.
        Assert.assertFalse(result);

        result = table.checkAndPut(rowKey, ColumnFamilyNameBytes, QName2, null,
                put);
        // check ok, put ok.
        Assert.assertTrue(result);

        result = table.checkAndPut(rowKey, ColumnFamilyNameBytes, QName2, null,
                put);
        // check fail, put fail.
        Assert.assertFalse(result);

        result = table.checkAndPut(rowKey, ColumnFamilyNameBytes, QName2,
                Bytes.toBytes("b"), put);
        // check ok, put ok.
        Assert.assertTrue(result);
    }
}
