package com.alipay.simplehbase.antlr.manual.visitor;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkey_hbaseendContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkey_hbasestartContext;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkeytextfun.RowKeyTextFunc;
import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

/**
 * @author xinzhi
 * */
public class RowKeyVisitor extends StatementsBaseVisitor<RowKey> {

    private SimpleHbaseRuntimeSetting runtimeSetting;

    public RowKeyVisitor(SimpleHbaseRuntimeSetting runtimeSetting) {
        super();
        this.runtimeSetting = runtimeSetting;
    }

    @Override
    public RowKey visitRowkey_FuncConstant(
            StatementsParser.Rowkey_FuncConstantContext ctx) {
        String text = ctx.constant().TEXT().getText();
        String funcName = ctx.funcname().TEXT().getText();
        RowKeyTextFunc rowKeyTextFunc = runtimeSetting
                .findRowKeyTextFunc(funcName);
        return rowKeyTextFunc.func(text);
    }

    @Override
    public RowKey visitRowkey_Wrapper(StatementsParser.Rowkey_WrapperContext ctx) {
        return ctx.rowkeyexp().accept(this);
    }

    @Override
    public RowKey visitRowkey_hbaseend(Rowkey_hbaseendContext ctx) {
        return RowKeyUtil.END_ROW;
    }

    @Override
    public RowKey visitRowkey_hbasestart(Rowkey_hbasestartContext ctx) {
        return RowKeyUtil.START_ROW;
    }

}
