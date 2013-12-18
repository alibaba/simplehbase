package com.alipay.simplehbase.util;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * XmlUtil.
 * 
 * @author xinzhi
 * */
public class XmlUtil {

    /**
     * Get attr node value of node or null if attr doesn't exist.
     * */
    public static String getAttr(Node node, String attrName) {

        Util.checkNull(node);
        Util.checkEmptyString(attrName);

        NamedNodeMap columnAttrs = node.getAttributes();
        if (columnAttrs == null) {
            return null;
        }
        Node attrNode = columnAttrs.getNamedItem(attrName);
        if (attrNode == null) {
            return null;
        }
        return attrNode.getNodeValue();
    }

    private XmlUtil() {
    }
}
