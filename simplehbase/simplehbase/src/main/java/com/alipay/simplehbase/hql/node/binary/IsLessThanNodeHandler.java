package com.alipay.simplehbase.hql.node.binary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsLessThanNodeHandler extends BinaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsLessThanNode isLessThanNode = new IsLessThanNode();
        super.handle(isLessThanNode, node);
        return isLessThanNode;
    }
}
