package com.alipay.simplehbase.client.service.hbaseRawService;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import allen.studyhbase.TimeDepend;
import allen.test.Config;
import allen.test.CreateTestTable;

import com.alipay.simplehbase.client.SimpleHbaseCellResult;

/**
 * @author xinzhi
 * */
public class TestDelete extends RawServiceTestBase {

    private void fillData() {
        String hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ";
        simpleHbaseClient.put(hql);

        hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"1\") ";
        simpleHbaseClient.put(hql);

        hql = "insert into "
                + Config.TableName
                + " ( name,age ) values ( \"linzhi\", \"10\" ) rowkey is intkey (\"2\") ";
        simpleHbaseClient.put(hql);
    }

    @Test
    public void testDelete_Star() {
        fillData();

        List<List<SimpleHbaseCellResult>> cellListList = simpleHbaseClient
                .select("select * from "
                        + Config.TableName
                        + " startkey is intkey (\"0\") , endkey is intkey (\"3\")  ");

        Assert.assertEquals(3, cellListList.size());
        Assert.assertEquals(2, cellListList.get(0).size());

        simpleHbaseClient.delete("delete * from " + Config.TableName
                + " startkey is intkey (\"0\") ,  endkey is intkey (\"0\")  ");
        cellListList = simpleHbaseClient.select("select * from "
                + Config.TableName
                + " startkey is intkey (\"0\") , endkey is  intkey (\"3\")  ");
        Assert.assertEquals(2, cellListList.size());
        Assert.assertEquals(2, cellListList.get(0).size());
    }

    @Test
    public void testDelete_Filter() {

        fillData();

        simpleHbaseClient
                .delete("delete * from "
                        + Config.TableName
                        + " where name equal \"allen\" startkey is  intkey (\"0\") , endkey is intkey (\"3\")  ");

        List<List<SimpleHbaseCellResult>> cellListList = simpleHbaseClient
                .select("select * from "
                        + Config.TableName
                        + " startkey is  intkey (\"0\") , endkey is intkey (\"3\")  ");

        Assert.assertEquals(2, cellListList.size());

        assertSimpleHbaseCellResult(cellListList.get(0), "name", "dan");
        assertSimpleHbaseCellResult(cellListList.get(1), "name", "linzhi");
    }

    @TimeDepend
    @Test
    public void testDelete_Ts() {

        CreateTestTable.main(null);

        String putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"allen\", \"30\" ) rowkey is intkey (\"0\") ts is \"2000-01-01\"";
        simpleHbaseClient.put(putHql);

        putHql = "insert into "
                + Config.TableName
                + " ( MyRecordFamily:name,age ) values ( \"dan\", \"20\" ) rowkey is intkey (\"0\") ts is \"2001-01-01\"";
        simpleHbaseClient.put(putHql);

        String selectHql = "select * from " + Config.TableName
                + " startkey is  intkey (\"0\") , endkey is intkey (\"3\")  ";

        List<List<SimpleHbaseCellResult>> cellListList = simpleHbaseClient
                .select(selectHql);

        Assert.assertEquals(1, cellListList.size());
        Assert.assertEquals(2, cellListList.get(0).size());
        assertSimpleHbaseCellResult(cellListList.get(0), "name", "dan");
        assertSimpleHbaseCellResult(cellListList.get(0), "age", 20L);

        simpleHbaseClient
                .delete("delete * from "
                        + Config.TableName
                        + " startkey is intkey (\"0\") , endkey is intkey (\"0\")  ts is \"2001-01-01\" ");

        cellListList = simpleHbaseClient.select(selectHql);

        Assert.assertEquals(1, cellListList.size());
        Assert.assertEquals(2, cellListList.get(0).size());
        assertSimpleHbaseCellResult(cellListList.get(0), "name", "allen");
        assertSimpleHbaseCellResult(cellListList.get(0), "age", 30L);

        CreateTestTable.main(null);
    }
}
