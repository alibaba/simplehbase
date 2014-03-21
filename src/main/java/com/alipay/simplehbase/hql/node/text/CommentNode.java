package com.alipay.simplehbase.hql.node.text;

import java.util.Map;

import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;
import com.alipay.simplehbase.hql.HQLNodeType;

/**
 * @author xinzhi
 */
public class CommentNode extends BaseTextNode {

    protected CommentNode() {
        super(HQLNodeType.Comment);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context,
            SimpleHbaseRuntimeSetting runtimeSetting) {
        // do nothing.
    }
}
