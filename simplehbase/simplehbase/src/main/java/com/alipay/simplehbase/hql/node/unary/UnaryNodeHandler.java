package com.alipay.simplehbase.hql.node.unary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.node.PrependNodeHandler;
import com.alipay.simplehbase.util.XmlUtil;

abstract public class UnaryNodeHandler extends PrependNodeHandler {

    public void handle(UnaryNode unaryNode, Node node) {
        unaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        super.handle(unaryNode, node);
    }
}
