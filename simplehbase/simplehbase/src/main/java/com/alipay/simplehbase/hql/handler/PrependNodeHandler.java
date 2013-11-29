package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNodeHandler;
import com.alipay.simplehbase.util.XmlUtil;

abstract public class PrependNodeHandler implements HQLNodeHandler {

    public void handle(PrependNode prependNode, Node node) {
        prependNode.setPrependValue(XmlUtil.getAttr(node, "prepend"));
    }
}
