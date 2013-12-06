package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsPropertyAvailableNode extends UnaryNode {

    protected IsPropertyAvailableNode() {
        super(HQLNodeType.IsPropertyAvailable);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        return para.containsKey(getProperty());
    }

}