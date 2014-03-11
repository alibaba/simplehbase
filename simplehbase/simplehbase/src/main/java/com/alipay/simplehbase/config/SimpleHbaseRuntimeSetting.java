package com.alipay.simplehbase.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alipay.simplehbase.client.rowkeytextfun.IntTextFunc;
import com.alipay.simplehbase.client.rowkeytextfun.RowKeyTextFunc;
import com.alipay.simplehbase.client.rowkeytextfun.StringTextFunc;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.literal.LiteralInterpreter;
import com.alipay.simplehbase.literal.interpreter.BooleanInterpreter;
import com.alipay.simplehbase.literal.interpreter.ByteInterpreter;
import com.alipay.simplehbase.literal.interpreter.CharInterpreter;
import com.alipay.simplehbase.literal.interpreter.DateInterpreter;
import com.alipay.simplehbase.literal.interpreter.DoubleInterpreter;
import com.alipay.simplehbase.literal.interpreter.FloatInterpreter;
import com.alipay.simplehbase.literal.interpreter.IntegerInterpreter;
import com.alipay.simplehbase.literal.interpreter.LongInterpreter;
import com.alipay.simplehbase.literal.interpreter.ShortInterpreter;
import com.alipay.simplehbase.literal.interpreter.StringInterpreter;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseRuntimeSetting.
 * 
 * @author xinzhi
 * */
public class SimpleHbaseRuntimeSetting {
    /**
     * scan caching size.
     * */
    private int                            scanCachingSize                = 20;
    /**
     * delete batch size.
     * */
    private int                            deleteBatchSize                = 50;
    /**
     * rowkey text func list.
     * */
    private List<RowKeyTextFunc>           rowKeyTextFuncList;
    /**
     * LiteralInterpreter list.
     * */
    private List<LiteralInterpreter>       literalInterpreterList;

    /**
     * build-in rowkey text func list.
     * */
    private List<RowKeyTextFunc>           buildInRowKeyTextFuncList;

    private Map<Class, LiteralInterpreter> literalInterpreterCache        = new HashMap<Class, LiteralInterpreter>();
    private Map<Class, LiteralInterpreter> buildInliteralInterpreterCache = new HashMap<Class, LiteralInterpreter>();

    public SimpleHbaseRuntimeSetting() {

        buildInRowKeyTextFuncList = new ArrayList<RowKeyTextFunc>();
        buildInRowKeyTextFuncList.add(new IntTextFunc());
        buildInRowKeyTextFuncList.add(new StringTextFunc());

        List<LiteralInterpreter> buildInLiteralInterpreterList = new ArrayList<LiteralInterpreter>();
        buildInLiteralInterpreterList.add(new BooleanInterpreter());
        buildInLiteralInterpreterList.add(new ByteInterpreter());
        buildInLiteralInterpreterList.add(new CharInterpreter());
        buildInLiteralInterpreterList.add(new DateInterpreter());
        buildInLiteralInterpreterList.add(new DoubleInterpreter());
        buildInLiteralInterpreterList.add(new FloatInterpreter());
        buildInLiteralInterpreterList.add(new IntegerInterpreter());
        buildInLiteralInterpreterList.add(new LongInterpreter());
        buildInLiteralInterpreterList.add(new ShortInterpreter());
        buildInLiteralInterpreterList.add(new StringInterpreter());

        for (LiteralInterpreter interpreter : buildInLiteralInterpreterList) {
            Class type = ClassUtil.tryConvertToBoxClass(interpreter
                    .getTypeCanInterpret());
            buildInliteralInterpreterCache.put(type, interpreter);
        }
    }

    /**
     * findRowKeyTextFunc.
     * */
    public RowKeyTextFunc findRowKeyTextFunc(String funcName) {
        if (rowKeyTextFuncList != null) {
            for (RowKeyTextFunc fun : rowKeyTextFuncList) {
                if (fun.funcName().equals(funcName)) {
                    return fun;
                }
            }
        }
        for (RowKeyTextFunc fun : buildInRowKeyTextFuncList) {
            if (fun.funcName().equals(funcName)) {
                return fun;
            }
        }
        throw new SimpleHBaseException("can not find func for " + funcName);
    }

    public Object interpret(Class type, String literalValue) {
        Util.checkNull(type);
        Util.checkNull(literalValue);

        Class temType = ClassUtil.tryConvertToBoxClass(type);

        if (literalInterpreterCache.get(temType) != null) {
            return literalInterpreterCache.get(temType).interpret(literalValue);
        }

        if (buildInliteralInterpreterCache.get(temType) != null) {
            return buildInliteralInterpreterCache.get(temType).interpret(
                    literalValue);
        }

        Object result = null;
        if (temType.isEnum()) {
            result = Enum.valueOf(type, literalValue);
        }
        Util.checkNull(result);

        return result;
    }

    public void setLiteralInterpreterList(
            List<LiteralInterpreter> literalInterpreterList) {
        this.literalInterpreterList = literalInterpreterList;

        if (this.literalInterpreterList != null) {
            for (LiteralInterpreter interpreter : literalInterpreterList) {
                Class type = ClassUtil.tryConvertToBoxClass(interpreter
                        .getTypeCanInterpret());
                literalInterpreterCache.put(type, interpreter);
            }
        }
    }

    public int getScanCachingSize() {
        return scanCachingSize;
    }

    public void setScanCachingSize(int scanCachingSize) {
        this.scanCachingSize = scanCachingSize;
    }

    public int getDeleteBatchSize() {
        return deleteBatchSize;
    }

    public void setDeleteBatchSize(int deleteBatchSize) {
        this.deleteBatchSize = deleteBatchSize;
    }

    public List<RowKeyTextFunc> getRowKeyTextFuncList() {
        return rowKeyTextFuncList;
    }

    public void setRowKeyTextFuncList(List<RowKeyTextFunc> rowKeyTextFuncList) {
        this.rowKeyTextFuncList = rowKeyTextFuncList;
    }

    public List<LiteralInterpreter> getLiteralInterpreterList() {
        return literalInterpreterList;
    }

}
