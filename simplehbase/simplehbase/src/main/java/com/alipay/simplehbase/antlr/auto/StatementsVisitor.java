package com.alipay.simplehbase.antlr.auto;
// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface StatementsVisitor<T> extends ParseTreeVisitor<T> {
	T visitConstantList(StatementsParser.ConstantListContext ctx);

	T visitNotmatchconstant(StatementsParser.NotmatchconstantContext ctx);

	T visitNotbetweenconstant(StatementsParser.NotbetweenconstantContext ctx);

	T visitNotmatchvar(StatementsParser.NotmatchvarContext ctx);

	T visitVar(StatementsParser.VarContext ctx);

	T visitEqualvar(StatementsParser.EqualvarContext ctx);

	T visitNotinconstantlist(StatementsParser.NotinconstantlistContext ctx);

	T visitBetweenvar(StatementsParser.BetweenvarContext ctx);

	T visitCountc(StatementsParser.CountcContext ctx);

	T visitIsnotnullc(StatementsParser.IsnotnullcContext ctx);

	T visitLessconstant(StatementsParser.LessconstantContext ctx);

	T visitIsnullc(StatementsParser.IsnullcContext ctx);

	T visitWrapper(StatementsParser.WrapperContext ctx);

	T visitSelectc(StatementsParser.SelectcContext ctx);

	T visitGreaterconstant(StatementsParser.GreaterconstantContext ctx);

	T visitEqualconstant(StatementsParser.EqualconstantContext ctx);

	T visitGreatervar(StatementsParser.GreatervarContext ctx);

	T visitMatchvar(StatementsParser.MatchvarContext ctx);

	T visitSelectcl(StatementsParser.SelectclContext ctx);

	T visitGreaterequalvar(StatementsParser.GreaterequalvarContext ctx);

	T visitConstant(StatementsParser.ConstantContext ctx);

	T visitWherec(StatementsParser.WherecContext ctx);

	T visitNotbetweenvar(StatementsParser.NotbetweenvarContext ctx);

	T visitOrcondition(StatementsParser.OrconditionContext ctx);

	T visitCountcl(StatementsParser.CountclContext ctx);

	T visitGreaterequalconstant(StatementsParser.GreaterequalconstantContext ctx);

	T visitInvarlist(StatementsParser.InvarlistContext ctx);

	T visitCid(StatementsParser.CidContext ctx);

	T visitAndcondition(StatementsParser.AndconditionContext ctx);

	T visitNotequalconstant(StatementsParser.NotequalconstantContext ctx);

	T visitBetweenconstant(StatementsParser.BetweenconstantContext ctx);

	T visitLessequalvar(StatementsParser.LessequalvarContext ctx);

	T visitLessvar(StatementsParser.LessvarContext ctx);

	T visitLessequalconstant(StatementsParser.LessequalconstantContext ctx);

	T visitNotinvarlist(StatementsParser.NotinvarlistContext ctx);

	T visitMatchconstant(StatementsParser.MatchconstantContext ctx);

	T visitInconstantlist(StatementsParser.InconstantlistContext ctx);

	T visitNotequalvar(StatementsParser.NotequalvarContext ctx);
}