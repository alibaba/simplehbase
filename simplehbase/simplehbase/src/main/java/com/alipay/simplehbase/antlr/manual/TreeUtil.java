package com.alipay.simplehbase.antlr.manual;

import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * TreeUtil.
 * 
 * @author xinzhi.zhang
 * */
public class TreeUtil {

    /**
     * Parse ProgContext from hql string.
     * */
    public static ProgContext parseProgContext(String hql) {
        Util.checkEmptyString(hql);

        try {
            ANTLRInputStream input = new ANTLRInputStream(new StringReader(hql));
            SimpleHbaseStatementsLexer lexer = new SimpleHbaseStatementsLexer(
                    input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            StatementsParser parser = new StatementsParser(tokens);
            parser.setErrorHandler(SimpleHbaseErrorStrategy.instance);
            ProgContext progContext = parser.prog();
            return progContext;
        } catch (Exception e) {
            throw new SimpleHBaseException("parse error.", e);
        }
    }

    private TreeUtil() {
    }

}
