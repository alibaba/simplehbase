package com.alipay.simplehbase.antlr.manual;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.antlr.auto.StatementsParser.CidContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CidListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.RowkeyexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.TsexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.VarContext;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableConfig;
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
    public static HBaseColumnSchema parseHBaseColumnSchema(
            HBaseTableConfig hbaseTableConfig, CidContext cidContext) {
        Util.checkNull(hbaseTableConfig);
        Util.checkNull(cidContext);

        String cid = cidContext.TEXT().getText();

        String[] parts = cid.toString().split("\\.");
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
    public static List<HBaseColumnSchema> parseHBaseColumnSchemaList(
            HBaseTableConfig hbaseTableConfig, CidListContext cidListContext) {
        Util.checkNull(hbaseTableConfig);
        Util.checkNull(cidListContext);

        List<HBaseColumnSchema> result = new ArrayList<HBaseColumnSchema>();

        for (CidContext cidContext : cidListContext.cid()) {
            result.add(parseHBaseColumnSchema(hbaseTableConfig, cidContext));
        }

        return result;

    }

    /**
     * Parse parameter from varContext.
     * */
    public static Object parsePara(VarContext varContext,
            Map<String, Object> para) {
        Util.checkNull(varContext);
        Util.checkNull(para);

        String var = varContext.TEXT().getText();
        Util.checkEmptyString(var);

        return para.get(var);
    }

    /**
     * Parse parameter list from varContext list.
     * */
    public static List<Object> parseParaList(List<VarContext> varContextList,
            Map<String, Object> para) {
        Util.checkNull(varContextList);
        Util.checkNull(para);

        List<Object> result = new ArrayList<Object>();
        for (VarContext varContext : varContextList) {
            result.add(parsePara(varContext, para));
        }
        return result;
    }

    /**
     * Parse constant from constantContext.
     * */
    public static Object parseConstant(HBaseColumnSchema hbaseColumnSchema,
            ConstantContext constantContext) {
        Util.checkNull(hbaseColumnSchema);
        Util.checkNull(constantContext);

        String constant = constantContext.TEXT().getText();
        Util.checkEmptyString(constant);

        return LiteralValueInterpreter.convertToObject(
                hbaseColumnSchema.getType(), constant);
    }

    /**
     * Parse constant list from constantContext list.
     * */
    public static List<Object> parseConstantList(
            HBaseColumnSchema hbaseColumnSchema,
            List<ConstantContext> constantContextList) {
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
    public static RowKey parseRowKey(RowkeyexpContext rowkeyexpContext) {
        Util.checkNull(rowkeyexpContext);

        SimpleHbaseRowKeyVisitor visitor = new SimpleHbaseRowKeyVisitor();
        return rowkeyexpContext.accept(visitor);
    }

    /**
     * Parse Date from TsexpContext.
     */
    public static Date parseTsDate(TsexpContext tsexpContext) {
        Util.checkNull(tsexpContext);

        String constant = tsexpContext.constant().TEXT().getText();
        return (Date) LiteralValueInterpreter.convertToObject(Date.class,
                constant);
    }
}
