package com.alipay.simplehbase.antlr.manual;

import java.util.Map;

import com.alipay.simplehbase.antlr.auto.StatementsParser.CidContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.VarContext;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.HBaseTableConfig;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.literal.LiteralValue;

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

        String var = varContext.TEXT().getText();

        return para.get(var);
    }

    /**
     * Parse constant from constantContext.
     * */
    public static Object parseConstant(HBaseColumnSchema hbaseColumnSchema,
            ConstantContext constantContext) {

        String constant = constantContext.TEXT().getText();
        return LiteralValue.convertToObject(hbaseColumnSchema.getType(),
                constant);
    }

}
