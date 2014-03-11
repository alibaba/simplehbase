package com.alipay.simplehbase.hql.node;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNode;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class DynamicNode extends PrependNode {

    protected DynamicNode() {
        super(HQLNodeType.Dynamic);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context,
            SimpleHbaseRuntimeSetting runtimeSetting) {

        for (HQLNode hqlNode : subNodeList) {
            hqlNode.applyParaMap(para, sb, context, runtimeSetting);
        }

    }

}
