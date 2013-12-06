package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsNullNode extends UnaryNode {

    protected IsNullNode() {
        super(HQLNodeType.IsNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) == null;
    }
}
