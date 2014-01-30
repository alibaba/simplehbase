package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface StatementsVisitor<T> extends ParseTreeVisitor<T> {
	T visitTsexp(StatementsParser.TsexpContext ctx);

	T visitConstantList(StatementsParser.ConstantListContext ctx);

	T visitNotmatchconstant(StatementsParser.NotmatchconstantContext ctx);

	T visitRowkey_Wrapper(StatementsParser.Rowkey_WrapperContext ctx);

	T visitRowkey_Start(StatementsParser.Rowkey_StartContext ctx);

	T visitConstant2_NotNull(StatementsParser.Constant2_NotNullContext ctx);

	T visitEqualvar(StatementsParser.EqualvarContext ctx);

	T visitNotinconstantlist(StatementsParser.NotinconstantlistContext ctx);

	T visitSelectHqlCl(StatementsParser.SelectHqlClContext ctx);

	T visitRowkey_FuncConstant(StatementsParser.Rowkey_FuncConstantContext ctx);

	T visitCidList(StatementsParser.CidListContext ctx);

	T visitIsmissingc(StatementsParser.IsmissingcContext ctx);

	T visitSelectc(StatementsParser.SelectcContext ctx);

	T visitIsnullc(StatementsParser.IsnullcContext ctx);

	T visitMaxversionexp(StatementsParser.MaxversionexpContext ctx);

	T visitLimitexp(StatementsParser.LimitexpContext ctx);

	T visitGreatervar(StatementsParser.GreatervarContext ctx);

	T visitMaxversion(StatementsParser.MaxversionContext ctx);

	T visitSelectcl(StatementsParser.SelectclContext ctx);

	T visitWherec(StatementsParser.WherecContext ctx);

	T visitNotbetweenvar(StatementsParser.NotbetweenvarContext ctx);

	T visitCountcl(StatementsParser.CountclContext ctx);

	T visitCid(StatementsParser.CidContext ctx);

	T visitCidList_Star(StatementsParser.CidList_StarContext ctx);

	T visitAndcondition(StatementsParser.AndconditionContext ctx);

	T visitRowkey_Func(StatementsParser.Rowkey_FuncContext ctx);

	T visitBetweenconstant(StatementsParser.BetweenconstantContext ctx);

	T visitTsrange(StatementsParser.TsrangeContext ctx);

	T visitMatchconstant(StatementsParser.MatchconstantContext ctx);

	T visitNotmatchvar(StatementsParser.NotmatchvarContext ctx);

	T visitNotbetweenconstant(StatementsParser.NotbetweenconstantContext ctx);

	T visitVar(StatementsParser.VarContext ctx);

	T visitRowkey_End(StatementsParser.Rowkey_EndContext ctx);

	T visitIsnotmissingc(StatementsParser.IsnotmissingcContext ctx);

	T visitCidList_CidList(StatementsParser.CidList_CidListContext ctx);

	T visitBetweenvar(StatementsParser.BetweenvarContext ctx);

	T visitCountc(StatementsParser.CountcContext ctx);

	T visitIsnotnullc(StatementsParser.IsnotnullcContext ctx);

	T visitLessconstant(StatementsParser.LessconstantContext ctx);

	T visitConditionwrapper(StatementsParser.ConditionwrapperContext ctx);

	T visitSelecthqlc(StatementsParser.SelecthqlcContext ctx);

	T visitInserthqlc(StatementsParser.InserthqlcContext ctx);

	T visitGreaterconstant(StatementsParser.GreaterconstantContext ctx);

	T visitEqualconstant(StatementsParser.EqualconstantContext ctx);

	T visitMatchvar(StatementsParser.MatchvarContext ctx);

	T visitGreaterequalvar(StatementsParser.GreaterequalvarContext ctx);

	T visitInsertHqlCl(StatementsParser.InsertHqlClContext ctx);

	T visitConstant(StatementsParser.ConstantContext ctx);

	T visitConstant2List(StatementsParser.Constant2ListContext ctx);

	T visitGreaterequalconstant(StatementsParser.GreaterequalconstantContext ctx);

	T visitOrcondition(StatementsParser.OrconditionContext ctx);

	T visitInvarlist(StatementsParser.InvarlistContext ctx);

	T visitRowkeyrange(StatementsParser.RowkeyrangeContext ctx);

	T visitConstant2_Null(StatementsParser.Constant2_NullContext ctx);

	T visitNotequalconstant(StatementsParser.NotequalconstantContext ctx);

	T visitLessequalvar(StatementsParser.LessequalvarContext ctx);

	T visitLessvar(StatementsParser.LessvarContext ctx);

	T visitTablename(StatementsParser.TablenameContext ctx);

	T visitLessequalconstant(StatementsParser.LessequalconstantContext ctx);

	T visitNotinvarlist(StatementsParser.NotinvarlistContext ctx);

	T visitCidList_Regx(StatementsParser.CidList_RegxContext ctx);

	T visitInconstantlist(StatementsParser.InconstantlistContext ctx);

	T visitNotequalvar(StatementsParser.NotequalvarContext ctx);

	T visitFuncname(StatementsParser.FuncnameContext ctx);
}