package com.alipay.simplehbase.client.rowkeystringfun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.Util;

public class RowKeyStringFuncHolder {

    /** log. */
    private static Logger                                      log             = Logger.getLogger(RowKeyStringFuncHolder.class);

    /** BIF. */
    private static List<RowKeyStringFunc>                      buildInFuncList = new ArrayList<RowKeyStringFunc>();

    /** String->RowKeyStringFunc map. */
    private static ConcurrentHashMap<String, RowKeyStringFunc> funcs           = new ConcurrentHashMap<String, RowKeyStringFunc>();

    static {

        buildInFuncList.add(new IntStringFunc());

        for (RowKeyStringFunc func : buildInFuncList) {
            Util.checkEmptyString(func.funcName());
            funcs.put(func.funcName(), func);
            log.info("register RowKeyStringFunc : funcName=" + func.funcName()
                    + " type=" + func.getClass().getCanonicalName());
        }

    }

    /**
     * Register a RowKeyStringFunc.
     * */
    public static void register(String type) {
        Util.checkEmptyString(type);
        try {
            Class<?> c = ClassUtil.forName(type);
            RowKeyStringFunc func = (RowKeyStringFunc) c.newInstance();
            funcs.put(func.funcName(), func);

            log.info("register RowKeyStringFunc : funcName=" + func.funcName()
                    + " type=" + c.getCanonicalName());

        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }

    }

    /**
     * Find RowKeyStringFunc by name.
     * 
     * @param funcName funcName.
     * @return RowKeyStringFunc.
     */
    public static RowKeyStringFunc findRowKeyStringFunc(String funcName) {
        Util.checkEmptyString(funcName);
        return funcs.get(funcName);
    }
}
