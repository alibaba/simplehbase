package allen.studyhbase;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;

import org.apache.hadoop.hbase.util.Bytes;

import org.junit.Assert;

import org.junit.Test;

import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;

/**
 * HbaseBasicOpAboutTsTest.
 * 
 * @author xinzhi.zhang
 * */
public class HbaseBasicOpAboutTsTest extends HbaseTestBase {

    private void fillData() throws Exception {

        Put put = new Put(rowKey_ForTest);

        put.add(ColumnFamilyName, QName1, 1L, Bytes.toBytes("a"));

        put.add(ColumnFamilyName, QName1, 2L, Bytes.toBytes("b"));

        put.add(ColumnFamilyName, QName1, 3L, Bytes.toBytes("c"));

        table.put(put);
    }

    @TimeDepend
    @Test
    public void testGetWith_Ts() throws Exception {
        CreateTestTable.main(null);
        fillData();

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyName, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(3, result.raw().length);

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void testDeleteColumnWithTs() throws Exception {
        CreateTestTable.main(null);
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyName, QName1, 2L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyName, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(2, result.raw().length);

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void testDeleteColumnWithoutTs() throws Exception {
        CreateTestTable.main(null);
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyName, QName1);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyName, QName1);
        get.setMaxVersions(3);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(2, result.raw().length);

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void testMaxVersion() throws Exception {
        CreateTestTable.main(null);
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyName, QName1, 2L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyName, QName1);
        get.setMaxVersions(1);

        get.setTimeStamp(3L);
        Result result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void testMaxVersion2() throws Exception {
        CreateTestTable.main(null);
        fillData();

        Delete delete = new Delete(rowKey_ForTest);
        delete.deleteColumn(ColumnFamilyName, QName1, 3L);
        table.delete(delete);

        Get get = new Get(rowKey_ForTest);
        get.addColumn(ColumnFamilyName, QName1);
        get.setMaxVersions(1);

        Result result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(3L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeStamp(2L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(1L);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        get.setTimeStamp(0L);
        result = table.get(get);
        Assert.assertEquals(0, result.raw().length);

        get.setTimeRange(1, 4);
        result = table.get(get);
        Assert.assertEquals(1, result.raw().length);

        CreateTestTable.main(null);
    }

}
