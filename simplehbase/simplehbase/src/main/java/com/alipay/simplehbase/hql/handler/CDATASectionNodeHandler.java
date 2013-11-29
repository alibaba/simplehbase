package com.alipay.simplehbase.hql.handler;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class CDATASectionNodeHandler extends BaseTextNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        CDATASectionNode cdataSectionNode = new CDATASectionNode();
        super.handle(cdataSectionNode, node);
        return cdataSectionNode;
    }

}
