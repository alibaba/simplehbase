package com.alipay.simplehbase.hql.node.text;

import org.junit.Test;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLTestBase;

/**
 * @author xinzhi
 */
public class Test_Text extends HQLTestBase {

    @Test
    public void test() {
        HQLNode hqlNode = findStatementHQLNode("test_text");
        hqlNode.applyParaMap(para, sb, context, new SimpleHbaseRuntimeSetting());
        assertEqualHQL("hello world to allen .", sb.toString());
    }
}
