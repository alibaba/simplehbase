package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.literal.LiteralValue;
import com.alipay.simplehbase.util.CompareUtil;

public class IsGreaterThanNode extends BinaryNode {

    protected IsGreaterThanNode() {
        super(HQLNodeType.IsGreaterThan);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = LiteralValue.convertToObject(
                propertyObject.getClass(), getCompareValue());
        return CompareUtil.compare(propertyObject, compareObject) > 0;
    }
}
