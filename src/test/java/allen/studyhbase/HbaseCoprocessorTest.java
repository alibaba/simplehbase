package allen.studyhbase;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.config.Config;

/**
 * HbaseCoprocessorTest.
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
public class HbaseCoprocessorTest extends HbaseTestBase {

    @Test
    public void testMax() throws Throwable {

        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = new AggregationClient(
                Config.getConfiguration());
        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName1);
        Long max = aggregationClient.max(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(max.longValue() == 100);
    }

    @Test
    public void testMin() throws Throwable {

        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = new AggregationClient(
                Config.getConfiguration());

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName1);

        Long min = aggregationClient.min(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(min.longValue() == 20);

    }

    @Test
    public void testSum() throws Throwable {
        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = new AggregationClient(
                Config.getConfiguration());
        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName1);
        Long sum = aggregationClient.sum(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(sum.longValue() == 120);
    }

    @Test
    public void testCount() throws Throwable {
        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = new AggregationClient(
                Config.getConfiguration());
        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName1);
        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);

        Assert.assertTrue(count.longValue() == 4);

        scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName3);
        count = aggregationClient.rowCount(TableNameBytes, columnInterpreter,
                scan);
        Assert.assertTrue(count.longValue() == 4);
    }

    @Test
    public void testCount_NonExistColumn() throws Throwable {
        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = new AggregationClient(
                Config.getConfiguration());

        Scan scan = new Scan();
        scan.addColumn(ColumnFamilyName, QName_NotExistColumn);

        Long count = aggregationClient.rowCount(TableNameBytes,
                columnInterpreter, scan);
        Assert.assertTrue(count.longValue() == 4);
    }
}
