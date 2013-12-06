package com.alipay.simplehbase.hql.node.text;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNodeHandler;

abstract public class BaseTextNodeHandler implements HQLNodeHandler {

    public void handle(BaseTextNode baseTextNode, Node node) {
        baseTextNode.setTextValue(node.getNodeValue());
    }
}
