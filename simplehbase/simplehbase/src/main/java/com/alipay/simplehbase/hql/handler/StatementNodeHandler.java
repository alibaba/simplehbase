package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeHandler;

public class StatementNodeHandler implements HQLNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        StatementNode statementNode = new StatementNode();
        return statementNode;
    }
}
