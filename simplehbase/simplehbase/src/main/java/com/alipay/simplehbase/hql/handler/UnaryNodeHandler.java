package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.util.XmlUtil;

abstract public class UnaryNodeHandler extends PrependNodeHandler {

    public void handle(UnaryNode unaryNode, Node node) {
        unaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        super.handle(unaryNode, node);
    }
}
