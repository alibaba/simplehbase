package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsNotEqualNode extends BinaryNode {

    protected IsNotEqualNode() {
        super(HQLNodeType.IsNotEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = runtimeSetting.interpret(
                propertyObject.getClass(), getCompareValue());
        return !propertyObject.equals(compareObject);
    }
}
