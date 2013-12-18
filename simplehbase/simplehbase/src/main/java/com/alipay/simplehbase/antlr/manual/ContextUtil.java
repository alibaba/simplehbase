package com.alipay.simplehbase.antlr.manual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.antlr.auto.StatementsParser.CidContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.VarContext;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.literal.LiteralValue;
import com.alipay.simplehbase.util.Util;

/**
 * ContextUtil.
 * 
 * @author xinzhi.zhang
 * */
public class ContextUtil {

    /**
     * Parse column schema from cidContext.
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
     * Parse para from varContext.
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
     * Parse para list from varContext list.
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

        return LiteralValue.convertToObject(hbaseColumnSchema.getType(),
                constant);
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
}
