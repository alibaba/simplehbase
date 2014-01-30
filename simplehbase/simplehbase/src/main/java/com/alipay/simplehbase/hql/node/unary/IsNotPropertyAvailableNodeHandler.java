package com.alipay.simplehbase.hql.node.unary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;
/**
 * @author xinzhi
 */
public class IsNotPropertyAvailableNodeHandler extends UnaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsNotPropertyAvailableNode isNotPropertyAvailableNode = new IsNotPropertyAvailableNode();
        super.handle(isNotPropertyAvailableNode, node);
        return isNotPropertyAvailableNode;
    }
}
