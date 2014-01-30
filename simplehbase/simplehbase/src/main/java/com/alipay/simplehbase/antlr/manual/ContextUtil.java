package com.alipay.simplehbase.antlr.manual;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.hadoop.hbase.filter.Filter;

import com.alipay.simplehbase.antlr.auto.StatementsParser.CidContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CidListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConditioncContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2Context;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CountclContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InsertHqlClContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InserthqlcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.LimitexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.MaxversionexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectCidListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectHqlClContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelecthqlcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.TsrangeContext;

import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.RowkeyexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectclContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.TsexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.VarContext;
import com.alipay.simplehbase.antlr.manual.visitor.Constant2Visitor;
import com.alipay.simplehbase.antlr.manual.visitor.FilterVisitor;
import com.alipay.simplehbase.antlr.manual.visitor.RowKeyVisitor;
import com.alipay.simplehbase.antlr.manual.visitor.SelectCidListVisitor;
import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.config.SimpleHbaseConstants;
import com.alipay.simplehbase.core.NotNullable;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.literal.LiteralValueInterpreter;
import com.alipay.simplehbase.util.Util;

/**
 * ContextUtil.
 * 
 * @author xinzhi.zhang
 * */
public class ContextUtil {

    /**
     * Parse HBaseColumnSchema from cidContext.
     * */
    @NotNullable
    public static HBaseColumnSchema parseHBaseColumnSchema(
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @NotNullable CidContext cidContext) {
        Util.checkNull(hbaseTableConfig);
        Util.checkNull(cidContext);

        String cid = cidContext.TEXT().getText();

        String[] parts = cid.toString().split(
                SimpleHbaseConstants.Family_Qualifier_Separator);
        if (parts.length == 1) {
            return hbaseTableConfig.getHbaseTableSchema().findColumnSchema(
                    parts[0]);
        }

        if (parts.length == 2) {
            return hbaseTableConfig.getHbaseTableSchema().findColumnSchema(
                    parts[0], parts[1]);
        }

        throw new SimpleHBaseException("parseHBaseColumnSchema error. cid="
                + cid);
    }

    /**
     * Parse HBaseColumnSchema list from CidListContext.
     * */
    @NotNullable
    public static List<HBaseColumnSchema> parseHBaseColumnSchemaList(
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @NotNullable CidListContext cidListContext) {
        Util.checkNull(hbaseTableConfig);
        Util.checkNull(cidListContext);

        List<HBaseColumnSchema> result = new ArrayList<HBaseColumnSchema>();

        for (CidContext cidContext : cidListContext.cid()) {
            result.add(parseHBaseColumnSchema(hbaseTableConfig, cidContext));
        }

        return result;

    }

    /**
     * Parse HBaseColumnSchema list from SelectCidListContext.
     * */
    @NotNullable
    public static List<HBaseColumnSchema> parseHBaseColumnSchemaList(
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @NotNullable SelectCidListContext selectCidListContext) {
        Util.checkNull(hbaseTableConfig);
        Util.checkNull(selectCidListContext);

        SelectCidListVisitor visitor = new SelectCidListVisitor(
                hbaseTableConfig);
        return selectCidListContext.accept(visitor);
    }

    /**
     * Parse parameter from varContext.
     * */
    @NotNullable
    public static Object parsePara(@NotNullable VarContext varContext,
            @NotNullable Map<String, Object> para) {
        Util.checkNull(varContext);
        Util.checkNull(para);

        String var = varContext.TEXT().getText();
        Util.checkEmptyString(var);

        Object obj = para.get(var);
        Util.checkNull(obj);

        return obj;
    }

    /**
     * Parse parameter list from varContext list.
     * */
    @NotNullable
    public static List<Object> parseParaList(
            @NotNullable List<VarContext> varContextList,
            @NotNullable Map<String, Object> para) {
        Util.checkNull(varContextList);
        Util.checkNull(para);

        List<Object> result = new ArrayList<Object>();
        for (VarContext varContext : varContextList) {
            result.add(parsePara(varContext, para));
        }
        return result;
    }

    /**
     * Parse constant from constant2Context.
     * */
    @Nullable
    public static Object parseConstant(
            @NotNullable HBaseColumnSchema hbaseColumnSchema,
            @NotNullable Constant2Context constant2Context) {
        Util.checkNull(hbaseColumnSchema);
        Util.checkNull(constant2Context);

        Constant2Visitor visitor = new Constant2Visitor(hbaseColumnSchema);
        return constant2Context.accept(visitor);
    }

    /**
     * Parse constant from constantContext.
     * */
    @NotNullable
    public static Object parseConstant(
            @NotNullable HBaseColumnSchema hbaseColumnSchema,
            @NotNullable ConstantContext constantContext) {
        Util.checkNull(hbaseColumnSchema);
        Util.checkNull(constantContext);

        String constant = constantContext.TEXT().getText();
        Util.checkEmptyString(constant);

        Object obj = LiteralValueInterpreter.convertToObject(
                hbaseColumnSchema.getType(), constant);
        Util.checkNull(obj);
        return obj;
    }

    /**
     * Parse constant list from constantContext list.
     * */
    @NotNullable
    public static List<Object> parseConstantList(
            @NotNullable HBaseColumnSchema hbaseColumnSchema,
            @NotNullable List<ConstantContext> constantContextList) {
        Util.checkNull(hbaseColumnSchema);
        Util.checkNull(constantContextList);

        List<Object> result = new ArrayList<Object>();
        for (ConstantContext constantContext : constantContextList) {
            result.add(parseConstant(hbaseColumnSchema, constantContext));
        }
        return result;
    }

