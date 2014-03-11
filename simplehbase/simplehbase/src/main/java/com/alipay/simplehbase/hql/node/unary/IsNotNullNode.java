package com.alipay.simplehbase.hql.node.unary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsNotNullNode extends UnaryNode {

    protected IsNotNullNode() {
        super(HQLNodeType.IsNotNull);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            @Nullable SimpleHbaseRuntimeSetting runtimeSetting) {
        return para.containsKey(getProperty())
                && para.get(getProperty()) != null;
    }
}
