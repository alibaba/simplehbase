package com.alipay.simplehbase.hql.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;

import junit.framework.Assert;

import com.alipay.simplehbase.config.HBaseTableConfigParser;
import com.alipay.simplehbase.config.Config;
import com.alipay.simplehbase.hql.HBaseQuery;
import com.alipay.simplehbase.hql.HQLNode;

/**
 * @author xinzhi
 */
public class HQLTestBase {

    /** log. */
    private static Logger         log     = Logger.getLogger(HQLTestBase.class);

    protected StringBuilder       sb      = new StringBuilder();
    protected Map<String, Object> para    = new HashMap<String, Object>();
    protected Map<Object, Object> context = new HashMap<Object, Object>();

    @Before
    public void before() {
        sb = new StringBuilder();
        para = new HashMap<String, Object>();
        context = new HashMap<Object, Object>();
    }

    protected HQLNode findStatementHQLNode(String id) {
        List<HBaseQuery> hbaseQueries = HBaseTableConfigParser
                .parseHBaseQuery(Config.TestHqlNodeXmlFile);
        for (HBaseQuery query : hbaseQueries) {
            if (query.getId().equals(id)) {
                return query.getHqlNode();
            }
        }
        return null;
    }

    protected void assertEqualHQL(String s1, String s2) {
        String[] s1Array = s1.split("[ \n\r\t]");
        List<String> s1List = new ArrayList<String>();
        for (String s : s1Array) {
            if (!s.isEmpty()) {
                s1List.add(s);
            }
        }

        String[] s2Array = s2.split("[ \n\r\t]");
        List<String> s2List = new ArrayList<String>();
        for (String s : s2Array) {
            if (!s.isEmpty()) {
                s2List.add(s);
            }
        }

        log.info("s1 List=" + s1List);
        log.info("s2 List=" + s2List);

        Assert.assertTrue(s1List.size() == s2List.size());
        for (int i = 0; i < s1List.size(); i++) {
            Assert.assertEquals(s1List.get(i), s2List.get(i));
        }
    }

}
