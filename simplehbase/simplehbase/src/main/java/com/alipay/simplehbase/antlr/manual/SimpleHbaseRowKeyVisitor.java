package com.alipay.simplehbase.antlr.manual;

import java.util.ArrayList;
import java.util.List;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.RowkeyexpContext;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkeyfun.RowKeyFunc;
import com.alipay.simplehbase.client.rowkeyfun.RowKeyFuncHolder;
import com.alipay.simplehbase.client.rowkeystringfun.RowKeyTextFunc;
import com.alipay.simplehbase.client.rowkeystringfun.RowKeyTextFuncHolder;

public class SimpleHbaseRowKeyVisitor extends StatementsBaseVisitor<RowKey> {

    @Override
    public RowKey visitRowkeyfuncconstant(
            StatementsParser.RowkeyfuncconstantContext ctx) {
        String text = ctx.constant().TEXT().getText();
        String funcName = ctx.funcname().TEXT().getText();
        RowKeyTextFunc rowKeyTextFunc = RowKeyTextFuncHolder
                .findRowKeyTextFunc(funcName);
        return rowKeyTextFunc.func(text);
    }

    @Override
    public RowKey visitRowkeyfunc(StatementsParser.RowkeyfuncContext ctx) {
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
    public RowKey visitRowkeywrapper(StatementsParser.RowkeywrapperContext ctx) {
        return ctx.rowkeyexp().accept(this);
    }

}
