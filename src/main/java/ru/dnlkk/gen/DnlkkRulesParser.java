// Generated from C:/Users/user/DnlkkProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.dnlkk.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DnlkkRulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, STRING_LITERAL=12, IF=13, ELIF=14, ELSE=15, WHILE=16, 
		FOR=17, RETURN=18, FUN=19, GOTO=20, LOGICAL_OPERATORS=21, NOT_LOGICAL_OPERATOR=22, 
		VAR=23, IDENT=24, CHAR=25, NUM=26, DOUBLE=27, BOOL=28, NULL=29, UNDEFINED=30, 
		START_COMMENT=31, END_COMMENT=32, COMPARE=33, ADD=34, MULT=35, WS=36, 
		COMMENT=37;
	public static final int
		RULE_program = 0, RULE_stmt_list = 1, RULE_stmt_block = 2, RULE_stmt = 3, 
		RULE_if = 4, RULE_elif = 5, RULE_else = 6, RULE_while = 7, RULE_for = 8, 
		RULE_return = 9, RULE_definition = 10, RULE_assign = 11, RULE_expr = 12, 
		RULE_logical = 13, RULE_compare = 14, RULE_add = 15, RULE_mult = 16, RULE_unary = 17, 
		RULE_call = 18, RULE_group = 19, RULE_primitive = 20, RULE_fun = 21, RULE_array_literal = 22, 
		RULE_array_element = 23, RULE_object_literal = 24, RULE_field = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt_list", "stmt_block", "stmt", "if", "elif", "else", "while", 
			"for", "return", "definition", "assign", "expr", "logical", "compare", 
			"add", "mult", "unary", "call", "group", "primitive", "fun", "array_literal", 
			"array_element", "object_literal", "field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "'='", "','", "'.'", "'['", 
			"']'", "':'", null, "'if'", "'elif'", "'else'", "'while'", "'for'", "'return'", 
			"'fun'", null, null, "'not'", "'var'", null, null, null, null, null, 
			"'null'", "'undefined'", "'<--'", "'-->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"STRING_LITERAL", "IF", "ELIF", "ELSE", "WHILE", "FOR", "RETURN", "FUN", 
			"GOTO", "LOGICAL_OPERATORS", "NOT_LOGICAL_OPERATOR", "VAR", "IDENT", 
			"CHAR", "NUM", "DOUBLE", "BOOL", "NULL", "UNDEFINED", "START_COMMENT", 
			"END_COMMENT", "COMPARE", "ADD", "MULT", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DnlkkRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DnlkkRulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DnlkkRulesParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			stmt_list();
			setState(53);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Stmt_listContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitStmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			stmt();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 53651386890L) != 0)) {
				{
				{
				setState(56);
				stmt();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Stmt_blockContext extends ParserRuleContext {
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Stmt_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterStmt_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitStmt_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitStmt_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_blockContext stmt_block() throws RecognitionException {
		Stmt_blockContext _localctx = new Stmt_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 53651386890L) != 0)) {
				{
				setState(63);
				stmt_list();
				}
			}

			setState(66);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends StmtContext {
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public While_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Definition_stmtContext extends StmtContext {
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public Definition_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterDefinition_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitDefinition_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitDefinition_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends StmtContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public If_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class For_stmtContext extends StmtContext {
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public For_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Goto_stmtContext extends StmtContext {
		public TerminalNode GOTO() { return getToken(DnlkkRulesParser.GOTO, 0); }
		public Goto_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterGoto_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitGoto_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitGoto_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_stmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Assign_stmtContext extends StmtContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Assign_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends StmtContext {
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public Return_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new Definition_stmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				definition();
				}
				break;
			case 2:
				_localctx = new Assign_stmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				assign();
				}
				break;
			case 3:
				_localctx = new Expr_stmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				expr();
				}
				break;
			case 4:
				_localctx = new If_stmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				if_();
				}
				break;
			case 5:
				_localctx = new While_stmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				while_();
				}
				break;
			case 6:
				_localctx = new For_stmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				for_();
				}
				break;
			case 7:
				_localctx = new Return_stmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
				return_();
				}
				break;
			case 8:
				_localctx = new Goto_stmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(75);
				match(GOTO);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(DnlkkRulesParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public List<ElifContext> elif() {
			return getRuleContexts(ElifContext.class);
		}
		public ElifContext elif(int i) {
			return getRuleContext(ElifContext.class,i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(IF);
			setState(79);
			match(T__2);
			setState(80);
			expr();
			setState(81);
			match(T__3);
			setState(82);
			stmt_block();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(83);
				elif();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(89);
				else_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElifContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(DnlkkRulesParser.ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public ElifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterElif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitElif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitElif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifContext elif() throws RecognitionException {
		ElifContext _localctx = new ElifContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ELIF);
			setState(93);
			match(T__2);
			setState(94);
			expr();
			setState(95);
			match(T__3);
			setState(96);
			stmt_block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(DnlkkRulesParser.ELSE, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ELSE);
			setState(99);
			stmt_block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(DnlkkRulesParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(WHILE);
			setState(102);
			match(T__2);
			setState(103);
			expr();
			setState(104);
			match(T__3);
			setState(105);
			stmt_block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(DnlkkRulesParser.FOR, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(FOR);
			setState(108);
			match(T__2);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(109);
				definition();
				}
			}

			setState(112);
			match(T__4);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 53641482762L) != 0)) {
				{
				setState(113);
				logical(0);
				}
			}

			setState(116);
			match(T__4);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097680906L) != 0)) {
				{
				setState(117);
				assign();
				}
			}

			setState(120);
			match(T__3);
			setState(121);
			stmt_block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(DnlkkRulesParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(RETURN);
			setState(124);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(DnlkkRulesParser.VAR, 0); }
		public TerminalNode IDENT() { return getToken(DnlkkRulesParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(VAR);
			setState(127);
			match(IDENT);
			setState(128);
			match(T__5);
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(129);
				expr();
				}
				break;
			case 2:
				{
				setState(130);
				fun();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			call(0);
			setState(134);
			match(T__5);
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(135);
				expr();
				}
				break;
			case 2:
				{
				setState(136);
				fun();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			logical(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ParserRuleContext {
		public LogicalContext left;
		public LogicalContext not_operand;
		public LogicalContext right;
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode NOT_LOGICAL_OPERATOR() { return getToken(DnlkkRulesParser.NOT_LOGICAL_OPERATOR, 0); }
		public List<LogicalContext> logical() {
			return getRuleContexts(LogicalContext.class);
		}
		public LogicalContext logical(int i) {
			return getRuleContext(LogicalContext.class,i);
		}
		public TerminalNode LOGICAL_OPERATORS() { return getToken(DnlkkRulesParser.LOGICAL_OPERATORS, 0); }
		public LogicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitLogical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalContext logical() throws RecognitionException {
		return logical(0);
	}

	private LogicalContext logical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalContext _localctx = new LogicalContext(_ctx, _parentState);
		LogicalContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__8:
			case STRING_LITERAL:
			case FUN:
			case IDENT:
			case NUM:
			case DOUBLE:
			case BOOL:
			case NULL:
			case UNDEFINED:
			case ADD:
			case MULT:
				{
				setState(142);
				compare(0);
				}
				break;
			case NOT_LOGICAL_OPERATOR:
				{
				setState(143);
				match(NOT_LOGICAL_OPERATOR);
				setState(144);
				((LogicalContext)_localctx).not_operand = logical(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_logical);
					setState(147);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(148);
					match(LOGICAL_OPERATORS);
					setState(149);
					((LogicalContext)_localctx).right = logical(2);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompareContext extends ParserRuleContext {
		public CompareContext left;
		public CompareContext right;
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode COMPARE() { return getToken(DnlkkRulesParser.COMPARE, 0); }
		public List<CompareContext> compare() {
			return getRuleContexts(CompareContext.class);
		}
		public CompareContext compare(int i) {
			return getRuleContext(CompareContext.class,i);
		}
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		return compare(0);
	}

	private CompareContext compare(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompareContext _localctx = new CompareContext(_ctx, _parentState);
		CompareContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_compare, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(156);
			add(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_compare);
					setState(158);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(159);
					match(COMPARE);
					setState(160);
					((CompareContext)_localctx).right = compare(2);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ParserRuleContext {
		public AddContext left;
		public AddContext right;
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public TerminalNode ADD() { return getToken(DnlkkRulesParser.ADD, 0); }
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		return add(0);
	}

	private AddContext add(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddContext _localctx = new AddContext(_ctx, _parentState);
		AddContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_add, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(167);
			mult(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_add);
					setState(169);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(170);
					match(ADD);
					setState(171);
					((AddContext)_localctx).right = add(2);
					}
					} 
				}
				setState(176);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultContext extends ParserRuleContext {
		public MultContext left;
		public MultContext right;
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode MULT() { return getToken(DnlkkRulesParser.MULT, 0); }
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		return mult(0);
	}

	private MultContext mult(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultContext _localctx = new MultContext(_ctx, _parentState);
		MultContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_mult, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(178);
			unary();
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_mult);
					setState(180);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(181);
					match(MULT);
					setState(182);
					((MultContext)_localctx).right = mult(2);
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext unary_add_operand;
		public UnaryContext unary_mult_operand;
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode ADD() { return getToken(DnlkkRulesParser.ADD, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode MULT() { return getToken(DnlkkRulesParser.MULT, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unary);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__8:
			case STRING_LITERAL:
			case FUN:
			case IDENT:
			case NUM:
			case DOUBLE:
			case BOOL:
			case NULL:
			case UNDEFINED:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				call(0);
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(ADD);
				setState(190);
				((UnaryContext)_localctx).unary_add_operand = unary();
				}
				break;
			case MULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(MULT);
				setState(192);
				((UnaryContext)_localctx).unary_mult_operand = unary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	 
		public CallContext() { }
		public void copyFrom(CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Fun_callContext extends CallContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Fun_callContext(CallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterFun_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitFun_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitFun_call(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Group_callContext extends CallContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public Group_callContext(CallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterGroup_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitGroup_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitGroup_call(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Array_callContext extends CallContext {
		public ExprContext index;
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_callContext(CallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterArray_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitArray_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitArray_call(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Object_callContext extends CallContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(DnlkkRulesParser.IDENT, 0); }
		public Object_callContext(CallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterObject_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitObject_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitObject_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		return call(0);
	}

	private CallContext call(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CallContext _localctx = new CallContext(_ctx, _parentState);
		CallContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_call, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Group_callContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(196);
			group();
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Fun_callContext(new CallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_call);
						setState(198);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(199);
						match(T__2);
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 53641482762L) != 0)) {
							{
							setState(200);
							expr();
							setState(205);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__6) {
								{
								{
								setState(201);
								match(T__6);
								setState(202);
								expr();
								}
								}
								setState(207);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(210);
						match(T__3);
						}
						break;
					case 2:
						{
						_localctx = new Object_callContext(new CallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_call);
						setState(211);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(212);
						match(T__7);
						setState(213);
						match(IDENT);
						}
						break;
					case 3:
						{
						_localctx = new Array_callContext(new CallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_call);
						setState(214);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(215);
						match(T__8);
						setState(216);
						((Array_callContext)_localctx).index = expr();
						setState(217);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GroupContext extends ParserRuleContext {
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
	 
		public GroupContext() { }
		public void copyFrom(GroupContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_groupContext extends GroupContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_groupContext(GroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterExpr_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitExpr_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitExpr_group(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_groupContext extends GroupContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public Primitive_groupContext(GroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterPrimitive_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitPrimitive_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitPrimitive_group(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Array_literal_groupContext extends GroupContext {
		public Array_literalContext array_literal() {
			return getRuleContext(Array_literalContext.class,0);
		}
		public Array_literal_groupContext(GroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterArray_literal_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitArray_literal_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitArray_literal_group(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Object_literal_groupContext extends GroupContext {
		public Object_literalContext object_literal() {
			return getRuleContext(Object_literalContext.class,0);
		}
		public Object_literal_groupContext(GroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterObject_literal_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitObject_literal_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitObject_literal_group(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Fun_groupContext extends GroupContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public Fun_groupContext(GroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterFun_group(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitFun_group(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitFun_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_group);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
			case IDENT:
			case NUM:
			case DOUBLE:
			case BOOL:
			case NULL:
			case UNDEFINED:
				_localctx = new Primitive_groupContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				primitive();
				}
				break;
			case FUN:
				_localctx = new Fun_groupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				fun();
				}
				break;
			case T__8:
				_localctx = new Array_literal_groupContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				array_literal();
				}
				break;
			case T__0:
				_localctx = new Object_literal_groupContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				object_literal();
				}
				break;
			case T__2:
				_localctx = new Expr_groupContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(T__2);
				setState(229);
				expr();
				setState(230);
				match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(DnlkkRulesParser.NULL, 0); }
		public TerminalNode UNDEFINED() { return getToken(DnlkkRulesParser.UNDEFINED, 0); }
		public TerminalNode BOOL() { return getToken(DnlkkRulesParser.BOOL, 0); }
		public TerminalNode NUM() { return getToken(DnlkkRulesParser.NUM, 0); }
		public TerminalNode DOUBLE() { return getToken(DnlkkRulesParser.DOUBLE, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DnlkkRulesParser.STRING_LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(DnlkkRulesParser.IDENT, 0); }
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097156096L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends ParserRuleContext {
		public Token fun_ident;
		public TerminalNode FUN() { return getToken(DnlkkRulesParser.FUN, 0); }
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public List<TerminalNode> IDENT() { return getTokens(DnlkkRulesParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(DnlkkRulesParser.IDENT, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(FUN);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(237);
				((FunContext)_localctx).fun_ident = match(IDENT);
				}
			}

			setState(240);
			match(T__2);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(241);
				match(IDENT);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(242);
					match(T__6);
					setState(243);
					match(IDENT);
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(251);
			match(T__3);
			setState(252);
			stmt_block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Array_literalContext extends ParserRuleContext {
		public List<Array_elementContext> array_element() {
			return getRuleContexts(Array_elementContext.class);
		}
		public Array_elementContext array_element(int i) {
			return getRuleContext(Array_elementContext.class,i);
		}
		public Array_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterArray_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitArray_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitArray_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_array_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__8);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 53641482762L) != 0)) {
				{
				setState(255);
				array_element();
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(256);
					match(T__6);
					setState(257);
					array_element();
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(265);
			match(T__9);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Array_elementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public Array_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterArray_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitArray_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitArray_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elementContext array_element() throws RecognitionException {
		Array_elementContext _localctx = new Array_elementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_array_element);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				fun();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Object_literalContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public Object_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterObject_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitObject_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitObject_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_literalContext object_literal() throws RecognitionException {
		Object_literalContext _localctx = new Object_literalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_object_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__0);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(272);
				field();
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(273);
					match(T__6);
					setState(274);
					field();
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(282);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(DnlkkRulesParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DnlkkRulesListener ) ((DnlkkRulesListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DnlkkRulesVisitor ) return ((DnlkkRulesVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(IDENT);
			setState(285);
			match(T__10);
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(286);
				expr();
				}
				break;
			case 2:
				{
				setState(287);
				fun();
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return logical_sempred((LogicalContext)_localctx, predIndex);
		case 14:
			return compare_sempred((CompareContext)_localctx, predIndex);
		case 15:
			return add_sempred((AddContext)_localctx, predIndex);
		case 16:
			return mult_sempred((MultContext)_localctx, predIndex);
		case 18:
			return call_sempred((CallContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_sempred(LogicalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean compare_sempred(CompareContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean add_sempred(AddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mult_sempred(MultContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean call_sempred(CallContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u0123\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003M\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004U\b\u0004\n\u0004\f\u0004"+
		"X\t\u0004\u0001\u0004\u0003\u0004[\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0003\bo\b\b\u0001\b\u0001\b\u0003\bs\b"+
		"\b\u0001\b\u0001\b\u0003\bw\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0084\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008a\b\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0092\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0097\b\r\n\r\f\r\u009a\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00a2\b\u000e"+
		"\n\u000e\f\u000e\u00a5\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ad\b\u000f\n\u000f\f\u000f"+
		"\u00b0\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00b8\b\u0010\n\u0010\f\u0010\u00bb\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c2"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00cc\b\u0012\n\u0012\f\u0012"+
		"\u00cf\t\u0012\u0003\u0012\u00d1\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u00dc\b\u0012\n\u0012\f\u0012\u00df\t\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00e9\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u00ef\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u00f5\b\u0015\n\u0015\f\u0015\u00f8\t\u0015\u0003"+
		"\u0015\u00fa\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0103\b\u0016\n\u0016\f\u0016"+
		"\u0106\t\u0016\u0003\u0016\u0108\b\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u010e\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u0114\b\u0018\n\u0018\f\u0018\u0117\t\u0018"+
		"\u0003\u0018\u0119\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u0121\b\u0019\u0001\u0019\u0000\u0005"+
		"\u001a\u001c\u001e $\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0001\u0003\u0000"+
		"\f\f\u0018\u0018\u001a\u001e\u0131\u00004\u0001\u0000\u0000\u0000\u0002"+
		"7\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006L\u0001"+
		"\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000"+
		"\fb\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010k\u0001"+
		"\u0000\u0000\u0000\u0012{\u0001\u0000\u0000\u0000\u0014~\u0001\u0000\u0000"+
		"\u0000\u0016\u0085\u0001\u0000\u0000\u0000\u0018\u008b\u0001\u0000\u0000"+
		"\u0000\u001a\u0091\u0001\u0000\u0000\u0000\u001c\u009b\u0001\u0000\u0000"+
		"\u0000\u001e\u00a6\u0001\u0000\u0000\u0000 \u00b1\u0001\u0000\u0000\u0000"+
		"\"\u00c1\u0001\u0000\u0000\u0000$\u00c3\u0001\u0000\u0000\u0000&\u00e8"+
		"\u0001\u0000\u0000\u0000(\u00ea\u0001\u0000\u0000\u0000*\u00ec\u0001\u0000"+
		"\u0000\u0000,\u00fe\u0001\u0000\u0000\u0000.\u010d\u0001\u0000\u0000\u0000"+
		"0\u010f\u0001\u0000\u0000\u00002\u011c\u0001\u0000\u0000\u000045\u0003"+
		"\u0002\u0001\u000056\u0005\u0000\u0000\u00016\u0001\u0001\u0000\u0000"+
		"\u00007;\u0003\u0006\u0003\u00008:\u0003\u0006\u0003\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<\u0003\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>@\u0005\u0001\u0000\u0000?A\u0003\u0002\u0001\u0000@?\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0005"+
		"\u0002\u0000\u0000C\u0005\u0001\u0000\u0000\u0000DM\u0003\u0014\n\u0000"+
		"EM\u0003\u0016\u000b\u0000FM\u0003\u0018\f\u0000GM\u0003\b\u0004\u0000"+
		"HM\u0003\u000e\u0007\u0000IM\u0003\u0010\b\u0000JM\u0003\u0012\t\u0000"+
		"KM\u0005\u0014\u0000\u0000LD\u0001\u0000\u0000\u0000LE\u0001\u0000\u0000"+
		"\u0000LF\u0001\u0000\u0000\u0000LG\u0001\u0000\u0000\u0000LH\u0001\u0000"+
		"\u0000\u0000LI\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005\r\u0000\u0000"+
		"OP\u0005\u0003\u0000\u0000PQ\u0003\u0018\f\u0000QR\u0005\u0004\u0000\u0000"+
		"RV\u0003\u0004\u0002\u0000SU\u0003\n\u0005\u0000TS\u0001\u0000\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y[\u0003\f\u0006"+
		"\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\t\u0001\u0000"+
		"\u0000\u0000\\]\u0005\u000e\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0003"+
		"\u0018\f\u0000_`\u0005\u0004\u0000\u0000`a\u0003\u0004\u0002\u0000a\u000b"+
		"\u0001\u0000\u0000\u0000bc\u0005\u000f\u0000\u0000cd\u0003\u0004\u0002"+
		"\u0000d\r\u0001\u0000\u0000\u0000ef\u0005\u0010\u0000\u0000fg\u0005\u0003"+
		"\u0000\u0000gh\u0003\u0018\f\u0000hi\u0005\u0004\u0000\u0000ij\u0003\u0004"+
		"\u0002\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005\u0011\u0000\u0000"+
		"ln\u0005\u0003\u0000\u0000mo\u0003\u0014\n\u0000nm\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0005\u0005\u0000"+
		"\u0000qs\u0003\u001a\r\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0005\u0005\u0000\u0000uw\u0003\u0016"+
		"\u000b\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0005\u0004\u0000\u0000yz\u0003\u0004\u0002\u0000"+
		"z\u0011\u0001\u0000\u0000\u0000{|\u0005\u0012\u0000\u0000|}\u0003\u0018"+
		"\f\u0000}\u0013\u0001\u0000\u0000\u0000~\u007f\u0005\u0017\u0000\u0000"+
		"\u007f\u0080\u0005\u0018\u0000\u0000\u0080\u0083\u0005\u0006\u0000\u0000"+
		"\u0081\u0084\u0003\u0018\f\u0000\u0082\u0084\u0003*\u0015\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0015\u0001\u0000\u0000\u0000\u0085\u0086\u0003$\u0012\u0000\u0086\u0089"+
		"\u0005\u0006\u0000\u0000\u0087\u008a\u0003\u0018\f\u0000\u0088\u008a\u0003"+
		"*\u0015\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u0017\u0001\u0000\u0000\u0000\u008b\u008c\u0003\u001a"+
		"\r\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u008d\u008e\u0006\r\uffff"+
		"\uffff\u0000\u008e\u0092\u0003\u001c\u000e\u0000\u008f\u0090\u0005\u0016"+
		"\u0000\u0000\u0090\u0092\u0003\u001a\r\u0002\u0091\u008d\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0098\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\n\u0001\u0000\u0000\u0094\u0095\u0005\u0015\u0000\u0000"+
		"\u0095\u0097\u0003\u001a\r\u0002\u0096\u0093\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u001b\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0006\u000e\uffff\uffff\u0000"+
		"\u009c\u009d\u0003\u001e\u000f\u0000\u009d\u00a3\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\n\u0001\u0000\u0000\u009f\u00a0\u0005!\u0000\u0000\u00a0"+
		"\u00a2\u0003\u001c\u000e\u0002\u00a1\u009e\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u001d\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0006\u000f\uffff\uffff\u0000"+
		"\u00a7\u00a8\u0003 \u0010\u0000\u00a8\u00ae\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\n\u0001\u0000\u0000\u00aa\u00ab\u0005\"\u0000\u0000\u00ab\u00ad"+
		"\u0003\u001e\u000f\u0002\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ad\u00b0"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u001f\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0006\u0010\uffff\uffff\u0000\u00b2"+
		"\u00b3\u0003\"\u0011\u0000\u00b3\u00b9\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\n\u0001\u0000\u0000\u00b5\u00b6\u0005#\u0000\u0000\u00b6\u00b8\u0003"+
		" \u0010\u0002\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bc\u00c2\u0003$\u0012\u0000\u00bd\u00be\u0005\"\u0000\u0000"+
		"\u00be\u00c2\u0003\"\u0011\u0000\u00bf\u00c0\u0005#\u0000\u0000\u00c0"+
		"\u00c2\u0003\"\u0011\u0000\u00c1\u00bc\u0001\u0000\u0000\u0000\u00c1\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2#\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0006\u0012\uffff\uffff\u0000\u00c4\u00c5"+
		"\u0003&\u0013\u0000\u00c5\u00dd\u0001\u0000\u0000\u0000\u00c6\u00c7\n"+
		"\u0003\u0000\u0000\u00c7\u00d0\u0005\u0003\u0000\u0000\u00c8\u00cd\u0003"+
		"\u0018\f\u0000\u00c9\u00ca\u0005\u0007\u0000\u0000\u00ca\u00cc\u0003\u0018"+
		"\f\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d0\u00c8\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00dc\u0005\u0004\u0000"+
		"\u0000\u00d3\u00d4\n\u0002\u0000\u0000\u00d4\u00d5\u0005\b\u0000\u0000"+
		"\u00d5\u00dc\u0005\u0018\u0000\u0000\u00d6\u00d7\n\u0001\u0000\u0000\u00d7"+
		"\u00d8\u0005\t\u0000\u0000\u00d8\u00d9\u0003\u0018\f\u0000\u00d9\u00da"+
		"\u0005\n\u0000\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00c6\u0001"+
		"\u0000\u0000\u0000\u00db\u00d3\u0001\u0000\u0000\u0000\u00db\u00d6\u0001"+
		"\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de%\u0001\u0000"+
		"\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e9\u0003(\u0014"+
		"\u0000\u00e1\u00e9\u0003*\u0015\u0000\u00e2\u00e9\u0003,\u0016\u0000\u00e3"+
		"\u00e9\u00030\u0018\u0000\u00e4\u00e5\u0005\u0003\u0000\u0000\u00e5\u00e6"+
		"\u0003\u0018\f\u0000\u00e6\u00e7\u0005\u0004\u0000\u0000\u00e7\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e0\u0001\u0000\u0000\u0000\u00e8\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e2\u0001\u0000\u0000\u0000\u00e8\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000\u00e9\'\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0007\u0000\u0000\u0000\u00eb)\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ee\u0005\u0013\u0000\u0000\u00ed\u00ef\u0005\u0018\u0000"+
		"\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f9\u0005\u0003\u0000"+
		"\u0000\u00f1\u00f6\u0005\u0018\u0000\u0000\u00f2\u00f3\u0005\u0007\u0000"+
		"\u0000\u00f3\u00f5\u0005\u0018\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0005\u0004\u0000\u0000\u00fc\u00fd\u0003\u0004\u0002"+
		"\u0000\u00fd+\u0001\u0000\u0000\u0000\u00fe\u0107\u0005\t\u0000\u0000"+
		"\u00ff\u0104\u0003.\u0017\u0000\u0100\u0101\u0005\u0007\u0000\u0000\u0101"+
		"\u0103\u0003.\u0017\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0106"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u00ff\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0005\n\u0000\u0000\u010a-\u0001\u0000\u0000\u0000\u010b\u010e\u0003"+
		"\u0018\f\u0000\u010c\u010e\u0003*\u0015\u0000\u010d\u010b\u0001\u0000"+
		"\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e/\u0001\u0000\u0000"+
		"\u0000\u010f\u0118\u0005\u0001\u0000\u0000\u0110\u0115\u00032\u0019\u0000"+
		"\u0111\u0112\u0005\u0007\u0000\u0000\u0112\u0114\u00032\u0019\u0000\u0113"+
		"\u0111\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115"+
		"\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116"+
		"\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118"+
		"\u0110\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0002\u0000\u0000\u011b"+
		"1\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u0018\u0000\u0000\u011d\u0120"+
		"\u0005\u000b\u0000\u0000\u011e\u0121\u0003\u0018\f\u0000\u011f\u0121\u0003"+
		"*\u0015\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u011f\u0001\u0000"+
		"\u0000\u0000\u01213\u0001\u0000\u0000\u0000\u001e;@LVZnrv\u0083\u0089"+
		"\u0091\u0098\u00a3\u00ae\u00b9\u00c1\u00cd\u00d0\u00db\u00dd\u00e8\u00ee"+
		"\u00f6\u00f9\u0104\u0107\u010d\u0115\u0118\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}