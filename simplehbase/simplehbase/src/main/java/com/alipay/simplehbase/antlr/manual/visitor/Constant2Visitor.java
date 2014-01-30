package com.alipay.simplehbase.antlr.manual.visitor;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2_NotNullContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2_NullContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.config.HBaseColumnSchema;

/**
 * @author xinzhi
 * */
public class Constant2Visitor extends StatementsBaseVisitor<Object> {

    private HBaseColumnSchema hbaseColumnSchema;

    public Constant2Visitor() {
    }

    public Constant2Visitor(HBaseColumnSchema hbaseColumnSchema) {
        this.hbaseColumnSchema = hbaseColumnSchema;
    }

    @Override
    public Object visitConstant2_Null(Constant2_NullContext ctx) {
        return null;
    }

    @Override
    public Object visitConstant2_NotNull(Constant2_NotNullContext ctx) {
        return ContextUtil.parseConstant(hbaseColumnSchema, ctx.constant());
    }

}
