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
		RULE_selectc = 4, RULE_wherec = 5, RULE_conditionc = 6, RULE_rowkeyrange = 7, 
		RULE_rowkeyexp = 8, RULE_tsrange = 9, RULE_tsexp = 10, RULE_selectCidList = 11, 
		RULE_cidList = 12, RULE_cid = 13, RULE_funcname = 14, RULE_constantList = 15, 
		RULE_constant2List = 16, RULE_constant2 = 17, RULE_maxversionexp = 18, 
		RULE_limitexp = 19, RULE_tablename = 20, RULE_maxversion = 21, RULE_constant = 22, 
		RULE_var = 23;
	public static final String[] ruleNames = {
		"prog", "inserthqlc", "selecthqlc", "deletehqlc", "selectc", "wherec", 
		"conditionc", "rowkeyrange", "rowkeyexp", "tsrange", "tsexp", "selectCidList", 
		"cidList", "cid", "funcname", "constantList", "constant2List", "constant2", 
		"maxversionexp", "limitexp", "tablename", "maxversion", "constant", "var"
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
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SelectclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48); selectc();
				}
				break;

			case 2:
				_localctx = new InsertHqlClContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49); inserthqlc();
				}
				break;

			case 3:
				_localctx = new SelectHqlClContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50); selecthqlc();
				}
				break;

			case 4:
				_localctx = new DeleteHqlClContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51); deletehqlc();
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
			setState(54); match(INSERT);
			setState(55); match(INTO);
			setState(56); tablename();
			setState(57); cidList();
			setState(58); match(VALUES);
			setState(59); constant2List();
			setState(60); match(ROWKEY);
			setState(61); match(IS);
			setState(62); rowkeyexp();
			setState(66);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(63); match(TS);
				setState(64); match(IS);
				setState(65); tsexp();
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
			setState(68); match(SELECT);
			setState(69); selectCidList();
			setState(70); match(FROM);
			setState(71); tablename();
			setState(73);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(72); wherec();
				}
			}

			setState(75); rowkeyrange();
			setState(77);
			_la = _input.LA(1);
			if (_la==MAXVERSION) {
				{
				setState(76); maxversionexp();
				}
			}

			setState(80);
			_la = _input.LA(1);
			if (_la==STARTTS || _la==ENDTS) {
				{
				setState(79); tsrange();
				}
			}

			setState(83);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(82); limitexp();
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
			setState(85); match(DELETE);
			setState(86); selectCidList();
			setState(87); match(FROM);
			setState(88); tablename();
			setState(90);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(89); wherec();
				}
			}

			setState(92); rowkeyrange();
			setState(96);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(93); match(TS);
				setState(94); match(IS);
				setState(95); tsexp();
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
			setState(98); match(SELECT);
			setState(99); wherec();
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
		enterRule(_localctx, 10, RULE_wherec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(WHERE);
			setState(102); conditionc(0);
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
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_conditionc);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionwrapperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(105); match(LB);
				setState(106); conditionc(0);
				setState(107); match(RB);
				}
				break;

			case 2:
				{
				_localctx = new EqualconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); cid();
				setState(110); match(EQUAL);
				setState(111); constant();
				}
				break;

			case 3:
				{
				_localctx = new EqualvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); cid();
				setState(114); match(EQUAL);
				setState(115); var();
				}
				break;

			case 4:
				{
				_localctx = new LessconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); cid();
				setState(118); match(LESS);
				setState(119); constant();
				}
				break;

			case 5:
				{
				_localctx = new LessvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121); cid();
				setState(122); match(LESS);
				setState(123); var();
				}
				break;

			case 6:
				{
				_localctx = new GreaterconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125); cid();
				setState(126); match(GREATER);
				setState(127); constant();
				}
				break;

			case 7:
				{
				_localctx = new GreatervarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129); cid();
				setState(130); match(GREATER);
				setState(131); var();
				}
				break;

			case 8:
				{
				_localctx = new LessequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133); cid();
				setState(134); match(LESSEQUAL);
				setState(135); constant();
				}
				break;

			case 9:
				{
				_localctx = new LessequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137); cid();
				setState(138); match(LESSEQUAL);
				setState(139); var();
				}
				break;

			case 10:
				{
				_localctx = new GreaterequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141); cid();
				setState(142); match(GREATEREQUAL);
				setState(143); constant();
				}
				break;

			case 11:
				{
				_localctx = new GreaterequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145); cid();
				setState(146); match(GREATEREQUAL);
				setState(147); var();
				}
				break;

			case 12:
				{
				_localctx = new NotequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149); cid();
				setState(150); match(NOTEQUAL);
				setState(151); constant();
				}
				break;

			case 13:
				{
				_localctx = new NotequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153); cid();
				setState(154); match(NOTEQUAL);
				setState(155); var();
				}
				break;

			case 14:
				{
				_localctx = new NotmatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); cid();
				setState(158); match(NOTMATCH);
				setState(159); constant();
				}
				break;

			case 15:
				{
				_localctx = new NotmatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161); cid();
				setState(162); match(NOTMATCH);
				setState(163); var();
				}
				break;

			case 16:
				{
				_localctx = new MatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165); cid();
				setState(166); match(MATCH);
				setState(167); constant();
				}
				break;

			case 17:
				{
				_localctx = new MatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169); cid();
				setState(170); match(MATCH);
				setState(171); var();
				}
				break;

			case 18:
				{
				_localctx = new InconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173); cid();
				setState(174); match(IN);
				setState(175); constantList();
				}
				break;

			case 19:
				{
				_localctx = new InvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177); cid();
				setState(178); match(IN);
				setState(179); var();
				}
				break;

			case 20:
				{
				_localctx = new NotinconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181); cid();
				setState(182); match(NOTIN);
				setState(183); constantList();
				}
				break;

			case 21:
				{
				_localctx = new NotinvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185); cid();
				setState(186); match(NOTIN);
				setState(187); var();
				}
				break;

			case 22:
				{
				_localctx = new BetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189); cid();
				setState(190); match(BETWEEN);
				setState(191); constant();
				setState(192); match(AND);
				setState(193); constant();
				}
				break;

			case 23:
				{
				_localctx = new BetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); cid();
				setState(196); match(BETWEEN);
				setState(197); var();
				setState(198); match(AND);
				setState(199); var();
				}
				break;

			case 24:
				{
				_localctx = new NotbetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201); cid();
				setState(202); match(NOTBETWEEN);
				setState(203); constant();
				setState(204); match(AND);
				setState(205); constant();
				}
				break;

			case 25:
				{
				_localctx = new NotbetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207); cid();
				setState(208); match(NOTBETWEEN);
				setState(209); var();
				setState(210); match(AND);
				setState(211); var();
				}
				break;

			case 26:
				{
				_localctx = new IsnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); cid();
				setState(214); match(ISNULL);
				}
				break;

			case 27:
				{
				_localctx = new IsnotnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); cid();
				setState(217); match(ISNOTNULL);
				}
				break;

			case 28:
				{
				_localctx = new IsmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219); cid();
				setState(220); match(ISMISSING);
				}
				break;

			case 29:
				{
				_localctx = new IsnotmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); cid();
				setState(223); match(ISNOTMISSING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(233);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AndconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(227);
						if (!(30 >= _localctx._p)) throw new FailedPredicateException(this, "30 >= $_p");
						setState(228); match(AND);
						setState(229); conditionc(31);
						}
						break;

					case 2:
						{
						_localctx = new OrconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(230);
						if (!(29 >= _localctx._p)) throw new FailedPredicateException(this, "29 >= $_p");
						setState(231); match(OR);
						setState(232); conditionc(30);
						}
						break;
					}
					} 
				}
				setState(237);
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
		enterRule(_localctx, 14, RULE_rowkeyrange);
		try {
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new Rowkeyrange_startAndEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238); match(STARTKEY);
				setState(239); match(IS);
				setState(240); rowkeyexp();
				setState(241); match(1);
				setState(242); match(ENDKEY);
				setState(243); match(IS);
				setState(244); rowkeyexp();
				}
				break;

			case 2:
				_localctx = new Rowkeyrange_startContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(246); match(STARTKEY);
				setState(247); match(IS);
				setState(248); rowkeyexp();
				}
				break;

			case 3:
				_localctx = new Rowkeyrange_endContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(249); match(ENDKEY);
				setState(250); match(IS);
				setState(251); rowkeyexp();
				}
				break;

			case 4:
				_localctx = new Rowkeyrange_onerowkeyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252); match(ROWKEY);
				setState(253); match(IS);
				setState(254); rowkeyexp();
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
		enterRule(_localctx, 16, RULE_rowkeyexp);
		try {
			setState(268);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new Rowkey_WrapperContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(257); match(LB);
				setState(258); rowkeyexp();
				setState(259); match(RB);
				}
				break;
			case TEXT:
				_localctx = new Rowkey_FuncConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(261); funcname();
				setState(262); match(LB);
				setState(263); constant();
				setState(264); match(RB);
				}
				break;
			case HBASESTARTKEY:
				_localctx = new Rowkey_hbasestartContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(266); match(HBASESTARTKEY);
				}
				break;
			case HBASEENDKEY:
				_localctx = new Rowkey_hbaseendContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(267); match(HBASEENDKEY);
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
		enterRule(_localctx, 18, RULE_tsrange);
		try {
			setState(284);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Tsrange_startAndEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(270); match(STARTTS);
				setState(271); match(IS);
				setState(272); tsexp();
				setState(273); match(1);
				setState(274); match(ENDTS);
				setState(275); match(IS);
				setState(276); tsexp();
				}
				break;

			case 2:
				_localctx = new Tsrange_startContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(278); match(STARTTS);
				setState(279); match(IS);
				setState(280); tsexp();
				}
				break;

			case 3:
				_localctx = new Tsrange_endContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(281); match(ENDTS);
				setState(282); match(IS);
				setState(283); tsexp();
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
		enterRule(_localctx, 20, RULE_tsexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); constant();
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
		enterRule(_localctx, 22, RULE_selectCidList);
		try {
			setState(291);
			switch (_input.LA(1)) {
			case LB:
				_localctx = new CidList_CidListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288); cidList();
				}
				break;
			case STAR:
				_localctx = new CidList_StarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289); match(STAR);
				}
				break;
			case TEXT:
				_localctx = new CidList_RegxContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(290); match(TEXT);
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
		enterRule(_localctx, 24, RULE_cidList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(LB);
			setState(294); cid();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(295); match(1);
				setState(296); cid();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302); match(RB);
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
		enterRule(_localctx, 26, RULE_cid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304); match(TEXT);
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
		enterRule(_localctx, 28, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); match(TEXT);
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
		enterRule(_localctx, 30, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(LB);
			setState(309); constant();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(310); match(1);
				setState(311); constant();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317); match(RB);
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
		enterRule(_localctx, 32, RULE_constant2List);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(LB);
			setState(320); constant2();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(321); match(1);
				setState(322); constant2();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328); match(RB);
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
		enterRule(_localctx, 34, RULE_constant2);
		try {
			setState(332);
			switch (_input.LA(1)) {
			case 3:
				_localctx = new Constant2_NotNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(330); constant();
				}
				break;
			case NULL:
				_localctx = new Constant2_NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(331); match(NULL);
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
		enterRule(_localctx, 36, RULE_maxversionexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(MAXVERSION);
			setState(335); maxversion();
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
		enterRule(_localctx, 38, RULE_limitexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); match(LIMIT);
			setState(338); match(TEXT);
			setState(341);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(339); match(1);
				setState(340); match(TEXT);
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
		enterRule(_localctx, 40, RULE_tablename);
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
		enterRule(_localctx, 42, RULE_maxversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); match(TEXT);
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
		enterRule(_localctx, 44, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); match(3);
			setState(348); match(TEXT);
			setState(349); match(3);
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
		enterRule(_localctx, 46, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351); match(2);
			setState(352); match(TEXT);
			setState(353); match(2);
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
		case 6: return conditionc_sempred((ConditioncContext)_localctx, predIndex);
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
		"\2\3\62\u0166\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\3\2\3\2\3\2\3\2\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3E\n\3\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\4"+
		"\3\4\5\4P\n\4\3\4\5\4S\n\4\3\4\5\4V\n\4\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3"+
		"\5\3\5\3\5\3\5\5\5c\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e4\n\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\7\b\u00ec\n\b\f\b\16\b\u00ef\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0102\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u010f\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u011f\n\13\3\f\3\f"+
		"\3\r\3\r\3\r\5\r\u0126\n\r\3\16\3\16\3\16\3\16\7\16\u012c\n\16\f\16\16"+
		"\16\u012f\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\7\21"+
		"\u013b\n\21\f\21\16\21\u013e\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22"+
		"\u0146\n\22\f\22\16\22\u0149\13\22\3\22\3\22\3\23\3\23\5\23\u014f\n\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0158\n\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\2\32\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\2\2\u0184\2\66\3\2\2\2\48\3\2\2\2\6F\3"+
		"\2\2\2\bW\3\2\2\2\nd\3\2\2\2\fg\3\2\2\2\16\u00e3\3\2\2\2\20\u0101\3\2"+
		"\2\2\22\u010e\3\2\2\2\24\u011e\3\2\2\2\26\u0120\3\2\2\2\30\u0125\3\2\2"+
		"\2\32\u0127\3\2\2\2\34\u0132\3\2\2\2\36\u0134\3\2\2\2 \u0136\3\2\2\2\""+
		"\u0141\3\2\2\2$\u014e\3\2\2\2&\u0150\3\2\2\2(\u0153\3\2\2\2*\u0159\3\2"+
		"\2\2,\u015b\3\2\2\2.\u015d\3\2\2\2\60\u0161\3\2\2\2\62\67\5\n\6\2\63\67"+
		"\5\4\3\2\64\67\5\6\4\2\65\67\5\b\5\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64"+
		"\3\2\2\2\66\65\3\2\2\2\67\3\3\2\2\289\7\r\2\29:\7\17\2\2:;\5*\26\2;<\5"+
		"\32\16\2<=\7\20\2\2=>\5\"\22\2>?\7\22\2\2?@\7\34\2\2@D\5\22\n\2AB\7\31"+
		"\2\2BC\7\34\2\2CE\5\26\f\2DA\3\2\2\2DE\3\2\2\2E\5\3\2\2\2FG\7\n\2\2GH"+
		"\5\30\r\2HI\7\21\2\2IK\5*\26\2JL\5\f\7\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2"+
		"MO\5\20\t\2NP\5&\24\2ON\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\5\24\13\2RQ\3\2"+
		"\2\2RS\3\2\2\2SU\3\2\2\2TV\5(\25\2UT\3\2\2\2UV\3\2\2\2V\7\3\2\2\2WX\7"+
		"\16\2\2XY\5\30\r\2YZ\7\21\2\2Z\\\5*\26\2[]\5\f\7\2\\[\3\2\2\2\\]\3\2\2"+
		"\2]^\3\2\2\2^b\5\20\t\2_`\7\31\2\2`a\7\34\2\2ac\5\26\f\2b_\3\2\2\2bc\3"+
		"\2\2\2c\t\3\2\2\2de\7\n\2\2ef\5\f\7\2f\13\3\2\2\2gh\7\t\2\2hi\5\16\b\2"+
		"i\r\3\2\2\2jk\b\b\1\2kl\7\7\2\2lm\5\16\b\2mn\7\b\2\2n\u00e4\3\2\2\2op"+
		"\5\34\17\2pq\7&\2\2qr\5.\30\2r\u00e4\3\2\2\2st\5\34\17\2tu\7&\2\2uv\5"+
		"\60\31\2v\u00e4\3\2\2\2wx\5\34\17\2xy\7\"\2\2yz\5.\30\2z\u00e4\3\2\2\2"+
		"{|\5\34\17\2|}\7\"\2\2}~\5\60\31\2~\u00e4\3\2\2\2\177\u0080\5\34\17\2"+
		"\u0080\u0081\7$\2\2\u0081\u0082\5.\30\2\u0082\u00e4\3\2\2\2\u0083\u0084"+
		"\5\34\17\2\u0084\u0085\7$\2\2\u0085\u0086\5\60\31\2\u0086\u00e4\3\2\2"+
		"\2\u0087\u0088\5\34\17\2\u0088\u0089\7!\2\2\u0089\u008a\5.\30\2\u008a"+
		"\u00e4\3\2\2\2\u008b\u008c\5\34\17\2\u008c\u008d\7!\2\2\u008d\u008e\5"+
		"\60\31\2\u008e\u00e4\3\2\2\2\u008f\u0090\5\34\17\2\u0090\u0091\7#\2\2"+
		"\u0091\u0092\5.\30\2\u0092\u00e4\3\2\2\2\u0093\u0094\5\34\17\2\u0094\u0095"+
		"\7#\2\2\u0095\u0096\5\60\31\2\u0096\u00e4\3\2\2\2\u0097\u0098\5\34\17"+
		"\2\u0098\u0099\7%\2\2\u0099\u009a\5.\30\2\u009a\u00e4\3\2\2\2\u009b\u009c"+
		"\5\34\17\2\u009c\u009d\7%\2\2\u009d\u009e\5\60\31\2\u009e\u00e4\3\2\2"+
		"\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\7\'\2\2\u00a1\u00a2\5.\30\2\u00a2"+
		"\u00e4\3\2\2\2\u00a3\u00a4\5\34\17\2\u00a4\u00a5\7\'\2\2\u00a5\u00a6\5"+
		"\60\31\2\u00a6\u00e4\3\2\2\2\u00a7\u00a8\5\34\17\2\u00a8\u00a9\7(\2\2"+
		"\u00a9\u00aa\5.\30\2\u00aa\u00e4\3\2\2\2\u00ab\u00ac\5\34\17\2\u00ac\u00ad"+
		"\7(\2\2\u00ad\u00ae\5\60\31\2\u00ae\u00e4\3\2\2\2\u00af\u00b0\5\34\17"+
		"\2\u00b0\u00b1\7)\2\2\u00b1\u00b2\5 \21\2\u00b2\u00e4\3\2\2\2\u00b3\u00b4"+
		"\5\34\17\2\u00b4\u00b5\7)\2\2\u00b5\u00b6\5\60\31\2\u00b6\u00e4\3\2\2"+
		"\2\u00b7\u00b8\5\34\17\2\u00b8\u00b9\7*\2\2\u00b9\u00ba\5 \21\2\u00ba"+
		"\u00e4\3\2\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\7*\2\2\u00bd\u00be\5"+
		"\60\31\2\u00be\u00e4\3\2\2\2\u00bf\u00c0\5\34\17\2\u00c0\u00c1\7+\2\2"+
		"\u00c1\u00c2\5.\30\2\u00c2\u00c3\7\37\2\2\u00c3\u00c4\5.\30\2\u00c4\u00e4"+
		"\3\2\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7\7+\2\2\u00c7\u00c8\5\60\31"+
		"\2\u00c8\u00c9\7\37\2\2\u00c9\u00ca\5\60\31\2\u00ca\u00e4\3\2\2\2\u00cb"+
		"\u00cc\5\34\17\2\u00cc\u00cd\7,\2\2\u00cd\u00ce\5.\30\2\u00ce\u00cf\7"+
		"\37\2\2\u00cf\u00d0\5.\30\2\u00d0\u00e4\3\2\2\2\u00d1\u00d2\5\34\17\2"+
		"\u00d2\u00d3\7,\2\2\u00d3\u00d4\5\60\31\2\u00d4\u00d5\7\37\2\2\u00d5\u00d6"+
		"\5\60\31\2\u00d6\u00e4\3\2\2\2\u00d7\u00d8\5\34\17\2\u00d8\u00d9\7-\2"+
		"\2\u00d9\u00e4\3\2\2\2\u00da\u00db\5\34\17\2\u00db\u00dc\7.\2\2\u00dc"+
		"\u00e4\3\2\2\2\u00dd\u00de\5\34\17\2\u00de\u00df\7/\2\2\u00df\u00e4\3"+
		"\2\2\2\u00e0\u00e1\5\34\17\2\u00e1\u00e2\7\60\2\2\u00e2\u00e4\3\2\2\2"+
		"\u00e3j\3\2\2\2\u00e3o\3\2\2\2\u00e3s\3\2\2\2\u00e3w\3\2\2\2\u00e3{\3"+
		"\2\2\2\u00e3\177\3\2\2\2\u00e3\u0083\3\2\2\2\u00e3\u0087\3\2\2\2\u00e3"+
		"\u008b\3\2\2\2\u00e3\u008f\3\2\2\2\u00e3\u0093\3\2\2\2\u00e3\u0097\3\2"+
		"\2\2\u00e3\u009b\3\2\2\2\u00e3\u009f\3\2\2\2\u00e3\u00a3\3\2\2\2\u00e3"+
		"\u00a7\3\2\2\2\u00e3\u00ab\3\2\2\2\u00e3\u00af\3\2\2\2\u00e3\u00b3\3\2"+
		"\2\2\u00e3\u00b7\3\2\2\2\u00e3\u00bb\3\2\2\2\u00e3\u00bf\3\2\2\2\u00e3"+
		"\u00c5\3\2\2\2\u00e3\u00cb\3\2\2\2\u00e3\u00d1\3\2\2\2\u00e3\u00d7\3\2"+
		"\2\2\u00e3\u00da\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4"+
		"\u00ed\3\2\2\2\u00e5\u00e6\6\b\2\3\u00e6\u00e7\7\37\2\2\u00e7\u00ec\5"+
		"\16\b\2\u00e8\u00e9\6\b\3\3\u00e9\u00ea\7 \2\2\u00ea\u00ec\5\16\b\2\u00eb"+
		"\u00e5\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\17\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1"+
		"\7\23\2\2\u00f1\u00f2\7\34\2\2\u00f2\u00f3\5\22\n\2\u00f3\u00f4\7\3\2"+
		"\2\u00f4\u00f5\7\24\2\2\u00f5\u00f6\7\34\2\2\u00f6\u00f7\5\22\n\2\u00f7"+
		"\u0102\3\2\2\2\u00f8\u00f9\7\23\2\2\u00f9\u00fa\7\34\2\2\u00fa\u0102\5"+
		"\22\n\2\u00fb\u00fc\7\24\2\2\u00fc\u00fd\7\34\2\2\u00fd\u0102\5\22\n\2"+
		"\u00fe\u00ff\7\22\2\2\u00ff\u0100\7\34\2\2\u0100\u0102\5\22\n\2\u0101"+
		"\u00f0\3\2\2\2\u0101\u00f8\3\2\2\2\u0101\u00fb\3\2\2\2\u0101\u00fe\3\2"+
		"\2\2\u0102\21\3\2\2\2\u0103\u0104\7\7\2\2\u0104\u0105\5\22\n\2\u0105\u0106"+
		"\7\b\2\2\u0106\u010f\3\2\2\2\u0107\u0108\5\36\20\2\u0108\u0109\7\7\2\2"+
		"\u0109\u010a\5.\30\2\u010a\u010b\7\b\2\2\u010b\u010f\3\2\2\2\u010c\u010f"+
		"\7\25\2\2\u010d\u010f\7\26\2\2\u010e\u0103\3\2\2\2\u010e\u0107\3\2\2\2"+
		"\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f\23\3\2\2\2\u0110\u0111"+
		"\7\32\2\2\u0111\u0112\7\34\2\2\u0112\u0113\5\26\f\2\u0113\u0114\7\3\2"+
		"\2\u0114\u0115\7\33\2\2\u0115\u0116\7\34\2\2\u0116\u0117\5\26\f\2\u0117"+
		"\u011f\3\2\2\2\u0118\u0119\7\32\2\2\u0119\u011a\7\34\2\2\u011a\u011f\5"+
		"\26\f\2\u011b\u011c\7\33\2\2\u011c\u011d\7\34\2\2\u011d\u011f\5\26\f\2"+
		"\u011e\u0110\3\2\2\2\u011e\u0118\3\2\2\2\u011e\u011b\3\2\2\2\u011f\25"+
		"\3\2\2\2\u0120\u0121\5.\30\2\u0121\27\3\2\2\2\u0122\u0126\5\32\16\2\u0123"+
		"\u0126\7\6\2\2\u0124\u0126\7\61\2\2\u0125\u0122\3\2\2\2\u0125\u0123\3"+
		"\2\2\2\u0125\u0124\3\2\2\2\u0126\31\3\2\2\2\u0127\u0128\7\7\2\2\u0128"+
		"\u012d\5\34\17\2\u0129\u012a\7\3\2\2\u012a\u012c\5\34\17\2\u012b\u0129"+
		"\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7\b\2\2\u0131\33\3\2\2"+
		"\2\u0132\u0133\7\61\2\2\u0133\35\3\2\2\2\u0134\u0135\7\61\2\2\u0135\37"+
		"\3\2\2\2\u0136\u0137\7\7\2\2\u0137\u013c\5.\30\2\u0138\u0139\7\3\2\2\u0139"+
		"\u013b\5.\30\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0140\7\b\2\2\u0140!\3\2\2\2\u0141\u0142\7\7\2\2\u0142\u0147\5$\23\2"+
		"\u0143\u0144\7\3\2\2\u0144\u0146\5$\23\2\u0145\u0143\3\2\2\2\u0146\u0149"+
		"\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\7\b\2\2\u014b#\3\2\2\2\u014c\u014f\5.\30\2"+
		"\u014d\u014f\7\35\2\2\u014e\u014c\3\2\2\2\u014e\u014d\3\2\2\2\u014f%\3"+
		"\2\2\2\u0150\u0151\7\27\2\2\u0151\u0152\5,\27\2\u0152\'\3\2\2\2\u0153"+
		"\u0154\7\30\2\2\u0154\u0157\7\61\2\2\u0155\u0156\7\3\2\2\u0156\u0158\7"+
		"\61\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158)\3\2\2\2\u0159\u015a"+
		"\7\61\2\2\u015a+\3\2\2\2\u015b\u015c\7\61\2\2\u015c-\3\2\2\2\u015d\u015e"+
		"\7\5\2\2\u015e\u015f\7\61\2\2\u015f\u0160\7\5\2\2\u0160/\3\2\2\2\u0161"+
		"\u0162\7\4\2\2\u0162\u0163\7\61\2\2\u0163\u0164\7\4\2\2\u0164\61\3\2\2"+
		"\2\26\66DKORU\\b\u00e3\u00eb\u00ed\u0101\u010e\u011e\u0125\u012d\u013c"+
		"\u0147\u014e\u0157";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}