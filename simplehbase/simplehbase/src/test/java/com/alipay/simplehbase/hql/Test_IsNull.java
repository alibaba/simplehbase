package com.alipay.simplehbase.hql;

import org.junit.Test;

public class Test_IsNull extends TestHQL {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isNull");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isNull");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND love", sb.toString());
    }

    @Test
    public void test_2() {
        HQLNode hqlNode = findStatementHQLNode("test_isNull");
        para.put("c", null);
        para.put("d", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND love  dandan", sb.toString());
    }

    @Test
    public void test_3() {
        HQLNode hqlNode = findStatementHQLNode("test_isNull");
        para.put("c", "c");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());
    }
}
