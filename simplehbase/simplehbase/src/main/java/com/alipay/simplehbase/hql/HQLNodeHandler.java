package com.alipay.simplehbase.hql;

import org.w3c.dom.Node;

/**
 * HQLNodeHandler负责解析Node为HQLNode。
 * 
 * 
 * @author xinzhi
 * @version $Id: HQLNodeHandler.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public interface HQLNodeHandler {

    /**
     * 解析Node为HQLNode。
     * */
    public HQLNode handle(Node node);
}
