package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsNullNodeHandler extends UnaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsNullNode isNullNode = new IsNullNode();
        super.handle(isNullNode, node);
        return isNullNode;
    }

}
