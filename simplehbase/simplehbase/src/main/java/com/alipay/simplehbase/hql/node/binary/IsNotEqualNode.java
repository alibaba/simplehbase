package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.literal.LiteralValueInterpreter;

public class IsNotEqualNode extends BinaryNode {

    protected IsNotEqualNode() {
        super(HQLNodeType.IsNotEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = LiteralValueInterpreter.convertToObject(
                propertyObject.getClass(), getCompareValue());
        return !propertyObject.equals(compareObject);
    }
}
