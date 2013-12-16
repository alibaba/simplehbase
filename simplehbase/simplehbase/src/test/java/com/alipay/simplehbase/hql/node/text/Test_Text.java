package com.alipay.simplehbase.hql.node.text;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.TestHQL;

/**
 * @author xinzhi
 */
public class Test_Text extends TestHQL {

    @Test
    public void test() {
        HQLNode hqlNode = findStatementHQLNode("test_text");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("hello world to allen .", sb.toString());
    }
}
