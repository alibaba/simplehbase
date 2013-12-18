package com.alipay.simplehbase.antlr.manual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.RegexStringComparator;

import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;

import com.alipay.simplehbase.antlr.auto.StatementsParser.AndconditionContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.BetweenconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.BetweenvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CidContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConditioncContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CountcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CountclContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.EqualconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.EqualvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.GreaterconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.GreaterequalconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.GreaterequalvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.GreatervarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InconstantlistContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InvarlistContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.LessconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.LessequalconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.LessequalvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.LessvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.MatchconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.MatchvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotbetweenconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotbetweenvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotequalconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotequalvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotinconstantlistContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotinvarlistContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotmatchconstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.NotmatchvarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.OrconditionContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectclContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.VarContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.WherecContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.WrapperContext;
import com.alipay.simplehbase.antlr.auto.StatementsVisitor;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseVisitor.
 * 
 * @author xinzhi.zhang
 * */
public class SimpleHbaseVisitor implements StatementsVisitor<Filter> {

    private HBaseTableConfig    hbaseTableConfig;
    private Map<String, Object> para;

    public SimpleHbaseVisitor(HBaseTableConfig hbaseTableConfig,
            Map<String, Object> para) {
        this.hbaseTableConfig = hbaseTableConfig;
        this.para = para;
    }

    @Override
    public Filter visitOrcondition(OrconditionContext ctx) {
        List<ConditioncContext> conditioncContextList = ctx.conditionc();
        List<Filter> filters = new ArrayList<Filter>();
        for (ConditioncContext conditioncContext : conditioncContextList) {
            filters.add(conditioncContext.accept(this));
        }

        FilterList filterList = new FilterList(Operator.MUST_PASS_ONE, filters);
        return filterList;
    }

    @Override
    public Filter visitAndcondition(AndconditionContext ctx) {
        List<ConditioncContext> conditioncContextList = ctx.conditionc();
        List<Filter> filters = new ArrayList<Filter>();
        for (ConditioncContext conditioncContext : conditioncContextList) {
            filters.add(conditioncContext.accept(this));
        }

        FilterList filterList = new FilterList(Operator.MUST_PASS_ALL, filters);
        return filterList;
    }

    @Override
    public Filter visitWrapper(WrapperContext ctx) {
        return ctx.conditionc().accept(this);
    }

