package com.alipay.simplehbase.hql.handler;

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
