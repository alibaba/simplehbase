package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.util.XmlUtil;

abstract public class BinaryNodeHandler extends PrependNodeHandler {

    public void handle(BinaryNode binaryNode, Node node) {
        binaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        binaryNode.setCompareValue(XmlUtil.getAttr(node, "compareValue"));
        super.handle(binaryNode, node);
    }
}
