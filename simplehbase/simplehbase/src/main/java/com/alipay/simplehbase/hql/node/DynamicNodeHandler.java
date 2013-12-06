package com.alipay.simplehbase.hql.node;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class DynamicNodeHandler extends PrependNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        DynamicNode dynamicNode = new DynamicNode();
        super.handle(dynamicNode, node);
        return dynamicNode;
    }
}