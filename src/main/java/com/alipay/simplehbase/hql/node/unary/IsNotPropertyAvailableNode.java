package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsNotPropertyAvailableNode extends UnaryNode {

    protected IsNotPropertyAvailableNode() {
        super(HQLNodeType.IsNotPropertyAvailable);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        return !para.containsKey(getProperty());
    }

}