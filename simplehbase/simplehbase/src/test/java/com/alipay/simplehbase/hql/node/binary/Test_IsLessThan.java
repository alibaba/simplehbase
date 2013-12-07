package com.alipay.simplehbase.hql.node.binary;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.TestHQL;
import com.alipay.simplehbase.util.DateUtil;

public class Test_IsLessThan extends TestHQL {
    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isLessThan");
        para.put("name", "alice");
        para.put("age", 11);
        para.put("date", DateUtil.parse("2013-09-01", DateUtil.DayFormat));
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND MARRIED OR AGE OR tree", sb.toString());

    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isLessThan");
        para.put("name", "bob");
        para.put("age", 30);
        para.put("date", DateUtil.parse("2013-10-01", DateUtil.DayFormat));
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen", sb.toString());
    }

    @Test
    public void test_2() {
        HQLNode hqlNode = findStatementHQLNode("test_isLessThan");
        para.put("name", "cat");
        para.put("age", 40);
        para.put("date", DateUtil.parse("2013-11-01", DateUtil.DayFormat));
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen", sb.toString());
    }

}
