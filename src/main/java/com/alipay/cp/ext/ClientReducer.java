package com.alipay.cp.ext;

/**
 * ClientReducer.
 * 
 * <pre>
 * The reducer of client side.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface ClientReducer<T, R> {

    /**
     * Init value.
     * */
    public R getInitValue();

    /**
     * Reduce it.
     * */
    public R reduce(R r, T t);
}
