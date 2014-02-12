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
		INSERT=10, DELETE=11, INTO=12, VALUES=13, FROM=14, ROWKEY=15, STARTROWKEY=16, 
		ENDROWKEY=17, MAXVERSION=18, RANGE=19, LIMIT=20, TS=21, IS=22, NULL=23, 
		NOT=24, AND=25, OR=26, LESSEQUAL=27, LESS=28, GREATEREQUAL=29, GREATER=30, 
		NOTEQUAL=31, EQUAL=32, NOTMATCH=33, MATCH=34, IN=35, NOTIN=36, BETWEEN=37, 
		NOTBETWEEN=38, ISNULL=39, ISNOTNULL=40, ISMISSING=41, ISNOTMISSING=42, 
		TEXT=43, WS=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'#'", "'\"'", "'*'", "'('", "')'", "'where'", "'select'", "'count'", 
		"'insert'", "'delete'", "'into'", "'values'", "'from'", "'rowkey'", "'startkey'", 
		"'endkey'", "'maxversion'", "'range'", "'limit'", "'ts'", "'is'", "'null'", 
		"'not'", "'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", 
		"'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'", 
		"TEXT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "STAR", "LB", "RB", "WHERE", "SELECT", "COUNT", 
		"INSERT", "DELETE", "INTO", "VALUES", "FROM", "ROWKEY", "STARTROWKEY", 
		"ENDROWKEY", "MAXVERSION", "RANGE", "LIMIT", "TS", "IS", "NULL", "NOT", 
		"AND", "OR", "LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", "NOTEQUAL", 
		"EQUAL", "NOTMATCH", "MATCH", "IN", "NOTIN", "BETWEEN", "NOTBETWEEN", 
		"ISNULL", "ISNOTNULL", "ISMISSING", "ISNOTMISSING", "TEXT", "WS"
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
		case 43: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4.\u016f\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3,\6,\u0165\n,\r,\16,\u0166\3-\6-\u016a\n-\r-\16-"+
		"\u016b\3-\3-\2.\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\2\3"+
		"\2\4\n##&&*-/\60\62<>ACac\177\5\13\f\17\17\"\"\u0170\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2"+
		"\re\3\2\2\2\17g\3\2\2\2\21m\3\2\2\2\23t\3\2\2\2\25z\3\2\2\2\27\u0081\3"+
		"\2\2\2\31\u0088\3\2\2\2\33\u008d\3\2\2\2\35\u0094\3\2\2\2\37\u0099\3\2"+
		"\2\2!\u00a0\3\2\2\2#\u00a9\3\2\2\2%\u00b0\3\2\2\2\'\u00bb\3\2\2\2)\u00c1"+
		"\3\2\2\2+\u00c7\3\2\2\2-\u00ca\3\2\2\2/\u00cd\3\2\2\2\61\u00d2\3\2\2\2"+
		"\63\u00d6\3\2\2\2\65\u00da\3\2\2\2\67\u00dd\3\2\2\29\u00e7\3\2\2\2;\u00ec"+
		"\3\2\2\2=\u00f9\3\2\2\2?\u0101\3\2\2\2A\u010a\3\2\2\2C\u0110\3\2\2\2E"+
		"\u0119\3\2\2\2G\u011f\3\2\2\2I\u0122\3\2\2\2K\u0128\3\2\2\2M\u0130\3\2"+
		"\2\2O\u013b\3\2\2\2Q\u0142\3\2\2\2S\u014c\3\2\2\2U\u0156\3\2\2\2W\u0164"+
		"\3\2\2\2Y\u0169\3\2\2\2[\\\7.\2\2\\\4\3\2\2\2]^\7%\2\2^\6\3\2\2\2_`\7"+
		"$\2\2`\b\3\2\2\2ab\7,\2\2b\n\3\2\2\2cd\7*\2\2d\f\3\2\2\2ef\7+\2\2f\16"+
		"\3\2\2\2gh\7y\2\2hi\7j\2\2ij\7g\2\2jk\7t\2\2kl\7g\2\2l\20\3\2\2\2mn\7"+
		"u\2\2no\7g\2\2op\7n\2\2pq\7g\2\2qr\7e\2\2rs\7v\2\2s\22\3\2\2\2tu\7e\2"+
		"\2uv\7q\2\2vw\7w\2\2wx\7p\2\2xy\7v\2\2y\24\3\2\2\2z{\7k\2\2{|\7p\2\2|"+
		"}\7u\2\2}~\7g\2\2~\177\7t\2\2\177\u0080\7v\2\2\u0080\26\3\2\2\2\u0081"+
		"\u0082\7f\2\2\u0082\u0083\7g\2\2\u0083\u0084\7n\2\2\u0084\u0085\7g\2\2"+
		"\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2\u0087\30\3\2\2\2\u0088\u0089\7"+
		"k\2\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c\7q\2\2\u008c\32"+
		"\3\2\2\2\u008d\u008e\7x\2\2\u008e\u008f\7c\2\2\u008f\u0090\7n\2\2\u0090"+
		"\u0091\7w\2\2\u0091\u0092\7g\2\2\u0092\u0093\7u\2\2\u0093\34\3\2\2\2\u0094"+
		"\u0095\7h\2\2\u0095\u0096\7t\2\2\u0096\u0097\7q\2\2\u0097\u0098\7o\2\2"+
		"\u0098\36\3\2\2\2\u0099\u009a\7t\2\2\u009a\u009b\7q\2\2\u009b\u009c\7"+
		"y\2\2\u009c\u009d\7m\2\2\u009d\u009e\7g\2\2\u009e\u009f\7{\2\2\u009f "+
		"\3\2\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7c\2\2\u00a3"+
		"\u00a4\7t\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7m\2\2\u00a6\u00a7\7g\2\2"+
		"\u00a7\u00a8\7{\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p"+
		"\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7m\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af"+
		"\7{\2\2\u00af$\3\2\2\2\u00b0\u00b1\7o\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3"+
		"\7z\2\2\u00b3\u00b4\7x\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7t\2\2\u00b6"+
		"\u00b7\7u\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7p\2\2"+
		"\u00ba&\3\2\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7p\2"+
		"\2\u00be\u00bf\7i\2\2\u00bf\u00c0\7g\2\2\u00c0(\3\2\2\2\u00c1\u00c2\7"+
		"n\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7o\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6*\3\2\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7u\2\2\u00c9,\3"+
		"\2\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2\u00cc.\3\2\2\2\u00cd\u00ce"+
		"\7p\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7n\2\2\u00d1"+
		"\60\3\2\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7v\2\2\u00d5"+
		"\62\3\2\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7f\2\2\u00d9"+
		"\64\3\2\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7t\2\2\u00dc\66\3\2\2\2\u00dd"+
		"\u00de\7n\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7u\2\2"+
		"\u00e1\u00e2\7g\2\2\u00e2\u00e3\7s\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5"+
		"\7c\2\2\u00e5\u00e6\7n\2\2\u00e68\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9"+
		"\7g\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7u\2\2\u00eb:\3\2\2\2\u00ec\u00ed"+
		"\7i\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7c\2\2\u00f0"+
		"\u00f1\7v\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7g\2\2"+
		"\u00f4\u00f5\7s\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8"+
		"\7n\2\2\u00f8<\3\2\2\2\u00f9\u00fa\7i\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc"+
		"\7g\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7g\2\2\u00ff"+
		"\u0100\7t\2\2\u0100>\3\2\2\2\u0101\u0102\7p\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7v\2\2\u0104\u0105\7g\2\2\u0105\u0106\7s\2\2\u0106\u0107\7w\2\2"+
		"\u0107\u0108\7c\2\2\u0108\u0109\7n\2\2\u0109@\3\2\2\2\u010a\u010b\7g\2"+
		"\2\u010b\u010c\7s\2\2\u010c\u010d\7w\2\2\u010d\u010e\7c\2\2\u010e\u010f"+
		"\7n\2\2\u010fB\3\2\2\2\u0110\u0111\7p\2\2\u0111\u0112\7q\2\2\u0112\u0113"+
		"\7v\2\2\u0113\u0114\7o\2\2\u0114\u0115\7c\2\2\u0115\u0116\7v\2\2\u0116"+
		"\u0117\7e\2\2\u0117\u0118\7j\2\2\u0118D\3\2\2\2\u0119\u011a\7o\2\2\u011a"+
		"\u011b\7c\2\2\u011b\u011c\7v\2\2\u011c\u011d\7e\2\2\u011d\u011e\7j\2\2"+
		"\u011eF\3\2\2\2\u011f\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121H\3\2\2\2\u0122"+
		"\u0123\7p\2\2\u0123\u0124\7q\2\2\u0124\u0125\7v\2\2\u0125\u0126\7k\2\2"+
		"\u0126\u0127\7p\2\2\u0127J\3\2\2\2\u0128\u0129\7d\2\2\u0129\u012a\7g\2"+
		"\2\u012a\u012b\7v\2\2\u012b\u012c\7y\2\2\u012c\u012d\7g\2\2\u012d\u012e"+
		"\7g\2\2\u012e\u012f\7p\2\2\u012fL\3\2\2\2\u0130\u0131\7p\2\2\u0131\u0132"+
		"\7q\2\2\u0132\u0133\7v\2\2\u0133\u0134\7d\2\2\u0134\u0135\7g\2\2\u0135"+
		"\u0136\7v\2\2\u0136\u0137\7y\2\2\u0137\u0138\7g\2\2\u0138\u0139\7g\2\2"+
		"\u0139\u013a\7p\2\2\u013aN\3\2\2\2\u013b\u013c\7k\2\2\u013c\u013d\7u\2"+
		"\2\u013d\u013e\7p\2\2\u013e\u013f\7w\2\2\u013f\u0140\7n\2\2\u0140\u0141"+
		"\7n\2\2\u0141P\3\2\2\2\u0142\u0143\7k\2\2\u0143\u0144\7u\2\2\u0144\u0145"+
		"\7p\2\2\u0145\u0146\7q\2\2\u0146\u0147\7v\2\2\u0147\u0148\7p\2\2\u0148"+
		"\u0149\7w\2\2\u0149\u014a\7n\2\2\u014a\u014b\7n\2\2\u014bR\3\2\2\2\u014c"+
		"\u014d\7k\2\2\u014d\u014e\7u\2\2\u014e\u014f\7o\2\2\u014f\u0150\7k\2\2"+
		"\u0150\u0151\7u\2\2\u0151\u0152\7u\2\2\u0152\u0153\7k\2\2\u0153\u0154"+
		"\7p\2\2\u0154\u0155\7i\2\2\u0155T\3\2\2\2\u0156\u0157\7k\2\2\u0157\u0158"+
		"\7u\2\2\u0158\u0159\7p\2\2\u0159\u015a\7q\2\2\u015a\u015b\7v\2\2\u015b"+
		"\u015c\7o\2\2\u015c\u015d\7k\2\2\u015d\u015e\7u\2\2\u015e\u015f\7u\2\2"+
		"\u015f\u0160\7k\2\2\u0160\u0161\7p\2\2\u0161\u0162\7i\2\2\u0162V\3\2\2"+
		"\2\u0163\u0165\t\2\2\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167X\3\2\2\2\u0168\u016a\t\3\2\2\u0169"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b-\2\2\u016eZ\3\2\2\2\5\2\u0166\u016b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}