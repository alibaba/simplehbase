package com.alipay.simplehbase.antlr.manual;

import org.apache.log4j.Logger;
import org.antlr.v4.runtime.*;

import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * SimpleHbaseErrorStrategy.
 * 
 * @author xinzhi.zhang
 * */
public class SimpleHbaseErrorStrategy extends DefaultErrorStrategy {

    /** log. */
    private static Logger                  log      = Logger.getLogger(SimpleHbaseErrorStrategy.class);
    /** instance. */
    public static SimpleHbaseErrorStrategy instance = new SimpleHbaseErrorStrategy();

    /**
     * Instead of recovering from exception e, rethrow it wrapped in a generic
     * RuntimeException so it is not caught by the rule function catches.
     * Exception e is the "cause" of the RuntimeException.
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        log.error(e);
        throw new SimpleHBaseException(e);
    }

    /**
     * Make sure we don't attempt to recover inline; if the parser successfully
     * recovers, it won't throw an exception.
     */
    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        log.error("parser error.");
        throw new SimpleHBaseException("parser error.",
                new InputMismatchException(recognizer));
    }

    /** Make sure we don't attempt to recover from problems in subrules. */
    @Override
    public void sync(Parser recognizer) {
    }

    private SimpleHbaseErrorStrategy() {
    }
}