    /**
     * Parse Rowkey from RowkeyexpContext.
     */
    @NotNullable
    public static RowKey parseRowKey(
            @NotNullable RowkeyexpContext rowkeyexpContext) {
        Util.checkNull(rowkeyexpContext);

        RowKeyVisitor visitor = new RowKeyVisitor();
        RowKey rowkey = rowkeyexpContext.accept(visitor);
        Util.checkNull(rowkey);

        return rowkey;
    }

    /**
     * Parse Date from TsexpContext.
     */
    @NotNullable
    public static Date parseTsDate(@NotNullable TsexpContext tsexpContext) {
        Util.checkNull(tsexpContext);

        String constant = tsexpContext.constant().TEXT().getText();
        Date date = (Date) LiteralValueInterpreter.convertToObject(Date.class,
                constant);

        Util.checkNull(date);
        return date;
    }

    /**
     * Parse filter from select hql's progContext.
     * */
    @Nullable
    public static Filter parseSelectFilter(
            @NotNullable ProgContext progContext,
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @Nullable Map<String, Object> para) {
        Util.checkNull(progContext);
        Util.checkNull(hbaseTableConfig);

        SelectclContext SelectclContext = ((SelectclContext) progContext);
        ConditioncContext conditioncContext = SelectclContext.selectc()
                .wherec().conditionc();

        return parseFilter(conditioncContext, hbaseTableConfig, para);
    }

    /**
     * Parse filter from count hql's progContext.
     * */
    @Nullable
    public static Filter parseCountFilter(@NotNullable ProgContext progContext,
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @Nullable Map<String, Object> para) {
        Util.checkNull(progContext);
        Util.checkNull(hbaseTableConfig);

        CountclContext countclContext = ((CountclContext) progContext);
        ConditioncContext conditioncContext = countclContext.countc().wherec()
                .conditionc();

        return parseFilter(conditioncContext, hbaseTableConfig, para);
    }

    /**
     * Parse filter from SelectHqlClContext.
     * */
    @Nullable
    public static Filter parseSelectHqlFilter(
            @NotNullable ProgContext progContext,
            @NotNullable HBaseTableConfig hbaseTableConfig) {
        Util.checkNull(progContext);
        Util.checkNull(hbaseTableConfig);

        SelectHqlClContext selectHqlClContext = ((SelectHqlClContext) progContext);

        if (selectHqlClContext.selecthqlc().wherec() == null) {
            return null;
        } else {
            return parseFilter(selectHqlClContext.selecthqlc().wherec()
                    .conditionc(), hbaseTableConfig, null);
        }
    }

    /**
     * Parse filter from ConditioncContext.
     * */
    @Nullable
    private static Filter parseFilter(
            @Nullable ConditioncContext conditioncContext,
            @NotNullable HBaseTableConfig hbaseTableConfig,
            @Nullable Map<String, Object> para) {

        Util.checkNull(hbaseTableConfig);

        if (conditioncContext == null) {
            return null;
        }

        FilterVisitor visitor = new FilterVisitor(hbaseTableConfig, para);
        return conditioncContext.accept(visitor);
    }

    /**
     * Parse InserthqlcContext from insert hql.
     * */
    @NotNullable
    public static InserthqlcContext parseInserthqlcContext(
            @NotNullable ProgContext progContext) {
        Util.checkNull(progContext);

        InsertHqlClContext insertHqlClContext = (InsertHqlClContext) progContext;
        InserthqlcContext result = insertHqlClContext.inserthqlc();

        Util.checkNull(result);
        return result;
    }

    /**
     * Parse InserthqlcContext from insert hql.
     * */
    @NotNullable
    public static SelecthqlcContext parseSelecthqlcContext(
            @NotNullable ProgContext progContext) {
        Util.checkNull(progContext);

        SelectHqlClContext selectHqlClContext = (SelectHqlClContext) progContext;
        SelecthqlcContext result = selectHqlClContext.selecthqlc();

        Util.checkNull(result);
        return result;
    }

    /**
     * Parse QueryExtInfo from SelecthqlcContext.
     * */
    @NotNullable
    public static QueryExtInfo parseQueryExtInfo(
            @NotNullable SelecthqlcContext selecthqlcContext) {
        Util.checkNull(selecthqlcContext);

        QueryExtInfo extInfo = new QueryExtInfo();

        MaxversionexpContext maxversionexpContext = selecthqlcContext
                .maxversionexp();
        if (maxversionexpContext != null) {
            extInfo.setMaxVersions(Integer.parseInt(maxversionexpContext
                    .maxversion().TEXT().getText()));
        }

        TsrangeContext tsrangeContext = selecthqlcContext.tsrange();
        if (tsrangeContext != null) {
            List<TsexpContext> tsexpContextList = tsrangeContext.tsexp();
            Util.check(tsexpContextList.size() == 2);
            Date minStamp = parseTsDate(tsexpContextList.get(0));
            Date maxStamp = parseTsDate(tsexpContextList.get(1));
            extInfo.setTimeRange(minStamp, maxStamp);
        }

        LimitexpContext limitexpContext = selecthqlcContext.limitexp();
        if (limitexpContext != null) {
            List<TerminalNode> terminalNodeList = limitexpContext.TEXT();
            Util.check(terminalNodeList.size() == 1
                    || terminalNodeList.size() == 2);
            if (terminalNodeList.size() == 1) {
                extInfo.setLimit(0L,
                        Long.parseLong(terminalNodeList.get(0).getText()));
            }

            if (terminalNodeList.size() == 2) {
                extInfo.setLimit(
                        Long.parseLong(terminalNodeList.get(0).getText()),
                        Long.parseLong(terminalNodeList.get(1).getText()));
            }
        }

        return extInfo;
    }

    private ContextUtil() {
    }
}
