package com.alipay.simplehbase.hql.handler;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.util.Util;

public class StatementNode extends HQLNode {
    protected StatementNode() {
        super(HQLNodeType.Statement);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context) {
        Util.checkNull(para);
        Util.checkNull(sb);
        Util.checkNull(context);

        for (HQLNode hqlNode : subNodeList) {
            hqlNode.applyParaMap(para, sb, context);
        }

    }

}
