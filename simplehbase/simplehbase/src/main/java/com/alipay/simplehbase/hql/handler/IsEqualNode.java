package com.alipay.simplehbase.hql.handler;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsEqualNode extends BinaryNode {

    protected IsEqualNode() {
        super(HQLNodeType.IsEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        throw new RuntimeException();
    }
}
