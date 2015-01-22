package com.alipay.simplehbase.client.service.hbaseRawService;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import allen.test.Config;

import com.alipay.simplehbase.client.SimpleHbaseCellResult;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 * */
public class RawServiceTestBase extends MyRecordTestBase {

    protected void assertSimpleHbaseCellResult(
            List<SimpleHbaseCellResult> result, String qualifier, Date ts,
            Object expectedObject) {
        for (SimpleHbaseCellResult cell : result) {
            if (cell.getQualifierStr().equals(qualifier)
                    && cell.getTsDate().equals(ts)) {
                Assert.assertEquals(expectedObject, cell.getValueObject());
                return;
            }
        }

        Assert.fail();
    }

    protected void assertSimpleHbaseCellResult(
            List<SimpleHbaseCellResult> result, String qualifier,
            Object expectedObject) {
        for (SimpleHbaseCellResult cell : result) {
            if (cell.getQualifierStr().equals(qualifier)) {
                Assert.assertEquals(expectedObject, cell.getValueObject());
                return;
            }
        }

        Assert.fail();
    }

    protected String rowkeyRange(int start, int end) {
        return " startkey is intkey ( \"" + start
                + "\" ) ,  endkey is intkey ( \"" + end + "\" )";
    }

    protected String countHql(int start, int end) {
        return countHql("", start, end);
    }

    protected String countHql(String wherec, int start, int end) {
        return " count from " + Config.TableName + " " + wherec
                + rowkeyRange(start, end);
    }

    protected String countsumHql(String cidList, String wherec, int start,
            int end) {
        return " countsum " + cidList + " from " + Config.TableName + " "
                + wherec + rowkeyRange(start, end);
    }

}
