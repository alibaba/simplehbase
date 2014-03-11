package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsPropertyAvailableNode extends UnaryNode {

    protected IsPropertyAvailableNode() {
        super(HQLNodeType.IsPropertyAvailable);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty());
    }

}