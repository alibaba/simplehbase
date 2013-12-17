package com.alipay.simplehbase.hql.node.text;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLBase;

/**
 * @author xinzhi
 */
public class Test_CDATA extends HQLBase {

    @Test
    public void test() {
        HQLNode hqlNode = findStatementHQLNode("test_CDATA");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("hello world to allen . <sender>John Smith</sender>",
                sb.toString());
    }
}
