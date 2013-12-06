package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsNotNullNode extends UnaryNode {

    protected IsNotNullNode() {
        super(HQLNodeType.IsNotNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) != null;
    }
}
