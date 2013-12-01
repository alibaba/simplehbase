package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsNotEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsNotEqualNode isNotEqualNode = new IsNotEqualNode();
        super.handle(isNotEqualNode, node);
        return isNotEqualNode;
    }
}
