// Generated from /home/datom/Projects/UNI/ELP/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
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
		LOAD=1, TO=2, SAVE=3, EQUALS=4, COMMENT=5, SPACE=6, NEWLINE=7, ARGUMENT=8, 
		NAME=9, DOT=10, ARROW=11, COUNT=12, OFFSET=13, SUM=14, TEMPLATE=15;
	public static final int
		RULE_document = 0, RULE_instruction = 1, RULE_load = 2, RULE_assign = 3, 
		RULE_save = 4, RULE_expression = 5, RULE_composition = 6, RULE_variable = 7, 
		RULE_attribute = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "instruction", "load", "assign", "save", "expression", "composition", 
			"variable", "attribute"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'load'", "'to'", "'save'", "'='", null, null, "'\\n'", null, null, 
			"'.'", "'->'", "'#'", null, "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LOAD", "TO", "SAVE", "EQUALS", "COMMENT", "SPACE", "NEWLINE", 
			"ARGUMENT", "NAME", "DOT", "ARROW", "COUNT", "OFFSET", "SUM", "TEMPLATE"
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
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(XQLParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(XQLParser.COMMENT, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(XQLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(XQLParser.NEWLINE, i);
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
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18);
					instruction();
					setState(20);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(19);
						match(SPACE);
						}
					}

					setState(23);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMENT) {
						{
						setState(22);
						match(COMMENT);
						}
					}

					setState(26); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(25);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(28); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(35);
			instruction();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(36);
				match(SPACE);
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(39);
				match(COMMENT);
				}
			}

			setState(42);
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
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(XQLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(XQLParser.NEWLINE, i);
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
		enterRule(_localctx, 2, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE || _la==NEWLINE) {
				{
				{
				setState(44);
				_la = _input.LA(1);
				if ( !(_la==SPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				{
				setState(50);
				load();
				}
				break;
			case NAME:
				{
				setState(51);
				assign();
				}
				break;
			case SAVE:
				{
				setState(52);
				save();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class LoadContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(XQLParser.LOAD, 0); }
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
		}
		public TerminalNode ARGUMENT() { return getToken(XQLParser.ARGUMENT, 0); }
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
		enterRule(_localctx, 4, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(LOAD);
			setState(56);
			match(SPACE);
			setState(57);
			match(ARGUMENT);
			setState(58);
			match(SPACE);
			setState(59);
			match(TO);
			setState(60);
			match(SPACE);
			setState(61);
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
		enterRule(_localctx, 6, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			variable();
			setState(64);
			match(SPACE);
			setState(65);
			match(EQUALS);
			setState(66);
			match(SPACE);
			setState(67);
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
		public TerminalNode ARGUMENT() { return getToken(XQLParser.ARGUMENT, 0); }
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
		enterRule(_localctx, 8, RULE_save);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(SAVE);
			setState(70);
			match(SPACE);
			setState(71);
			variable();
			setState(72);
			match(SPACE);
			setState(73);
			match(TO);
			setState(74);
			match(SPACE);
			setState(75);
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
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				variable();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(78);
					composition();
					}
				}

				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
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
		public TerminalNode SUM() { return getToken(XQLParser.SUM, 0); }
		public TerminalNode COUNT() { return getToken(XQLParser.COUNT, 0); }
		public TerminalNode OFFSET() { return getToken(XQLParser.OFFSET, 0); }
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
		enterRule(_localctx, 12, RULE_composition);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(DOT);
				setState(85);
				variable();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(86);
					composition();
					}
				}

				}
				break;
			case ARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(ARROW);
				setState(90);
				attribute();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUM) {
					{
					setState(91);
					match(SUM);
					}
				}

				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(COUNT);
				}
				break;
			case OFFSET:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				match(OFFSET);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(96);
					composition();
					}
				}

				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
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
		enterRule(_localctx, 14, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 16, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
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
		"\u0004\u0001\u000fk\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0003\u0000\u0015\b\u0000\u0001\u0000"+
		"\u0003\u0000\u0018\b\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b"+
		"\u0000\f\u0000\u001c\u0005\u0000\u001f\b\u0000\n\u0000\f\u0000\"\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000&\b\u0000\u0001\u0000\u0003\u0000"+
		")\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001.\b\u0001\n\u0001"+
		"\f\u00011\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005P\b\u0005\u0001\u0005\u0003\u0005S\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006X\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006]\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006b\b\u0006\u0001\u0006\u0003\u0006e\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0000\u0001\u0001\u0000\u0006\u0007s\u0000 \u0001\u0000\u0000\u0000"+
		"\u0002/\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006?"+
		"\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000"+
		"\u0000\fd\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000\u0010"+
		"h\u0001\u0000\u0000\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0015"+
		"\u0005\u0006\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u0017\u0001\u0000\u0000\u0000\u0016\u0018"+
		"\u0005\u0005\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u001a\u0001\u0000\u0000\u0000\u0019\u001b"+
		"\u0005\u0007\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u0012"+
		"\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000#%\u0003\u0002\u0001\u0000$&\u0005\u0006\u0000"+
		"\u0000%$\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000"+
		"\u0000\u0000\')\u0005\u0005\u0000\u0000(\'\u0001\u0000\u0000\u0000()\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0005\u0000\u0000\u0001"+
		"+\u0001\u0001\u0000\u0000\u0000,.\u0007\u0000\u0000\u0000-,\u0001\u0000"+
		"\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u000005\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u0000"+
		"26\u0003\u0004\u0002\u000036\u0003\u0006\u0003\u000046\u0003\b\u0004\u0000"+
		"52\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000"+
		"\u00006\u0003\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u000089\u0005"+
		"\u0006\u0000\u00009:\u0005\b\u0000\u0000:;\u0005\u0006\u0000\u0000;<\u0005"+
		"\u0002\u0000\u0000<=\u0005\u0006\u0000\u0000=>\u0003\u000e\u0007\u0000"+
		">\u0005\u0001\u0000\u0000\u0000?@\u0003\u000e\u0007\u0000@A\u0005\u0006"+
		"\u0000\u0000AB\u0005\u0004\u0000\u0000BC\u0005\u0006\u0000\u0000CD\u0003"+
		"\n\u0005\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0005\u0003\u0000\u0000"+
		"FG\u0005\u0006\u0000\u0000GH\u0003\u000e\u0007\u0000HI\u0005\u0006\u0000"+
		"\u0000IJ\u0005\u0002\u0000\u0000JK\u0005\u0006\u0000\u0000KL\u0005\b\u0000"+
		"\u0000L\t\u0001\u0000\u0000\u0000MO\u0003\u000e\u0007\u0000NP\u0003\f"+
		"\u0006\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PS\u0001"+
		"\u0000\u0000\u0000QS\u0005\u000f\u0000\u0000RM\u0001\u0000\u0000\u0000"+
		"RQ\u0001\u0000\u0000\u0000S\u000b\u0001\u0000\u0000\u0000TU\u0005\n\u0000"+
		"\u0000UW\u0003\u000e\u0007\u0000VX\u0003\f\u0006\u0000WV\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000Xe\u0001\u0000\u0000\u0000YZ\u0005\u000b"+
		"\u0000\u0000Z\\\u0003\u0010\b\u0000[]\u0005\u000e\u0000\u0000\\[\u0001"+
		"\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]e\u0001\u0000\u0000\u0000"+
		"^e\u0005\f\u0000\u0000_a\u0005\r\u0000\u0000`b\u0003\f\u0006\u0000a`\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000"+
		"ce\u0005\u000e\u0000\u0000dT\u0001\u0000\u0000\u0000dY\u0001\u0000\u0000"+
		"\u0000d^\u0001\u0000\u0000\u0000d_\u0001\u0000\u0000\u0000dc\u0001\u0000"+
		"\u0000\u0000e\r\u0001\u0000\u0000\u0000fg\u0005\t\u0000\u0000g\u000f\u0001"+
		"\u0000\u0000\u0000hi\u0005\t\u0000\u0000i\u0011\u0001\u0000\u0000\u0000"+
		"\u000e\u0014\u0017\u001c %(/5ORW\\ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}