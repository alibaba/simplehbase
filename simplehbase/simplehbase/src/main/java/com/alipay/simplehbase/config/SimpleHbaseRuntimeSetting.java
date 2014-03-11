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

    private Map<String, RowKeyTextFunc>    rowKeyTextFuncCache            = new HashMap<String, RowKeyTextFunc>();
    private Map<String, RowKeyTextFunc>    buildInRowKeyTextFuncCache     = new HashMap<String, RowKeyTextFunc>();

    /**
     * LiteralInterpreter list.
     * */
    private List<LiteralInterpreter>       literalInterpreterList;

    private Map<Class, LiteralInterpreter> literalInterpreterCache        = new HashMap<Class, LiteralInterpreter>();
    private Map<Class, LiteralInterpreter> buildInliteralInterpreterCache = new HashMap<Class, LiteralInterpreter>();

    public SimpleHbaseRuntimeSetting() {

        List<RowKeyTextFunc> buildInRowKeyTextFuncList = new ArrayList<RowKeyTextFunc>();
        buildInRowKeyTextFuncList.add(new IntTextFunc());
        buildInRowKeyTextFuncList.add(new StringTextFunc());
        for (RowKeyTextFunc func : buildInRowKeyTextFuncList) {
            buildInRowKeyTextFuncCache.put(func.funcName(), func);
        }

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
        if (rowKeyTextFuncCache.containsKey(funcName)) {
            return rowKeyTextFuncCache.get(funcName);
        }
        if (buildInRowKeyTextFuncCache.containsKey(funcName)) {
            return buildInRowKeyTextFuncCache.get(funcName);
        }
        throw new SimpleHBaseException("can not find func for " + funcName);
    }

    public List<RowKeyTextFunc> findAllRowKeyTextFunc() {
        Map<String, RowKeyTextFunc> tem = new HashMap<String, RowKeyTextFunc>();
        tem.putAll(buildInRowKeyTextFuncCache);
        tem.putAll(rowKeyTextFuncCache);
        return new ArrayList<RowKeyTextFunc>(tem.values());
    }

    public Object interpret(Class type, String literalValue) {
        Util.checkNull(type);
        Util.checkNull(literalValue);

        Class temType = ClassUtil.tryConvertToBoxClass(type);

        if (literalInterpreterCache.containsKey(temType)) {
            return literalInterpreterCache.get(temType).interpret(literalValue);
        }

        if (buildInliteralInterpreterCache.containsKey(temType)) {
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

    public List<LiteralInterpreter> findAllLiteralInterpreter() {
        Map<Class, LiteralInterpreter> tem = new HashMap<Class, LiteralInterpreter>();
        tem.putAll(buildInliteralInterpreterCache);
        tem.putAll(literalInterpreterCache);
        return new ArrayList<LiteralInterpreter>(tem.values());
    }

    public void setLiteralInterpreterList(
            List<LiteralInterpreter> literalInterpreterList) {
        this.literalInterpreterList = literalInterpreterList;
        if (this.literalInterpreterList != null) {
            for (LiteralInterpreter interpreter : this.literalInterpreterList) {
                Class type = ClassUtil.tryConvertToBoxClass(interpreter
                        .getTypeCanInterpret());
                literalInterpreterCache.put(type, interpreter);
            }
        }
    }

    public void setRowKeyTextFuncList(List<RowKeyTextFunc> rowKeyTextFuncList) {
        this.rowKeyTextFuncList = rowKeyTextFuncList;
        if (this.rowKeyTextFuncList != null) {
            for (RowKeyTextFunc func : rowKeyTextFuncList) {
                rowKeyTextFuncCache.put(func.funcName(), func);
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

    public List<LiteralInterpreter> getLiteralInterpreterList() {
        return literalInterpreterList;
    }

}
