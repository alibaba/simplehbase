package com.alipay.simplehbase.hql.node.binary;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLBase;

/**
 * @author xinzhi
 */
public class Test_IsNotEqual extends HQLBase {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEqual");
        para.put("ok", "Y");
        para.put("age", 11);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen OR AGE", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEqual");
        para.put("ok", "N");
        para.put("age", 30);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND MARRIED", sb.toString());
    }
}
