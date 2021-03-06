package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.util.CompareUtil;

/**
 * @author xinzhi
 */
public class IsGreaterThanNode extends BinaryNode {

    protected IsGreaterThanNode() {
        super(HQLNodeType.IsGreaterThan);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = runtimeSetting.interpret(
                propertyObject.getClass(), getCompareValue());
        return CompareUtil.compare(propertyObject, compareObject) > 0;
    }
}
