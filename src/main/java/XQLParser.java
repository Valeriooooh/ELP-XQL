// Generated from /home/goncalo/Development/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LOAD=1, TO=2, SAVE=3, EQUALS=4, SPACE=5, NEWLINE=6, COMMENT=7, TEXT=8, 
		ARGUMENT=9, NAME=10, DOT=11, ARROW=12, COUNT=13, OFFSET=14, SUM=15, TEMPLATE=16;
	public static final int
		RULE_document = 0, RULE_comment = 1, RULE_instruction = 2, RULE_load = 3, 
		RULE_assign = 4, RULE_save = 5, RULE_expression = 6, RULE_composition = 7, 
		RULE_argument = 8, RULE_variable = 9, RULE_attribute = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "comment", "instruction", "load", "assign", "save", "expression", 
			"composition", "argument", "variable", "attribute"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'load'", "'to'", "'save'", "'='", null, "'\\n'", "'//'", null, 
			null, null, "'.'", "'->'", "'#'", null, "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LOAD", "TO", "SAVE", "EQUALS", "SPACE", "NEWLINE", "COMMENT", 
			"TEXT", "ARGUMENT", "NAME", "DOT", "ARROW", "COUNT", "OFFSET", "SUM", 
			"TEMPLATE"
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
	public String getGrammarFileName() { return "XQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(XQLParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(XQLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(XQLParser.NEWLINE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(22);
					instruction();
					setState(24);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(23);
						match(SPACE);
						}
					}

					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMENT) {
						{
						setState(26);
						comment();
						}
					}

					setState(29);
					match(NEWLINE);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(36);
			instruction();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(37);
				match(SPACE);
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(40);
				comment();
				}
			}

			setState(43);
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
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(XQLParser.COMMENT, 0); }
		public TerminalNode TEXT() { return getToken(XQLParser.TEXT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(COMMENT);
			setState(46);
			match(TEXT);
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
	public static class InstructionContext extends ParserRuleContext {
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public SaveContext save() {
			return getRuleContext(SaveContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				load();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				assign();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				save();
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
	public static class LoadContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(XQLParser.LOAD, 0); }
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode TO() { return getToken(XQLParser.TO, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LOAD);
			setState(54);
			match(SPACE);
			setState(55);
			argument();
			setState(56);
			match(SPACE);
			setState(57);
			match(TO);
			setState(58);
			match(SPACE);
			setState(59);
			variable();
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public TerminalNode EQUALS() { return getToken(XQLParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			variable();
			setState(62);
			match(SPACE);
			setState(63);
			match(EQUALS);
			setState(64);
			match(SPACE);
			setState(65);
			expression();
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
	public static class SaveContext extends ParserRuleContext {
		public TerminalNode SAVE() { return getToken(XQLParser.SAVE, 0); }
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode TO() { return getToken(XQLParser.TO, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public SaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveContext save() throws RecognitionException {
		SaveContext _localctx = new SaveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_save);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(SAVE);
			setState(68);
			match(SPACE);
			setState(69);
			variable();
			setState(70);
			match(SPACE);
			setState(71);
			match(TO);
			setState(72);
			match(SPACE);
			setState(73);
			argument();
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
	public static class ExpressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public CompositionContext composition() {
			return getRuleContext(CompositionContext.class,0);
		}
		public TerminalNode TEMPLATE() { return getToken(XQLParser.TEMPLATE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				variable();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) {
					{
					setState(76);
					composition();
					}
				}

				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(TEMPLATE);
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
	public static class CompositionContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(XQLParser.DOT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public CompositionContext composition() {
			return getRuleContext(CompositionContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(XQLParser.ARROW, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(XQLParser.COUNT, 0); }
		public TerminalNode OFFSET() { return getToken(XQLParser.OFFSET, 0); }
		public TerminalNode SUM() { return getToken(XQLParser.SUM, 0); }
		public CompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositionContext composition() throws RecognitionException {
		CompositionContext _localctx = new CompositionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_composition);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(DOT);
				setState(83);
				variable();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) {
					{
					setState(84);
					composition();
					}
				}

				}
				break;
			case ARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(ARROW);
				setState(88);
				attribute();
				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(COUNT);
				}
				break;
			case OFFSET:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				match(OFFSET);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) {
					{
					setState(91);
					composition();
					}
				}

				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				match(SUM);
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
	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode ARGUMENT() { return getToken(XQLParser.ARGUMENT, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ARGUMENT);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(NAME);
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
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLListener ) ((XQLListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLVisitor ) return ((XQLVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(NAME);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0010h\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0019\b\u0000\u0001\u0000\u0003\u0000\u001c\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000\'\b\u0000\u0001\u0000\u0003\u0000*\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006N\b\u0006\u0001"+
		"\u0006\u0003\u0006Q\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007V\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007]\b\u0007\u0001\u0007\u0003\u0007`\b\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0000\u0000\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000k\u0000!\u0001\u0000"+
		"\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000"+
		"\u00065\u0001\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\nC\u0001\u0000"+
		"\u0000\u0000\fP\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000"+
		"\u0010a\u0001\u0000\u0000\u0000\u0012c\u0001\u0000\u0000\u0000\u0014e"+
		"\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0004\u0002\u0000\u0017\u0019"+
		"\u0005\u0005\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005\u0006\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u0016\u0001"+
		"\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000$&\u0003\u0004\u0002\u0000%\'\u0005\u0005\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001"+
		"\u0000\u0000\u0000-.\u0005\u0007\u0000\u0000./\u0005\b\u0000\u0000/\u0003"+
		"\u0001\u0000\u0000\u000004\u0003\u0006\u0003\u000014\u0003\b\u0004\u0000"+
		"24\u0003\n\u0005\u000030\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"32\u0001\u0000\u0000\u00004\u0005\u0001\u0000\u0000\u000056\u0005\u0001"+
		"\u0000\u000067\u0005\u0005\u0000\u000078\u0003\u0010\b\u000089\u0005\u0005"+
		"\u0000\u00009:\u0005\u0002\u0000\u0000:;\u0005\u0005\u0000\u0000;<\u0003"+
		"\u0012\t\u0000<\u0007\u0001\u0000\u0000\u0000=>\u0003\u0012\t\u0000>?"+
		"\u0005\u0005\u0000\u0000?@\u0005\u0004\u0000\u0000@A\u0005\u0005\u0000"+
		"\u0000AB\u0003\f\u0006\u0000B\t\u0001\u0000\u0000\u0000CD\u0005\u0003"+
		"\u0000\u0000DE\u0005\u0005\u0000\u0000EF\u0003\u0012\t\u0000FG\u0005\u0005"+
		"\u0000\u0000GH\u0005\u0002\u0000\u0000HI\u0005\u0005\u0000\u0000IJ\u0003"+
		"\u0010\b\u0000J\u000b\u0001\u0000\u0000\u0000KM\u0003\u0012\t\u0000LN"+
		"\u0003\u000e\u0007\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NQ\u0001\u0000\u0000\u0000OQ\u0005\u0010\u0000\u0000PK\u0001\u0000"+
		"\u0000\u0000PO\u0001\u0000\u0000\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005"+
		"\u000b\u0000\u0000SU\u0003\u0012\t\u0000TV\u0003\u000e\u0007\u0000UT\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V`\u0001\u0000\u0000\u0000"+
		"WX\u0005\f\u0000\u0000X`\u0003\u0014\n\u0000Y`\u0005\r\u0000\u0000Z\\"+
		"\u0005\u000e\u0000\u0000[]\u0003\u000e\u0007\u0000\\[\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^`\u0005\u000f"+
		"\u0000\u0000_R\u0001\u0000\u0000\u0000_W\u0001\u0000\u0000\u0000_Y\u0001"+
		"\u0000\u0000\u0000_Z\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`\u000f\u0001\u0000\u0000\u0000ab\u0005\t\u0000\u0000b\u0011\u0001\u0000"+
		"\u0000\u0000cd\u0005\n\u0000\u0000d\u0013\u0001\u0000\u0000\u0000ef\u0005"+
		"\n\u0000\u0000f\u0015\u0001\u0000\u0000\u0000\u000b\u0018\u001b!&)3MP"+
		"U\\_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}