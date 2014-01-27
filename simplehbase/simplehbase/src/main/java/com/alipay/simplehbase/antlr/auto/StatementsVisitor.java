package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface StatementsVisitor<T> extends ParseTreeVisitor<T> {
	T visitTsexp(StatementsParser.TsexpContext ctx);

	T visitNotmatchconstant(StatementsParser.NotmatchconstantContext ctx);

	T visitConstantList(StatementsParser.ConstantListContext ctx);

	T visitEqualvar(StatementsParser.EqualvarContext ctx);

	T visitNotinconstantlist(StatementsParser.NotinconstantlistContext ctx);

	T visitIsmissingc(StatementsParser.IsmissingcContext ctx);

	T visitCidList(StatementsParser.CidListContext ctx);

	T visitSelectc(StatementsParser.SelectcContext ctx);

	T visitWrapper(StatementsParser.WrapperContext ctx);

	T visitIsnullc(StatementsParser.IsnullcContext ctx);

	T visitInsertconstantList(StatementsParser.InsertconstantListContext ctx);

	T visitGreatervar(StatementsParser.GreatervarContext ctx);

	T visitSelectcl(StatementsParser.SelectclContext ctx);

	T visitWherec(StatementsParser.WherecContext ctx);

	T visitNotbetweenvar(StatementsParser.NotbetweenvarContext ctx);

	T visitCountcl(StatementsParser.CountclContext ctx);

	T visitCid(StatementsParser.CidContext ctx);

	T visitAndcondition(StatementsParser.AndconditionContext ctx);

	T visitRowkeyfunc_constant(StatementsParser.Rowkeyfunc_constantContext ctx);

	T visitBetweenconstant(StatementsParser.BetweenconstantContext ctx);

	T visitMatchconstant(StatementsParser.MatchconstantContext ctx);

	T visitNotmatchvar(StatementsParser.NotmatchvarContext ctx);

	T visitNotbetweenconstant(StatementsParser.NotbetweenconstantContext ctx);

	T visitVar(StatementsParser.VarContext ctx);

	T visitIsnotmissingc(StatementsParser.IsnotmissingcContext ctx);

	T visitBetweenvar(StatementsParser.BetweenvarContext ctx);

	T visitRowkeywrapper(StatementsParser.RowkeywrapperContext ctx);

	T visitCountc(StatementsParser.CountcContext ctx);

	T visitIsnotnullc(StatementsParser.IsnotnullcContext ctx);

	T visitLessconstant(StatementsParser.LessconstantContext ctx);

	T visitRowkeyfunc(StatementsParser.RowkeyfuncContext ctx);

	T visitEqualconstant(StatementsParser.EqualconstantContext ctx);

	T visitGreaterconstant(StatementsParser.GreaterconstantContext ctx);

	T visitMatchvar(StatementsParser.MatchvarContext ctx);

	T visitGreaterequalvar(StatementsParser.GreaterequalvarContext ctx);

	T visitConstant(StatementsParser.ConstantContext ctx);

	T visitGreaterequalconstant(StatementsParser.GreaterequalconstantContext ctx);

	T visitOrcondition(StatementsParser.OrconditionContext ctx);

	T visitInvarlist(StatementsParser.InvarlistContext ctx);

	T visitNotequalconstant(StatementsParser.NotequalconstantContext ctx);

	T visitLessequalvar(StatementsParser.LessequalvarContext ctx);

	T visitLessvar(StatementsParser.LessvarContext ctx);

	T visitLessequalconstant(StatementsParser.LessequalconstantContext ctx);

	T visitTablename(StatementsParser.TablenameContext ctx);

	T visitInsertcl(StatementsParser.InsertclContext ctx);

	T visitNotinvarlist(StatementsParser.NotinvarlistContext ctx);

	T visitInconstantlist(StatementsParser.InconstantlistContext ctx);

	T visitNotequalvar(StatementsParser.NotequalvarContext ctx);

	T visitFuncname(StatementsParser.FuncnameContext ctx);
}