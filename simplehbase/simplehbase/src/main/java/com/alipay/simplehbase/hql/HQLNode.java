package com.alipay.simplehbase.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.util.Util;
import com.sun.istack.internal.Nullable;

/**
 * 一个hql的节点。
 * 
 * @author xinzhi
 * @version $Id: HQLNode.java 2013-09-11 上午11:27:31 xinzhi $
 * */
abstract public class HQLNode {
    /** BlankSpace。 */
    protected static final String BlankSpace  = " ";

    /** parent hql 节点。 */
    protected HQLNode             parent;
    /** HQLNodeType。 */
    protected HQLNodeType         hqlNodeType;

    /** 子节点列表。 */
    protected List<HQLNode>       subNodeList = new ArrayList<HQLNode>();

    /**
     * 应用参数map后，该节点的HQL字符串。
     * 
     * @param para 参数map。
     * @param sb StringBuilder，结果收集器。
     * @param context 应用参数解析HQL字符串时的上下文。
     * */
    public abstract void applyParaMap(@Nullable Map<String, Object> para,
            StringBuilder sb, Map<Object, Object> context);

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

    public HQLNodeType getHqlNodeType() {
        return hqlNodeType;
    }
}
