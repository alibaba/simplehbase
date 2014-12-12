package com.alipay.simplehbase.antlr.auto;// Generated from Statements.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface StatementsVisitor<T> extends ParseTreeVisitor<T> {
	T visitTsexp(StatementsParser.TsexpContext ctx);

	T visitRowkey_hbasestart(StatementsParser.Rowkey_hbasestartContext ctx);

	T visitConstantList(StatementsParser.ConstantListContext ctx);

	T visitNotmatchconstant(StatementsParser.NotmatchconstantContext ctx);

	T visitTsrange_end(StatementsParser.Tsrange_endContext ctx);

	T visitDeleteHqlCl(StatementsParser.DeleteHqlClContext ctx);

	T visitRowkey_Wrapper(StatementsParser.Rowkey_WrapperContext ctx);

	T visitConstant2_NotNull(StatementsParser.Constant2_NotNullContext ctx);

	T visitEqualvar(StatementsParser.EqualvarContext ctx);

	T visitNotinconstantlist(StatementsParser.NotinconstantlistContext ctx);

	T visitSelectHqlCl(StatementsParser.SelectHqlClContext ctx);

	T visitTsrange_start(StatementsParser.Tsrange_startContext ctx);

	T visitRowkey_FuncConstant(StatementsParser.Rowkey_FuncConstantContext ctx);

	T visitCidList(StatementsParser.CidListContext ctx);

	T visitIsmissingc(StatementsParser.IsmissingcContext ctx);

	T visitSelectc(StatementsParser.SelectcContext ctx);

	T visitIsnullc(StatementsParser.IsnullcContext ctx);

	T visitMaxversionexp(StatementsParser.MaxversionexpContext ctx);

	T visitRowkeyrange_start(StatementsParser.Rowkeyrange_startContext ctx);

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

	T visitRowkey_hbaseend(StatementsParser.Rowkey_hbaseendContext ctx);

	T visitBetweenconstant(StatementsParser.BetweenconstantContext ctx);

	T visitRowkeyrange_onerowkey(StatementsParser.Rowkeyrange_onerowkeyContext ctx);

	T visitMatchconstant(StatementsParser.MatchconstantContext ctx);

	T visitNotmatchvar(StatementsParser.NotmatchvarContext ctx);

	T visitNotbetweenconstant(StatementsParser.NotbetweenconstantContext ctx);

	T visitVar(StatementsParser.VarContext ctx);

	T visitIsnotmissingc(StatementsParser.IsnotmissingcContext ctx);

	T visitCidList_CidList(StatementsParser.CidList_CidListContext ctx);

	T visitDeletehqlc(StatementsParser.DeletehqlcContext ctx);

	T visitCountsumc(StatementsParser.CountsumcContext ctx);

	T visitBetweenvar(StatementsParser.BetweenvarContext ctx);

	T visitCountc(StatementsParser.CountcContext ctx);

	T visitIsnotnullc(StatementsParser.IsnotnullcContext ctx);

	T visitLessconstant(StatementsParser.LessconstantContext ctx);

	T visitRowkeyrange_startAndEnd(StatementsParser.Rowkeyrange_startAndEndContext ctx);

	T visitConditionwrapper(StatementsParser.ConditionwrapperContext ctx);

	T visitSelecthqlc(StatementsParser.SelecthqlcContext ctx);

	T visitCountsumcl(StatementsParser.CountsumclContext ctx);

	T visitInserthqlc(StatementsParser.InserthqlcContext ctx);

	T visitRowkeyrange_end(StatementsParser.Rowkeyrange_endContext ctx);

	T visitGreaterconstant(StatementsParser.GreaterconstantContext ctx);

	T visitEqualconstant(StatementsParser.EqualconstantContext ctx);

	T visitMatchvar(StatementsParser.MatchvarContext ctx);

	T visitGreaterequalvar(StatementsParser.GreaterequalvarContext ctx);

	T visitInsertHqlCl(StatementsParser.InsertHqlClContext ctx);

	T visitConstant(StatementsParser.ConstantContext ctx);

	T visitConstant2List(StatementsParser.Constant2ListContext ctx);

	T visitTsrange_startAndEnd(StatementsParser.Tsrange_startAndEndContext ctx);

	T visitGreaterequalconstant(StatementsParser.GreaterequalconstantContext ctx);

	T visitOrcondition(StatementsParser.OrconditionContext ctx);

	T visitInvarlist(StatementsParser.InvarlistContext ctx);

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