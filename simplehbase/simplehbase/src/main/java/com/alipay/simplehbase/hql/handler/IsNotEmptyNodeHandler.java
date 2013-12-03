package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsNotEmptyNodeHandler extends UnaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsNotEmptyNode isNotEmptyNode = new IsNotEmptyNode();
        super.handle(isNotEmptyNode, node);
        return isNotEmptyNode;
    }

}
