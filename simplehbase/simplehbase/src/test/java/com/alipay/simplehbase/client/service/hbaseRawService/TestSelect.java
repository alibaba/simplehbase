package com.alipay.simplehbase.client.service.hbaseRawService;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.alipay.simplehbase.client.SimpleHbaseCellResult;
import com.alipay.simplehbase.config.Config;
import com.alipay.simplehbase.config.CreateTestTable;
import com.alipay.simplehbase.config.TimeDepend;

import com.alipay.simplehbase.util.DateUtil;

/**
 * @author xinzhi
 * */
public class TestSelect extends RawServiceTestBase {

    @Test
    public void testSelect_RowKeyRange() {

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"0\") )";

        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(2, list.get(0).size());

        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "age", 30L);
    }

    @Test
    public void testSelect_Filter() {

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from "
                + Config.TableName
                + " where age greater \"10\" rowkey range ( intkey (\"0\") , intkey (\"2\") )";

        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(2, list.get(0).size());
        Assert.assertEquals(2, list.get(1).size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "age", 30L);
        assertSimpleHbaseCellResult(list.get(1), "name", "dan");
        assertSimpleHbaseCellResult(list.get(1), "age", 20L);

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " where age greater \"25\" rowkey range ( intkey (\"0\") , intkey (\"2\") )";

        list = simpleHbaseClient.select(selectHql);

        Assert.assertEquals(1, list.size());
        Assert.assertEquals(2, list.get(0).size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "age", 30L);
    }

    @Test
    public void testSelect_Limit_1_Para() {

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"linzhi\", \"10\" ) rowkey is intkey (\"2\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 4 ";
        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(3, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(1), "name", "dan");
        assertSimpleHbaseCellResult(list.get(2), "name", "linzhi");

        selectHql = "select ( name,age ) from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 3 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(3, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(1), "name", "dan");
        assertSimpleHbaseCellResult(list.get(2), "name", "linzhi");

        selectHql = "select ( name,age ) from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 2 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(2, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(1), "name", "dan");

        selectHql = "select ( name,age ) from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 1 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(1, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
    }

    @Test
    public void testSelect_Limit_2_Para() {

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"linzhi\", \"10\" ) rowkey is intkey (\"2\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 4 , 1 ";
        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(0, list.size());

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 0, 4 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(3, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(1), "name", "dan");
        assertSimpleHbaseCellResult(list.get(2), "name", "linzhi");

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 1,2 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(2, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "dan");
        assertSimpleHbaseCellResult(list.get(1), "name", "linzhi");

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 1,1 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(1, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "dan");

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) limit 1, 10 ";
        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(2, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name", "dan");
        assertSimpleHbaseCellResult(list.get(1), "name", "linzhi");
    }

    @TimeDepend
    @Test
    public void testSelect_Ts() {
        CreateTestTable.main(null);

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ts is \"2000-01-01\"";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ts is \"2001-01-01\"";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ts is \"2002-01-01\"";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) ts range ( \"1999-01-01\" ,  \"2003-01-01\") ";

        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(2, list.size());

        assertSimpleHbaseCellResult(list.get(0), "name",
                DateUtil.parse("2001-01-01", DateUtil.DayFormat), "allen");
        assertSimpleHbaseCellResult(list.get(1), "name",
                DateUtil.parse("2002-01-01", DateUtil.DayFormat), "dan");

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) ts range ( \"2000-01-01\" ,  \"2000-01-02\") ";

        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(1, list.size());
        assertSimpleHbaseCellResult(list.get(0), "name",
                DateUtil.parse("2000-01-01", DateUtil.DayFormat), "allen");

        CreateTestTable.main(null);
    }

    @TimeDepend
    @Test
    public void testSelect_Maxversion() {
        CreateTestTable.main(null);

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen2000\", \"30\" ) rowkey is intkey (\"0\") ts is \"2000-01-01\"";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen2001\", \"30\" ) rowkey is intkey (\"0\") ts is \"2001-01-01\"";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ts is \"2002-01-01\"";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) maxversion 1 ";

        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(2, list.get(0).size());
        Assert.assertEquals(2, list.get(1).size());
        assertSimpleHbaseCellResult(list.get(0), "name",
                DateUtil.parse("2001-01-01", DateUtil.DayFormat), "allen2001");
        assertSimpleHbaseCellResult(list.get(1), "name",
                DateUtil.parse("2002-01-01", DateUtil.DayFormat), "dan");

        selectHql = "select ( name,age ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) maxversion 2 ";

        list = simpleHbaseClient.select(selectHql);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(4, list.get(0).size());
        Assert.assertEquals(2, list.get(1).size());
        assertSimpleHbaseCellResult(list.get(0), "name",
                DateUtil.parse("2001-01-01", DateUtil.DayFormat), "allen2001");
        assertSimpleHbaseCellResult(list.get(0), "name",
                DateUtil.parse("2000-01-01", DateUtil.DayFormat), "allen2000");
        assertSimpleHbaseCellResult(list.get(1), "name",
                DateUtil.parse("2002-01-01", DateUtil.DayFormat), "dan");

        CreateTestTable.main(null);
    }

    @Test
    public void testSelect_Columns() {
        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age,fatname ) values ( \"allen\", \"30\" , \"dan\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select ( name,age ,fatname ) from "
                + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) ";
        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(3, list.get(0).size());

        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "age", 30L);
        assertSimpleHbaseCellResult(list.get(0), "fatname", "dan");
    }

    @Test
    public void testSelect_RegxColumns() {
        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age,fatname ) values ( \"allen\", \"30\" , \"dan\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select  .*name  from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) ";
        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(2, list.get(0).size());

        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "fatname", "dan");
    }

    @Test
    public void testSelect_Star() {
        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age,fatname ) values ( \"allen\", \"30\" , \"dan\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(putHql);

        String selectHql = "select  *  from " + Config.TableName
                + " rowkey range ( intkey (\"0\") , intkey (\"3\") ) ";
        List<List<SimpleHbaseCellResult>> list = simpleHbaseClient
                .select(selectHql);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(3, list.get(0).size());

        assertSimpleHbaseCellResult(list.get(0), "name", "allen");
        assertSimpleHbaseCellResult(list.get(0), "age", 30L);
        assertSimpleHbaseCellResult(list.get(0), "fatname", "dan");
    }
}
