package com.alipay.simplehbase.exception;

/**
 * SimpleHbase exception.
 * 
 * <pre>
 * All the exception should extends this exception.
 * </pre>
 * 
 * @author xinzhi
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
