package com.alipay.simplehbase.hql;

import org.junit.Test;

public class Test_Text extends TestHQL {

    @Test
    public void test() {
        HQLNode hqlNode = findStatementHQLNode("test_text");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("hello world to allen .", sb.toString());
    }
}
