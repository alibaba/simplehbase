package com.alipay.simplehbase.hql.node.binary;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.hql.node.ConditionNode;

/**
 * @author xinzhi
 */
abstract public class BinaryNode extends ConditionNode {

    private String property;
    private String compareValue;

    protected BinaryNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

}
