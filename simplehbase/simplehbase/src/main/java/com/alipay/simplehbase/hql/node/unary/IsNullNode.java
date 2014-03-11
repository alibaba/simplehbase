package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsNullNode extends UnaryNode {

    protected IsNullNode() {
        super(HQLNodeType.IsNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) == null;
    }
}
