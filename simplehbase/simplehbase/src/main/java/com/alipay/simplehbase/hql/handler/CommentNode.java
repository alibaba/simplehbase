package com.alipay.simplehbase.hql.handler;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;

public class CommentNode extends BaseTextNode {

    protected CommentNode() {
        super(HQLNodeType.Comment);
    }

    @Override
    public void applyParaMap(Map<String, Object> para, StringBuilder sb,
            Map<Object, Object> context) {
        // do nothing.
    }
}