    @Override
    public Filter visitEqualvar(EqualvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareOp.EQUAL, object);
    }

    @Override
    public Filter visitEqualconstant(EqualconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.EQUAL, object);
    }

    @Override
    public Filter visitNotequalconstant(NotequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.NOT_EQUAL, object);
    }

    @Override
    public Filter visitNotequalvar(NotequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareOp.NOT_EQUAL, object);
    }

    @Override
    public Filter visitLessvar(LessvarContext ctx) {

        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareOp.LESS, object);
    }

    @Override
    public Filter visitLessconstant(LessconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.LESS, object);

    }

    @Override
    public Filter visitLessequalconstant(LessequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.LESS_OR_EQUAL,
                object);
    }

    @Override
    public Filter visitLessequalvar(LessequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareOp.LESS_OR_EQUAL,
                object);
    }

    @Override
    public Filter visitGreaterconstant(GreaterconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.GREATER, object);
    }

    @Override
    public Filter visitGreatervar(GreatervarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareOp.GREATER, object);
    }

    @Override
    public Filter visitGreaterequalvar(GreaterequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareOp.GREATER_OR_EQUAL,
                object);
    }

    @Override
    public Filter visitGreaterequalconstant(GreaterequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilter(hbaseColumnSchema, CompareOp.GREATER_OR_EQUAL,
                object);
    }

    private static Filter constructFilter(HBaseColumnSchema hbaseColumnSchema,
            CompareOp compareOp, Object object) {
        byte[] value = hbaseColumnSchema.getTypeHandler().toBytes(
                hbaseColumnSchema.getType(), object);

        Util.checkNull(value);

        byte[] familyBytes = hbaseColumnSchema.getFamilyBytes();
        byte[] qualifierBytes = hbaseColumnSchema.getQualifierBytes();

        SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
                familyBytes, qualifierBytes, compareOp, value);
        singleColumnValueFilter.setFilterIfMissing(true);

        return singleColumnValueFilter;

    }

    @Override
    public Filter visitNotmatchconstant(NotmatchconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilterWithRegex(hbaseColumnSchema, CompareOp.NOT_EQUAL,
                object);
    }

    @Override
    public Filter visitNotmatchvar(NotmatchvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilterWithRegex(hbaseColumnSchema, CompareOp.NOT_EQUAL,
                object);
    }

    @Override
    public Filter visitMatchvar(MatchvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilterWithRegex(hbaseColumnSchema, CompareOp.EQUAL,
                object);
    }

    @Override
    public Filter visitMatchconstant(MatchconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parseConstant(hbaseColumnSchema,
                constantContext);

        return constructFilterWithRegex(hbaseColumnSchema, CompareOp.EQUAL,
                object);
    }

    private static Filter constructFilterWithRegex(
            HBaseColumnSchema hbaseColumnSchema, CompareOp compareOp,
            Object object) {

        Util.checkNull(object);

        if (compareOp != CompareOp.EQUAL && compareOp != CompareOp.NOT_EQUAL) {
            throw new SimpleHBaseException(
                    "only EQUAL or NOT_EQUAL can use regex match. compareOp = "
                            + compareOp);
        }
        if (object.getClass() != String.class) {
            throw new SimpleHBaseException(
                    "only String can use regex match. object = " + object);
        }
        if (hbaseColumnSchema.getType() != String.class) {
            throw new SimpleHBaseException(
                    "only String can use regex match. hbaseColumnSchema = "
                            + hbaseColumnSchema);
        }

        byte[] familyBytes = hbaseColumnSchema.getFamilyBytes();
        byte[] qualifierBytes = hbaseColumnSchema.getQualifierBytes();

        RegexStringComparator regexStringComparator = new RegexStringComparator(
                (String) object);

        SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
                familyBytes, qualifierBytes, compareOp, regexStringComparator);
        singleColumnValueFilter.setFilterIfMissing(true);

        return singleColumnValueFilter;
    }

    @Override
    public Filter visitNotinconstantlist(NotinconstantlistContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);

        ConstantListContext constantListContext = ctx.constantList();
        List<ConstantContext> constantContextList = constantListContext
                .constant();
        List<Object> list = ContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList);

        return constructFilterForContain(hbaseColumnSchema,
                CompareOp.NOT_EQUAL, list, Operator.MUST_PASS_ALL);
    }

    @Override
    public Filter visitNotinvarlist(NotinvarlistContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilterForContain(hbaseColumnSchema,
                CompareOp.NOT_EQUAL, (List<Object>) object,
                Operator.MUST_PASS_ALL);
    }

    @Override
    public Filter visitInvarlist(InvarlistContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        Object object = ContextUtil.parsePara(varContext, para);

        return constructFilterForContain(hbaseColumnSchema, CompareOp.EQUAL,
                (List<Object>) object, Operator.MUST_PASS_ONE);
    }

    @Override
    public Filter visitInconstantlist(InconstantlistContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);

        ConstantListContext constantListContext = ctx.constantList();
        List<ConstantContext> constantContextList = constantListContext
                .constant();
        List<Object> list = ContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList);

        return constructFilterForContain(hbaseColumnSchema, CompareOp.EQUAL,
                list, Operator.MUST_PASS_ONE);
    }

    private static Filter constructFilterForContain(
            HBaseColumnSchema hbaseColumnSchema, CompareOp compareOp,
            List<Object> list, Operator operator) {

        List<Filter> filters = new ArrayList<Filter>();
        for (Object obj : list) {
            filters.add(constructFilter(hbaseColumnSchema, compareOp, obj));
        }

        FilterList filterList = new FilterList(operator, filters);
        return filterList;
    }

    @Override
    public Filter visitNotbetweenconstant(NotbetweenconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);

        List<ConstantContext> constantContextList = ctx.constant();

        List<Object> list = ContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList);

        Filter startFilter = constructFilter(hbaseColumnSchema, CompareOp.LESS,
                list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareOp.GREATER, list.get(1));

        FilterList filterList = new FilterList(Operator.MUST_PASS_ONE,
                Arrays.asList(startFilter, endFilter));
        return filterList;
    }

    @Override
    public Filter visitNotbetweenvar(NotbetweenvarContext ctx) {
        CidContext cidContext = ctx.cid();
        List<VarContext> varContextList = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        List<Object> list = ContextUtil.parseParaList(varContextList, para);

        Filter startFilter = constructFilter(hbaseColumnSchema, CompareOp.LESS,
                list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareOp.GREATER, list.get(1));

        FilterList filterList = new FilterList(Operator.MUST_PASS_ONE,
                Arrays.asList(startFilter, endFilter));

        return filterList;
    }

    @Override
    public Filter visitBetweenvar(BetweenvarContext ctx) {
        CidContext cidContext = ctx.cid();
        List<VarContext> varContextList = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);
        List<Object> list = ContextUtil.parseParaList(varContextList, para);

        Filter startFilter = constructFilter(hbaseColumnSchema,
                CompareOp.GREATER_OR_EQUAL, list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareOp.LESS_OR_EQUAL, list.get(1));

        FilterList filterList = new FilterList(Operator.MUST_PASS_ALL,
                Arrays.asList(startFilter, endFilter));
        return filterList;
    }

    @Override
    public Filter visitBetweenconstant(BetweenconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = ContextUtil
                .parseHBaseColumnSchema(hbaseTableConfig, cidContext);

        List<ConstantContext> constantContextList = ctx.constant();

        List<Object> list = ContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList);

        Filter startFilter = constructFilter(hbaseColumnSchema,
                CompareOp.GREATER_OR_EQUAL, list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareOp.LESS_OR_EQUAL, list.get(1));

        FilterList filterList = new FilterList(Operator.MUST_PASS_ALL,
                Arrays.asList(startFilter, endFilter));

        return filterList;
    }

    @Override
    public Filter visitCid(CidContext ctx) {
        return null;
    }

    @Override
    public Filter visitWherec(WherecContext ctx) {
        return null;
    }

    @Override
    public Filter visitVar(VarContext ctx) {
        return null;
    }

    @Override
    public Filter visitConstant(ConstantContext ctx) {
        return null;
    }

    @Override
    public Filter visit(@NotNull ParseTree arg0) {
        return null;
    }

    @Override
    public Filter visitChildren(@NotNull RuleNode arg0) {
        return null;
    }

    @Override
    public Filter visitErrorNode(@NotNull ErrorNode arg0) {
        return null;
    }

    @Override
    public Filter visitTerminal(@NotNull TerminalNode arg0) {
        return null;
    }

    @Override
    public Filter visitConstantList(ConstantListContext ctx) {
        return null;
    }

    @Override
    public Filter visitCountc(CountcContext ctx) {
        return null;
    }

    @Override
    public Filter visitSelectcl(SelectclContext ctx) {
        return null;
    }

    @Override
    public Filter visitCountcl(CountclContext ctx) {
        return null;
    }

    @Override
    public Filter visitSelectc(SelectcContext ctx) {
        return null;
    }
}
