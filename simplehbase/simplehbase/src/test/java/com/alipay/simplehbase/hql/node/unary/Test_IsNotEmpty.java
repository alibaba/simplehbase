package com.alipay.simplehbase.hql.node.unary;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.node.HQLBase;
/**
 * @author xinzhi
 */
public class Test_IsNotEmpty extends HQLBase {

    @Test
    public void test_String_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());

    }

    @Test
    public void test_String_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        para.put("c", "");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());

    }

    @Test
    public void test_String_2() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        para.put("c", "d");
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen love dandan ", sb.toString());
    }

    @Test
    public void test_List_0() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        para.put("c", null);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());

    }

    @Test
    public void test_List_1() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        List<String> list = new ArrayList<String>();
        para.put("c", list);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen ", sb.toString());

    }

    @Test
    public void test_List_2() {
        HQLNode hqlNode = findStatementHQLNode("test_isNotEmpty");
        List<String> list = new ArrayList<String>();
        list.add("d");
        para.put("c", list);
        hqlNode.applyParaMap(para, sb, context);
        assertEqualHQL("allen  love dandan ", sb.toString());
    }
}
