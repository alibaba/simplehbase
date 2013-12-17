package com.alipay.simplehbase.hql.node;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;

/**
 * @author xinzhi
 */
public class Test_Dynamic1 extends HQLTestBase {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic1");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic1");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND love", sb.toString());
    }

    @Test
    public void test_2() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic1");
        para.put("d", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen  dandan", sb.toString());
    }

    @Test
    public void test_3() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic1");
        para.put("c", null);
        para.put("d", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND love  dandan", sb.toString());
    }

    @Test
    public void test_4() {
        HQLNode hqlNode = findStatementHQLNode("test_dynamic1");
        para.put("c", "c");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());
    }
}
