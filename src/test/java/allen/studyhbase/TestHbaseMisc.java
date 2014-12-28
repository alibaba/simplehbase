package allen.studyhbase;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;

import org.apache.hadoop.hbase.client.Get;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

import org.junit.Assert;

import org.junit.Test;

/**
 * @author xinzhi.zhang
 * */
public class TestHbaseMisc extends HbaseTestBase {

    private void fillData() throws Exception {

        Put put = new Put(rowKey_ForTest);

        put.add(ColumnFamilyNameBytes, QName1, 1L, Bytes.toBytes("a"));

        put.add(ColumnFamilyNameBytes, QName1, 2L, Bytes.toBytes("b"));

        put.add(ColumnFamilyNameBytes, QName1, 3L, Bytes.toBytes("c"));

        table.put(put);
    }

    @TimeDepend
    @Test
    public void testScan_ts_same() throws Exception {

        recreateTable();

        Date ts = parse("2000-01-01", "yyyy-MM-dd");

        Put put = new Put(rowKey_ForTest);

        put.add(ColumnFamilyNameBytes, QName1, ts.getTime(), Bytes.toBytes("a"));

        table.put(put);

        Set<String> resultRowKeys = new HashSet<String>();
        Scan scan = new Scan(rowKey_ForTest, rowKey_ForTest);
        scan.setTimeRange(ts.getTime(), ts.getTime());

        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result = resultScanner.next(); result != null; result = resultScanner
                .next()) {
            resultRowKeys.add(Bytes.toString(result.getRow()));
        }

        close(resultScanner);

        Assert.assertTrue(resultRowKeys.size() == 0);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testPutMultiVersionSameTime() throws Exception {
        recreateTable();

        Put put = new Put(rowKey_ForTest);
        put.add(ColumnFamilyNameBytes, QName1, 1000, Bytes.toBytes("a"));
        put.add(ColumnFamilyNameBytes, QName1, 2000, Bytes.toBytes("b"));
        table.put(put);

        Get get = new Get(rowKey_ForTest);
        get.setMaxVersions(10);
        Result result = table.get(get);
        Cell[] cells = result.rawCells();
        Assert.assertEquals(2, cells.length);
        //have a and b both.
        Assert.assertEquals('a' + 'b', CellUtil.cloneValue(cells[0])[0]
                + CellUtil.cloneValue(cells[1])[0]);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testDeleteColumnWithoutTs() throws Exception {
        recreateTable();
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyNameBytes, QName1);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyNameBytes, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(2, result.rawCells().length);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testDeleteColumnWithTs() throws Exception {
        recreateTable();
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyNameBytes, QName1, 2L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyNameBytes, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(2, result.rawCells().length);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testGetWith_Ts() throws Exception {
        recreateTable();
        fillData();

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyNameBytes, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(3, result.rawCells().length);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testMaxVersion() throws Exception {
        recreateTable();
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyNameBytes, QName1, 2L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyNameBytes, QName1);
        get.setMaxVersions(1);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        recreateTable();
    }

    @TimeDepend
    @Test
    public void testMaxVersion2() throws Exception {
        recreateTable();
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyNameBytes, QName1, 3L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyNameBytes, QName1);
        get.setMaxVersions(1);

        Result result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(3L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.rawCells().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(1, result.rawCells().length);

        recreateTable();
    }
}
