package com.alipay.simplehbase.antlr.manual.visitor;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2_NotNullContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2_NullContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

/**
 * @author xinzhi
 * */
public class Constant2Visitor extends StatementsBaseVisitor<Object> {

    private HBaseColumnSchema         hbaseColumnSchema;
    private SimpleHbaseRuntimeSetting simpleHbaseRuntimeSetting;

    public Constant2Visitor(HBaseColumnSchema hbaseColumnSchema,
            SimpleHbaseRuntimeSetting simpleHbaseRuntimeSetting) {
        this.hbaseColumnSchema = hbaseColumnSchema;
        this.simpleHbaseRuntimeSetting = simpleHbaseRuntimeSetting;
    }

    @Override
    public Object visitConstant2_Null(Constant2_NullContext ctx) {
        return null;
    }

    @Override
    public Object visitConstant2_NotNull(Constant2_NotNullContext ctx) {
        return ContextUtil.parseConstant(hbaseColumnSchema, ctx.constant(),
                simpleHbaseRuntimeSetting);
    }

}
