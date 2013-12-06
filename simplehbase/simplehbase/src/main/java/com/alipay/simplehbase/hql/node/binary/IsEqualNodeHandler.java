package com.alipay.simplehbase.hql.node.binary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsEqualNode isEqualNode = new IsEqualNode();
        super.handle(isEqualNode, node);
        return isEqualNode;
    }
}
