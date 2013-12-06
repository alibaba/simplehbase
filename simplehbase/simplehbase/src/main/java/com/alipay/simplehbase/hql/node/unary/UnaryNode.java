package com.alipay.simplehbase.hql.node.unary;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.hql.node.ConditionNode;

abstract public class UnaryNode extends ConditionNode {

    private String property;

    protected UnaryNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
