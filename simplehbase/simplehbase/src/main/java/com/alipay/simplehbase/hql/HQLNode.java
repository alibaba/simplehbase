package com.alipay.simplehbase.hql;

import java.util.ArrayList;
import java.util.List;

import com.alipay.simplehbase.util.Util;

/**
 * 一个hql的节点。
 * 
 * @author xinzhi
 * @version $Id: HQLNode.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class HQLNode {

    protected HQLNode       parent;
    protected HQLNodeType   hqlNodeType;
    protected List<HQLNode> subNodeList = new ArrayList<HQLNode>();

    protected HQLNode(HQLNodeType hqlNodeType) {
        Util.checkNull(hqlNodeType);
        this.hqlNodeType = hqlNodeType;
    }

    public void addSubHQLNode(HQLNode hqlNode) {
        subNodeList.add(hqlNode);
    }

    public HQLNode getParent() {
        return parent;
    }

    public void setParent(HQLNode parent) {
        this.parent = parent;
    }
}
