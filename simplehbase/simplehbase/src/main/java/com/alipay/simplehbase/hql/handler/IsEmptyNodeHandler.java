package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsEmptyNodeHandler extends UnaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsEmptyNode isEmptyNode = new IsEmptyNode();
        super.handle(isEmptyNode, node);
        return isEmptyNode;
    }

}
