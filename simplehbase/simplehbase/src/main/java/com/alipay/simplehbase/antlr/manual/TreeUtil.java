package com.alipay.simplehbase.antlr.manual;

import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import com.alipay.simplehbase.antlr.auto.StatementsParser;
import com.alipay.simplehbase.antlr.auto.StatementsParser.DeleteHqlClContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InsertHqlClContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectHqlClContext;
import com.alipay.simplehbase.core.RawHQLType;
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

    /**
     * Parse table name from ProgContext.
     * */
    public static String parseTableName(ProgContext progContext) {
        Util.checkNull(progContext);

        if (progContext instanceof InsertHqlClContext) {
            return InsertHqlClContext.class.cast(progContext).inserthqlc()
                    .tablename().TEXT().getText();
        }

        if (progContext instanceof SelectHqlClContext) {
            return SelectHqlClContext.class.cast(progContext).selecthqlc()
                    .tablename().TEXT().getText();
        }

        if (progContext instanceof DeleteHqlClContext) {
            return DeleteHqlClContext.class.cast(progContext).deletehqlc()
                    .tablename().TEXT().getText();
        }

        throw new SimpleHBaseException("parse error.");
    }

    /**
     * Parse RawHQLType.
     * */
    public static RawHQLType parseHQLType(ProgContext progContext) {
        Util.checkNull(progContext);

        if (progContext instanceof InsertHqlClContext) {
            return RawHQLType.PUT;
        }

        if (progContext instanceof SelectHqlClContext) {
            return RawHQLType.SELECT;
        }

        if (progContext instanceof DeleteHqlClContext) {
            return RawHQLType.DELETE;
        }

        throw new SimpleHBaseException("parse error.");
    }

}
