package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNodeType;

public class DynamicNode extends PrependNode {

    protected DynamicNode() {
        super(HQLNodeType.Dynamic);
    }

}
