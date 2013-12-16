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
		T__2=1, T__1=2, T__0=3, LB=4, RB=5, WHERE=6, SELECT=7, COUNT=8, AND=9, 
		OR=10, LESSEQUAL=11, LESS=12, GREATEREQUAL=13, GREATER=14, NOTEQUAL=15, 
		EQUAL=16, NOTMATCH=17, MATCH=18, IN=19, NOTIN=20, BETWEEN=21, NOTBETWEEN=22, 
		TEXT=23, WS=24;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'#'", "'\"'", "'('", "')'", "'where'", "'select'", 
		"'count'", "'and'", "'or'", "'lessequal'", "'less'", "'greaterequal'", 
		"'greater'", "'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", 
		"'notin'", "'between'", "'notbetween'", "TEXT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_selectc = 1, RULE_wherec = 2, RULE_conditionc = 3, 
		RULE_constantList = 4, RULE_cid = 5, RULE_constant = 6, RULE_var = 7;
	public static final String[] ruleNames = {
		"prog", "selectc", "wherec", "conditionc", "constantList", "cid", "constant", 
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
		public SelectcContext selectc() {
			return getRuleContext(SelectcContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); selectc();
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
		enterRule(_localctx, 2, RULE_selectc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); match(SELECT);
			setState(19); wherec();
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
		enterRule(_localctx, 4, RULE_wherec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); match(WHERE);
			setState(22); conditionc(0);
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
	public static class WrapperContext extends ConditioncContext {
		public ConditioncContext conditionc() {
			return getRuleContext(ConditioncContext.class,0);
		}
		public TerminalNode LB() { return getToken(StatementsParser.LB, 0); }
		public TerminalNode RB() { return getToken(StatementsParser.RB, 0); }
		public WrapperContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StatementsVisitor ) return ((StatementsVisitor<? extends T>)visitor).visitWrapper(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_conditionc);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new WrapperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(25); match(LB);
				setState(26); conditionc(0);
				setState(27); match(RB);
				}
				break;

			case 2:
				{
				_localctx = new EqualconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29); cid();
				setState(30); match(EQUAL);
				setState(31); constant();
				}
				break;

			case 3:
				{
				_localctx = new EqualvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33); cid();
				setState(34); match(EQUAL);
				setState(35); var();
				}
				break;

			case 4:
				{
				_localctx = new LessconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37); cid();
				setState(38); match(LESS);
				setState(39); constant();
				}
				break;

			case 5:
				{
				_localctx = new LessvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41); cid();
				setState(42); match(LESS);
				setState(43); var();
				}
				break;

			case 6:
				{
				_localctx = new GreaterconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45); cid();
				setState(46); match(GREATER);
				setState(47); constant();
				}
				break;

			case 7:
				{
				_localctx = new GreatervarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49); cid();
				setState(50); match(GREATER);
				setState(51); var();
				}
				break;

			case 8:
				{
				_localctx = new LessequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); cid();
				setState(54); match(LESSEQUAL);
				setState(55); constant();
				}
				break;

			case 9:
				{
				_localctx = new LessequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57); cid();
				setState(58); match(LESSEQUAL);
				setState(59); var();
				}
				break;

			case 10:
				{
				_localctx = new GreaterequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); cid();
				setState(62); match(GREATEREQUAL);
				setState(63); constant();
				}
				break;

			case 11:
				{
				_localctx = new GreaterequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); cid();
				setState(66); match(GREATEREQUAL);
				setState(67); var();
				}
				break;

			case 12:
				{
				_localctx = new NotequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); cid();
				setState(70); match(NOTEQUAL);
				setState(71); constant();
				}
				break;

			case 13:
				{
				_localctx = new NotequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73); cid();
				setState(74); match(NOTEQUAL);
				setState(75); var();
				}
				break;

			case 14:
				{
				_localctx = new NotmatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); cid();
				setState(78); match(NOTMATCH);
				setState(79); constant();
				}
				break;

			case 15:
				{
				_localctx = new NotmatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81); cid();
				setState(82); match(NOTMATCH);
				setState(83); var();
				}
				break;

			case 16:
				{
				_localctx = new MatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85); cid();
				setState(86); match(MATCH);
				setState(87); constant();
				}
				break;

			case 17:
				{
				_localctx = new MatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89); cid();
				setState(90); match(MATCH);
				setState(91); var();
				}
				break;

			case 18:
				{
				_localctx = new InconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93); cid();
				setState(94); match(IN);
				setState(95); constantList();
				}
				break;

			case 19:
				{
				_localctx = new InvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97); cid();
				setState(98); match(IN);
				setState(99); var();
				}
				break;

			case 20:
				{
				_localctx = new NotinconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101); cid();
				setState(102); match(NOTIN);
				setState(103); constantList();
				}
				break;

			case 21:
				{
				_localctx = new NotinvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105); cid();
				setState(106); match(NOTIN);
				setState(107); var();
				}
				break;

			case 22:
				{
				_localctx = new BetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); cid();
				setState(110); match(BETWEEN);
				setState(111); constant();
				setState(112); match(AND);
				setState(113); constant();
				}
				break;

			case 23:
				{
				_localctx = new BetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); cid();
				setState(116); match(BETWEEN);
				setState(117); var();
				setState(118); match(AND);
				setState(119); var();
				}
				break;

			case 24:
				{
				_localctx = new NotbetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121); cid();
				setState(122); match(NOTBETWEEN);
				setState(123); constant();
				setState(124); match(AND);
				setState(125); constant();
				}
				break;

			case 25:
				{
				_localctx = new NotbetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127); cid();
				setState(128); match(NOTBETWEEN);
				setState(129); var();
				setState(130); match(AND);
				setState(131); var();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(141);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AndconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(135);
						if (!(26 >= _localctx._p)) throw new FailedPredicateException(this, "26 >= $_p");
						setState(136); match(AND);
						setState(137); conditionc(27);
						}
						break;

					case 2:
						{
						_localctx = new OrconditionContext(new ConditioncContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(138);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(139); match(OR);
						setState(140); conditionc(26);
						}
						break;
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		enterRule(_localctx, 8, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(LB);
			setState(147); constant();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(148); match(1);
				setState(149); constant();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155); match(RB);
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
		enterRule(_localctx, 10, RULE_cid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(TEXT);
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
		enterRule(_localctx, 12, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(3);
			setState(160); match(TEXT);
			setState(161); match(3);
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
		enterRule(_localctx, 14, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(2);
			setState(164); match(TEXT);
			setState(165); match(2);
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
		case 3: return conditionc_sempred((ConditioncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditionc_sempred(ConditioncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 26 >= _localctx._p;

		case 1: return 25 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\32\u00aa\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0088\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0090\n\5\f\5\16\5\u0093\13\5\3\6\3\6\3\6"+
		"\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\2\n\2\4\6\b\n\f\16\20\2\2\u00bc\2\22\3\2\2\2\4\24"+
		"\3\2\2\2\6\27\3\2\2\2\b\u0087\3\2\2\2\n\u0094\3\2\2\2\f\u009f\3\2\2\2"+
		"\16\u00a1\3\2\2\2\20\u00a5\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2\2\24\25\7"+
		"\t\2\2\25\26\5\6\4\2\26\5\3\2\2\2\27\30\7\b\2\2\30\31\5\b\5\2\31\7\3\2"+
		"\2\2\32\33\b\5\1\2\33\34\7\6\2\2\34\35\5\b\5\2\35\36\7\7\2\2\36\u0088"+
		"\3\2\2\2\37 \5\f\7\2 !\7\22\2\2!\"\5\16\b\2\"\u0088\3\2\2\2#$\5\f\7\2"+
		"$%\7\22\2\2%&\5\20\t\2&\u0088\3\2\2\2\'(\5\f\7\2()\7\16\2\2)*\5\16\b\2"+
		"*\u0088\3\2\2\2+,\5\f\7\2,-\7\16\2\2-.\5\20\t\2.\u0088\3\2\2\2/\60\5\f"+
		"\7\2\60\61\7\20\2\2\61\62\5\16\b\2\62\u0088\3\2\2\2\63\64\5\f\7\2\64\65"+
		"\7\20\2\2\65\66\5\20\t\2\66\u0088\3\2\2\2\678\5\f\7\289\7\r\2\29:\5\16"+
		"\b\2:\u0088\3\2\2\2;<\5\f\7\2<=\7\r\2\2=>\5\20\t\2>\u0088\3\2\2\2?@\5"+
		"\f\7\2@A\7\17\2\2AB\5\16\b\2B\u0088\3\2\2\2CD\5\f\7\2DE\7\17\2\2EF\5\20"+
		"\t\2F\u0088\3\2\2\2GH\5\f\7\2HI\7\21\2\2IJ\5\16\b\2J\u0088\3\2\2\2KL\5"+
		"\f\7\2LM\7\21\2\2MN\5\20\t\2N\u0088\3\2\2\2OP\5\f\7\2PQ\7\23\2\2QR\5\16"+
		"\b\2R\u0088\3\2\2\2ST\5\f\7\2TU\7\23\2\2UV\5\20\t\2V\u0088\3\2\2\2WX\5"+
		"\f\7\2XY\7\24\2\2YZ\5\16\b\2Z\u0088\3\2\2\2[\\\5\f\7\2\\]\7\24\2\2]^\5"+
		"\20\t\2^\u0088\3\2\2\2_`\5\f\7\2`a\7\25\2\2ab\5\n\6\2b\u0088\3\2\2\2c"+
		"d\5\f\7\2de\7\25\2\2ef\5\20\t\2f\u0088\3\2\2\2gh\5\f\7\2hi\7\26\2\2ij"+
		"\5\n\6\2j\u0088\3\2\2\2kl\5\f\7\2lm\7\26\2\2mn\5\20\t\2n\u0088\3\2\2\2"+
		"op\5\f\7\2pq\7\27\2\2qr\5\16\b\2rs\7\13\2\2st\5\16\b\2t\u0088\3\2\2\2"+
		"uv\5\f\7\2vw\7\27\2\2wx\5\20\t\2xy\7\13\2\2yz\5\20\t\2z\u0088\3\2\2\2"+
		"{|\5\f\7\2|}\7\30\2\2}~\5\16\b\2~\177\7\13\2\2\177\u0080\5\16\b\2\u0080"+
		"\u0088\3\2\2\2\u0081\u0082\5\f\7\2\u0082\u0083\7\30\2\2\u0083\u0084\5"+
		"\20\t\2\u0084\u0085\7\13\2\2\u0085\u0086\5\20\t\2\u0086\u0088\3\2\2\2"+
		"\u0087\32\3\2\2\2\u0087\37\3\2\2\2\u0087#\3\2\2\2\u0087\'\3\2\2\2\u0087"+
		"+\3\2\2\2\u0087/\3\2\2\2\u0087\63\3\2\2\2\u0087\67\3\2\2\2\u0087;\3\2"+
		"\2\2\u0087?\3\2\2\2\u0087C\3\2\2\2\u0087G\3\2\2\2\u0087K\3\2\2\2\u0087"+
		"O\3\2\2\2\u0087S\3\2\2\2\u0087W\3\2\2\2\u0087[\3\2\2\2\u0087_\3\2\2\2"+
		"\u0087c\3\2\2\2\u0087g\3\2\2\2\u0087k\3\2\2\2\u0087o\3\2\2\2\u0087u\3"+
		"\2\2\2\u0087{\3\2\2\2\u0087\u0081\3\2\2\2\u0088\u0091\3\2\2\2\u0089\u008a"+
		"\6\5\2\3\u008a\u008b\7\13\2\2\u008b\u0090\5\b\5\2\u008c\u008d\6\5\3\3"+
		"\u008d\u008e\7\f\2\2\u008e\u0090\5\b\5\2\u008f\u0089\3\2\2\2\u008f\u008c"+
		"\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\t\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\6\2\2\u0095\u009a\5\16\b"+
		"\2\u0096\u0097\7\3\2\2\u0097\u0099\5\16\b\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7\7\2\2\u009e\13\3\2\2\2\u009f\u00a0"+
		"\7\31\2\2\u00a0\r\3\2\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\7\31\2\2\u00a3"+
		"\u00a4\7\5\2\2\u00a4\17\3\2\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a7\7\31\2"+
		"\2\u00a7\u00a8\7\4\2\2\u00a8\21\3\2\2\2\6\u0087\u008f\u0091\u009a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}