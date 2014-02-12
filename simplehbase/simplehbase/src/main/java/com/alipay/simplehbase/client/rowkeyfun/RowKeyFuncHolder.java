package com.alipay.simplehbase.client.rowkeyfun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.Util;

/**
 * @author xinzhi
 */
public class RowKeyFuncHolder {

    /** log. */
    private static Logger                                log   = Logger.getLogger(RowKeyFuncHolder.class);

    /** String->RowKeyFunc map. */
    private static ConcurrentHashMap<String, RowKeyFunc> funcs = new ConcurrentHashMap<String, RowKeyFunc>();

    static {

        List<RowKeyFunc> buildInFuncList = new ArrayList<RowKeyFunc>();

        for (RowKeyFunc func : buildInFuncList) {
            Util.checkEmptyString(func.funcName());
            funcs.put(func.funcName(), func);
            log.info("register RowKeyFunc : funcName=" + func.funcName()
                    + " type=" + func.getClass().getCanonicalName());
        }
    }

    /**
     * Register a RowKeyFunc.
     * */
    public static void register(String type) {
        Util.checkEmptyString(type);
        try {
            Class<?> c = ClassUtil.forName(type);
            RowKeyFunc func = (RowKeyFunc) c.newInstance();
            funcs.put(func.funcName(), func);

            log.info("register RowKeyFunc : funcName=" + func.funcName()
                    + " type=" + c.getCanonicalName());

        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }

    }

    /**
     * Find RowKeyFunc by name.
     * 
     * @param funcName funcName.
     * @return RowKeyFunc.
     */
    public static RowKeyFunc findRowKeyFunc(String funcName) {
        Util.checkEmptyString(funcName);
        return funcs.get(funcName);
    }
}
