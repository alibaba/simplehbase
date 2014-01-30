package com.alipay.simplehbase.hql.node.text;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;
/**
 * @author xinzhi
 */
public class CDATASectionNodeHandler extends BaseTextNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        CDATASectionNode cdataSectionNode = new CDATASectionNode();
        super.handle(cdataSectionNode, node);
        return cdataSectionNode;
    }

}
