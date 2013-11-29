package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;

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
