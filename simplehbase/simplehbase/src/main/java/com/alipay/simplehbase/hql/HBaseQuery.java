package com.alipay.simplehbase.hql;

import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;

/**
 * HBaseQuery¡£
 * 
 * @author xinzhi
 * @version $Id: HBaseQuery.java 2013-09-11 ÉÏÎç11:27:31 xinzhi $
 * */
public class HBaseQuery {

    private String  id;
    private HQLNode hqlNode;

    public HBaseQuery(String id, HQLNode hqlNode) {
        StringUtil.checkEmptyString(id);
        Util.checkNull(hqlNode);

        this.id = id;
        this.hqlNode = hqlNode;
    }

    public String getId() {
        return id;
    }

    public HQLNode getHqlNode() {
        return hqlNode;
    }

}
