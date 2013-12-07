package com.alipay.simplehbase.hql.node.binary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class IsGreaterEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsGreaterEqualNode isGreaterEqualNode = new IsGreaterEqualNode();
        super.handle(isGreaterEqualNode, node);
        return isGreaterEqualNode;
    }
}
