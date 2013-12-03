package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsNotNullNodeHandler extends UnaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsNotNullNode isNotNullNode = new IsNotNullNode();
        super.handle(isNotNullNode, node);
        return isNotNullNode;
    }

}
