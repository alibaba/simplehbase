package com.alipay.simplehbase.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.core.NotNullable;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.util.Util;

/**
 * One HQL Node.
 * 
 * @author xinzhi
 * */
abstract public class HQLNode {

    /** BlankSpace. */
    protected static final String BlankSpace  = " ";

    /** parent hql node. */
    protected HQLNode             parent;

    /** HQLNodeType. */
    protected HQLNodeType         hqlNodeType;

    /** Children nodes list. */
    protected List<HQLNode>       subNodeList = new ArrayList<HQLNode>();

    /**
     * After apply the parameter map, the hql string value of this HQL node.
     * 
     * @param para parameter map.
     * @param sb result collector.
     * @param context the context.
     * */
    public abstract void applyParaMap(@Nullable Map<String, Object> para,
            @NotNullable StringBuilder sb,
            @NotNullable Map<Object, Object> context,
            @NotNullable SimpleHbaseRuntimeSetting runtimeSetting);

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
