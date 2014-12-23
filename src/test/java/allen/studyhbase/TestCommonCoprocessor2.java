package allen.studyhbase;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Assert;
import org.junit.Test;

import com.alipay.cp.ext.aggr.AggrHandler;
import com.alipay.cp.ext.aggr.AggrReducer;
import com.alipay.cp.ext.aggr.AggrRequest;
import com.alipay.cp.ext.aggr.AggrResult;
import com.alipay.cp.ext2.CpClient2;


/**
 * @author xinzhi.zhang
 * */
public class TestCommonCoprocessor2 extends HbaseTestBase {

    private void testSum_OneColumn(byte[] qualifer, long expected)
            throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        aggrRequest.add(Bytes.toString(ColumnFamilyNameBytes),
                Bytes.toString(qualifer));
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();

        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(expected == aggrResult.getSum(0));
    }

    @Test
    public void testSum_OneColumn() throws Throwable {
        testSum_OneColumn(QName1, 85L);
        testSum_OneColumn(QName2, 170L);
        testSum_OneColumn(QName3, 0L);
        testSum_OneColumn(QName_NotExistColumn, 0L);
    }

    private void testSum_Family_ManyColumn(byte[][] qualifers, long[] expected)
            throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        for (byte[] qualifer : qualifers) {
            aggrRequest.add(Bytes.toString(ColumnFamilyNameBytes),
                    Bytes.toString(qualifer));
        }
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();

        scan.addFamily(ColumnFamilyNameBytes);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue(expected[i] == aggrResult.getSum(i));
        }
    }

    @Test
    public void testSum_Family_ManyColumn() throws Throwable {

        testSum_Family_ManyColumn(new byte[][] { QName1 }, new long[] { 85L });
        testSum_Family_ManyColumn(new byte[][] { QName2 }, new long[] { 170L });
        testSum_Family_ManyColumn(new byte[][] { QName3 }, new long[] { 0L });
        testSum_Family_ManyColumn(new byte[][] { QName_NotExistColumn },
                new long[] { 0L });

        testSum_Family_ManyColumn(new byte[][] { QName1, QName2, QName3,
                QName_NotExistColumn }, new long[] { 85L, 170L, 0L, 0L });

    }

    private void testSum_WithFilter(byte[] qualifer, Long expected)
            throws Throwable {

        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        aggrRequest.add(Bytes.toString(ColumnFamilyNameBytes),
                Bytes.toString(qualifer));
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();
        applyDefaultFilter(scan);

        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(expected == aggrResult.getSum(0));
    }

    @Test
    public void testSum_WithFilter() throws Throwable {
        switch (hBaseVersion()) {
            case _94_24:
                testSum_WithFilter(QName1, 84L);
                testSum_WithFilter(QName2, 170L);
                testSum_WithFilter(QName3, 0L);
                testSum_WithFilter(QName_NotExistColumn, 0L);
                break;
            default:
                testSum_WithFilter(QName1, 84L);
                testSum_WithFilter(QName2, 40L);
                testSum_WithFilter(QName3, 0L);
                testSum_WithFilter(QName_NotExistColumn, 0L);
                break;
        }
    }

    private void testSum_WithFilter_Family_ManyColumn(byte[][] qualifers,
            long[] expected) throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        for (byte[] qualifer : qualifers) {
            aggrRequest.add(Bytes.toString(ColumnFamilyNameBytes),
                    Bytes.toString(qualifer));
        }
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();
        applyDefaultFilter(scan);

        scan.addFamily(ColumnFamilyNameBytes);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue(expected[i] == aggrResult.getSum(i));
        }
    }

    @Test
    public void testSum_WithFilter_Family_ManyColumn() throws Throwable {
        testSum_WithFilter_Family_ManyColumn(new byte[][] { QName1 },
                new long[] { 84L });
        testSum_WithFilter_Family_ManyColumn(new byte[][] { QName2 },
                new long[] { 40L });
        testSum_WithFilter_Family_ManyColumn(new byte[][] { QName3 },
                new long[] { 0L });
        testSum_WithFilter_Family_ManyColumn(
                new byte[][] { QName_NotExistColumn }, new long[] { 0L });

        testSum_WithFilter_Family_ManyColumn(new byte[][] { QName1, QName2,
                QName3, QName_NotExistColumn }, new long[] { 84L, 40L, 0L, 0L });
    }

    private void testCount_OneColumn(byte[] qualifer, Long expected)
            throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();

        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(expected == aggrResult.getCount());
    }

    @Test
    public void testCount_OneColumn() throws Throwable {
        testCount_OneColumn(QName1, 6L);
        testCount_OneColumn(QName2, 6L);
        testCount_OneColumn(QName3, 1L);
        testCount_OneColumn(QName_NotExistColumn, 0L);
    }

    @Test
    public void testCount_Family() throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();

        scan.addFamily(ColumnFamilyNameBytes);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(8 == aggrResult.getCount());
    }

    private void testCount_WithFilter(byte[] qualifer, Long expected)
            throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();
        applyDefaultFilter(scan);
        scan.addColumn(ColumnFamilyNameBytes, qualifer);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(expected == aggrResult.getCount());
    }

    @Test
    public void testCount_WithFilter() throws Throwable {
        switch (hBaseVersion()) {
            case _94_24:
                testCount_WithFilter(QName1, 3L);
                testCount_WithFilter(QName2, 6L);
                testCount_WithFilter(QName3, 1L);
                testCount_WithFilter(QName_NotExistColumn, 0L);
                break;
            default:
                testCount_WithFilter(QName1, 3L);
                testCount_WithFilter(QName2, 3L);
                testCount_WithFilter(QName3, 1L);
                testCount_WithFilter(QName_NotExistColumn, 0L);
                break;
        }

    }

    @Test
    public void testCount_WithFilter_Family() throws Throwable {
        CpClient2 myClient = new CpClient2(table);
        AggrRequest aggrRequest = new AggrRequest();
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);
        Scan scan = new Scan();
        applyDefaultFilter(scan);
        scan.addFamily(ColumnFamilyNameBytes);
        AggrResult aggrResult = myClient.call(aggrHandler, new AggrReducer(),
                scan);
        Assert.assertTrue(5 == aggrResult.getCount());
    }

}
