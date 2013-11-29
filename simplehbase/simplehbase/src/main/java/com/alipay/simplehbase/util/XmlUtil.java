package com.alipay.simplehbase.util;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * XmlUtil。
 * 
 * @author xinzhi
 * @version $Id: XmlUtil.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class XmlUtil {

    /**
     * 查找node的属性为attrName的value。
     * */
    public static String getAttr(Node node, String attrName) {

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
