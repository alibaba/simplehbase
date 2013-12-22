package com.alipay.simplehbase.hql;

import org.w3c.dom.Node;

/**
 * HQLNodeHandler.
 * 
 * 
 * @author xinzhi
 * */
public interface HQLNodeHandler {

    /**
     * Convert DOM's node to HQLNode.
     * */
    public HQLNode handle(Node node);
}
