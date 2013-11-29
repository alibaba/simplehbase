package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNodeType;

public class IsEqualNode extends BinaryNode {

    protected IsEqualNode() {
        super(HQLNodeType.IsEqual);
    }

}
