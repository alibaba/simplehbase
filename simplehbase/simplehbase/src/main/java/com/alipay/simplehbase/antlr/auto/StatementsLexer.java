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
		T__2=1, T__1=2, T__0=3, LB=4, RB=5, WHERE=6, SELECT=7, COUNT=8, AND=9, 
		OR=10, LESSEQUAL=11, LESS=12, GREATEREQUAL=13, GREATER=14, NOTEQUAL=15, 
		EQUAL=16, NOTMATCH=17, MATCH=18, IN=19, NOTIN=20, BETWEEN=21, NOTBETWEEN=22, 
		ISNULL=23, ISNOTNULL=24, ISMISSING=25, ISNOTMISSING=26, TEXT=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'#'", "'\"'", "'('", "')'", "'where'", "'select'", "'count'", 
		"'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", 
		"'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'", 
		"TEXT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "LB", "RB", "WHERE", "SELECT", "COUNT", "AND", 
		"OR", "LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", "NOTEQUAL", "EQUAL", 
		"NOTMATCH", "MATCH", "IN", "NOTIN", "BETWEEN", "NOTBETWEEN", "ISNULL", 
		"ISNOTNULL", "ISMISSING", "ISNOTMISSING", "TEXT", "WS"
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
		case 27: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\36\u00f1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\6\34\u00e7\n\34\r\34\16\34\u00e8\3\35"+
		"\6\35\u00ec\n\35\r\35\16\35\u00ed\3\35\3\35\2\36\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1"+
		"\63\33\1\65\34\1\67\35\19\36\2\3\2\4\n##&&*-/\60\62;>ACac\177\5\13\f\17"+
		"\17\"\"\u00f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2\rE\3\2"+
		"\2\2\17K\3\2\2\2\21R\3\2\2\2\23X\3\2\2\2\25\\\3\2\2\2\27_\3\2\2\2\31i"+
		"\3\2\2\2\33n\3\2\2\2\35{\3\2\2\2\37\u0083\3\2\2\2!\u008c\3\2\2\2#\u0092"+
		"\3\2\2\2%\u009b\3\2\2\2\'\u00a1\3\2\2\2)\u00a4\3\2\2\2+\u00aa\3\2\2\2"+
		"-\u00b2\3\2\2\2/\u00bd\3\2\2\2\61\u00c4\3\2\2\2\63\u00ce\3\2\2\2\65\u00d8"+
		"\3\2\2\2\67\u00e6\3\2\2\29\u00eb\3\2\2\2;<\7.\2\2<\4\3\2\2\2=>\7%\2\2"+
		">\6\3\2\2\2?@\7$\2\2@\b\3\2\2\2AB\7*\2\2B\n\3\2\2\2CD\7+\2\2D\f\3\2\2"+
		"\2EF\7y\2\2FG\7j\2\2GH\7g\2\2HI\7t\2\2IJ\7g\2\2J\16\3\2\2\2KL\7u\2\2L"+
		"M\7g\2\2MN\7n\2\2NO\7g\2\2OP\7e\2\2PQ\7v\2\2Q\20\3\2\2\2RS\7e\2\2ST\7"+
		"q\2\2TU\7w\2\2UV\7p\2\2VW\7v\2\2W\22\3\2\2\2XY\7c\2\2YZ\7p\2\2Z[\7f\2"+
		"\2[\24\3\2\2\2\\]\7q\2\2]^\7t\2\2^\26\3\2\2\2_`\7n\2\2`a\7g\2\2ab\7u\2"+
		"\2bc\7u\2\2cd\7g\2\2de\7s\2\2ef\7w\2\2fg\7c\2\2gh\7n\2\2h\30\3\2\2\2i"+
		"j\7n\2\2jk\7g\2\2kl\7u\2\2lm\7u\2\2m\32\3\2\2\2no\7i\2\2op\7t\2\2pq\7"+
		"g\2\2qr\7c\2\2rs\7v\2\2st\7g\2\2tu\7t\2\2uv\7g\2\2vw\7s\2\2wx\7w\2\2x"+
		"y\7c\2\2yz\7n\2\2z\34\3\2\2\2{|\7i\2\2|}\7t\2\2}~\7g\2\2~\177\7c\2\2\177"+
		"\u0080\7v\2\2\u0080\u0081\7g\2\2\u0081\u0082\7t\2\2\u0082\36\3\2\2\2\u0083"+
		"\u0084\7p\2\2\u0084\u0085\7q\2\2\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2"+
		"\u0087\u0088\7s\2\2\u0088\u0089\7w\2\2\u0089\u008a\7c\2\2\u008a\u008b"+
		"\7n\2\2\u008b \3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e\7s\2\2\u008e\u008f"+
		"\7w\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2\u0091\"\3\2\2\2\u0092\u0093"+
		"\7p\2\2\u0093\u0094\7q\2\2\u0094\u0095\7v\2\2\u0095\u0096\7o\2\2\u0096"+
		"\u0097\7c\2\2\u0097\u0098\7v\2\2\u0098\u0099\7e\2\2\u0099\u009a\7j\2\2"+
		"\u009a$\3\2\2\2\u009b\u009c\7o\2\2\u009c\u009d\7c\2\2\u009d\u009e\7v\2"+
		"\2\u009e\u009f\7e\2\2\u009f\u00a0\7j\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7"+
		"k\2\2\u00a2\u00a3\7p\2\2\u00a3(\3\2\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6"+
		"\7q\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9"+
		"*\3\2\2\2\u00aa\u00ab\7d\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7v\2\2\u00ad"+
		"\u00ae\7y\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7p\2\2"+
		"\u00b1,\3\2\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7v\2"+
		"\2\u00b5\u00b6\7d\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9"+
		"\7y\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc"+
		".\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7p\2\2\u00c0"+
		"\u00c1\7w\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7n\2\2\u00c3\60\3\2\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7q\2\2"+
		"\u00c8\u00c9\7v\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc"+
		"\7n\2\2\u00cc\u00cd\7n\2\2\u00cd\62\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0"+
		"\7u\2\2\u00d0\u00d1\7o\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7u\2\2\u00d3"+
		"\u00d4\7u\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7i\2\2"+
		"\u00d7\64\3\2\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7"+
		"p\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7o\2\2\u00de\u00df"+
		"\7k\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7k\2\2\u00e2"+
		"\u00e3\7p\2\2\u00e3\u00e4\7i\2\2\u00e4\66\3\2\2\2\u00e5\u00e7\t\2\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e98\3\2\2\2\u00ea\u00ec\t\3\2\2\u00eb\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef\u00f0\b\35\2\2\u00f0:\3\2\2\2\5\2\u00e8\u00ed";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}