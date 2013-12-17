package com.alipay.simplehbase.hql.node.unary;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLTestBase;
/**
 * @author xinzhi
 */
public class Test_IsPropertyAvailable extends HQLTestBase {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isPropertyAvailable");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isPropertyAvailable");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen  love dandan", sb.toString());
    }

}
