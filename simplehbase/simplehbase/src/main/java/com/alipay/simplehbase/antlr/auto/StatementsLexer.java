package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StatementsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, LB=4, RB=5, WHERE=6, SELECT=7, COUNT=8, INSERT=9, 
		INTO=10, VALUES=11, ROWKEY=12, TS=13, IS=14, AND=15, OR=16, LESSEQUAL=17, 
		LESS=18, GREATEREQUAL=19, GREATER=20, NOTEQUAL=21, EQUAL=22, NOTMATCH=23, 
		MATCH=24, IN=25, NOTIN=26, BETWEEN=27, NOTBETWEEN=28, ISNULL=29, ISNOTNULL=30, 
		ISMISSING=31, ISNOTMISSING=32, TEXT=33, WS=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'#'", "'\"'", "'('", "')'", "'where'", "'select'", "'count'", 
		"'insert'", "'into'", "'values'", "'rowkey'", "'ts'", "'is'", "'and'", 
		"'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", "'notequal'", 
		"'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", "'notbetween'", 
		"'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'", "TEXT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "LB", "RB", "WHERE", "SELECT", "COUNT", "INSERT", 
		"INTO", "VALUES", "ROWKEY", "TS", "IS", "AND", "OR", "LESSEQUAL", "LESS", 
		"GREATEREQUAL", "GREATER", "NOTEQUAL", "EQUAL", "NOTMATCH", "MATCH", "IN", 
		"NOTIN", "BETWEEN", "NOTBETWEEN", "ISNULL", "ISNOTNULL", "ISMISSING", 
		"ISNOTMISSING", "TEXT", "WS"
	};


	public StatementsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Statements.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 33: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4$\u011d\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\6\"\u0113\n\"\r\"\16"+
		"\"\u0114\3#\6#\u0118\n#\r#\16#\u0119\3#\3#\2$\3\3\1\5\4\1\7\5\1\t\6\1"+
		"\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20"+
		"\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63"+
		"\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\2\3\2\4\n##&&*-/"+
		"\60\62;>ACac\177\5\13\f\17\17\"\"\u011e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3"+
		"\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17W\3\2\2\2\21^\3\2\2\2\23d\3\2\2\2\25k"+
		"\3\2\2\2\27p\3\2\2\2\31w\3\2\2\2\33~\3\2\2\2\35\u0081\3\2\2\2\37\u0084"+
		"\3\2\2\2!\u0088\3\2\2\2#\u008b\3\2\2\2%\u0095\3\2\2\2\'\u009a\3\2\2\2"+
		")\u00a7\3\2\2\2+\u00af\3\2\2\2-\u00b8\3\2\2\2/\u00be\3\2\2\2\61\u00c7"+
		"\3\2\2\2\63\u00cd\3\2\2\2\65\u00d0\3\2\2\2\67\u00d6\3\2\2\29\u00de\3\2"+
		"\2\2;\u00e9\3\2\2\2=\u00f0\3\2\2\2?\u00fa\3\2\2\2A\u0104\3\2\2\2C\u0112"+
		"\3\2\2\2E\u0117\3\2\2\2GH\7.\2\2H\4\3\2\2\2IJ\7%\2\2J\6\3\2\2\2KL\7$\2"+
		"\2L\b\3\2\2\2MN\7*\2\2N\n\3\2\2\2OP\7+\2\2P\f\3\2\2\2QR\7y\2\2RS\7j\2"+
		"\2ST\7g\2\2TU\7t\2\2UV\7g\2\2V\16\3\2\2\2WX\7u\2\2XY\7g\2\2YZ\7n\2\2Z"+
		"[\7g\2\2[\\\7e\2\2\\]\7v\2\2]\20\3\2\2\2^_\7e\2\2_`\7q\2\2`a\7w\2\2ab"+
		"\7p\2\2bc\7v\2\2c\22\3\2\2\2de\7k\2\2ef\7p\2\2fg\7u\2\2gh\7g\2\2hi\7t"+
		"\2\2ij\7v\2\2j\24\3\2\2\2kl\7k\2\2lm\7p\2\2mn\7v\2\2no\7q\2\2o\26\3\2"+
		"\2\2pq\7x\2\2qr\7c\2\2rs\7n\2\2st\7w\2\2tu\7g\2\2uv\7u\2\2v\30\3\2\2\2"+
		"wx\7t\2\2xy\7q\2\2yz\7y\2\2z{\7m\2\2{|\7g\2\2|}\7{\2\2}\32\3\2\2\2~\177"+
		"\7v\2\2\177\u0080\7u\2\2\u0080\34\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7u\2\2\u0083\36\3\2\2\2\u0084\u0085\7c\2\2\u0085\u0086\7p\2\2\u0086\u0087"+
		"\7f\2\2\u0087 \3\2\2\2\u0088\u0089\7q\2\2\u0089\u008a\7t\2\2\u008a\"\3"+
		"\2\2\2\u008b\u008c\7n\2\2\u008c\u008d\7g\2\2\u008d\u008e\7u\2\2\u008e"+
		"\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\u0091\7s\2\2\u0091\u0092\7w\2\2"+
		"\u0092\u0093\7c\2\2\u0093\u0094\7n\2\2\u0094$\3\2\2\2\u0095\u0096\7n\2"+
		"\2\u0096\u0097\7g\2\2\u0097\u0098\7u\2\2\u0098\u0099\7u\2\2\u0099&\3\2"+
		"\2\2\u009a\u009b\7i\2\2\u009b\u009c\7t\2\2\u009c\u009d\7g\2\2\u009d\u009e"+
		"\7c\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7t\2\2\u00a1"+
		"\u00a2\7g\2\2\u00a2\u00a3\7s\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7c\2\2"+
		"\u00a5\u00a6\7n\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7i\2\2\u00a8\u00a9\7t\2"+
		"\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad"+
		"\7g\2\2\u00ad\u00ae\7t\2\2\u00ae*\3\2\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1"+
		"\7q\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7s\2\2\u00b4"+
		"\u00b5\7w\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7n\2\2\u00b7,\3\2\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00ba\7s\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7c\2\2"+
		"\u00bc\u00bd\7n\2\2\u00bd.\3\2\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7q\2"+
		"\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7o\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4"+
		"\7v\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7j\2\2\u00c6\60\3\2\2\2\u00c7\u00c8"+
		"\7o\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7e\2\2\u00cb"+
		"\u00cc\7j\2\2\u00cc\62\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"\64\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\u00d4\7k\2\2\u00d4\u00d5\7p\2\2\u00d5\66\3\2\2\2\u00d6\u00d7\7d\2\2\u00d7"+
		"\u00d8\7g\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7y\2\2\u00da\u00db\7g\2\2"+
		"\u00db\u00dc\7g\2\2\u00dc\u00dd\7p\2\2\u00dd8\3\2\2\2\u00de\u00df\7p\2"+
		"\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7d\2\2\u00e2\u00e3"+
		"\7g\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7y\2\2\u00e5\u00e6\7g\2\2\u00e6"+
		"\u00e7\7g\2\2\u00e7\u00e8\7p\2\2\u00e8:\3\2\2\2\u00e9\u00ea\7k\2\2\u00ea"+
		"\u00eb\7u\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7n\2\2"+
		"\u00ee\u00ef\7n\2\2\u00ef<\3\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7u\2"+
		"\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6"+
		"\7p\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7n\2\2\u00f9"+
		">\3\2\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7o\2\2\u00fd"+
		"\u00fe\7k\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7u\2\2\u0100\u0101\7k\2\2"+
		"\u0101\u0102\7p\2\2\u0102\u0103\7i\2\2\u0103@\3\2\2\2\u0104\u0105\7k\2"+
		"\2\u0105\u0106\7u\2\2\u0106\u0107\7p\2\2\u0107\u0108\7q\2\2\u0108\u0109"+
		"\7v\2\2\u0109\u010a\7o\2\2\u010a\u010b\7k\2\2\u010b\u010c\7u\2\2\u010c"+
		"\u010d\7u\2\2\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110\7i\2\2"+
		"\u0110B\3\2\2\2\u0111\u0113\t\2\2\2\u0112\u0111\3\2\2\2\u0113\u0114\3"+
		"\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115D\3\2\2\2\u0116\u0118"+
		"\t\3\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\b#\2\2\u011cF\3\2\2\2\5"+
		"\2\u0114\u0119";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}