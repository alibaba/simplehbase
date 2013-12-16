package com.alipay.simplehbase.antlr.manual;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.tools.ant.filters.StringInputStream;

import com.alipay.simplehbase.antlr.auto.StatementsLexer;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConditioncContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * TreeUtil.
 * 
 * @author xinzhi.zhang
 * */
public class TreeUtil {

    /**
     * Parse ProgContext from hql string.
     * */
    public static ProgContext parse(String hql) {
        try {
            ANTLRInputStream input = new ANTLRInputStream(
                    new StringInputStream(hql));
            StatementsLexer lexer = new StatementsLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            StatementsParser parser = new StatementsParser(tokens);
            ProgContext progContext = parser.prog();
            return progContext;
        } catch (Exception e) {
            throw new SimpleHBaseException("parse error.", e);
        }
    }

    /**
     * Parse filter from select hql's progContext.
     * */
    public static Filter parseSelectFilter(ProgContext progContext,
            HBaseTableConfig hbaseTableConfig, Map<String, Object> para) {
        ConditioncContext conditioncContext = progContext.selectc().wherec()
                .conditionc();
        SimpleHbaseVisitor hbaseVisitor = new SimpleHbaseVisitor(
                hbaseTableConfig, para);
        return conditioncContext.accept(hbaseVisitor);

    }
}
