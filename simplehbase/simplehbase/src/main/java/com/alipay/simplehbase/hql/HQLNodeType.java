package com.alipay.simplehbase.hql;

import org.w3c.dom.Node;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * HQL的node type。
 * 
 * @author xinzhi
 * @version $Id: HQLNodeType.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public enum HQLNodeType {
    //Text
    CDATASection("#cdata-section"),

    Text("#text"),

    Comment("#comment"),

    //顶级statement。
    Statement("statement"),

    //动态节点。
    Dynamic("dynamic"),

    //二元条件节点。
    IsEqual("isEqual"),

    IsNotEqual("isNotEqual"),

    //一元条件节点。
    IsNull("isNull"),

    IsNotNull("isNotNull"),

    IsEmpty("isEmpty"),

    IsNotEmpty("isNotEmpty"),

    IsPropertyAvailable("isPropertyAvailable"),

    IsNotPropertyAvailable("isNotPropertyAvailable"),

    ;

    /**
     * xml中node的name。
     * */
    private String xmlNodeName;

    private HQLNodeType(String xmlNodeName) {
        this.xmlNodeName = xmlNodeName;
    }

    public static HQLNodeType findHQLNodeType(Node node) {

        for (HQLNodeType hqlNodeType : HQLNodeType.values()) {
            if (node.getNodeName().equals(hqlNodeType.xmlNodeName)) {
                return hqlNodeType;
            }
        }

        throw new SimpleHBaseException("parse err. node = " + node);
    }

}
