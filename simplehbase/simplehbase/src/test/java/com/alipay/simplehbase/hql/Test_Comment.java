package com.alipay.simplehbase.hql;

import org.junit.Test;

public class Test_Comment extends TestHQL {

    @Test
    public void test() {
        HQLNode hqlNode = findStatementHQLNode("test_comment");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("hello world to allen .", sb.toString());
    }
}
