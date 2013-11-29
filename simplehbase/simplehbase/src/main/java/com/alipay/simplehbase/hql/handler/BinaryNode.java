package com.alipay.simplehbase.hql.handler;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class BinaryNode extends ConditionNode {

    private String property;
    private String compareValue;

    protected BinaryNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        throw new RuntimeException();
    }
}
