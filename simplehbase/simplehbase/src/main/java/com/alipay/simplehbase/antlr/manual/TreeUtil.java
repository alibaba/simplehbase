package com.alipay.simplehbase.antlr.manual;

import java.io.StringReader;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.hadoop.hbase.filter.Filter;

import com.alipay.simplehbase.antlr.auto.StatementsLexer;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConditioncContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CountclContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectclContext;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

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
        Util.checkEmptyString(hql);

        try {
            ANTLRInputStream input = new ANTLRInputStream(new StringReader(hql));
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
            HBaseTableConfig hbaseTableConfig,
            @Nullable Map<String, Object> para) {
        Util.checkNull(progContext);
        Util.checkNull(hbaseTableConfig);

        SelectclContext SelectclContext = ((SelectclContext) progContext);
        ConditioncContext conditioncContext = SelectclContext.selectc()
                .wherec().conditionc();
        SimpleHbaseVisitor hbaseVisitor = new SimpleHbaseVisitor(
                hbaseTableConfig, para);
        return conditioncContext.accept(hbaseVisitor);
    }

    /**
     * Parse filter from count hql's progContext.
     * */
    public static Filter parseCountFilter(ProgContext progContext,
            HBaseTableConfig hbaseTableConfig,
            @Nullable Map<String, Object> para) {
        Util.checkNull(progContext);
        Util.checkNull(hbaseTableConfig);

        CountclContext countclContext = ((CountclContext) progContext);
        ConditioncContext conditioncContext = countclContext.countc().wherec()
                .conditionc();
        SimpleHbaseVisitor hbaseVisitor = new SimpleHbaseVisitor(
                hbaseTableConfig, para);
        return conditioncContext.accept(hbaseVisitor);
    }

}
