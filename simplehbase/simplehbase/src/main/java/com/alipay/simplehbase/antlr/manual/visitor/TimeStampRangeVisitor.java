package com.alipay.simplehbase.antlr.manual.visitor;

import java.util.Date;

import com.alipay.simplehbase.antlr.auto.StatementsBaseVisitor;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_endContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_startAndEndContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.Tsrange_startContext;

import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.antlr.manual.TimeStampRange;
import com.alipay.simplehbase.config.SimpleHbaseRuntimeSetting;

/**
 * TimeStampRangeVisitor.
 * 
 * @author xinzhi.zhang
 * */
public class TimeStampRangeVisitor extends
        StatementsBaseVisitor<TimeStampRange> {
    private SimpleHbaseRuntimeSetting runtimeSetting;

    public TimeStampRangeVisitor(SimpleHbaseRuntimeSetting runtimeSetting) {
        this.runtimeSetting = runtimeSetting;
    }

    @Override
    public TimeStampRange visitTsrange_start(Tsrange_startContext startContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(ContextUtil.parseTimeStampDate(
                startContext.tsexp(), runtimeSetting));
        timeStampRange.setEnd(new Date(Long.MAX_VALUE));
        return timeStampRange;
    }

    @Override
    public TimeStampRange visitTsrange_end(Tsrange_endContext endContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(new Date(0L));
        timeStampRange.setEnd(ContextUtil.parseTimeStampDate(
                endContext.tsexp(), runtimeSetting));
        return timeStampRange;
    }

    @Override
    public TimeStampRange visitTsrange_startAndEnd(
            Tsrange_startAndEndContext startAndEndContext) {
        TimeStampRange timeStampRange = new TimeStampRange();
        timeStampRange.setStart(ContextUtil.parseTimeStampDate(
                startAndEndContext.tsexp(0), runtimeSetting));
        timeStampRange.setEnd(ContextUtil.parseTimeStampDate(
                startAndEndContext.tsexp(1), runtimeSetting));
        return timeStampRange;
    }
}
