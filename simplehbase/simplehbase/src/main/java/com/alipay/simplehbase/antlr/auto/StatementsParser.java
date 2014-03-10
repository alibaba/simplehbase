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
		INSERT=10, DELETE=11, INTO=12, VALUES=13, FROM=14, ROWKEY=15, STARTROWKEY=16, 
		ENDROWKEY=17, MAXVERSION=18, RANGE=19, LIMIT=20, TS=21, IS=22, NULL=23, 
		NOT=24, AND=25, OR=26, LESSEQUAL=27, LESS=28, GREATEREQUAL=29, GREATER=30, 
		NOTEQUAL=31, EQUAL=32, NOTMATCH=33, MATCH=34, IN=35, NOTIN=36, BETWEEN=37, 
		NOTBETWEEN=38, ISNULL=39, ISNOTNULL=40, ISMISSING=41, ISNOTMISSING=42, 
		TEXT=43, WS=44;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'#'", "'\"'", "'*'", "'('", "')'", "'where'", "'select'", 
		"'count'", "'insert'", "'delete'", "'into'", "'values'", "'from'", "'rowkey'", 
		"'startkey'", "'endkey'", "'maxversion'", "'range'", "'limit'", "'ts'", 
		"'is'", "'null'", "'not'", "'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", 
		"'greater'", "'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", 
		"'notin'", "'between'", "'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", 
		"'isnotmissing'", "TEXT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_inserthqlc = 1, RULE_selecthqlc = 2, RULE_deletehqlc = 3, 
		RULE_selectc = 4, RULE_countc = 5, RULE_wherec = 6, RULE_conditionc = 7, 
		RULE_rowkeyrange = 8, RULE_rowkeyexp = 9, RULE_tsrange = 10, RULE_tsexp = 11, 
		RULE_selectCidList = 12, RULE_cidList = 13, RULE_cid = 14, RULE_funcname = 15, 
		RULE_constantList = 16, RULE_constant2List = 17, RULE_constant2 = 18, 
		RULE_maxversionexp = 19, RULE_limitexp = 20, RULE_tablename = 21, RULE_maxversion = 22, 
		RULE_constant = 23, RULE_var = 24;
	public static final String[] ruleNames = {
		"prog", "inserthqlc", "selecthqlc", "deletehqlc", "selectc", "countc", 
		"wherec", "conditionc", "rowkeyrange", "rowkeyexp", "tsrange", "tsexp", 
		"selectCidList", "cidList", "cid", "funcname", "constantList", "constant2List", 
		"constant2", "maxversionexp", "limitexp", "tablename", "maxversion", "constant", 
		"var"
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

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SelectclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50); selectc();
				}
				break;

			case 2:
				_localctx = new CountclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51); countc();
				}
				break;

			case 3:
				_localctx = new InsertHqlClContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52); inserthqlc();
				}
				break;

			case 4:
				_localctx = new SelectHqlClContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(53); selecthqlc();
				}
				break;

			case 5:
				_localctx = new DeleteHqlClContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(54); deletehqlc();
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
			setState(57); match(INSERT);
			setState(58); match(INTO);
			setState(59); tablename();
			setState(60); cidList();
			setState(61); match(VALUES);
			setState(62); constant2List();
			setState(63); match(ROWKEY);
			setState(64); match(IS);
			setState(65); rowkeyexp();
			setState(69);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(66); match(TS);
				setState(67); match(IS);
				setState(68); tsexp();
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
			setState(71); match(SELECT);
			setState(72); selectCidList();
			setState(73); match(FROM);
			setState(74); tablename();
			setState(76);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(75); wherec();
				}
			}

			setState(78); rowkeyrange();
			setState(80);
			_la = _input.LA(1);
			if (_la==MAXVERSION) {
				{
				setState(79); maxversionexp();
				}
			}

			setState(83);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(82); tsrange();
				}
			}

			setState(86);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(85); limitexp();
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
			setState(88); match(DELETE);
			setState(89); selectCidList();
			setState(90); match(FROM);
			setState(91); tablename();
			setState(93);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(92); wherec();
				}
			}

			setState(95); rowkeyrange();
			setState(99);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(96); match(TS);
				setState(97); match(IS);
				setState(98); tsexp();
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
		enterRule(_localctx, 8, RULE_selectc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(SELECT);
			setState(102); wherec();
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
		enterRule(_localctx, 10, RULE_countc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(COUNT);
			setState(105); wherec();
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
		enterRule(_localctx, 12, RULE_wherec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(WHERE);
			setState(108); conditionc(0);
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
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_conditionc);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionwrapperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(111); match(LB);
				setState(112); conditionc(0);
				setState(113); match(RB);
				}
				break;

			case 2:
				{
				_localctx = new EqualconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); cid();
				setState(116); match(EQUAL);
				setState(117); constant();
				}
				break;

			case 3:
				{
				_localctx = new EqualvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119); cid();
				setState(120); match(EQUAL);
				setState(121); var();
				}
				break;

			case 4:
				{
				_localctx = new LessconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123); cid();
				setState(124); match(LESS);
				setState(125); constant();
				}
				break;

			case 5:
				{
				_localctx = new LessvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127); cid();
				setState(128); match(LESS);
				setState(129); var();
				}
				break;

			case 6:
				{
				_localctx = new GreaterconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131); cid();
				setState(132); match(GREATER);
				setState(133); constant();
				}
				break;

			case 7:
				{
				_localctx = new GreatervarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135); cid();
				setState(136); match(GREATER);
				setState(137); var();
				}
				break;

			case 8:
				{
				_localctx = new LessequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139); cid();
				setState(140); match(LESSEQUAL);
				setState(141); constant();
				}
				break;

			case 9:
				{
				_localctx = new LessequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143); cid();
				setState(144); match(LESSEQUAL);
				setState(145); var();
				}
				break;

			case 10:
				{
				_localctx = new GreaterequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147); cid();
				setState(148); match(GREATEREQUAL);
				setState(149); constant();
				}
				break;

			case 11:
				{
				_localctx = new GreaterequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151); cid();
				setState(152); match(GREATEREQUAL);
				setState(153); var();
				}
				break;

			case 12:
				{
				_localctx = new NotequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155); cid();
				setState(156); match(NOTEQUAL);
				setState(157); constant();
				}
				break;

			case 13:
				{
				_localctx = new NotequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159); cid();
				setState(160); match(NOTEQUAL);
				setState(161); var();
				}
				break;

			case 14:
				{
				_localctx = new NotmatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163); cid();
				setState(164); match(NOTMATCH);
				setState(165); constant();
				}
				break;

			case 15:
				{
				_localctx = new NotmatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167); cid();
				setState(168); match(NOTMATCH);
				setState(169); var();
				}
				break;

			case 16:
				{
				_localctx = new MatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171); cid();
				setState(172); match(MATCH);
				setState(173); constant();
				}
				break;

			case 17:
				{
				_localctx = new MatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175); cid();
				setState(176); match(MATCH);
				setState(177); var();
				}
				break;

			case 18:
				{
				_localctx = new InconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); cid();
				setState(180); match(IN);
				setState(181); constantList();
				}
				break;

			case 19:
				{
				_localctx = new InvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183); cid();
				setState(184); match(IN);
				setState(185); var();
				}
				break;

			case 20:
				{
				_localctx = new NotinconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187); cid();
				setState(188); match(NOTIN);
				setState(189); constantList();
				}
				break;

			case 21:
				{
				_localctx = new NotinvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191); cid();
				setState(192); match(NOTIN);
				setState(193); var();
				}
				break;

			case 22:
				{
				_localctx = new BetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); cid();
				setState(196); match(BETWEEN);
				setState(197); constant();
				setState(198); match(AND);
				setState(199); constant();
				}
				break;

			case 23:
				{
				_localctx = new BetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201); cid();
				setState(202); match(BETWEEN);
				setState(203); var();
				setState(204); match(AND);
				setState(205); var();
				}
				break;

			case 24:
				{
				_localctx = new NotbetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207); cid();
				setState(208); match(NOTBETWEEN);
				setState(209); constant();
				setState(210); match(AND);
				setState(211); constant();
				}
				break;

			case 25:
				{
				_localctx = new NotbetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); cid();
				setState(214); match(NOTBETWEEN);
				setState(215); var();
				setState(216); match(AND);
				setState(217); var();
				}
				break;

			case 26:
				{
				_localctx = new IsnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219); cid();
				setState(220); match(ISNULL);
				}
				break;

			case 27:
				{
				_localctx = new IsnotnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); cid();
				setState(223); match(ISNOTNULL);
				}
				break;

			case 28:
				{
				_localctx = new IsmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225); cid();
				setState(226); match(ISMISSING);
				}
				break;

			case 29:
				{
				_localctx = new IsnotmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); cid();
				setState(229); match(ISNOTMISSING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(239);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AndconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(233);
						if (!(30 >= _localctx._p)) throw new FailedPredicateException(this, "30 >= $_p");
						setState(234); match(AND);
						setState(235); conditionc(31);
						}
						break;

					case 2:
						{
						_localctx = new OrconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(236);
						if (!(29 >= _localctx._p)) throw new FailedPredicateException(this, "29 >= $_p");
						setState(237); match(OR);
						setState(238); conditionc(30);
						}
						break;
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public TerminalNode RANGE() { return getToken(StatementsParser.RANGE, 0); }
		public List<RowkeyexpContext> rowkeyexp() {
			return getRuleContexts(RowkeyexpContext.class);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode ROWKEY() { return getToken(StatementsParser.ROWKEY, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public RowkeyexpContext rowkeyexp(int i) {
			return getRuleContext(RowkeyexpContext.class,i);
		}
		public RowkeyrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowkeyrange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkeyrange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyrangeContext rowkeyrange() throws RecognitionException {
		RowkeyrangeContext _localctx = new RowkeyrangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rowkeyrange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); match(ROWKEY);
			setState(245); match(RANGE);
			setState(246); match(LB);
			setState(247); rowkeyexp();
			setState(248); match(1);
			setState(249); rowkeyexp();
			setState(250); match(RB);
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
	public static class Rowkey_StartContext extends RowkeyexpContext {
		public TerminalNode STARTROWKEY() { return getToken(StatementsParser.STARTROWKEY, 0); }
		public Rowkey_StartContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_Start(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rowkey_EndContext extends RowkeyexpContext {
		public TerminalNode ENDROWKEY() { return getToken(StatementsParser.ENDROWKEY, 0); }
		public Rowkey_EndContext(RowkeyexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitRowkey_End(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyexpContext rowkeyexp() throws RecognitionException {
		RowkeyexpContext _localctx = new RowkeyexpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rowkeyexp);
		try {
			setState(263);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new Rowkey_WrapperContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252); match(LB);
				setState(253); rowkeyexp();
				setState(254); match(RB);
				}
				break;
			case TEXT:
				_localctx = new Rowkey_FuncConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256); funcname();
				setState(257); match(LB);
				setState(258); constant();
				setState(259); match(RB);
				}
				break;
			case STARTROWKEY:
				_localctx = new Rowkey_StartContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261); match(STARTROWKEY);
				}
				break;
			case ENDROWKEY:
				_localctx = new Rowkey_EndContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(262); match(ENDROWKEY);
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
		public List<TsexpContext> tsexp() {
			return getRuleContexts(TsexpContext.class);
		}
		public TerminalNode RANGE() { return getToken(StatementsParser.RANGE, 0); }
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public TsexpContext tsexp(int i) {
			return getRuleContext(TsexpContext.class,i);
		}
		public TerminalNode TS() { return getToken(StatementsParser.TS, 0); }
		public TsrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsrange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitTsrange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsrangeContext tsrange() throws RecognitionException {
		TsrangeContext _localctx = new TsrangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tsrange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(TS);
			setState(266); match(RANGE);
			setState(267); match(LB);
			setState(268); tsexp();
			setState(269); match(1);
			setState(270); tsexp();
			setState(271); match(RB);
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
		enterRule(_localctx, 22, RULE_tsexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); constant();
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
		enterRule(_localctx, 24, RULE_selectCidList);
		try {
			setState(278);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new CidList_CidListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275); cidList();
				}
				break;
			case STAR:
				_localctx = new CidList_StarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276); match(STAR);
				}
				break;
			case TEXT:
				_localctx = new CidList_RegxContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277); match(TEXT);
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
		enterRule(_localctx, 26, RULE_cidList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(LB);
			setState(281); cid();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(282); match(1);
				setState(283); cid();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289); match(RB);
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
		enterRule(_localctx, 28, RULE_cid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(TEXT);
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
		enterRule(_localctx, 30, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(TEXT);
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
		enterRule(_localctx, 32, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); match(LB);
			setState(296); constant();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(297); match(1);
				setState(298); constant();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304); match(RB);
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
		enterRule(_localctx, 34, RULE_constant2List);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); match(LB);
			setState(307); constant2();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(308); match(1);
				setState(309); constant2();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315); match(RB);
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
		enterRule(_localctx, 36, RULE_constant2);
		try {
			setState(319);
			switch (_input.LA(1)) {
			case 3:
				_localctx = new Constant2_NotNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(317); constant();
				}
				break;
			case NULL:
				_localctx = new Constant2_NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(318); match(NULL);
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
		enterRule(_localctx, 38, RULE_maxversionexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321); match(MAXVERSION);
			setState(322); maxversion();
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
		enterRule(_localctx, 40, RULE_limitexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(LIMIT);
			setState(325); match(TEXT);
			setState(328);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(326); match(1);
				setState(327); match(TEXT);
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
		enterRule(_localctx, 42, RULE_tablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(TEXT);
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
		enterRule(_localctx, 44, RULE_maxversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(TEXT);
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
		enterRule(_localctx, 46, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(3);
			setState(335); match(TEXT);
			setState(336); match(3);
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
		enterRule(_localctx, 48, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); match(2);
			setState(339); match(TEXT);
			setState(340); match(2);
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
		case 7: return conditionc_sempred((ConditioncContext)_localctx, predIndex);
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
		"\2\3.\u0159\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\5\2:\n\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\4\3\4\5"+
		"\4O\n\4\3\4\3\4\5\4S\n\4\3\4\5\4V\n\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\5\5`\n\5\3\5\3\5\3\5\3\5\5\5f\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ea"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f2\n\t\f\t\16\t\u00f5\13\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u010a\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\5\16\u0119\n\16\3\17\3\17\3\17\3\17\7\17\u011f\n\17\f\17\16"+
		"\17\u0122\13\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22"+
		"\u012e\n\22\f\22\16\22\u0131\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23"+
		"\u0139\n\23\f\23\16\23\u013c\13\23\3\23\3\23\3\24\3\24\5\24\u0142\n\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u014b\n\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\2\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\u0172\29\3\2\2\2\4;\3\2\2\2\6I\3"+
		"\2\2\2\bZ\3\2\2\2\ng\3\2\2\2\fj\3\2\2\2\16m\3\2\2\2\20\u00e9\3\2\2\2\22"+
		"\u00f6\3\2\2\2\24\u0109\3\2\2\2\26\u010b\3\2\2\2\30\u0113\3\2\2\2\32\u0118"+
		"\3\2\2\2\34\u011a\3\2\2\2\36\u0125\3\2\2\2 \u0127\3\2\2\2\"\u0129\3\2"+
		"\2\2$\u0134\3\2\2\2&\u0141\3\2\2\2(\u0143\3\2\2\2*\u0146\3\2\2\2,\u014c"+
		"\3\2\2\2.\u014e\3\2\2\2\60\u0150\3\2\2\2\62\u0154\3\2\2\2\64:\5\n\6\2"+
		"\65:\5\f\7\2\66:\5\4\3\2\67:\5\6\4\28:\5\b\5\29\64\3\2\2\29\65\3\2\2\2"+
		"9\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\3\3\2\2\2;<\7\f\2\2<=\7\16\2\2=>\5"+
		",\27\2>?\5\34\17\2?@\7\17\2\2@A\5$\23\2AB\7\21\2\2BC\7\30\2\2CG\5\24\13"+
		"\2DE\7\27\2\2EF\7\30\2\2FH\5\30\r\2GD\3\2\2\2GH\3\2\2\2H\5\3\2\2\2IJ\7"+
		"\n\2\2JK\5\32\16\2KL\7\20\2\2LN\5,\27\2MO\5\16\b\2NM\3\2\2\2NO\3\2\2\2"+
		"OP\3\2\2\2PR\5\22\n\2QS\5(\25\2RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2TV\5\26\f"+
		"\2UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2WY\5*\26\2XW\3\2\2\2XY\3\2\2\2Y\7\3\2"+
		"\2\2Z[\7\r\2\2[\\\5\32\16\2\\]\7\20\2\2]_\5,\27\2^`\5\16\b\2_^\3\2\2\2"+
		"_`\3\2\2\2`a\3\2\2\2ae\5\22\n\2bc\7\27\2\2cd\7\30\2\2df\5\30\r\2eb\3\2"+
		"\2\2ef\3\2\2\2f\t\3\2\2\2gh\7\n\2\2hi\5\16\b\2i\13\3\2\2\2jk\7\13\2\2"+
		"kl\5\16\b\2l\r\3\2\2\2mn\7\t\2\2no\5\20\t\2o\17\3\2\2\2pq\b\t\1\2qr\7"+
		"\7\2\2rs\5\20\t\2st\7\b\2\2t\u00ea\3\2\2\2uv\5\36\20\2vw\7\"\2\2wx\5\60"+
		"\31\2x\u00ea\3\2\2\2yz\5\36\20\2z{\7\"\2\2{|\5\62\32\2|\u00ea\3\2\2\2"+
		"}~\5\36\20\2~\177\7\36\2\2\177\u0080\5\60\31\2\u0080\u00ea\3\2\2\2\u0081"+
		"\u0082\5\36\20\2\u0082\u0083\7\36\2\2\u0083\u0084\5\62\32\2\u0084\u00ea"+
		"\3\2\2\2\u0085\u0086\5\36\20\2\u0086\u0087\7 \2\2\u0087\u0088\5\60\31"+
		"\2\u0088\u00ea\3\2\2\2\u0089\u008a\5\36\20\2\u008a\u008b\7 \2\2\u008b"+
		"\u008c\5\62\32\2\u008c\u00ea\3\2\2\2\u008d\u008e\5\36\20\2\u008e\u008f"+
		"\7\35\2\2\u008f\u0090\5\60\31\2\u0090\u00ea\3\2\2\2\u0091\u0092\5\36\20"+
		"\2\u0092\u0093\7\35\2\2\u0093\u0094\5\62\32\2\u0094\u00ea\3\2\2\2\u0095"+
		"\u0096\5\36\20\2\u0096\u0097\7\37\2\2\u0097\u0098\5\60\31\2\u0098\u00ea"+
		"\3\2\2\2\u0099\u009a\5\36\20\2\u009a\u009b\7\37\2\2\u009b\u009c\5\62\32"+
		"\2\u009c\u00ea\3\2\2\2\u009d\u009e\5\36\20\2\u009e\u009f\7!\2\2\u009f"+
		"\u00a0\5\60\31\2\u00a0\u00ea\3\2\2\2\u00a1\u00a2\5\36\20\2\u00a2\u00a3"+
		"\7!\2\2\u00a3\u00a4\5\62\32\2\u00a4\u00ea\3\2\2\2\u00a5\u00a6\5\36\20"+
		"\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\5\60\31\2\u00a8\u00ea\3\2\2\2\u00a9"+
		"\u00aa\5\36\20\2\u00aa\u00ab\7#\2\2\u00ab\u00ac\5\62\32\2\u00ac\u00ea"+
		"\3\2\2\2\u00ad\u00ae\5\36\20\2\u00ae\u00af\7$\2\2\u00af\u00b0\5\60\31"+
		"\2\u00b0\u00ea\3\2\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7$\2\2\u00b3"+
		"\u00b4\5\62\32\2\u00b4\u00ea\3\2\2\2\u00b5\u00b6\5\36\20\2\u00b6\u00b7"+
		"\7%\2\2\u00b7\u00b8\5\"\22\2\u00b8\u00ea\3\2\2\2\u00b9\u00ba\5\36\20\2"+
		"\u00ba\u00bb\7%\2\2\u00bb\u00bc\5\62\32\2\u00bc\u00ea\3\2\2\2\u00bd\u00be"+
		"\5\36\20\2\u00be\u00bf\7&\2\2\u00bf\u00c0\5\"\22\2\u00c0\u00ea\3\2\2\2"+
		"\u00c1\u00c2\5\36\20\2\u00c2\u00c3\7&\2\2\u00c3\u00c4\5\62\32\2\u00c4"+
		"\u00ea\3\2\2\2\u00c5\u00c6\5\36\20\2\u00c6\u00c7\7\'\2\2\u00c7\u00c8\5"+
		"\60\31\2\u00c8\u00c9\7\33\2\2\u00c9\u00ca\5\60\31\2\u00ca\u00ea\3\2\2"+
		"\2\u00cb\u00cc\5\36\20\2\u00cc\u00cd\7\'\2\2\u00cd\u00ce\5\62\32\2\u00ce"+
		"\u00cf\7\33\2\2\u00cf\u00d0\5\62\32\2\u00d0\u00ea\3\2\2\2\u00d1\u00d2"+
		"\5\36\20\2\u00d2\u00d3\7(\2\2\u00d3\u00d4\5\60\31\2\u00d4\u00d5\7\33\2"+
		"\2\u00d5\u00d6\5\60\31\2\u00d6\u00ea\3\2\2\2\u00d7\u00d8\5\36\20\2\u00d8"+
		"\u00d9\7(\2\2\u00d9\u00da\5\62\32\2\u00da\u00db\7\33\2\2\u00db\u00dc\5"+
		"\62\32\2\u00dc\u00ea\3\2\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\7)\2\2"+
		"\u00df\u00ea\3\2\2\2\u00e0\u00e1\5\36\20\2\u00e1\u00e2\7*\2\2\u00e2\u00ea"+
		"\3\2\2\2\u00e3\u00e4\5\36\20\2\u00e4\u00e5\7+\2\2\u00e5\u00ea\3\2\2\2"+
		"\u00e6\u00e7\5\36\20\2\u00e7\u00e8\7,\2\2\u00e8\u00ea\3\2\2\2\u00e9p\3"+
		"\2\2\2\u00e9u\3\2\2\2\u00e9y\3\2\2\2\u00e9}\3\2\2\2\u00e9\u0081\3\2\2"+
		"\2\u00e9\u0085\3\2\2\2\u00e9\u0089\3\2\2\2\u00e9\u008d\3\2\2\2\u00e9\u0091"+
		"\3\2\2\2\u00e9\u0095\3\2\2\2\u00e9\u0099\3\2\2\2\u00e9\u009d\3\2\2\2\u00e9"+
		"\u00a1\3\2\2\2\u00e9\u00a5\3\2\2\2\u00e9\u00a9\3\2\2\2\u00e9\u00ad\3\2"+
		"\2\2\u00e9\u00b1\3\2\2\2\u00e9\u00b5\3\2\2\2\u00e9\u00b9\3\2\2\2\u00e9"+
		"\u00bd\3\2\2\2\u00e9\u00c1\3\2\2\2\u00e9\u00c5\3\2\2\2\u00e9\u00cb\3\2"+
		"\2\2\u00e9\u00d1\3\2\2\2\u00e9\u00d7\3\2\2\2\u00e9\u00dd\3\2\2\2\u00e9"+
		"\u00e0\3\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e6\3\2\2\2\u00ea\u00f3\3\2"+
		"\2\2\u00eb\u00ec\6\t\2\3\u00ec\u00ed\7\33\2\2\u00ed\u00f2\5\20\t\2\u00ee"+
		"\u00ef\6\t\3\3\u00ef\u00f0\7\34\2\2\u00f0\u00f2\5\20\t\2\u00f1\u00eb\3"+
		"\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\21\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7\21\2"+
		"\2\u00f7\u00f8\7\25\2\2\u00f8\u00f9\7\7\2\2\u00f9\u00fa\5\24\13\2\u00fa"+
		"\u00fb\7\3\2\2\u00fb\u00fc\5\24\13\2\u00fc\u00fd\7\b\2\2\u00fd\23\3\2"+
		"\2\2\u00fe\u00ff\7\7\2\2\u00ff\u0100\5\24\13\2\u0100\u0101\7\b\2\2\u0101"+
		"\u010a\3\2\2\2\u0102\u0103\5 \21\2\u0103\u0104\7\7\2\2\u0104\u0105\5\60"+
		"\31\2\u0105\u0106\7\b\2\2\u0106\u010a\3\2\2\2\u0107\u010a\7\22\2\2\u0108"+
		"\u010a\7\23\2\2\u0109\u00fe\3\2\2\2\u0109\u0102\3\2\2\2\u0109\u0107\3"+
		"\2\2\2\u0109\u0108\3\2\2\2\u010a\25\3\2\2\2\u010b\u010c\7\27\2\2\u010c"+
		"\u010d\7\25\2\2\u010d\u010e\7\7\2\2\u010e\u010f\5\30\r\2\u010f\u0110\7"+
		"\3\2\2\u0110\u0111\5\30\r\2\u0111\u0112\7\b\2\2\u0112\27\3\2\2\2\u0113"+
		"\u0114\5\60\31\2\u0114\31\3\2\2\2\u0115\u0119\5\34\17\2\u0116\u0119\7"+
		"\6\2\2\u0117\u0119\7-\2\2\u0118\u0115\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0117\3\2\2\2\u0119\33\3\2\2\2\u011a\u011b\7\7\2\2\u011b\u0120\5\36\20"+
		"\2\u011c\u011d\7\3\2\2\u011d\u011f\5\36\20\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\b\2\2\u0124\35\3\2\2\2\u0125\u0126"+
		"\7-\2\2\u0126\37\3\2\2\2\u0127\u0128\7-\2\2\u0128!\3\2\2\2\u0129\u012a"+
		"\7\7\2\2\u012a\u012f\5\60\31\2\u012b\u012c\7\3\2\2\u012c\u012e\5\60\31"+
		"\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7\b\2\2\u0133"+
		"#\3\2\2\2\u0134\u0135\7\7\2\2\u0135\u013a\5&\24\2\u0136\u0137\7\3\2\2"+
		"\u0137\u0139\5&\24\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013e\7\b\2\2\u013e%\3\2\2\2\u013f\u0142\5\60\31\2\u0140\u0142\7\31\2"+
		"\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\'\3\2\2\2\u0143\u0144"+
		"\7\24\2\2\u0144\u0145\5.\30\2\u0145)\3\2\2\2\u0146\u0147\7\26\2\2\u0147"+
		"\u014a\7-\2\2\u0148\u0149\7\3\2\2\u0149\u014b\7-\2\2\u014a\u0148\3\2\2"+
		"\2\u014a\u014b\3\2\2\2\u014b+\3\2\2\2\u014c\u014d\7-\2\2\u014d-\3\2\2"+
		"\2\u014e\u014f\7-\2\2\u014f/\3\2\2\2\u0150\u0151\7\5\2\2\u0151\u0152\7"+
		"-\2\2\u0152\u0153\7\5\2\2\u0153\61\3\2\2\2\u0154\u0155\7\4\2\2\u0155\u0156"+
		"\7-\2\2\u0156\u0157\7\4\2\2\u0157\63\3\2\2\2\249GNRUX_e\u00e9\u00f1\u00f3"+
		"\u0109\u0118\u0120\u012f\u013a\u0141\u014a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}