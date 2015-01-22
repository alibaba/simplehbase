package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StatementsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, STAR=4, LB=5, RB=6, WHERE=7, SELECT=8, COUNT=9, 
		COUNTSUM=10, INSERT=11, DELETE=12, INTO=13, VALUES=14, FROM=15, ROWKEY=16, 
		STARTKEY=17, ENDKEY=18, HBASESTARTKEY=19, HBASEENDKEY=20, MAXVERSION=21, 
		LIMIT=22, TS=23, STARTTS=24, ENDTS=25, IS=26, NULL=27, NOT=28, AND=29, 
		OR=30, LESSEQUAL=31, LESS=32, GREATEREQUAL=33, GREATER=34, NOTEQUAL=35, 
		EQUAL=36, NOTMATCH=37, MATCH=38, IN=39, NOTIN=40, BETWEEN=41, NOTBETWEEN=42, 
		ISNULL=43, ISNOTNULL=44, ISMISSING=45, ISNOTMISSING=46, TEXT=47, WS=48;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'#'", "'\"'", "'*'", "'('", "')'", "'where'", "'select'", 
		"'count'", "'countsum'", "'insert'", "'delete'", "'into'", "'values'", 
		"'from'", "'rowkey'", "'startkey'", "'endkey'", "'hbasestartkey'", "'hbaseendkey'", 
		"'maxversion'", "'limit'", "'ts'", "'startTS'", "'endTS'", "'is'", "'null'", 
		"'not'", "'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", "'greater'", 
		"'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'", 
		"TEXT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_inserthqlc = 1, RULE_selecthqlc = 2, RULE_deletehqlc = 3, 
		RULE_counthqlc = 4, RULE_countsumhqlc = 5, RULE_selectc = 6, RULE_countc = 7, 
		RULE_countsumc = 8, RULE_wherec = 9, RULE_conditionc = 10, RULE_rowkeyrange = 11, 
		RULE_rowkeyexp = 12, RULE_tsrange = 13, RULE_tsexp = 14, RULE_selectCidList = 15, 
		RULE_cidList = 16, RULE_cid = 17, RULE_funcname = 18, RULE_constantList = 19, 
		RULE_constant2List = 20, RULE_constant2 = 21, RULE_maxversionexp = 22, 
		RULE_limitexp = 23, RULE_tablename = 24, RULE_maxversion = 25, RULE_constant = 26, 
		RULE_var = 27;
	public static final String[] ruleNames = {
		"prog", "inserthqlc", "selecthqlc", "deletehqlc", "counthqlc", "countsumhqlc", 
		"selectc", "countc", "countsumc", "wherec", "conditionc", "rowkeyrange", 
		"rowkeyexp", "tsrange", "tsexp", "selectCidList", "cidList", "cid", "funcname", 
		"constantList", "constant2List", "constant2", "maxversionexp", "limitexp", 
		"tablename", "maxversion", "constant", "var"
	};

	@Override
	public String getGrammarFileName() { return "Statements.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public StatementsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectclContext extends ProgContext {
		public SelectcContext selectc() {
			return getRuleContext(SelectcContext.class,0);
		}
		public SelectclContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitSelectcl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertHqlClContext extends ProgContext {
		public InserthqlcContext inserthqlc() {
			return getRuleContext(InserthqlcContext.class,0);
		}
		public InsertHqlClContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitInsertHqlCl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteHqlClContext extends ProgContext {
		public DeletehqlcContext deletehqlc() {
			return getRuleContext(DeletehqlcContext.class,0);
		}
		public DeleteHqlClContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitDeleteHqlCl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountclContext extends ProgContext {
		public CountcContext countc() {
			return getRuleContext(CountcContext.class,0);
		}
		public CountclContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountcl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountsumclContext extends ProgContext {
		public CountsumcContext countsumc() {
			return getRuleContext(CountsumcContext.class,0);
		}
		public CountsumclContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountsumcl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectHqlClContext extends ProgContext {
		public SelecthqlcContext selecthqlc() {
			return getRuleContext(SelecthqlcContext.class,0);
		}
		public SelectHqlClContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitSelectHqlCl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountHqlClContext extends ProgContext {
		public CounthqlcContext counthqlc() {
			return getRuleContext(CounthqlcContext.class,0);
		}
		public CountHqlClContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountHqlCl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountsumHqlClContext extends ProgContext {
		public CountsumhqlcContext countsumhqlc() {
			return getRuleContext(CountsumhqlcContext.class,0);
		}
		public CountsumHqlClContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountsumHqlCl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SelectclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56); selectc();
				}
				break;

			case 2:
				_localctx = new CountclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57); countc();
				}
				break;

			case 3:
				_localctx = new CountsumclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58); countsumc();
				}
				break;

			case 4:
				_localctx = new InsertHqlClContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(59); inserthqlc();
				}
				break;

			case 5:
				_localctx = new SelectHqlClContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60); selecthqlc();
				}
				break;

			case 6:
				_localctx = new DeleteHqlClContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(61); deletehqlc();
				}
				break;

			case 7:
				_localctx = new CountHqlClContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(62); counthqlc();
				}
				break;

			case 8:
				_localctx = new CountsumHqlClContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(63); countsumhqlc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InserthqlcContext extends ParserRuleContext {
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public TerminalNode IS(int i) {
			return getToken(StatementsParser.IS, i);
		}
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public CidListContext cidList() {
			return getRuleContext(CidListContext.class,0);
		}
		public Constant2ListContext constant2List() {
			return getRuleContext(Constant2ListContext.class,0);
		}
		public TerminalNode ROWKEY() { return getToken(StatementsParser.ROWKEY, 0); }
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(StatementsParser.INSERT, 0); }
		public List<TerminalNode> IS() { return getTokens(StatementsParser.IS); }
		public TerminalNode INTO() { return getToken(StatementsParser.INTO, 0); }
		public TerminalNode TS() { return getToken(StatementsParser.TS, 0); }
		public TerminalNode VALUES() { return getToken(StatementsParser.VALUES, 0); }
		public InserthqlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inserthqlc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitInserthqlc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InserthqlcContext inserthqlc() throws RecognitionException {
		InserthqlcContext _localctx = new InserthqlcContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inserthqlc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(INSERT);
			setState(67); match(INTO);
			setState(68); tablename();
			setState(69); cidList();
			setState(70); match(VALUES);
			setState(71); constant2List();
			setState(72); match(ROWKEY);
			setState(73); match(IS);
			setState(74); rowkeyexp();
			setState(78);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(75); match(TS);
				setState(76); match(IS);
				setState(77); tsexp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelecthqlcContext extends ParserRuleContext {
		public LimitexpContext limitexp() {
			return getRuleContext(LimitexpContext.class,0);
		}
		public TsrangeContext tsrange() {
			return getRuleContext(TsrangeContext.class,0);
		}
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StatementsParser.FROM, 0); }
		public MaxversionexpContext maxversionexp() {
			return getRuleContext(MaxversionexpContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(StatementsParser.SELECT, 0); }
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public SelectCidListContext selectCidList() {
			return getRuleContext(SelectCidListContext.class,0);
		}
		public SelecthqlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecthqlc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitSelecthqlc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecthqlcContext selecthqlc() throws RecognitionException {
		SelecthqlcContext _localctx = new SelecthqlcContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selecthqlc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(SELECT);
			setState(81); selectCidList();
			setState(82); match(FROM);
			setState(83); tablename();
			setState(85);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(84); wherec();
				}
			}

			setState(87); rowkeyrange();
			setState(89);
			_la = _input.LA(1);
			if (_la==MAXVERSION) {
				{
				setState(88); maxversionexp();
				}
			}

			setState(92);
			_la = _input.LA(1);
			if (_la==STARTTS || _la==ENDTS) {
				{
				setState(91); tsrange();
				}
			}

			setState(95);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(94); limitexp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeletehqlcContext extends ParserRuleContext {
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(StatementsParser.DELETE, 0); }
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StatementsParser.FROM, 0); }
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public TerminalNode TS() { return getToken(StatementsParser.TS, 0); }
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public SelectCidListContext selectCidList() {
			return getRuleContext(SelectCidListContext.class,0);
		}
		public DeletehqlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deletehqlc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitDeletehqlc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeletehqlcContext deletehqlc() throws RecognitionException {
		DeletehqlcContext _localctx = new DeletehqlcContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_deletehqlc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(DELETE);
			setState(98); selectCidList();
			setState(99); match(FROM);
			setState(100); tablename();
			setState(102);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(101); wherec();
				}
			}

			setState(104); rowkeyrange();
			setState(108);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(105); match(TS);
				setState(106); match(IS);
				setState(107); tsexp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CounthqlcContext extends ParserRuleContext {
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(StatementsParser.COUNT, 0); }
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StatementsParser.FROM, 0); }
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public CounthqlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_counthqlc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCounthqlc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CounthqlcContext counthqlc() throws RecognitionException {
		CounthqlcContext _localctx = new CounthqlcContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_counthqlc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(COUNT);
			setState(111); match(FROM);
			setState(112); tablename();
			setState(114);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(113); wherec();
				}
			}

			setState(116); rowkeyrange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CountsumhqlcContext extends ParserRuleContext {
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(StatementsParser.FROM, 0); }
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public SelectCidListContext selectCidList() {
			return getRuleContext(SelectCidListContext.class,0);
		}
		public TerminalNode COUNTSUM() { return getToken(StatementsParser.COUNTSUM, 0); }
		public CountsumhqlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countsumhqlc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountsumhqlc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountsumhqlcContext countsumhqlc() throws RecognitionException {
		CountsumhqlcContext _localctx = new CountsumhqlcContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_countsumhqlc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(COUNTSUM);
			setState(119); selectCidList();
			setState(120); match(FROM);
			setState(121); tablename();
			setState(123);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(122); wherec();
				}
			}

			setState(125); rowkeyrange();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectcContext extends ParserRuleContext {
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(StatementsParser.SELECT, 0); }
		public SelectcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitSelectc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectcContext selectc() throws RecognitionException {
		SelectcContext _localctx = new SelectcContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(SELECT);
			setState(128); wherec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CountcContext extends ParserRuleContext {
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(StatementsParser.COUNT, 0); }
		public CountcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountcContext countc() throws RecognitionException {
		CountcContext _localctx = new CountcContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_countc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(COUNT);
			setState(131); wherec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CountsumcContext extends ParserRuleContext {
		public CidListContext cidList() {
			return getRuleContext(CidListContext.class,0);
		}
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode COUNTSUM() { return getToken(StatementsParser.COUNTSUM, 0); }
		public CountsumcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countsumc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCountsumc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountsumcContext countsumc() throws RecognitionException {
		CountsumcContext _localctx = new CountsumcContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_countsumc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(COUNTSUM);
			setState(134); cidList();
			setState(136);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(135); wherec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WherecContext extends ParserRuleContext {
		public ConditioncContext conditionc() {
			return getRuleContext(ConditioncContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(StatementsParser.WHERE, 0); }
		public WherecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitWherec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WherecContext wherec() throws RecognitionException {
		WherecContext _localctx = new WherecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_wherec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(WHERE);
			setState(139); conditionc(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditioncContext extends ParserRuleContext {
		public int _p;
		public ConditioncContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConditioncContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_conditionc; }
	 
		public ConditioncContext() { }
		public void copyFrom(ConditioncContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class NotmatchconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode NOTMATCH() { return getToken(StatementsParser.NOTMATCH, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public NotmatchconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotmatchconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotbetweenconstantContext extends ConditioncContext {
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public TerminalNode AND() { return getToken(StatementsParser.AND, 0); }
		public TerminalNode NOTBETWEEN() { return getToken(StatementsParser.NOTBETWEEN, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public NotbetweenconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotbetweenconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotmatchvarContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode NOTMATCH() { return getToken(StatementsParser.NOTMATCH, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public NotmatchvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotmatchvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualvarContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(StatementsParser.EQUAL, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public EqualvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitEqualvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnotmissingcContext extends ConditioncContext {
		public TerminalNode ISNOTMISSING() { return getToken(StatementsParser.ISNOTMISSING, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public IsnotmissingcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitIsnotmissingc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotinconstantlistContext extends ConditioncContext {
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode NOTIN() { return getToken(StatementsParser.NOTIN, 0); }
		public NotinconstantlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotinconstantlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenvarContext extends ConditioncContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public TerminalNode AND() { return getToken(StatementsParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(StatementsParser.BETWEEN, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public BetweenvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitBetweenvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnotnullcContext extends ConditioncContext {
		public TerminalNode ISNOTNULL() { return getToken(StatementsParser.ISNOTNULL, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public IsnotnullcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitIsnotnullc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode LESS() { return getToken(StatementsParser.LESS, 0); }
		public LessconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitLessconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsmissingcContext extends ConditioncContext {
		public TerminalNode ISMISSING() { return getToken(StatementsParser.ISMISSING, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public IsmissingcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitIsmissingc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnullcContext extends ConditioncContext {
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode ISNULL() { return getToken(StatementsParser.ISNULL, 0); }
		public IsnullcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitIsnullc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionwrapperContext extends ConditioncContext {
		public ConditioncContext conditionc() {
			return getRuleContext(ConditioncContext.class,0);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public ConditionwrapperContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConditionwrapper(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(StatementsParser.GREATER, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public GreaterconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitGreaterconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(StatementsParser.EQUAL, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public EqualconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitEqualconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreatervarContext extends ConditioncContext {
		public TerminalNode GREATER() { return getToken(StatementsParser.GREATER, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public GreatervarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitGreatervar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchvarContext extends ConditioncContext {
		public TerminalNode MATCH() { return getToken(StatementsParser.MATCH, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public MatchvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitMatchvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterequalvarContext extends ConditioncContext {
		public TerminalNode GREATEREQUAL() { return getToken(StatementsParser.GREATEREQUAL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public GreaterequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitGreaterequalvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotbetweenvarContext extends ConditioncContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public TerminalNode AND() { return getToken(StatementsParser.AND, 0); }
		public TerminalNode NOTBETWEEN() { return getToken(StatementsParser.NOTBETWEEN, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public NotbetweenvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotbetweenvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrconditionContext extends ConditioncContext {
		public List<ConditioncContext> conditionc() {
			return getRuleContexts(ConditioncContext.class);
		}
		public ConditioncContext conditionc(int i) {
			return getRuleContext(ConditioncContext.class,i);
		}
		public TerminalNode OR() { return getToken(StatementsParser.OR, 0); }
		public OrconditionContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitOrcondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterequalconstantContext extends ConditioncContext {
		public TerminalNode GREATEREQUAL() { return getToken(StatementsParser.GREATEREQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public GreaterequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitGreaterequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvarlistContext extends ConditioncContext {
		public TerminalNode IN() { return getToken(StatementsParser.IN, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public InvarlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitInvarlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndconditionContext extends ConditioncContext {
		public List<ConditioncContext> conditionc() {
			return getRuleContexts(ConditioncContext.class);
		}
		public ConditioncContext conditionc(int i) {
			return getRuleContext(ConditioncContext.class,i);
		}
		public TerminalNode AND() { return getToken(StatementsParser.AND, 0); }
		public AndconditionContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitAndcondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotequalconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(StatementsParser.NOTEQUAL, 0); }
		public NotequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessequalvarContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode LESSEQUAL() { return getToken(StatementsParser.LESSEQUAL, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public LessequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitLessequalvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenconstantContext extends ConditioncContext {
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public TerminalNode AND() { return getToken(StatementsParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(StatementsParser.BETWEEN, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public BetweenconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitBetweenconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessvarContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode LESS() { return getToken(StatementsParser.LESS, 0); }
		public LessvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitLessvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessequalconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode LESSEQUAL() { return getToken(StatementsParser.LESSEQUAL, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public LessequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitLessequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotinvarlistContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode NOTIN() { return getToken(StatementsParser.NOTIN, 0); }
		public NotinvarlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotinvarlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InconstantlistContext extends ConditioncContext {
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public TerminalNode IN() { return getToken(StatementsParser.IN, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public InconstantlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitInconstantlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchconstantContext extends ConditioncContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode MATCH() { return getToken(StatementsParser.MATCH, 0); }
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public MatchconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitMatchconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotequalvarContext extends ConditioncContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CidContext cid() {
			return getRuleContext(CidContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(StatementsParser.NOTEQUAL, 0); }
		public NotequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitNotequalvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditioncContext conditionc(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditioncContext _localctx = new ConditioncContext(_ctx, _parentState, _p);
		ConditioncContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_conditionc);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionwrapperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(142); match(LB);
				setState(143); conditionc(0);
				setState(144); match(RB);
				}
				break;

			case 2:
				{
				_localctx = new EqualconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146); cid();
				setState(147); match(EQUAL);
				setState(148); constant();
				}
				break;

			case 3:
				{
				_localctx = new EqualvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150); cid();
				setState(151); match(EQUAL);
				setState(152); var();
				}
				break;

			case 4:
				{
				_localctx = new LessconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154); cid();
				setState(155); match(LESS);
				setState(156); constant();
				}
				break;

			case 5:
				{
				_localctx = new LessvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); cid();
				setState(159); match(LESS);
				setState(160); var();
				}
				break;

			case 6:
				{
				_localctx = new GreaterconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162); cid();
				setState(163); match(GREATER);
				setState(164); constant();
				}
				break;

			case 7:
				{
				_localctx = new GreatervarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166); cid();
				setState(167); match(GREATER);
				setState(168); var();
				}
				break;

			case 8:
				{
				_localctx = new LessequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170); cid();
				setState(171); match(LESSEQUAL);
				setState(172); constant();
				}
				break;

			case 9:
				{
				_localctx = new LessequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174); cid();
				setState(175); match(LESSEQUAL);
				setState(176); var();
				}
				break;

			case 10:
				{
				_localctx = new GreaterequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178); cid();
				setState(179); match(GREATEREQUAL);
				setState(180); constant();
				}
				break;

			case 11:
				{
				_localctx = new GreaterequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182); cid();
				setState(183); match(GREATEREQUAL);
				setState(184); var();
				}
				break;

			case 12:
				{
				_localctx = new NotequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186); cid();
				setState(187); match(NOTEQUAL);
				setState(188); constant();
				}
				break;

			case 13:
				{
				_localctx = new NotequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190); cid();
				setState(191); match(NOTEQUAL);
				setState(192); var();
				}
				break;

			case 14:
				{
				_localctx = new NotmatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194); cid();
				setState(195); match(NOTMATCH);
				setState(196); constant();
				}
				break;

			case 15:
				{
				_localctx = new NotmatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198); cid();
				setState(199); match(NOTMATCH);
				setState(200); var();
				}
				break;

			case 16:
				{
				_localctx = new MatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202); cid();
				setState(203); match(MATCH);
				setState(204); constant();
				}
				break;

			case 17:
				{
				_localctx = new MatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206); cid();
				setState(207); match(MATCH);
				setState(208); var();
				}
				break;

			case 18:
				{
				_localctx = new InconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); cid();
				setState(211); match(IN);
				setState(212); constantList();
				}
				break;

			case 19:
				{
				_localctx = new InvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); cid();
				setState(215); match(IN);
				setState(216); var();
				}
				break;

			case 20:
				{
				_localctx = new NotinconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218); cid();
				setState(219); match(NOTIN);
				setState(220); constantList();
				}
				break;

			case 21:
				{
				_localctx = new NotinvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); cid();
				setState(223); match(NOTIN);
				setState(224); var();
				}
				break;

			case 22:
				{
				_localctx = new BetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226); cid();
				setState(227); match(BETWEEN);
				setState(228); constant();
				setState(229); match(AND);
				setState(230); constant();
				}
				break;

			case 23:
				{
				_localctx = new BetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232); cid();
				setState(233); match(BETWEEN);
				setState(234); var();
				setState(235); match(AND);
				setState(236); var();
				}
				break;

			case 24:
				{
				_localctx = new NotbetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); cid();
				setState(239); match(NOTBETWEEN);
				setState(240); constant();
				setState(241); match(AND);
				setState(242); constant();
				}
				break;

			case 25:
				{
				_localctx = new NotbetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); cid();
				setState(245); match(NOTBETWEEN);
				setState(246); var();
				setState(247); match(AND);
				setState(248); var();
				}
				break;

			case 26:
				{
				_localctx = new IsnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250); cid();
				setState(251); match(ISNULL);
				}
				break;

			case 27:
				{
				_localctx = new IsnotnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253); cid();
				setState(254); match(ISNOTNULL);
				}
				break;

			case 28:
				{
				_localctx = new IsmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256); cid();
				setState(257); match(ISMISSING);
				}
				break;

			case 29:
				{
				_localctx = new IsnotmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259); cid();
				setState(260); match(ISNOTMISSING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(270);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new AndconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(264);
						if (!(30 >= _localctx._p)) throw new FailedPredicateException(this, "30 >= $_p");
						setState(265); match(AND);
						setState(266); conditionc(31);
						}
						break;

					case 2:
						{
						_localctx = new OrconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(267);
						if (!(29 >= _localctx._p)) throw new FailedPredicateException(this, "29 >= $_p");
						setState(268); match(OR);
						setState(269); conditionc(30);
						}
						break;
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RowkeyrangeContext extends ParserRuleContext {
		public RowkeyrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowkeyrange; }
	 
		public RowkeyrangeContext() { }
		public void copyFrom(RowkeyrangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Rowkeyrange_onerowkeyContext extends RowkeyrangeContext {
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public TerminalNode ROWKEY() { return getToken(StatementsParser.ROWKEY, 0); }
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public Rowkeyrange_onerowkeyContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkeyrange_onerowkey(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkeyrange_startAndEndContext extends RowkeyrangeContext {
		public TerminalNode STARTKEY() { return getToken(StatementsParser.STARTKEY, 0); }
		public TerminalNode IS(int i) {
			return getToken(StatementsParser.IS, i);
		}
		public TerminalNode ENDKEY() { return getToken(StatementsParser.ENDKEY, 0); }
		public List<RowkeyexpContext> rowkeyexp() {
			return getRuleContexts(RowkeyexpContext.class);
		}
		public RowkeyexpContext rowkeyexp(int i) {
			return getRuleContext(RowkeyexpContext.class,i);
		}
		public List<TerminalNode> IS() { return getTokens(StatementsParser.IS); }
		public Rowkeyrange_startAndEndContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkeyrange_startAndEnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkeyrange_endContext extends RowkeyrangeContext {
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public TerminalNode ENDKEY() { return getToken(StatementsParser.ENDKEY, 0); }
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public Rowkeyrange_endContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkeyrange_end(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkeyrange_startContext extends RowkeyrangeContext {
		public TerminalNode STARTKEY() { return getToken(StatementsParser.STARTKEY, 0); }
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public Rowkeyrange_startContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkeyrange_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyrangeContext rowkeyrange() throws RecognitionException {
		RowkeyrangeContext _localctx = new RowkeyrangeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rowkeyrange);
		try {
			setState(292);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new Rowkeyrange_startAndEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275); match(STARTKEY);
				setState(276); match(IS);
				setState(277); rowkeyexp();
				setState(278); match(1);
				setState(279); match(ENDKEY);
				setState(280); match(IS);
				setState(281); rowkeyexp();
				}
				break;

			case 2:
				_localctx = new Rowkeyrange_startContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(283); match(STARTKEY);
				setState(284); match(IS);
				setState(285); rowkeyexp();
				}
				break;

			case 3:
				_localctx = new Rowkeyrange_endContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(286); match(ENDKEY);
				setState(287); match(IS);
				setState(288); rowkeyexp();
				}
				break;

			case 4:
				_localctx = new Rowkeyrange_onerowkeyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(289); match(ROWKEY);
				setState(290); match(IS);
				setState(291); rowkeyexp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowkeyexpContext extends ParserRuleContext {
		public RowkeyexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowkeyexp; }
	 
		public RowkeyexpContext() { }
		public void copyFrom(RowkeyexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Rowkey_FuncConstantContext extends RowkeyexpContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public Rowkey_FuncConstantContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_FuncConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkey_hbasestartContext extends RowkeyexpContext {
		public TerminalNode HBASESTARTKEY() { return getToken(StatementsParser.HBASESTARTKEY, 0); }
		public Rowkey_hbasestartContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_hbasestart(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkey_hbaseendContext extends RowkeyexpContext {
		public TerminalNode HBASEENDKEY() { return getToken(StatementsParser.HBASEENDKEY, 0); }
		public Rowkey_hbaseendContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_hbaseend(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkey_WrapperContext extends RowkeyexpContext {
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public Rowkey_WrapperContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_Wrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyexpContext rowkeyexp() throws RecognitionException {
		RowkeyexpContext _localctx = new RowkeyexpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rowkeyexp);
		try {
			setState(305);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new Rowkey_WrapperContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294); match(LB);
				setState(295); rowkeyexp();
				setState(296); match(RB);
				}
				break;
			case TEXT:
				_localctx = new Rowkey_FuncConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(298); funcname();
				setState(299); match(LB);
				setState(300); constant();
				setState(301); match(RB);
				}
				break;
			case HBASESTARTKEY:
				_localctx = new Rowkey_hbasestartContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(303); match(HBASESTARTKEY);
				}
				break;
			case HBASEENDKEY:
				_localctx = new Rowkey_hbaseendContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(304); match(HBASEENDKEY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TsrangeContext extends ParserRuleContext {
		public TsrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsrange; }
	 
		public TsrangeContext() { }
		public void copyFrom(TsrangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Tsrange_startContext extends TsrangeContext {
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public TerminalNode STARTTS() { return getToken(StatementsParser.STARTTS, 0); }
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public Tsrange_startContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTsrange_start(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tsrange_endContext extends TsrangeContext {
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public TerminalNode IS() { return getToken(StatementsParser.IS, 0); }
		public TerminalNode ENDTS() { return getToken(StatementsParser.ENDTS, 0); }
		public Tsrange_endContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTsrange_end(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tsrange_startAndEndContext extends TsrangeContext {
		public List<TsexpContext> tsexp() {
			return getRuleContexts(TsexpContext.class);
		}
		public TerminalNode STARTTS() { return getToken(StatementsParser.STARTTS, 0); }
		public TerminalNode IS(int i) {
			return getToken(StatementsParser.IS, i);
		}
		public TsexpContext tsexp(int i) {
			return getRuleContext(TsexpContext.class,i);
		}
		public TerminalNode ENDTS() { return getToken(StatementsParser.ENDTS, 0); }
		public List<TerminalNode> IS() { return getTokens(StatementsParser.IS); }
		public Tsrange_startAndEndContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTsrange_startAndEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsrangeContext tsrange() throws RecognitionException {
		TsrangeContext _localctx = new TsrangeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tsrange);
		try {
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Tsrange_startAndEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307); match(STARTTS);
				setState(308); match(IS);
				setState(309); tsexp();
				setState(310); match(1);
				setState(311); match(ENDTS);
				setState(312); match(IS);
				setState(313); tsexp();
				}
				break;

			case 2:
				_localctx = new Tsrange_startContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315); match(STARTTS);
				setState(316); match(IS);
				setState(317); tsexp();
				}
				break;

			case 3:
				_localctx = new Tsrange_endContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(318); match(ENDTS);
				setState(319); match(IS);
				setState(320); tsexp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TsexpContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TsexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTsexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsexpContext tsexp() throws RecognitionException {
		TsexpContext _localctx = new TsexpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tsexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectCidListContext extends ParserRuleContext {
		public SelectCidListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectCidList; }
	 
		public SelectCidListContext() { }
		public void copyFrom(SelectCidListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CidList_CidListContext extends SelectCidListContext {
		public CidListContext cidList() {
			return getRuleContext(CidListContext.class,0);
		}
		public CidList_CidListContext(SelectCidListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCidList_CidList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CidList_RegxContext extends SelectCidListContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public CidList_RegxContext(SelectCidListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCidList_Regx(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CidList_StarContext extends SelectCidListContext {
		public TerminalNode STAR() { return getToken(StatementsParser.STAR, 0); }
		public CidList_StarContext(SelectCidListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCidList_Star(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectCidListContext selectCidList() throws RecognitionException {
		SelectCidListContext _localctx = new SelectCidListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_selectCidList);
		try {
			setState(328);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new CidList_CidListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(325); cidList();
				}
				break;
			case STAR:
				_localctx = new CidList_StarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(326); match(STAR);
				}
				break;
			case TEXT:
				_localctx = new CidList_RegxContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(327); match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CidListContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public CidContext cid(int i) {
			return getRuleContext(CidContext.class,i);
		}
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public List<CidContext> cid() {
			return getRuleContexts(CidContext.class);
		}
		public CidListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cidList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCidList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CidListContext cidList() throws RecognitionException {
		CidListContext _localctx = new CidListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cidList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(LB);
			setState(331); cid();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(332); match(1);
				setState(333); cid();
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CidContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public CidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cid; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitCid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CidContext cid() throws RecognitionException {
		CidContext _localctx = new CidContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantListContext extends ParserRuleContext {
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); match(LB);
			setState(346); constant();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(347); match(1);
				setState(348); constant();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant2ListContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public Constant2Context constant2(int i) {
			return getRuleContext(Constant2Context.class,i);
		}
		public List<Constant2Context> constant2() {
			return getRuleContexts(Constant2Context.class);
		}
		public Constant2ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant2List; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConstant2List(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant2ListContext constant2List() throws RecognitionException {
		Constant2ListContext _localctx = new Constant2ListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant2List);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); match(LB);
			setState(357); constant2();
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(358); match(1);
				setState(359); constant2();
				}
				}
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(365); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant2Context extends ParserRuleContext {
		public Constant2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant2; }
	 
		public Constant2Context() { }
		public void copyFrom(Constant2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Constant2_NotNullContext extends Constant2Context {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Constant2_NotNullContext(Constant2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConstant2_NotNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Constant2_NullContext extends Constant2Context {
		public TerminalNode NULL() { return getToken(StatementsParser.NULL, 0); }
		public Constant2_NullContext(Constant2Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConstant2_Null(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant2Context constant2() throws RecognitionException {
		Constant2Context _localctx = new Constant2Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_constant2);
		try {
			setState(369);
			switch (_input.LA(1)) {
			case 3:
				_localctx = new Constant2_NotNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(367); constant();
				}
				break;
			case NULL:
				_localctx = new Constant2_NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(368); match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaxversionexpContext extends ParserRuleContext {
		public MaxversionContext maxversion() {
			return getRuleContext(MaxversionContext.class,0);
		}
		public TerminalNode MAXVERSION() { return getToken(StatementsParser.MAXVERSION, 0); }
		public MaxversionexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxversionexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitMaxversionexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxversionexpContext maxversionexp() throws RecognitionException {
		MaxversionexpContext _localctx = new MaxversionexpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_maxversionexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371); match(MAXVERSION);
			setState(372); maxversion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitexpContext extends ParserRuleContext {
		public TerminalNode TEXT(int i) {
			return getToken(StatementsParser.TEXT, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(StatementsParser.TEXT); }
		public TerminalNode LIMIT() { return getToken(StatementsParser.LIMIT, 0); }
		public LimitexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitLimitexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitexpContext limitexp() throws RecognitionException {
		LimitexpContext _localctx = new LimitexpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_limitexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); match(LIMIT);
			setState(375); match(TEXT);
			setState(378);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(376); match(1);
				setState(377); match(TEXT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablenameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public TablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablename; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTablename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablenameContext tablename() throws RecognitionException {
		TablenameContext _localctx = new TablenameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaxversionContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public MaxversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxversion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitMaxversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxversionContext maxversion() throws RecognitionException {
		MaxversionContext _localctx = new MaxversionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_maxversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(3);
			setState(385); match(TEXT);
			setState(386); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(StatementsParser.TEXT, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); match(2);
			setState(389); match(TEXT);
			setState(390); match(2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10: return conditionc_sempred((ConditioncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditionc_sempred(ConditioncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 30 >= _localctx._p;

		case 1: return 29 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\62\u018b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2C\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3Q\n\3\3\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\5\4\\\n\4"+
		"\3\4\5\4_\n\4\3\4\5\4b\n\4\3\5\3\5\3\5\3\5\3\5\5\5i\n\5\3\5\3\5\3\5\3"+
		"\5\5\5o\n\5\3\6\3\6\3\6\3\6\5\6u\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7~"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u008b\n\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0109\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0111\n\f\f\f\16\f\u0114"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u0127\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u0134\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0144\n\17\3\20\3\20\3\21\3\21\3\21\5\21\u014b"+
		"\n\21\3\22\3\22\3\22\3\22\7\22\u0151\n\22\f\22\16\22\u0154\13\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u0160\n\25\f\25\16"+
		"\25\u0163\13\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u016b\n\26\f\26\16"+
		"\26\u016e\13\26\3\26\3\26\3\27\3\27\5\27\u0174\n\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\5\31\u017d\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668\2\2\u01ac\2B\3\2\2\2\4D\3\2\2\2\6R\3\2\2\2\bc\3"+
		"\2\2\2\np\3\2\2\2\fx\3\2\2\2\16\u0081\3\2\2\2\20\u0084\3\2\2\2\22\u0087"+
		"\3\2\2\2\24\u008c\3\2\2\2\26\u0108\3\2\2\2\30\u0126\3\2\2\2\32\u0133\3"+
		"\2\2\2\34\u0143\3\2\2\2\36\u0145\3\2\2\2 \u014a\3\2\2\2\"\u014c\3\2\2"+
		"\2$\u0157\3\2\2\2&\u0159\3\2\2\2(\u015b\3\2\2\2*\u0166\3\2\2\2,\u0173"+
		"\3\2\2\2.\u0175\3\2\2\2\60\u0178\3\2\2\2\62\u017e\3\2\2\2\64\u0180\3\2"+
		"\2\2\66\u0182\3\2\2\28\u0186\3\2\2\2:C\5\16\b\2;C\5\20\t\2<C\5\22\n\2"+
		"=C\5\4\3\2>C\5\6\4\2?C\5\b\5\2@C\5\n\6\2AC\5\f\7\2B:\3\2\2\2B;\3\2\2\2"+
		"B<\3\2\2\2B=\3\2\2\2B>\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\3\3\2\2"+
		"\2DE\7\r\2\2EF\7\17\2\2FG\5\62\32\2GH\5\"\22\2HI\7\20\2\2IJ\5*\26\2JK"+
		"\7\22\2\2KL\7\34\2\2LP\5\32\16\2MN\7\31\2\2NO\7\34\2\2OQ\5\36\20\2PM\3"+
		"\2\2\2PQ\3\2\2\2Q\5\3\2\2\2RS\7\n\2\2ST\5 \21\2TU\7\21\2\2UW\5\62\32\2"+
		"VX\5\24\13\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\5\30\r\2Z\\\5.\30\2[Z\3\2"+
		"\2\2[\\\3\2\2\2\\^\3\2\2\2]_\5\34\17\2^]\3\2\2\2^_\3\2\2\2_a\3\2\2\2`"+
		"b\5\60\31\2a`\3\2\2\2ab\3\2\2\2b\7\3\2\2\2cd\7\16\2\2de\5 \21\2ef\7\21"+
		"\2\2fh\5\62\32\2gi\5\24\13\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jn\5\30\r\2"+
		"kl\7\31\2\2lm\7\34\2\2mo\5\36\20\2nk\3\2\2\2no\3\2\2\2o\t\3\2\2\2pq\7"+
		"\13\2\2qr\7\21\2\2rt\5\62\32\2su\5\24\13\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2"+
		"\2vw\5\30\r\2w\13\3\2\2\2xy\7\f\2\2yz\5 \21\2z{\7\21\2\2{}\5\62\32\2|"+
		"~\5\24\13\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\5\30\r\2\u0080"+
		"\r\3\2\2\2\u0081\u0082\7\n\2\2\u0082\u0083\5\24\13\2\u0083\17\3\2\2\2"+
		"\u0084\u0085\7\13\2\2\u0085\u0086\5\24\13\2\u0086\21\3\2\2\2\u0087\u0088"+
		"\7\f\2\2\u0088\u008a\5\"\22\2\u0089\u008b\5\24\13\2\u008a\u0089\3\2\2"+
		"\2\u008a\u008b\3\2\2\2\u008b\23\3\2\2\2\u008c\u008d\7\t\2\2\u008d\u008e"+
		"\5\26\f\2\u008e\25\3\2\2\2\u008f\u0090\b\f\1\2\u0090\u0091\7\7\2\2\u0091"+
		"\u0092\5\26\f\2\u0092\u0093\7\b\2\2\u0093\u0109\3\2\2\2\u0094\u0095\5"+
		"$\23\2\u0095\u0096\7&\2\2\u0096\u0097\5\66\34\2\u0097\u0109\3\2\2\2\u0098"+
		"\u0099\5$\23\2\u0099\u009a\7&\2\2\u009a\u009b\58\35\2\u009b\u0109\3\2"+
		"\2\2\u009c\u009d\5$\23\2\u009d\u009e\7\"\2\2\u009e\u009f\5\66\34\2\u009f"+
		"\u0109\3\2\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2\7\"\2\2\u00a2\u00a3\58"+
		"\35\2\u00a3\u0109\3\2\2\2\u00a4\u00a5\5$\23\2\u00a5\u00a6\7$\2\2\u00a6"+
		"\u00a7\5\66\34\2\u00a7\u0109\3\2\2\2\u00a8\u00a9\5$\23\2\u00a9\u00aa\7"+
		"$\2\2\u00aa\u00ab\58\35\2\u00ab\u0109\3\2\2\2\u00ac\u00ad\5$\23\2\u00ad"+
		"\u00ae\7!\2\2\u00ae\u00af\5\66\34\2\u00af\u0109\3\2\2\2\u00b0\u00b1\5"+
		"$\23\2\u00b1\u00b2\7!\2\2\u00b2\u00b3\58\35\2\u00b3\u0109\3\2\2\2\u00b4"+
		"\u00b5\5$\23\2\u00b5\u00b6\7#\2\2\u00b6\u00b7\5\66\34\2\u00b7\u0109\3"+
		"\2\2\2\u00b8\u00b9\5$\23\2\u00b9\u00ba\7#\2\2\u00ba\u00bb\58\35\2\u00bb"+
		"\u0109\3\2\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\7%\2\2\u00be\u00bf\5\66"+
		"\34\2\u00bf\u0109\3\2\2\2\u00c0\u00c1\5$\23\2\u00c1\u00c2\7%\2\2\u00c2"+
		"\u00c3\58\35\2\u00c3\u0109\3\2\2\2\u00c4\u00c5\5$\23\2\u00c5\u00c6\7\'"+
		"\2\2\u00c6\u00c7\5\66\34\2\u00c7\u0109\3\2\2\2\u00c8\u00c9\5$\23\2\u00c9"+
		"\u00ca\7\'\2\2\u00ca\u00cb\58\35\2\u00cb\u0109\3\2\2\2\u00cc\u00cd\5$"+
		"\23\2\u00cd\u00ce\7(\2\2\u00ce\u00cf\5\66\34\2\u00cf\u0109\3\2\2\2\u00d0"+
		"\u00d1\5$\23\2\u00d1\u00d2\7(\2\2\u00d2\u00d3\58\35\2\u00d3\u0109\3\2"+
		"\2\2\u00d4\u00d5\5$\23\2\u00d5\u00d6\7)\2\2\u00d6\u00d7\5(\25\2\u00d7"+
		"\u0109\3\2\2\2\u00d8\u00d9\5$\23\2\u00d9\u00da\7)\2\2\u00da\u00db\58\35"+
		"\2\u00db\u0109\3\2\2\2\u00dc\u00dd\5$\23\2\u00dd\u00de\7*\2\2\u00de\u00df"+
		"\5(\25\2\u00df\u0109\3\2\2\2\u00e0\u00e1\5$\23\2\u00e1\u00e2\7*\2\2\u00e2"+
		"\u00e3\58\35\2\u00e3\u0109\3\2\2\2\u00e4\u00e5\5$\23\2\u00e5\u00e6\7+"+
		"\2\2\u00e6\u00e7\5\66\34\2\u00e7\u00e8\7\37\2\2\u00e8\u00e9\5\66\34\2"+
		"\u00e9\u0109\3\2\2\2\u00ea\u00eb\5$\23\2\u00eb\u00ec\7+\2\2\u00ec\u00ed"+
		"\58\35\2\u00ed\u00ee\7\37\2\2\u00ee\u00ef\58\35\2\u00ef\u0109\3\2\2\2"+
		"\u00f0\u00f1\5$\23\2\u00f1\u00f2\7,\2\2\u00f2\u00f3\5\66\34\2\u00f3\u00f4"+
		"\7\37\2\2\u00f4\u00f5\5\66\34\2\u00f5\u0109\3\2\2\2\u00f6\u00f7\5$\23"+
		"\2\u00f7\u00f8\7,\2\2\u00f8\u00f9\58\35\2\u00f9\u00fa\7\37\2\2\u00fa\u00fb"+
		"\58\35\2\u00fb\u0109\3\2\2\2\u00fc\u00fd\5$\23\2\u00fd\u00fe\7-\2\2\u00fe"+
		"\u0109\3\2\2\2\u00ff\u0100\5$\23\2\u0100\u0101\7.\2\2\u0101\u0109\3\2"+
		"\2\2\u0102\u0103\5$\23\2\u0103\u0104\7/\2\2\u0104\u0109\3\2\2\2\u0105"+
		"\u0106\5$\23\2\u0106\u0107\7\60\2\2\u0107\u0109\3\2\2\2\u0108\u008f\3"+
		"\2\2\2\u0108\u0094\3\2\2\2\u0108\u0098\3\2\2\2\u0108\u009c\3\2\2\2\u0108"+
		"\u00a0\3\2\2\2\u0108\u00a4\3\2\2\2\u0108\u00a8\3\2\2\2\u0108\u00ac\3\2"+
		"\2\2\u0108\u00b0\3\2\2\2\u0108\u00b4\3\2\2\2\u0108\u00b8\3\2\2\2\u0108"+
		"\u00bc\3\2\2\2\u0108\u00c0\3\2\2\2\u0108\u00c4\3\2\2\2\u0108\u00c8\3\2"+
		"\2\2\u0108\u00cc\3\2\2\2\u0108\u00d0\3\2\2\2\u0108\u00d4\3\2\2\2\u0108"+
		"\u00d8\3\2\2\2\u0108\u00dc\3\2\2\2\u0108\u00e0\3\2\2\2\u0108\u00e4\3\2"+
		"\2\2\u0108\u00ea\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00f6\3\2\2\2\u0108"+
		"\u00fc\3\2\2\2\u0108\u00ff\3\2\2\2\u0108\u0102\3\2\2\2\u0108\u0105\3\2"+
		"\2\2\u0109\u0112\3\2\2\2\u010a\u010b\6\f\2\3\u010b\u010c\7\37\2\2\u010c"+
		"\u0111\5\26\f\2\u010d\u010e\6\f\3\3\u010e\u010f\7 \2\2\u010f\u0111\5\26"+
		"\f\2\u0110\u010a\3\2\2\2\u0110\u010d\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\27\3\2\2\2\u0114\u0112\3\2\2"+
		"\2\u0115\u0116\7\23\2\2\u0116\u0117\7\34\2\2\u0117\u0118\5\32\16\2\u0118"+
		"\u0119\7\3\2\2\u0119\u011a\7\24\2\2\u011a\u011b\7\34\2\2\u011b\u011c\5"+
		"\32\16\2\u011c\u0127\3\2\2\2\u011d\u011e\7\23\2\2\u011e\u011f\7\34\2\2"+
		"\u011f\u0127\5\32\16\2\u0120\u0121\7\24\2\2\u0121\u0122\7\34\2\2\u0122"+
		"\u0127\5\32\16\2\u0123\u0124\7\22\2\2\u0124\u0125\7\34\2\2\u0125\u0127"+
		"\5\32\16\2\u0126\u0115\3\2\2\2\u0126\u011d\3\2\2\2\u0126\u0120\3\2\2\2"+
		"\u0126\u0123\3\2\2\2\u0127\31\3\2\2\2\u0128\u0129\7\7\2\2\u0129\u012a"+
		"\5\32\16\2\u012a\u012b\7\b\2\2\u012b\u0134\3\2\2\2\u012c\u012d\5&\24\2"+
		"\u012d\u012e\7\7\2\2\u012e\u012f\5\66\34\2\u012f\u0130\7\b\2\2\u0130\u0134"+
		"\3\2\2\2\u0131\u0134\7\25\2\2\u0132\u0134\7\26\2\2\u0133\u0128\3\2\2\2"+
		"\u0133\u012c\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134\33"+
		"\3\2\2\2\u0135\u0136\7\32\2\2\u0136\u0137\7\34\2\2\u0137\u0138\5\36\20"+
		"\2\u0138\u0139\7\3\2\2\u0139\u013a\7\33\2\2\u013a\u013b\7\34\2\2\u013b"+
		"\u013c\5\36\20\2\u013c\u0144\3\2\2\2\u013d\u013e\7\32\2\2\u013e\u013f"+
		"\7\34\2\2\u013f\u0144\5\36\20\2\u0140\u0141\7\33\2\2\u0141\u0142\7\34"+
		"\2\2\u0142\u0144\5\36\20\2\u0143\u0135\3\2\2\2\u0143\u013d\3\2\2\2\u0143"+
		"\u0140\3\2\2\2\u0144\35\3\2\2\2\u0145\u0146\5\66\34\2\u0146\37\3\2\2\2"+
		"\u0147\u014b\5\"\22\2\u0148\u014b\7\6\2\2\u0149\u014b\7\61\2\2\u014a\u0147"+
		"\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b!\3\2\2\2\u014c"+
		"\u014d\7\7\2\2\u014d\u0152\5$\23\2\u014e\u014f\7\3\2\2\u014f\u0151\5$"+
		"\23\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7\b"+
		"\2\2\u0156#\3\2\2\2\u0157\u0158\7\61\2\2\u0158%\3\2\2\2\u0159\u015a\7"+
		"\61\2\2\u015a\'\3\2\2\2\u015b\u015c\7\7\2\2\u015c\u0161\5\66\34\2\u015d"+
		"\u015e\7\3\2\2\u015e\u0160\5\66\34\2\u015f\u015d\3\2\2\2\u0160\u0163\3"+
		"\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0165\7\b\2\2\u0165)\3\2\2\2\u0166\u0167\7\7\2\2"+
		"\u0167\u016c\5,\27\2\u0168\u0169\7\3\2\2\u0169\u016b\5,\27\2\u016a\u0168"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\b\2\2\u0170+\3\2\2\2"+
		"\u0171\u0174\5\66\34\2\u0172\u0174\7\35\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0172\3\2\2\2\u0174-\3\2\2\2\u0175\u0176\7\27\2\2\u0176\u0177\5\64\33"+
		"\2\u0177/\3\2\2\2\u0178\u0179\7\30\2\2\u0179\u017c\7\61\2\2\u017a\u017b"+
		"\7\3\2\2\u017b\u017d\7\61\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2"+
		"\u017d\61\3\2\2\2\u017e\u017f\7\61\2\2\u017f\63\3\2\2\2\u0180\u0181\7"+
		"\61\2\2\u0181\65\3\2\2\2\u0182\u0183\7\5\2\2\u0183\u0184\7\61\2\2\u0184"+
		"\u0185\7\5\2\2\u0185\67\3\2\2\2\u0186\u0187\7\4\2\2\u0187\u0188\7\61\2"+
		"\2\u0188\u0189\7\4\2\2\u01899\3\2\2\2\31BPW[^ahnt}\u008a\u0108\u0110\u0112"+
		"\u0126\u0133\u0143\u014a\u0152\u0161\u016c\u0173\u017c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}