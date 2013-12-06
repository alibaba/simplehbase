package com.alipay.simplehbase.hql.node.text;

import org.w3c.dom.Node;

import com.alipay.simplehbase.hql.HQLNode;

public class CommentNodeHandler extends BaseTextNodeHandler {

    @Override
    public HQLNode handle(Node node) {
        CommentNode commentNode = new CommentNode();
        super.handle(commentNode, node);
        return commentNode;
    }

}
