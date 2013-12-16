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
		TEXT=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'#'", "'\"'", "'('", "')'", "'where'", "'select'", "'count'", 
		"'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", 
		"'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "TEXT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "LB", "RB", "WHERE", "SELECT", "COUNT", "AND", 
		"OR", "LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", "NOTEQUAL", "EQUAL", 
		"NOTMATCH", "MATCH", "IN", "NOTIN", "BETWEEN", "NOTBETWEEN", "TEXT", "WS"
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
		case 23: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\32\u00c1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\6\30\u00b7\n\30\r\30\16\30\u00b8\3\31\6\31\u00bc\n\31\r\31\16\31"+
		"\u00bd\3\31\3\31\2\32\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n"+
		"\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%"+
		"\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\2\3\2\4\n##&&*-/\60\62;>AC"+
		"ac\177\5\13\f\17\17\"\"\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2"+
		"\7\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17C\3\2\2\2\21J\3\2\2"+
		"\2\23P\3\2\2\2\25T\3\2\2\2\27W\3\2\2\2\31a\3\2\2\2\33f\3\2\2\2\35s\3\2"+
		"\2\2\37{\3\2\2\2!\u0084\3\2\2\2#\u008a\3\2\2\2%\u0093\3\2\2\2\'\u0099"+
		"\3\2\2\2)\u009c\3\2\2\2+\u00a2\3\2\2\2-\u00aa\3\2\2\2/\u00b6\3\2\2\2\61"+
		"\u00bb\3\2\2\2\63\64\7.\2\2\64\4\3\2\2\2\65\66\7%\2\2\66\6\3\2\2\2\67"+
		"8\7$\2\28\b\3\2\2\29:\7*\2\2:\n\3\2\2\2;<\7+\2\2<\f\3\2\2\2=>\7y\2\2>"+
		"?\7j\2\2?@\7g\2\2@A\7t\2\2AB\7g\2\2B\16\3\2\2\2CD\7u\2\2DE\7g\2\2EF\7"+
		"n\2\2FG\7g\2\2GH\7e\2\2HI\7v\2\2I\20\3\2\2\2JK\7e\2\2KL\7q\2\2LM\7w\2"+
		"\2MN\7p\2\2NO\7v\2\2O\22\3\2\2\2PQ\7c\2\2QR\7p\2\2RS\7f\2\2S\24\3\2\2"+
		"\2TU\7q\2\2UV\7t\2\2V\26\3\2\2\2WX\7n\2\2XY\7g\2\2YZ\7u\2\2Z[\7u\2\2["+
		"\\\7g\2\2\\]\7s\2\2]^\7w\2\2^_\7c\2\2_`\7n\2\2`\30\3\2\2\2ab\7n\2\2bc"+
		"\7g\2\2cd\7u\2\2de\7u\2\2e\32\3\2\2\2fg\7i\2\2gh\7t\2\2hi\7g\2\2ij\7c"+
		"\2\2jk\7v\2\2kl\7g\2\2lm\7t\2\2mn\7g\2\2no\7s\2\2op\7w\2\2pq\7c\2\2qr"+
		"\7n\2\2r\34\3\2\2\2st\7i\2\2tu\7t\2\2uv\7g\2\2vw\7c\2\2wx\7v\2\2xy\7g"+
		"\2\2yz\7t\2\2z\36\3\2\2\2{|\7p\2\2|}\7q\2\2}~\7v\2\2~\177\7g\2\2\177\u0080"+
		"\7s\2\2\u0080\u0081\7w\2\2\u0081\u0082\7c\2\2\u0082\u0083\7n\2\2\u0083"+
		" \3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086\7s\2\2\u0086\u0087\7w\2\2\u0087"+
		"\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089\"\3\2\2\2\u008a\u008b\7p\2\2\u008b"+
		"\u008c\7q\2\2\u008c\u008d\7v\2\2\u008d\u008e\7o\2\2\u008e\u008f\7c\2\2"+
		"\u008f\u0090\7v\2\2\u0090\u0091\7e\2\2\u0091\u0092\7j\2\2\u0092$\3\2\2"+
		"\2\u0093\u0094\7o\2\2\u0094\u0095\7c\2\2\u0095\u0096\7v\2\2\u0096\u0097"+
		"\7e\2\2\u0097\u0098\7j\2\2\u0098&\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b"+
		"\7p\2\2\u009b(\3\2\2\2\u009c\u009d\7p\2\2\u009d\u009e\7q\2\2\u009e\u009f"+
		"\7v\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1*\3\2\2\2\u00a2\u00a3"+
		"\7d\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7y\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7p\2\2\u00a9,\3\2\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7d\2\2"+
		"\u00ae\u00af\7g\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7y\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4.\3\2\2\2\u00b5\u00b7"+
		"\t\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\60\3\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2"+
		"\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf\u00c0\b\31\2\2\u00c0\62\3\2\2\2\5\2\u00b8\u00bd";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}