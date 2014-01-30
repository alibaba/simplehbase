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
		T__2=1, T__1=2, T__0=3, STAR=4, LB=5, RB=6, WHERE=7, SELECT=8, COUNT=9, 
		INSERT=10, INTO=11, VALUES=12, FROM=13, ROWKEY=14, STARTROWKEY=15, ENDROWKEY=16, 
		MAXVERSION=17, RANGE=18, LIMIT=19, TS=20, IS=21, NULL=22, NOT=23, AND=24, 
		OR=25, LESSEQUAL=26, LESS=27, GREATEREQUAL=28, GREATER=29, NOTEQUAL=30, 
		EQUAL=31, NOTMATCH=32, MATCH=33, IN=34, NOTIN=35, BETWEEN=36, NOTBETWEEN=37, 
		ISNULL=38, ISNOTNULL=39, ISMISSING=40, ISNOTMISSING=41, TEXT=42, WS=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'#'", "'\"'", "'*'", "'('", "')'", "'where'", "'select'", "'count'", 
		"'insert'", "'into'", "'values'", "'from'", "'rowkey'", "'startkey'", 
		"'endkey'", "'maxversion'", "'range'", "'limit'", "'ts'", "'is'", "'null'", 
		"'not'", "'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", 
		"'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'", 
		"TEXT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "STAR", "LB", "RB", "WHERE", "SELECT", "COUNT", 
		"INSERT", "INTO", "VALUES", "FROM", "ROWKEY", "STARTROWKEY", "ENDROWKEY", 
		"MAXVERSION", "RANGE", "LIMIT", "TS", "IS", "NULL", "NOT", "AND", "OR", 
		"LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", "NOTEQUAL", "EQUAL", "NOTMATCH", 
		"MATCH", "IN", "NOTIN", "BETWEEN", "NOTBETWEEN", "ISNULL", "ISNOTNULL", 
		"ISMISSING", "ISNOTMISSING", "TEXT", "WS"
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
		case 42: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4-\u0167\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#"+
		"\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\6"+
		"+\u015d\n+\r+\16+\u015e\3,\6,\u0162\n,\r,\16,\u0163\3,\3,\2-\3\3\1\5\4"+
		"\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1"+
		"/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$"+
		"\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\2\3\2\4\n##&&*-/\60\62<>ACac\177"+
		"\5\13\f\17\17\"\"\u0168\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3"+
		"\2\2\2\t_\3\2\2\2\13b\3\2\2\2\rd\3\2\2\2\17f\3\2\2\2\21l\3\2\2\2\23s\3"+
		"\2\2\2\25y\3\2\2\2\27\u0080\3\2\2\2\31\u0085\3\2\2\2\33\u008c\3\2\2\2"+
		"\35\u0091\3\2\2\2\37\u0098\3\2\2\2!\u00a1\3\2\2\2#\u00a8\3\2\2\2%\u00b3"+
		"\3\2\2\2\'\u00b9\3\2\2\2)\u00bf\3\2\2\2+\u00c2\3\2\2\2-\u00c5\3\2\2\2"+
		"/\u00ca\3\2\2\2\61\u00ce\3\2\2\2\63\u00d2\3\2\2\2\65\u00d5\3\2\2\2\67"+
		"\u00df\3\2\2\29\u00e4\3\2\2\2;\u00f1\3\2\2\2=\u00f9\3\2\2\2?\u0102\3\2"+
		"\2\2A\u0108\3\2\2\2C\u0111\3\2\2\2E\u0117\3\2\2\2G\u011a\3\2\2\2I\u0120"+
		"\3\2\2\2K\u0128\3\2\2\2M\u0133\3\2\2\2O\u013a\3\2\2\2Q\u0144\3\2\2\2S"+
		"\u014e\3\2\2\2U\u015c\3\2\2\2W\u0161\3\2\2\2YZ\7.\2\2Z\4\3\2\2\2[\\\7"+
		"%\2\2\\\6\3\2\2\2]^\7$\2\2^\b\3\2\2\2_`\7^\2\2`a\7,\2\2a\n\3\2\2\2bc\7"+
		"*\2\2c\f\3\2\2\2de\7+\2\2e\16\3\2\2\2fg\7y\2\2gh\7j\2\2hi\7g\2\2ij\7t"+
		"\2\2jk\7g\2\2k\20\3\2\2\2lm\7u\2\2mn\7g\2\2no\7n\2\2op\7g\2\2pq\7e\2\2"+
		"qr\7v\2\2r\22\3\2\2\2st\7e\2\2tu\7q\2\2uv\7w\2\2vw\7p\2\2wx\7v\2\2x\24"+
		"\3\2\2\2yz\7k\2\2z{\7p\2\2{|\7u\2\2|}\7g\2\2}~\7t\2\2~\177\7v\2\2\177"+
		"\26\3\2\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7q\2\2\u0084\30\3\2\2\2\u0085\u0086\7x\2\2\u0086\u0087\7c\2\2\u0087"+
		"\u0088\7n\2\2\u0088\u0089\7w\2\2\u0089\u008a\7g\2\2\u008a\u008b\7u\2\2"+
		"\u008b\32\3\2\2\2\u008c\u008d\7h\2\2\u008d\u008e\7t\2\2\u008e\u008f\7"+
		"q\2\2\u008f\u0090\7o\2\2\u0090\34\3\2\2\2\u0091\u0092\7t\2\2\u0092\u0093"+
		"\7q\2\2\u0093\u0094\7y\2\2\u0094\u0095\7m\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7{\2\2\u0097\36\3\2\2\2\u0098\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a"+
		"\u009b\7c\2\2\u009b\u009c\7t\2\2\u009c\u009d\7v\2\2\u009d\u009e\7m\2\2"+
		"\u009e\u009f\7g\2\2\u009f\u00a0\7{\2\2\u00a0 \3\2\2\2\u00a1\u00a2\7g\2"+
		"\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7f\2\2\u00a4\u00a5\7m\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\u00a7\7{\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7o\2\2\u00a9\u00aa"+
		"\7c\2\2\u00aa\u00ab\7z\2\2\u00ab\u00ac\7x\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		"\u00ae\7t\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7q\2\2"+
		"\u00b1\u00b2\7p\2\2\u00b2$\3\2\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7c\2"+
		"\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7i\2\2\u00b7\u00b8\7g\2\2\u00b8&\3\2"+
		"\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd"+
		"\7k\2\2\u00bd\u00be\7v\2\2\u00be(\3\2\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1"+
		"\7u\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7u\2\2\u00c4,\3"+
		"\2\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7n\2\2\u00c8"+
		"\u00c9\7n\2\2\u00c9.\3\2\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7q\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd\60\3\2\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7p\2\2\u00d0"+
		"\u00d1\7f\2\2\u00d1\62\3\2\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7t\2\2\u00d4"+
		"\64\3\2\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7u\2\2\u00d8"+
		"\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7s\2\2\u00db\u00dc\7w\2\2"+
		"\u00dc\u00dd\7c\2\2\u00dd\u00de\7n\2\2\u00de\66\3\2\2\2\u00df\u00e0\7"+
		"n\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7u\2\2\u00e38"+
		"\3\2\2\2\u00e4\u00e5\7i\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7g\2\2\u00e7"+
		"\u00e8\7c\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7t\2\2"+
		"\u00eb\u00ec\7g\2\2\u00ec\u00ed\7s\2\2\u00ed\u00ee\7w\2\2\u00ee\u00ef"+
		"\7c\2\2\u00ef\u00f0\7n\2\2\u00f0:\3\2\2\2\u00f1\u00f2\7i\2\2\u00f2\u00f3"+
		"\7t\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7v\2\2\u00f6"+
		"\u00f7\7g\2\2\u00f7\u00f8\7t\2\2\u00f8<\3\2\2\2\u00f9\u00fa\7p\2\2\u00fa"+
		"\u00fb\7q\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7s\2\2"+
		"\u00fe\u00ff\7w\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7n\2\2\u0101>\3\2\2"+
		"\2\u0102\u0103\7g\2\2\u0103\u0104\7s\2\2\u0104\u0105\7w\2\2\u0105\u0106"+
		"\7c\2\2\u0106\u0107\7n\2\2\u0107@\3\2\2\2\u0108\u0109\7p\2\2\u0109\u010a"+
		"\7q\2\2\u010a\u010b\7v\2\2\u010b\u010c\7o\2\2\u010c\u010d\7c\2\2\u010d"+
		"\u010e\7v\2\2\u010e\u010f\7e\2\2\u010f\u0110\7j\2\2\u0110B\3\2\2\2\u0111"+
		"\u0112\7o\2\2\u0112\u0113\7c\2\2\u0113\u0114\7v\2\2\u0114\u0115\7e\2\2"+
		"\u0115\u0116\7j\2\2\u0116D\3\2\2\2\u0117\u0118\7k\2\2\u0118\u0119\7p\2"+
		"\2\u0119F\3\2\2\2\u011a\u011b\7p\2\2\u011b\u011c\7q\2\2\u011c\u011d\7"+
		"v\2\2\u011d\u011e\7k\2\2\u011e\u011f\7p\2\2\u011fH\3\2\2\2\u0120\u0121"+
		"\7d\2\2\u0121\u0122\7g\2\2\u0122\u0123\7v\2\2\u0123\u0124\7y\2\2\u0124"+
		"\u0125\7g\2\2\u0125\u0126\7g\2\2\u0126\u0127\7p\2\2\u0127J\3\2\2\2\u0128"+
		"\u0129\7p\2\2\u0129\u012a\7q\2\2\u012a\u012b\7v\2\2\u012b\u012c\7d\2\2"+
		"\u012c\u012d\7g\2\2\u012d\u012e\7v\2\2\u012e\u012f\7y\2\2\u012f\u0130"+
		"\7g\2\2\u0130\u0131\7g\2\2\u0131\u0132\7p\2\2\u0132L\3\2\2\2\u0133\u0134"+
		"\7k\2\2\u0134\u0135\7u\2\2\u0135\u0136\7p\2\2\u0136\u0137\7w\2\2\u0137"+
		"\u0138\7n\2\2\u0138\u0139\7n\2\2\u0139N\3\2\2\2\u013a\u013b\7k\2\2\u013b"+
		"\u013c\7u\2\2\u013c\u013d\7p\2\2\u013d\u013e\7q\2\2\u013e\u013f\7v\2\2"+
		"\u013f\u0140\7p\2\2\u0140\u0141\7w\2\2\u0141\u0142\7n\2\2\u0142\u0143"+
		"\7n\2\2\u0143P\3\2\2\2\u0144\u0145\7k\2\2\u0145\u0146\7u\2\2\u0146\u0147"+
		"\7o\2\2\u0147\u0148\7k\2\2\u0148\u0149\7u\2\2\u0149\u014a\7u\2\2\u014a"+
		"\u014b\7k\2\2\u014b\u014c\7p\2\2\u014c\u014d\7i\2\2\u014dR\3\2\2\2\u014e"+
		"\u014f\7k\2\2\u014f\u0150\7u\2\2\u0150\u0151\7p\2\2\u0151\u0152\7q\2\2"+
		"\u0152\u0153\7v\2\2\u0153\u0154\7o\2\2\u0154\u0155\7k\2\2\u0155\u0156"+
		"\7u\2\2\u0156\u0157\7u\2\2\u0157\u0158\7k\2\2\u0158\u0159\7p\2\2\u0159"+
		"\u015a\7i\2\2\u015aT\3\2\2\2\u015b\u015d\t\2\2\2\u015c\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015fV\3\2\2\2"+
		"\u0160\u0162\t\3\2\2\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0161"+
		"\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\b,\2\2\u0166"+
		"X\3\2\2\2\5\2\u015e\u0163";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}