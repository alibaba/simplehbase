package com.alipay.simplehbase.exception;

/**
 * SimpleHbase的通用异常。
 * 
 * <pre>
 * 所有simplehbase框架的异常都应该继承此类。
 * </pre>
 * 
 * @author xinzhi
 * @version $Id: SimpleHBaseException.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class SimpleHBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SimpleHBaseException(String message) {
        super(message);
    }

    public SimpleHBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleHBaseException(Throwable cause) {
        super(cause);
    }
}
