package com.alipay.simplehbase.hql;

import java.util.List;

import org.junit.Test;

import com.alipay.simplehbase.config.HBaseTableConfigParser;

public class TestHQL {
    @Test
    public void test() {
        List<HBaseQuery> hbaseQueries = HBaseTableConfigParser
                .parseHBaseQuery("test\\hql\\1.xml");

    }
}
