package com.alipay.simplehbase.hql.node.text;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;
/**
 * @author xinzhi
 */
abstract public class BaseTextNode extends HQLNode {

    private String textValue;

    protected BaseTextNode(HQLNodeType hqlNodeType) {
        super(hqlNodeType);
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String value) {
        this.textValue = value;
    }
}
