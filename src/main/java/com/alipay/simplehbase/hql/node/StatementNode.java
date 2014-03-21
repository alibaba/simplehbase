package com.alipay.simplehbase.hql.node;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.util.Util;

/**
 * @author xinzhi
 */
public class StatementNode extends HQLNode {
    protected StatementNode() {
        super(HQLNodeType.Statement);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        Util.checkNull(sb);
        Util.checkNull(context);
        Util.checkNull(runtimeSetting);

        for (HQLNode hqlNode : subNodeList) {
            hqlNode.applyParaMap(para, sb, context, runtimeSetting);
        }

    }

}
