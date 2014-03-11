package com.alipay.simplehbase.hql.node.unary;

import org.junit.Test;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLTestBase;
/**
 * @author xinzhi
 */
public class Test_IsNotPropertyAvailable extends HQLTestBase {

    @Test
    public void test_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotPropertyAvailable");
        hqlNode.applyParaMap(para, sb, context, new SimpleHbaseRuntimeSetting());
        assertEqualHQL("allen  love dandan", sb.toString());
    }

    @Test
    public void test_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotPropertyAvailable");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context, new SimpleHbaseRuntimeSetting());
        assertEqualHQL("allen", sb.toString());
    }

}
