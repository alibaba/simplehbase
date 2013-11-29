package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNodeType;

public class UnaryNode extends PrependNode {

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
