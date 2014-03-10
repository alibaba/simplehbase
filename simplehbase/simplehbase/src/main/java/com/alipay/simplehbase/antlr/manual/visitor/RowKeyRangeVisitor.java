package com.alipay.simplehbase.antlr.manual.visitor;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_endContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_startAndEndContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Rowkeyrange_startContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.antlr.manual.RowKeyRange;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;

/**
 * RowKeyRange visitor.
 * 
 * @author xinzhi
 * */
public class RowKeyRangeVisitor extends StatementsBaseVisitor<RowKeyRange> {

    @Override
    public RowKeyRange visitRowkeyrange_start(
            Rowkeyrange_startContext startContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(ContextUtil.parseRowKey(startContext.rowkeyexp()));
        range.setEnd(RowKeyUtil.END_ROW);
        return range;
    }

    @Override
    public RowKeyRange visitRowkeyrange_end(Rowkeyrange_endContext endContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(RowKeyUtil.START_ROW);
        range.setEnd(ContextUtil.parseRowKey(endContext.rowkeyexp()));
        return range;
    }

    @Override
    public RowKeyRange visitRowkeyrange_startAndEnd(
            Rowkeyrange_startAndEndContext startAndEndContext) {
        RowKeyRange range = new RowKeyRange();
        range.setStart(ContextUtil.parseRowKey(startAndEndContext.rowkeyexp(0)));
        range.setEnd(ContextUtil.parseRowKey(startAndEndContext.rowkeyexp(1)));
        return range;
    }
}
