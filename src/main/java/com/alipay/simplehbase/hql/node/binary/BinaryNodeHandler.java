package com.alipay.simplehbase.hql.node.binary;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.node.PrependNodeHandler;
import com.alipay.simplehbase.util.XmlUtil;
/**
 * @author xinzhi
 */
abstract public class BinaryNodeHandler extends PrependNodeHandler {

    public void handle(BinaryNode binaryNode, Node node) {
        binaryNode.setProperty(XmlUtil.getAttr(node, "property"));
        binaryNode.setCompareValue(XmlUtil.getAttr(node, "compareValue"));
        super.handle(binaryNode, node);
    }
}
