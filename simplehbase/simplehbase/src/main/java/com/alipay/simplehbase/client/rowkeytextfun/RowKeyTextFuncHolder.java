package com.alipay.simplehbase.client.rowkeytextfun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.ClassUtil;
import com.alipay.simplehbase.util.Util;

/**
 * @author xinzhi
 * */
public class RowKeyTextFuncHolder {

    /** log. */
    private static Logger                                    log             = Logger.getLogger(RowKeyTextFuncHolder.class);

    /** BIF. */
    private static List<RowKeyTextFunc>                      buildInFuncList = new ArrayList<RowKeyTextFunc>();

    /** String->RowKeyTextFunc map. */
    private static ConcurrentHashMap<String, RowKeyTextFunc> funcs           = new ConcurrentHashMap<String, RowKeyTextFunc>();

    static {

        buildInFuncList.add(new IntTextFunc());
        buildInFuncList.add(new StringTextFunc());

        for (RowKeyTextFunc func : buildInFuncList) {
            Util.checkEmptyString(func.funcName());
            funcs.put(func.funcName(), func);
            log.info("register RowKeyTextFunc : funcName=" + func.funcName()
                    + " type=" + func.getClass().getCanonicalName());
        }

    }

    /**
     * Register a RowKeyTextFunc.
     * */
    public static void register(String type) {
        Util.checkEmptyString(type);
        try {
            Class<?> c = ClassUtil.forName(type);
            RowKeyTextFunc func = (RowKeyTextFunc) c.newInstance();
            funcs.put(func.funcName(), func);

            log.info("register RowKeyTextFunc : funcName=" + func.funcName()
                    + " type=" + c.getCanonicalName());

        } catch (Exception e) {
            throw new SimpleHBaseException(e);
        }

    }

    /**
     * Find RowKeyTextFunc by name.
     * 
     * @param funcName funcName.
     * @return RowKeyTextFunc.
     */
    public static RowKeyTextFunc findRowKeyTextFunc(String funcName) {
        Util.checkEmptyString(funcName);
        return funcs.get(funcName);
    }
}
