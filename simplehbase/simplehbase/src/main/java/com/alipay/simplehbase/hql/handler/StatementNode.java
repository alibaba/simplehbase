package com.alipay.simplehbase.hql.handler;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;

public class StatementNode extends HQLNode {
    protected StatementNode() {
        super(HQLNodeType.Statement);
    }
}
