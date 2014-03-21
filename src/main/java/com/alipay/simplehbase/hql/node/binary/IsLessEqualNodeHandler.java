package com.alipay.simplehbase.hql.node.binary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;
/**
 * @author xinzhi
 */
public class IsLessEqualNodeHandler extends BinaryNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        IsLessEqualNode isLessEqualNode = new IsLessEqualNode();
        super.handle(isLessEqualNode, node);
        return isLessEqualNode;
    }
}
