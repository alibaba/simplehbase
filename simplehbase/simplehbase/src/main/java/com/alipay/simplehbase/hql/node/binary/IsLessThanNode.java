package com.alipay.simplehbase.hql.node.binary;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.literal.LiteralValueInterpreter;
import com.alipay.simplehbase.util.CompareUtil;
/**
 * @author xinzhi
 */
public class IsLessThanNode extends BinaryNode {

    protected IsLessThanNode() {
        super(HQLNodeType.IsLessThan);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = LiteralValueInterpreter.convertToObject(
                propertyObject.getClass(), getCompareValue());
        return CompareUtil.compare(propertyObject, compareObject) < 0;
    }
}
