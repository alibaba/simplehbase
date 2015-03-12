package allen.studyhbase;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xinzhi.zhang
 * */
public class TestHbaseOpCoprocessor extends HbaseTestBase {

    private LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();

    @Test(expected = Exception.class)
    public void testCp() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        aggregationClient.rowCount(TableNameBytes, columnInterpreter, scan);
    }

    @Test
    public void testMax() throws Throwable {

        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, QName1);
        Long max = aggregationClient.max(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(max.longValue() == 64);
    }

    @Test
    public void testMin() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, QName1);

        Long min = aggregationClient.min(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(min.longValue() == 1);

    }

    @Test
    public void testSum_Two_column() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();
        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, QName1);
        scan.addColumn(ColumnFamilyNameBytes, QName2);
        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(sum.longValue() == 255);
    }

    private void testSum_OneColumn(byte[] qualifier, Long expected)
            throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, qualifier);
        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);
        if (expected == null) {
            Assert.assertTrue(sum == null);
        } else {
            Assert.assertTrue(expected.longValue() == sum.longValue());
        }
    }

    @Test
    public void testSum_OneColumn() throws Throwable {
        testSum_OneColumn(QName1, 85L);
        testSum_OneColumn(QName2, 170L);
        testSum_OneColumn(QName3, null);
        testSum_OneColumn(QName_NotExistColumn, null);
    }

    @Test
    public void testSum_Family() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();
        Scan scan = new Scan();
        scan.addFamily(ColumnFamilyNameBytes);
        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);

        Assert.assertTrue(sum.longValue() == 255);
    }

    private void testSum_WithFilter(byte[] qualifier, Long expected)
            throws Throwable {

        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();

        scan.addColumn(ColumnFamilyNameBytes, qualifier);

        applyDefaultFilter(scan);

        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);

        if (expected == null) {
            Assert.assertTrue(sum == null);
        } else {
            Assert.assertTrue(expected.longValue() == sum.longValue());
        }

    }

    @Test
    public void testSum_WithFilter() throws Throwable {
        switch (hBaseVersion()) {
            case _94_24:
                testSum_WithFilter(QName1, 84L);
                testSum_WithFilter(QName2, 170L);
                testSum_WithFilter(QName3, null);
                testSum_WithFilter(QName_NotExistColumn, null);
                break;

            default:
                testSum_WithFilter(QName1, 84L);
                testSum_WithFilter(QName2, 40L);
                testSum_WithFilter(QName3, null);
                testSum_WithFilter(QName_NotExistColumn, null);
                break;
        }
    }

    @Test
    public void testSum_WithFilter_Family() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();

        scan.addFamily(ColumnFamilyNameBytes);

        applyDefaultFilter(scan);

        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);

        Assert.assertTrue(sum.longValue() == 124L);
    }

    private void testCount_OneColumn(byte[] qualifier, Long expected)
            throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, qualifier);
        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);
        if (expected == null) {
            Assert.assertTrue(count == null);
        } else {
            Assert.assertTrue(expected.longValue() == count.longValue());
        }

    }

    @Test
    public void testCount_OneColumn() throws Throwable {
        switch (hBaseVersion()) {
            case _94adh3u5:
                testCount_OneColumn(QName1, 6L);
                testCount_OneColumn(QName2, 6L);
                testCount_OneColumn(QName3, 1L);
                testCount_OneColumn(QName_NotExistColumn, 0L);
                break;
            default:
                testCount_OneColumn(QName1, 8L);
                testCount_OneColumn(QName2, 8L);
                testCount_OneColumn(QName3, 8L);
                testCount_OneColumn(QName_NotExistColumn, 8L);
                break;
        }
    }

    @Test
    public void testCount_Family() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();
        Scan scan = new Scan();
        scan.addFamily(ColumnFamilyNameBytes);
        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);
        Assert.assertTrue(count.longValue() == 8);
    }

    private void testCount_WithFilter(byte[] qualifier, Long expected)
            throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyNameBytes, qualifier);
        applyDefaultFilter(scan);

        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);

        if (expected == null) {
            Assert.assertTrue(count == null);
        } else {
            Assert.assertTrue(expected.longValue() == count.longValue());
        }

    }

    @Test
    public void testCount_WithFilter() throws Throwable {
        switch (hBaseVersion()) {
            case _94adh3u5:
                testCount_WithFilter(QName1, 3L);
                testCount_WithFilter(QName2, 3L);
                testCount_WithFilter(QName3, 1L);
                testCount_WithFilter(QName_NotExistColumn, 0L);
                break;
            default:
                testCount_WithFilter(QName1, 5L);
                testCount_WithFilter(QName2, 5L);
                testCount_WithFilter(QName3, 5L);
                testCount_WithFilter(QName_NotExistColumn, 5L);
                break;
        }
    }

    @Test
    public void testCount_WithFilter_Family() throws Throwable {
        AggregationClient aggregationClient = getAggregationClient();

        Scan scan = new Scan();
        scan.addFamily(ColumnFamilyNameBytes);
        applyDefaultFilter(scan);

        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);
        Assert.assertTrue(count.longValue() == 5L);
    }

}
