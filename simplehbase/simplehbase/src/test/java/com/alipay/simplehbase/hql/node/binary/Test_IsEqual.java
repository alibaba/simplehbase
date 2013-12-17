package com.alipay.simplehbase.hql.node.binary;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLBase;

/**
 * @author xinzhi
 */
public class Test_IsEqual extends HQLBase {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isEqual");
        para.put("ok", "Y");
        para.put("age", 11);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen AND MARRIED", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isEqual");
        para.put("ok", "N");
        para.put("age", 30);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen OR AGE", sb.toString());
    }
}
