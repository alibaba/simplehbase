package com.alipay.simplehbase.antlr.manual.visitor;

import java.util.Date;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_endContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_startAndEndContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_startContext;

import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.antlr.manual.TimeStampRange;

/**
 * TimeStampRangeVisitor.
 * 
 * @author xinzhi.zhang
 * */
public class TimeStampRangeVisitor extends
        StatementsBaseVisitor<TimeStampRange> {

    @Override
    public TimeStampRange visitTsrange_start(Tsrange_startContext startContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(ContextUtil.parseTimeStampDate(startContext.tsexp()));
        timeStampRange.setEnd(new Date(0x7FFFFFFF));
        return timeStampRange;
    }

    @Override
    public TimeStampRange visitTsrange_end(Tsrange_endContext endContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(new Date(0));
        timeStampRange.setEnd(ContextUtil.parseTimeStampDate(endContext.tsexp()));
        return timeStampRange;
    }

    @Override
    public TimeStampRange visitTsrange_startAndEnd(
            Tsrange_startAndEndContext startAndEndContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(ContextUtil.parseTimeStampDate(startAndEndContext
                .tsexp(0)));
        timeStampRange.setEnd(ContextUtil.parseTimeStampDate(startAndEndContext
                .tsexp(1)));
        return timeStampRange;
    }
}
