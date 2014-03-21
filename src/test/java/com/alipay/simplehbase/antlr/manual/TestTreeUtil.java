package com.alipay.simplehbase.antlr.manual;

import org.junit.Test;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * @author xinzhi
 */
public class TestTreeUtil {

    @Test(expected = SimpleHBaseException.class)
    public void errorLexer_0() {
        String hql = "@";
        TreeUtil.parseProgContext(hql);
    }

    @Test(expected = SimpleHBaseException.class)
    public void errorLexer_1() {
        String hql = "";
        TreeUtil.parseProgContext(hql);
    }

    @Test(expected = SimpleHBaseException.class)
    public void errorParser_0() {
        String hql = "select where age equals \"allen\"";
        TreeUtil.parseProgContext(hql);
    }

    @Test(expected = SimpleHBaseException.class)
    public void errorParser_1() {
        String hql = "";
        TreeUtil.parseProgContext(hql);
    }
}
