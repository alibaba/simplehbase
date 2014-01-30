package com.alipay.simplehbase.antlr.manual.visitor;

import java.util.ArrayList;
import java.util.List;
import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkey_EndContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkey_StartContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.RowkeyexpContext;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkeyfun.RowKeyFunc;
import com.alipay.simplehbase.client.rowkeyfun.RowKeyFuncHolder;
import com.alipay.simplehbase.client.rowkeytextfun.RowKeyTextFunc;
import com.alipay.simplehbase.client.rowkeytextfun.RowKeyTextFuncHolder;

/**
 * @author xinzhi
 * */
public class RowKeyVisitor extends StatementsBaseVisitor<RowKey> {

    @Override
    public RowKey visitRowkey_FuncConstant(
            StatementsParser.Rowkey_FuncConstantContext ctx) {
        String text = ctx.constant().TEXT().getText();
        String funcName = ctx.funcname().TEXT().getText();
        RowKeyTextFunc rowKeyTextFunc = RowKeyTextFuncHolder
                .findRowKeyTextFunc(funcName);
        return rowKeyTextFunc.func(text);
    }

    @Override
    public RowKey visitRowkey_Func(StatementsParser.Rowkey_FuncContext ctx) {
        List<RowkeyexpContext> RowkeyexpContextList = ctx.rowkeyexp();
        List<RowKey> rowKeyList = new ArrayList<RowKey>();
        for (RowkeyexpContext rowkeyexpContext : RowkeyexpContextList) {
            rowKeyList.add(rowkeyexpContext.accept(this));
        }

        String funcName = ctx.funcname().TEXT().getText();
        RowKeyFunc rowKeyFunc = RowKeyFuncHolder.findRowKeyFunc(funcName);
        return rowKeyFunc.func(rowKeyList);
    }

    @Override
    public RowKey visitRowkey_Wrapper(StatementsParser.Rowkey_WrapperContext ctx) {
        return ctx.rowkeyexp().accept(this);
    }

    @Override
    public RowKey visitRowkey_Start(Rowkey_StartContext ctx) {
        return RowKeyUtil.START_ROW;
    }

    @Override
    public RowKey visitRowkey_End(Rowkey_EndContext ctx) {
        return RowKeyUtil.END_ROW;
    }

}
