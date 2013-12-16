package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class StatementsBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements StatementsVisitor<T> {
	@Override public T visitConstantList(StatementsParser.ConstantListContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotmatchconstant(StatementsParser.NotmatchconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotbetweenconstant(StatementsParser.NotbetweenconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotmatchvar(StatementsParser.NotmatchvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitVar(StatementsParser.VarContext ctx) { return visitChildren(ctx); }

	@Override public T visitEqualvar(StatementsParser.EqualvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotinconstantlist(StatementsParser.NotinconstantlistContext ctx) { return visitChildren(ctx); }

	@Override public T visitBetweenvar(StatementsParser.BetweenvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessconstant(StatementsParser.LessconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitProg(StatementsParser.ProgContext ctx) { return visitChildren(ctx); }

	@Override public T visitWrapper(StatementsParser.WrapperContext ctx) { return visitChildren(ctx); }

	@Override public T visitSelectc(StatementsParser.SelectcContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterconstant(StatementsParser.GreaterconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitEqualconstant(StatementsParser.EqualconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreatervar(StatementsParser.GreatervarContext ctx) { return visitChildren(ctx); }

	@Override public T visitMatchvar(StatementsParser.MatchvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterequalvar(StatementsParser.GreaterequalvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitConstant(StatementsParser.ConstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitWherec(StatementsParser.WherecContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotbetweenvar(StatementsParser.NotbetweenvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitOrcondition(StatementsParser.OrconditionContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterequalconstant(StatementsParser.GreaterequalconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitInvarlist(StatementsParser.InvarlistContext ctx) { return visitChildren(ctx); }

	@Override public T visitCid(StatementsParser.CidContext ctx) { return visitChildren(ctx); }

	@Override public T visitAndcondition(StatementsParser.AndconditionContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotequalconstant(StatementsParser.NotequalconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessequalvar(StatementsParser.LessequalvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitBetweenconstant(StatementsParser.BetweenconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessvar(StatementsParser.LessvarContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessequalconstant(StatementsParser.LessequalconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotinvarlist(StatementsParser.NotinvarlistContext ctx) { return visitChildren(ctx); }

	@Override public T visitMatchconstant(StatementsParser.MatchconstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitInconstantlist(StatementsParser.InconstantlistContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotequalvar(StatementsParser.NotequalvarContext ctx) { return visitChildren(ctx); }
}