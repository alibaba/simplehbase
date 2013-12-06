package com.alipay.simplehbase.hql.node;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;

public class DynamicNode extends PrependNode {

    protected DynamicNode() {
        super(HQLNodeType.Dynamic);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context) {

        for (HQLNode hqlNode : subNodeList) {
            hqlNode.applyParaMap(para, sb, context);
        }

    }

}
