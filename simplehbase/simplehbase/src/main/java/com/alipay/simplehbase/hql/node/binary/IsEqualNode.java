package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class IsEqualNode extends BinaryNode {

    protected IsEqualNode() {
        super(HQLNodeType.IsEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para,
            @Nullable SimpleHbaseRuntimeSetting runtimeSetting) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = runtimeSetting.interpret(
                propertyObject.getClass(), getCompareValue());
        return propertyObject.equals(compareObject);
    }
}
