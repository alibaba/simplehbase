package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsNullNode extends UnaryNode {

    protected IsNullNode() {
        super(HQLNodeType.IsNull);
    }

}
