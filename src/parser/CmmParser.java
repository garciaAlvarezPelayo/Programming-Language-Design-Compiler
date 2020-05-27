// Generated from E:/Grado/DLP/lab5/src/parser\Cmm.g4 by ANTLR 4.8
package parser;

    import ast.definitions.*;
    import ast.expressions.*;
    import ast.main.*;
    import ast.statements.*;
    import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
import java.util.List;
    import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, INT_CONSTANT=37, ONE_LINE_COMMENT=38, 
		MULTIPLE_LINE_COMMENT=39, ID=40, REAL_CONSTANT=41, CHAR_CONSTANT=42, WS=43;
	public static final int
		RULE_program = 0, RULE_builtinType = 1, RULE_type = 2, RULE_funcInv = 3, 
		RULE_expression = 4, RULE_statement = 5, RULE_definition = 6, RULE_varDefinition = 7, 
		RULE_identifiers = 8, RULE_statements = 9, RULE_definitions = 10, RULE_expressions = 11, 
		RULE_block = 12, RULE_funcTypes = 13, RULE_parameters = 14, RULE_records = 15, 
		RULE_main = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "builtinType", "type", "funcInv", "expression", "statement", 
			"definition", "varDefinition", "identifiers", "statements", "definitions", 
			"expressions", "block", "funcTypes", "parameters", "records", "main"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'double'", "'char'", "'['", "']'", "'struct'", "'{'", 
			"'}'", "'('", "')'", "'.'", "'-'", "'*'", "'/'", "'%'", "'+'", "'!'", 
			"'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "'='", 
			"';'", "'if'", "'else'", "'read'", "'write'", "'return'", "'while'", 
			"','", "'void'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", "ID", 
			"REAL_CONSTANT", "CHAR_CONSTANT", "WS"
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public MainContext main;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((ProgramContext)_localctx).definitions = definitions();
			setState(35);
			((ProgramContext)_localctx).main = main();
			setState(36);
			match(EOF);
			List<Definition> list = ((ProgramContext)_localctx).definitions.ast;
			                                            list.add(((ProgramContext)_localctx).main.ast);
			                                            ((ProgramContext)_localctx).ast =  new Program((((ProgramContext)_localctx).definitions!=null?(((ProgramContext)_localctx).definitions.start):null).getLine()
			                                                                , (((ProgramContext)_localctx).definitions!=null?(((ProgramContext)_localctx).definitions.start):null).getCharPositionInLine()+1
			                                                                , list);
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

	public static class BuiltinTypeContext extends ParserRuleContext {
		public Type ast;
		public Token i;
		public Token d;
		public Token c;
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_builtinType);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				((BuiltinTypeContext)_localctx).i = match(T__0);
				((BuiltinTypeContext)_localctx).ast =  new IntType(((BuiltinTypeContext)_localctx).i.getLine()
				                                                          , ((BuiltinTypeContext)_localctx).i.getCharPositionInLine()+1);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				((BuiltinTypeContext)_localctx).d = match(T__1);
				((BuiltinTypeContext)_localctx).ast =  new DoubleType(((BuiltinTypeContext)_localctx).d.getLine()
				                                                         , ((BuiltinTypeContext)_localctx).d.getCharPositionInLine()+1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				((BuiltinTypeContext)_localctx).c = match(T__2);
				((BuiltinTypeContext)_localctx).ast =  new CharType(((BuiltinTypeContext)_localctx).c.getLine()
				                                                            , ((BuiltinTypeContext)_localctx).c.getCharPositionInLine()+1);
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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext ty;
		public BuiltinTypeContext builtinType;
		public Token s;
		public RecordsContext records;
		public Token INT_CONSTANT;
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public RecordsContext records() {
			return getRuleContext(RecordsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				{
				setState(48);
				((TypeContext)_localctx).builtinType = builtinType();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).builtinType.ast;
				}
				break;
			case T__5:
				{
				setState(51);
				((TypeContext)_localctx).s = match(T__5);
				setState(52);
				match(T__6);
				setState(53);
				((TypeContext)_localctx).records = records();
				setState(54);
				match(T__7);
				((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).s.getLine()
				                                                              , ((TypeContext)_localctx).s.getCharPositionInLine()+1
				                                                              , ((TypeContext)_localctx).records.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.ty = _prevctx;
					_localctx.ty = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(59);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(60);
					match(T__3);
					setState(61);
					((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
					setState(62);
					match(T__4);
					((TypeContext)_localctx).ast =  new ArrayType((((TypeContext)_localctx).ty!=null?(((TypeContext)_localctx).ty.start):null).getLine()
					                                                                       , (((TypeContext)_localctx).ty!=null?(((TypeContext)_localctx).ty.start):null).getCharPositionInLine()+1
					                                                                       , ((TypeContext)_localctx).ty.ast
					                                                                       , LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null))).UpdateArray();
					}
					} 
				}
				setState(68);
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

	public static class FuncInvContext extends ParserRuleContext {
		public FuncInv ast;
		public Token ID;
		public ExpressionsContext expressions;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FuncInvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcInv; }
	}

	public final FuncInvContext funcInv() throws RecognitionException {
		FuncInvContext _localctx = new FuncInvContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcInv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((FuncInvContext)_localctx).ID = match(ID);
			((FuncInvContext)_localctx).ast =  new FuncInv(((FuncInvContext)_localctx).ID.getLine()
			                                                           , ((FuncInvContext)_localctx).ID.getCharPositionInLine()+1
			                                                           , new Variable(((FuncInvContext)_localctx).ID.getLine()
			                                                                         , ((FuncInvContext)_localctx).ID.getCharPositionInLine()+1
			                                                                         , (((FuncInvContext)_localctx).ID!=null?((FuncInvContext)_localctx).ID.getText():null))
			                                                           , new ArrayList<Expression>());
			setState(71);
			match(T__8);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << INT_CONSTANT) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				setState(72);
				((FuncInvContext)_localctx).expressions = expressions();
				_localctx.ast.setExpressions(((FuncInvContext)_localctx).expressions.ast);
				}
			}

			setState(77);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp1;
		public ExpressionContext ex;
		public FuncInvContext funcInv;
		public BuiltinTypeContext builtinType;
		public Token ID;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token op;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncInvContext funcInv() {
			return getRuleContext(FuncInvContext.class,0);
		}
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(80);
				match(T__8);
				setState(81);
				((ExpressionContext)_localctx).ex = expression(0);
				setState(82);
				match(T__9);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).ex.ast;
				}
				break;
			case 2:
				{
				setState(85);
				((ExpressionContext)_localctx).funcInv = funcInv();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).funcInv.ast;
				}
				break;
			case 3:
				{
				setState(88);
				match(T__8);
				setState(89);
				((ExpressionContext)_localctx).builtinType = builtinType();
				setState(90);
				match(T__9);
				setState(91);
				((ExpressionContext)_localctx).ex = expression(11);
				((ExpressionContext)_localctx).ast =  new CastType((((ExpressionContext)_localctx).builtinType!=null?(((ExpressionContext)_localctx).builtinType.start):null).getLine()
				                                                            , (((ExpressionContext)_localctx).builtinType!=null?(((ExpressionContext)_localctx).builtinType.start):null).getCharPositionInLine()+1
				                                                            , ((ExpressionContext)_localctx).builtinType.ast
				                                                            , ((ExpressionContext)_localctx).ex.ast);
				}
				break;
			case 4:
				{
				setState(94);
				match(T__11);
				setState(95);
				((ExpressionContext)_localctx).ex = expression(10);
				((ExpressionContext)_localctx).ast =  new UnaryMinus((((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getLine()
				                                                              , (((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getCharPositionInLine()+1
				                                                              , ((ExpressionContext)_localctx).ex.ast);
				}
				break;
			case 5:
				{
				setState(98);
				match(T__16);
				setState(99);
				((ExpressionContext)_localctx).ex = expression(7);
				((ExpressionContext)_localctx).ast =  new UnaryNegation((((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getLine()
				                                                                 , (((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getCharPositionInLine()+1
				                                                                 , ((ExpressionContext)_localctx).ex.ast);
				}
				break;
			case 6:
				{
				setState(102);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine()
				                                                            , ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1
				                                                            , (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 7:
				{
				setState(104);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine()
				                                                            , ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1
				                                                            , LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 8:
				{
				setState(106);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine()
				                                                               , ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1
				                                                               , LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			case 9:
				{
				setState(108);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharacterLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine()
				                                                                    , ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1
				                                                                    , LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(142);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(114);
						((ExpressionContext)_localctx).exp2 = expression(10);
						((ExpressionContext)_localctx).ast =  new AritmeticOperator((((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getLine()
						                                                                               , (((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getCharPositionInLine()+1
						                                                                               , (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)
						                                                                               , ((ExpressionContext)_localctx).exp1.ast
						                                                                               , ((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(118);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__15) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(119);
						((ExpressionContext)_localctx).exp2 = expression(9);
						((ExpressionContext)_localctx).ast =  new AritmeticOperator((((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getLine()
						                                                                               , (((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getCharPositionInLine()+1
						                                                                               , (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)
						                                                                               , ((ExpressionContext)_localctx).exp1.ast
						                                                                               , ((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(123);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						((ExpressionContext)_localctx).exp2 = expression(7);
						((ExpressionContext)_localctx).ast =  new LogicalComparator((((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getLine()
						                                                                               , (((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getCharPositionInLine()+1
						                                                                               , (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)
						                                                                               , ((ExpressionContext)_localctx).exp1.ast
						                                                                               , ((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(128);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						((ExpressionContext)_localctx).exp2 = expression(6);
						((ExpressionContext)_localctx).ast =  new LogicalDoor((((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getLine()
						                                                                         , (((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getCharPositionInLine()+1
						                                                                         , (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)
						                                                                         , ((ExpressionContext)_localctx).exp1.ast
						                                                                         , ((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(133);
						match(T__3);
						setState(134);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(135);
						match(T__4);
						((ExpressionContext)_localctx).ast =  new Indexing((((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getLine()
						                                                                      , (((ExpressionContext)_localctx).exp1!=null?(((ExpressionContext)_localctx).exp1.start):null).getCharPositionInLine()+1
						                                                                      , ((ExpressionContext)_localctx).exp1.ast
						                                                                      , ((ExpressionContext)_localctx).exp2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex = _prevctx;
						_localctx.ex = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(139);
						match(T__10);
						setState(140);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess((((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getLine()
						                                                                          , (((ExpressionContext)_localctx).ex!=null?(((ExpressionContext)_localctx).ex.start):null).getCharPositionInLine()+1
						                                                                          , (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)
						                                                                          , ((ExpressionContext)_localctx).ex.ast);
						}
						break;
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public IfElse ifelse;
		public ExpressionContext exp1;
		public Token op;
		public ExpressionContext exp2;
		public ExpressionContext expression;
		public BlockContext b1;
		public BlockContext b2;
		public ExpressionsContext expressions;
		public Token r;
		public Token w;
		public BlockContext block;
		public FuncInvContext funcInv;
		public VarDefinitionContext varDefinition;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FuncInvContext funcInv() {
			return getRuleContext(FuncInvContext.class,0);
		}
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(148);
				((StatementContext)_localctx).op = match(T__25);
				setState(149);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(150);
				match(T__26);
				_localctx.ast.add(new Assigment((((StatementContext)_localctx).exp1!=null?(((StatementContext)_localctx).exp1.start):null).getLine()
				                                                                            , (((StatementContext)_localctx).exp1!=null?(((StatementContext)_localctx).exp1.start):null).getCharPositionInLine()+1
				                                                                            , ((StatementContext)_localctx).exp1.ast
				                                                                            , ((StatementContext)_localctx).exp2.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(T__27);
				setState(154);
				match(T__8);
				setState(155);
				((StatementContext)_localctx).expression = expression(0);
				setState(156);
				match(T__9);
				setState(157);
				((StatementContext)_localctx).b1 = block();
				((StatementContext)_localctx).ifelse =  new IfElse((((StatementContext)_localctx).expression!=null?(((StatementContext)_localctx).expression.start):null).getLine()
				                                                                        , (((StatementContext)_localctx).expression!=null?(((StatementContext)_localctx).expression.start):null).getCharPositionInLine()+1
				                                                                        , ((StatementContext)_localctx).expression.ast
				                                                                        , ((StatementContext)_localctx).b1.ast);
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(159);
					match(T__28);
					setState(160);
					((StatementContext)_localctx).b2 = block();
					_localctx.ifelse.setElse(((StatementContext)_localctx).b2.ast);
					}
					break;
				}
				_localctx.ast.add(_localctx.ifelse);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				((StatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
					((StatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(168);
				((StatementContext)_localctx).expressions = expressions();
				setState(169);
				match(T__26);
				if((((StatementContext)_localctx).op!=null?((StatementContext)_localctx).op.getText():null).equals("read"))
				                                                        for(Expression each : ((StatementContext)_localctx).expressions.ast)
				                                                            _localctx.ast.add(new Read(((StatementContext)_localctx).op.getLine()
				                                                                     , ((StatementContext)_localctx).op.getCharPositionInLine()+1
				                                                                     , each));
				                                                    else
				                                                        for(Expression each : ((StatementContext)_localctx).expressions.ast)
				                                                            _localctx.ast.add(new Write(((StatementContext)_localctx).op.getLine()
				                                                                            , ((StatementContext)_localctx).op.getCharPositionInLine()+1
				                                                                            , each));
				                                                    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				((StatementContext)_localctx).r = match(T__31);
				setState(173);
				((StatementContext)_localctx).expression = expression(0);
				setState(174);
				match(T__26);
				_localctx.ast.add(new Return(((StatementContext)_localctx).r.getLine()
				                                                                      , ((StatementContext)_localctx).r.getCharPositionInLine()+1
				                                                                      , ((StatementContext)_localctx).expression.ast));
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(177);
				((StatementContext)_localctx).w = match(T__32);
				setState(178);
				match(T__8);
				setState(179);
				((StatementContext)_localctx).expression = expression(0);
				setState(180);
				match(T__9);
				setState(181);
				((StatementContext)_localctx).block = block();
				_localctx.ast.add(new While(((StatementContext)_localctx).w.getLine()
				                                                                     , ((StatementContext)_localctx).w.getCharPositionInLine()+1
				                                                                     , ((StatementContext)_localctx).expression.ast
				                                                                     , ((StatementContext)_localctx).block.ast));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				((StatementContext)_localctx).funcInv = funcInv();
				setState(185);
				match(T__26);
				_localctx.ast.add(((StatementContext)_localctx).funcInv.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				((StatementContext)_localctx).varDefinition = varDefinition();
				setState(189);
				match(T__26);
				_localctx.ast.addAll(((StatementContext)_localctx).varDefinition.ast);
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

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public FuncTypesContext funcTypes;
		public Token ID;
		public ParametersContext parameters;
		public StatementsContext statements;
		public VarDefinitionContext varDefinition;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FuncTypesContext funcTypes() {
			return getRuleContext(FuncTypesContext.class,0);
		}
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_definition);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(194);
				((DefinitionContext)_localctx).funcTypes = funcTypes();
				}
				setState(195);
				((DefinitionContext)_localctx).ID = match(ID);
				setState(196);
				match(T__8);
				setState(197);
				((DefinitionContext)_localctx).parameters = parameters();
				setState(198);
				match(T__9);
				setState(199);
				match(T__6);
				setState(200);
				((DefinitionContext)_localctx).statements = statements();
				setState(201);
				match(T__7);
				_localctx.ast.add(new FuncDefinition((((DefinitionContext)_localctx).funcTypes!=null?(((DefinitionContext)_localctx).funcTypes.start):null).getLine()
				                                                                                                                    , (((DefinitionContext)_localctx).funcTypes!=null?(((DefinitionContext)_localctx).funcTypes.start):null).getCharPositionInLine()+1
				                                                                                                                    , new FuncType((((DefinitionContext)_localctx).funcTypes!=null?(((DefinitionContext)_localctx).funcTypes.start):null).getLine()
				                                                                                                                                    , (((DefinitionContext)_localctx).funcTypes!=null?(((DefinitionContext)_localctx).funcTypes.start):null).getCharPositionInLine()+1
				                                                                                                                                    , ((DefinitionContext)_localctx).funcTypes.ast
				                                                                                                                                    , ((DefinitionContext)_localctx).parameters.ast)
				                                                                                                                    , (((DefinitionContext)_localctx).ID!=null?((DefinitionContext)_localctx).ID.getText():null)
				                                                                                                                    , ((DefinitionContext)_localctx).statements.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				((DefinitionContext)_localctx).varDefinition = varDefinition();
				_localctx.ast.addAll(((DefinitionContext)_localctx).varDefinition.ast);
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

	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext type;
		public IdentifiersContext identifiers;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiersContext identifiers() {
			return getRuleContext(IdentifiersContext.class,0);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			((VarDefinitionContext)_localctx).type = type(0);
			setState(210);
			((VarDefinitionContext)_localctx).identifiers = identifiers();
			setState(211);
			match(T__26);
			for(String each : ((VarDefinitionContext)_localctx).identifiers.ast)
			                                                                                            _localctx.ast.add(new VarDefinition((((VarDefinitionContext)_localctx).type!=null?(((VarDefinitionContext)_localctx).type.start):null).getLine()
			                                                                                                                        , (((VarDefinitionContext)_localctx).type!=null?(((VarDefinitionContext)_localctx).type.start):null).getCharPositionInLine()+1
			                                                                                                                        , ((VarDefinitionContext)_localctx).type.ast
			                                                                                                                        , each));
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

	public static class IdentifiersContext extends ParserRuleContext {
		public List<String> ast = new ArrayList<String>();
		public Token ID;
		public IdentifiersContext id;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public IdentifiersContext identifiers() {
			return getRuleContext(IdentifiersContext.class,0);
		}
		public IdentifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiers; }
	}

	public final IdentifiersContext identifiers() throws RecognitionException {
		IdentifiersContext _localctx = new IdentifiersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifiers);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				((IdentifiersContext)_localctx).ID = match(ID);
				setState(215);
				match(T__33);
				setState(216);
				((IdentifiersContext)_localctx).id = identifiers();
				_localctx.ast.add((((IdentifiersContext)_localctx).ID!=null?((IdentifiersContext)_localctx).ID.getText():null)); _localctx.ast.addAll(((IdentifiersContext)_localctx).id.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((IdentifiersContext)_localctx).ID = match(ID);
				_localctx.ast.add((((IdentifiersContext)_localctx).ID!=null?((IdentifiersContext)_localctx).ID.getText():null));
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

	public static class StatementsContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public VarDefinitionContext varDefinition;
		public StatementContext statement;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					((StatementsContext)_localctx).varDefinition = varDefinition();
					_localctx.ast.addAll(((StatementsContext)_localctx).varDefinition.ast);
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << INT_CONSTANT) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(231);
				((StatementsContext)_localctx).statement = statement();
				_localctx.ast.addAll(((StatementsContext)_localctx).statement.ast);
				}
				}
				setState(238);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(239);
					((DefinitionsContext)_localctx).definition = definition();
					_localctx.ast.addAll(((DefinitionsContext)_localctx).definition.ast);
					}
					} 
				}
				setState(246);
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
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext expression;
		public ExpressionsContext exs;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressions);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				((ExpressionsContext)_localctx).expression = expression(0);
				setState(248);
				match(T__33);
				setState(249);
				((ExpressionsContext)_localctx).exs = expressions();
				_localctx.ast.add(((ExpressionsContext)_localctx).expression.ast); _localctx.ast.addAll(((ExpressionsContext)_localctx).exs.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				((ExpressionsContext)_localctx).expression = expression(0);
				_localctx.ast.add(((ExpressionsContext)_localctx).expression.ast);
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

	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(T__6);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << INT_CONSTANT) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(258);
					((BlockContext)_localctx).statement = statement();
					_localctx.ast.addAll(((BlockContext)_localctx).statement.ast);
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(266);
				match(T__7);
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__5:
			case T__8:
			case T__11:
			case T__16:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case INT_CONSTANT:
			case ID:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				((BlockContext)_localctx).statement = statement();
				_localctx.ast.addAll(((BlockContext)_localctx).statement.ast);
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

	public static class FuncTypesContext extends ParserRuleContext {
		public Type ast;
		public BuiltinTypeContext builtinType;
		public Token v;
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public FuncTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcTypes; }
	}

	public final FuncTypesContext funcTypes() throws RecognitionException {
		FuncTypesContext _localctx = new FuncTypesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcTypes);
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				((FuncTypesContext)_localctx).builtinType = builtinType();
				((FuncTypesContext)_localctx).ast =  ((FuncTypesContext)_localctx).builtinType.ast;
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				((FuncTypesContext)_localctx).v = match(T__34);
				((FuncTypesContext)_localctx).ast =  new VoidType(((FuncTypesContext)_localctx).v.getLine()
				                                                , ((FuncTypesContext)_localctx).v.getCharPositionInLine()+1);
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

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext type;
		public Token ID;
		public ParametersContext p;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				((ParametersContext)_localctx).type = type(0);
				setState(280);
				((ParametersContext)_localctx).ID = match(ID);
				setState(281);
				match(T__33);
				setState(282);
				((ParametersContext)_localctx).p = parameters();
				_localctx.ast.add(new VarDefinition((((ParametersContext)_localctx).type!=null?(((ParametersContext)_localctx).type.start):null).getLine()
				                                                                                                            , (((ParametersContext)_localctx).type!=null?(((ParametersContext)_localctx).type.start):null).getCharPositionInLine()
				                                                                                                            , ((ParametersContext)_localctx).type.ast
				                                                                                                            , (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null))); _localctx.ast.addAll(((ParametersContext)_localctx).p.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				((ParametersContext)_localctx).type = type(0);
				setState(286);
				((ParametersContext)_localctx).ID = match(ID);
				_localctx.ast.add(new VarDefinition((((ParametersContext)_localctx).type!=null?(((ParametersContext)_localctx).type.start):null).getLine()
				                                                                                                            , (((ParametersContext)_localctx).type!=null?(((ParametersContext)_localctx).type.start):null).getCharPositionInLine()
				                                                                                                            , ((ParametersContext)_localctx).type.ast
				                                                                                                            , (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null)));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class RecordsContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public TypeContext type;
		public IdentifiersContext identifiers;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifiersContext> identifiers() {
			return getRuleContexts(IdentifiersContext.class);
		}
		public IdentifiersContext identifiers(int i) {
			return getRuleContext(IdentifiersContext.class,i);
		}
		public RecordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_records; }
	}

	public final RecordsContext records() throws RecognitionException {
		RecordsContext _localctx = new RecordsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_records);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__5))) != 0)) {
				{
				{
				setState(292);
				((RecordsContext)_localctx).type = type(0);
				setState(293);
				((RecordsContext)_localctx).identifiers = identifiers();
				setState(294);
				match(T__26);
				for (String each : ((RecordsContext)_localctx).identifiers.ast)
				                                                                                            _localctx.ast.add(new RecordField((((RecordsContext)_localctx).type!=null?(((RecordsContext)_localctx).type.start):null).getLine()
				                                                                                                                    , (((RecordsContext)_localctx).type!=null?(((RecordsContext)_localctx).type.start):null).getCharPositionInLine()+1
				                                                                                                                    , ((RecordsContext)_localctx).type.ast
				                                                                                                                    , each));
				}
				}
				setState(301);
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

	public static class MainContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token v;
		public Token id;
		public StatementsContext statements;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			((MainContext)_localctx).v = match(T__34);
			setState(303);
			((MainContext)_localctx).id = match(T__35);
			setState(304);
			match(T__8);
			setState(305);
			match(T__9);
			setState(306);
			match(T__6);
			setState(307);
			((MainContext)_localctx).statements = statements();
			setState(308);
			match(T__7);
			((MainContext)_localctx).ast =  new FuncDefinition(((MainContext)_localctx).v.getLine()
			                                                              , ((MainContext)_localctx).v.getCharPositionInLine()+1
			                                                              , new FuncType(((MainContext)_localctx).v.getLine()
			                                                                            , ((MainContext)_localctx).v.getCharPositionInLine()+1
			                                                                            , new VoidType(((MainContext)_localctx).v.getLine()
			                                                                                            , ((MainContext)_localctx).v.getCharPositionInLine()+1))
			                                                              , (((MainContext)_localctx).id!=null?((MainContext)_localctx).id.getText():null)
			                                                              , ((MainContext)_localctx).statements.ast);
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
		case 2:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\3\4\3\4\3\4\7\4C\n\4\f\4\16"+
		"\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0091\n\6\f\6\16\6\u0094\13\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a6\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00c3\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d2\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e0\n\n\3\13\3\13\3\13\7\13\u00e5\n\13\f"+
		"\13\16\13\u00e8\13\13\3\13\3\13\3\13\7\13\u00ed\n\13\f\13\16\13\u00f0"+
		"\13\13\3\f\3\f\3\f\7\f\u00f5\n\f\f\f\16\f\u00f8\13\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0102\n\r\3\16\3\16\3\16\3\16\7\16\u0108\n\16\f\16"+
		"\16\16\u010b\13\16\3\16\3\16\3\16\3\16\5\16\u0111\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0118\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0125\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u012c\n\21\f"+
		"\21\16\21\u012f\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\2\4\6\n\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\7\3\2\17\21\4"+
		"\2\16\16\22\22\3\2\24\31\3\2\32\33\3\2 !\2\u014e\2$\3\2\2\2\4/\3\2\2\2"+
		"\6;\3\2\2\2\bG\3\2\2\2\np\3\2\2\2\f\u00c2\3\2\2\2\16\u00d1\3\2\2\2\20"+
		"\u00d3\3\2\2\2\22\u00df\3\2\2\2\24\u00e6\3\2\2\2\26\u00f6\3\2\2\2\30\u0101"+
		"\3\2\2\2\32\u0110\3\2\2\2\34\u0117\3\2\2\2\36\u0124\3\2\2\2 \u012d\3\2"+
		"\2\2\"\u0130\3\2\2\2$%\5\26\f\2%&\5\"\22\2&\'\7\2\2\3\'(\b\2\1\2(\3\3"+
		"\2\2\2)*\7\3\2\2*\60\b\3\1\2+,\7\4\2\2,\60\b\3\1\2-.\7\5\2\2.\60\b\3\1"+
		"\2/)\3\2\2\2/+\3\2\2\2/-\3\2\2\2\60\5\3\2\2\2\61\62\b\4\1\2\62\63\5\4"+
		"\3\2\63\64\b\4\1\2\64<\3\2\2\2\65\66\7\b\2\2\66\67\7\t\2\2\678\5 \21\2"+
		"89\7\n\2\29:\b\4\1\2:<\3\2\2\2;\61\3\2\2\2;\65\3\2\2\2<D\3\2\2\2=>\f\4"+
		"\2\2>?\7\6\2\2?@\7\'\2\2@A\7\7\2\2AC\b\4\1\2B=\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GH\7*\2\2HI\b\5\1\2IM\7\13\2\2JK\5"+
		"\30\r\2KL\b\5\1\2LN\3\2\2\2MJ\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\f\2\2P\t"+
		"\3\2\2\2QR\b\6\1\2RS\7\13\2\2ST\5\n\6\2TU\7\f\2\2UV\b\6\1\2Vq\3\2\2\2"+
		"WX\5\b\5\2XY\b\6\1\2Yq\3\2\2\2Z[\7\13\2\2[\\\5\4\3\2\\]\7\f\2\2]^\5\n"+
		"\6\r^_\b\6\1\2_q\3\2\2\2`a\7\16\2\2ab\5\n\6\fbc\b\6\1\2cq\3\2\2\2de\7"+
		"\23\2\2ef\5\n\6\tfg\b\6\1\2gq\3\2\2\2hi\7*\2\2iq\b\6\1\2jk\7\'\2\2kq\b"+
		"\6\1\2lm\7+\2\2mq\b\6\1\2no\7,\2\2oq\b\6\1\2pQ\3\2\2\2pW\3\2\2\2pZ\3\2"+
		"\2\2p`\3\2\2\2pd\3\2\2\2ph\3\2\2\2pj\3\2\2\2pl\3\2\2\2pn\3\2\2\2q\u0092"+
		"\3\2\2\2rs\f\13\2\2st\t\2\2\2tu\5\n\6\fuv\b\6\1\2v\u0091\3\2\2\2wx\f\n"+
		"\2\2xy\t\3\2\2yz\5\n\6\13z{\b\6\1\2{\u0091\3\2\2\2|}\f\b\2\2}~\t\4\2\2"+
		"~\177\5\n\6\t\177\u0080\b\6\1\2\u0080\u0091\3\2\2\2\u0081\u0082\f\7\2"+
		"\2\u0082\u0083\t\5\2\2\u0083\u0084\5\n\6\b\u0084\u0085\b\6\1\2\u0085\u0091"+
		"\3\2\2\2\u0086\u0087\f\20\2\2\u0087\u0088\7\6\2\2\u0088\u0089\5\n\6\2"+
		"\u0089\u008a\7\7\2\2\u008a\u008b\b\6\1\2\u008b\u0091\3\2\2\2\u008c\u008d"+
		"\f\16\2\2\u008d\u008e\7\r\2\2\u008e\u008f\7*\2\2\u008f\u0091\b\6\1\2\u0090"+
		"r\3\2\2\2\u0090w\3\2\2\2\u0090|\3\2\2\2\u0090\u0081\3\2\2\2\u0090\u0086"+
		"\3\2\2\2\u0090\u008c\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\13\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\5\n\6"+
		"\2\u0096\u0097\7\34\2\2\u0097\u0098\5\n\6\2\u0098\u0099\7\35\2\2\u0099"+
		"\u009a\b\7\1\2\u009a\u00c3\3\2\2\2\u009b\u009c\7\36\2\2\u009c\u009d\7"+
		"\13\2\2\u009d\u009e\5\n\6\2\u009e\u009f\7\f\2\2\u009f\u00a0\5\32\16\2"+
		"\u00a0\u00a5\b\7\1\2\u00a1\u00a2\7\37\2\2\u00a2\u00a3\5\32\16\2\u00a3"+
		"\u00a4\b\7\1\2\u00a4\u00a6\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\7\1\2\u00a8\u00c3\3\2\2\2\u00a9"+
		"\u00aa\t\6\2\2\u00aa\u00ab\5\30\r\2\u00ab\u00ac\7\35\2\2\u00ac\u00ad\b"+
		"\7\1\2\u00ad\u00c3\3\2\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\5\n\6\2\u00b0"+
		"\u00b1\7\35\2\2\u00b1\u00b2\b\7\1\2\u00b2\u00c3\3\2\2\2\u00b3\u00b4\7"+
		"#\2\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\5\n\6\2\u00b6\u00b7\7\f\2\2\u00b7"+
		"\u00b8\5\32\16\2\u00b8\u00b9\b\7\1\2\u00b9\u00c3\3\2\2\2\u00ba\u00bb\5"+
		"\b\5\2\u00bb\u00bc\7\35\2\2\u00bc\u00bd\b\7\1\2\u00bd\u00c3\3\2\2\2\u00be"+
		"\u00bf\5\20\t\2\u00bf\u00c0\7\35\2\2\u00c0\u00c1\b\7\1\2\u00c1\u00c3\3"+
		"\2\2\2\u00c2\u0095\3\2\2\2\u00c2\u009b\3\2\2\2\u00c2\u00a9\3\2\2\2\u00c2"+
		"\u00ae\3\2\2\2\u00c2\u00b3\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00be\3\2"+
		"\2\2\u00c3\r\3\2\2\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\7*\2\2\u00c6\u00c7"+
		"\7\13\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9\7\f\2\2\u00c9\u00ca\7\t\2"+
		"\2\u00ca\u00cb\5\24\13\2\u00cb\u00cc\7\n\2\2\u00cc\u00cd\b\b\1\2\u00cd"+
		"\u00d2\3\2\2\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\b\b\1\2\u00d0\u00d2\3"+
		"\2\2\2\u00d1\u00c4\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\17\3\2\2\2\u00d3"+
		"\u00d4\5\6\4\2\u00d4\u00d5\5\22\n\2\u00d5\u00d6\7\35\2\2\u00d6\u00d7\b"+
		"\t\1\2\u00d7\21\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9\u00da\7$\2\2\u00da\u00db"+
		"\5\22\n\2\u00db\u00dc\b\n\1\2\u00dc\u00e0\3\2\2\2\u00dd\u00de\7*\2\2\u00de"+
		"\u00e0\b\n\1\2\u00df\u00d8\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\23\3\2\2"+
		"\2\u00e1\u00e2\5\20\t\2\u00e2\u00e3\b\13\1\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e1\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00ee\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\5\f\7\2\u00ea"+
		"\u00eb\b\13\1\2\u00eb\u00ed\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ed\u00f0\3"+
		"\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\25\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f2\5\16\b\2\u00f2\u00f3\b\f\1\2\u00f3\u00f5\3"+
		"\2\2\2\u00f4\u00f1\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\27\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\5\n\6"+
		"\2\u00fa\u00fb\7$\2\2\u00fb\u00fc\5\30\r\2\u00fc\u00fd\b\r\1\2\u00fd\u0102"+
		"\3\2\2\2\u00fe\u00ff\5\n\6\2\u00ff\u0100\b\r\1\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00f9\3\2\2\2\u0101\u00fe\3\2\2\2\u0102\31\3\2\2\2\u0103\u0109\7\t\2"+
		"\2\u0104\u0105\5\f\7\2\u0105\u0106\b\16\1\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0104\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0111\7\n\2\2\u010d"+
		"\u010e\5\f\7\2\u010e\u010f\b\16\1\2\u010f\u0111\3\2\2\2\u0110\u0103\3"+
		"\2\2\2\u0110\u010d\3\2\2\2\u0111\33\3\2\2\2\u0112\u0113\5\4\3\2\u0113"+
		"\u0114\b\17\1\2\u0114\u0118\3\2\2\2\u0115\u0116\7%\2\2\u0116\u0118\b\17"+
		"\1\2\u0117\u0112\3\2\2\2\u0117\u0115\3\2\2\2\u0118\35\3\2\2\2\u0119\u011a"+
		"\5\6\4\2\u011a\u011b\7*\2\2\u011b\u011c\7$\2\2\u011c\u011d\5\36\20\2\u011d"+
		"\u011e\b\20\1\2\u011e\u0125\3\2\2\2\u011f\u0120\5\6\4\2\u0120\u0121\7"+
		"*\2\2\u0121\u0122\b\20\1\2\u0122\u0125\3\2\2\2\u0123\u0125\3\2\2\2\u0124"+
		"\u0119\3\2\2\2\u0124\u011f\3\2\2\2\u0124\u0123\3\2\2\2\u0125\37\3\2\2"+
		"\2\u0126\u0127\5\6\4\2\u0127\u0128\5\22\n\2\u0128\u0129\7\35\2\2\u0129"+
		"\u012a\b\21\1\2\u012a\u012c\3\2\2\2\u012b\u0126\3\2\2\2\u012c\u012f\3"+
		"\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e!\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0131\7%\2\2\u0131\u0132\7&\2\2\u0132\u0133\7\13\2\2\u0133"+
		"\u0134\7\f\2\2\u0134\u0135\7\t\2\2\u0135\u0136\5\24\13\2\u0136\u0137\7"+
		"\n\2\2\u0137\u0138\b\22\1\2\u0138#\3\2\2\2\26/;DMp\u0090\u0092\u00a5\u00c2"+
		"\u00d1\u00df\u00e6\u00ee\u00f6\u0101\u0109\u0110\u0117\u0124\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}