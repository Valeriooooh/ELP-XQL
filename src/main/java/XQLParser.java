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
		RULE_save = 4, RULE_expression = 5, RULE_composition = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "instruction", "load", "assign", "save", "expression", "composition"
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
		public List<TerminalNode> COMMENT() { return getTokens(XQLParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(XQLParser.COMMENT, i);
		}
		public TerminalNode EOF() { return getToken(XQLParser.EOF, 0); }
		public List<TerminalNode> SPACE() { return getTokens(XQLParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(XQLParser.SPACE, i);
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
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(14);
					instruction();
					setState(16);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(15);
						match(SPACE);
						}
					}

					setState(24);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMENT:
						{
						setState(18);
						match(COMMENT);
						}
						break;
					case NEWLINE:
						{
						setState(20); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(19);
								match(NEWLINE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(22); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(31);
			instruction();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(32);
				match(SPACE);
				}
			}

			setState(35);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==COMMENT) ) {
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
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE || _la==NEWLINE) {
				{
				{
				setState(37);
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
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				{
				setState(43);
				load();
				}
				break;
			case NAME:
				{
				setState(44);
				assign();
				}
				break;
			case SAVE:
				{
				setState(45);
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
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
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
			setState(48);
			match(LOAD);
			setState(49);
			match(SPACE);
			setState(50);
			match(ARGUMENT);
			setState(51);
			match(SPACE);
			setState(52);
			match(TO);
			setState(53);
			match(SPACE);
			setState(54);
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
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
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
			setState(56);
			match(NAME);
			setState(57);
			match(SPACE);
			setState(58);
			match(EQUALS);
			setState(59);
			match(SPACE);
			setState(60);
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
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
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
			setState(62);
			match(SAVE);
			setState(63);
			match(SPACE);
			setState(64);
			match(NAME);
			setState(65);
			match(SPACE);
			setState(66);
			match(TO);
			setState(67);
			match(SPACE);
			setState(68);
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
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(NAME);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(71);
					composition();
					}
				}

				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
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
		public TerminalNode NAME() { return getToken(XQLParser.NAME, 0); }
		public CompositionContext composition() {
			return getRuleContext(CompositionContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(XQLParser.ARROW, 0); }
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
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(DOT);
				setState(78);
				match(NAME);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(79);
					composition();
					}
				}

				}
				break;
			case ARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(ARROW);
				setState(83);
				match(NAME);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) {
					{
					setState(84);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(COUNT);
				}
				break;
			case OFFSET:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				match(OFFSET);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
					{
					setState(89);
					composition();
					}
				}

				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000f`\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0015\b\u0000"+
		"\u000b\u0000\f\u0000\u0016\u0003\u0000\u0019\b\u0000\u0005\u0000\u001b"+
		"\b\u0000\n\u0000\f\u0000\u001e\t\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"\"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001\'\b\u0001\n"+
		"\u0001\f\u0001*\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"/\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0003\u0005I\b\u0005\u0001\u0005\u0003\u0005L\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006Q\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006[\b\u0006\u0001\u0006\u0003\u0006^\b\u0006\u0001\u0006"+
		"\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0003\u0001\u0001"+
		"\u0005\u0005\u0001\u0000\u0006\u0007\u0001\u0000\f\u000ei\u0000\u001c"+
		"\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u00040\u0001\u0000"+
		"\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000"+
		"\nK\u0001\u0000\u0000\u0000\f]\u0001\u0000\u0000\u0000\u000e\u0010\u0003"+
		"\u0002\u0001\u0000\u000f\u0011\u0005\u0006\u0000\u0000\u0010\u000f\u0001"+
		"\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u0018\u0001"+
		"\u0000\u0000\u0000\u0012\u0019\u0005\u0005\u0000\u0000\u0013\u0015\u0005"+
		"\u0007\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001"+
		"\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001"+
		"\u0000\u0000\u0000\u0017\u0019\u0001\u0000\u0000\u0000\u0018\u0012\u0001"+
		"\u0000\u0000\u0000\u0018\u0014\u0001\u0000\u0000\u0000\u0019\u001b\u0001"+
		"\u0000\u0000\u0000\u001a\u000e\u0001\u0000\u0000\u0000\u001b\u001e\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001"+
		"\u0000\u0000\u0000\u001f!\u0003\u0002\u0001\u0000 \"\u0005\u0006\u0000"+
		"\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#$\u0007\u0000\u0000\u0000$\u0001\u0001\u0000\u0000\u0000"+
		"%\'\u0007\u0001\u0000\u0000&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000).\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000+/\u0003\u0004\u0002\u0000,/\u0003"+
		"\u0006\u0003\u0000-/\u0003\b\u0004\u0000.+\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/\u0003\u0001\u0000\u0000"+
		"\u000001\u0005\u0001\u0000\u000012\u0005\u0006\u0000\u000023\u0005\b\u0000"+
		"\u000034\u0005\u0006\u0000\u000045\u0005\u0002\u0000\u000056\u0005\u0006"+
		"\u0000\u000067\u0005\t\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0005"+
		"\t\u0000\u00009:\u0005\u0006\u0000\u0000:;\u0005\u0004\u0000\u0000;<\u0005"+
		"\u0006\u0000\u0000<=\u0003\n\u0005\u0000=\u0007\u0001\u0000\u0000\u0000"+
		">?\u0005\u0003\u0000\u0000?@\u0005\u0006\u0000\u0000@A\u0005\t\u0000\u0000"+
		"AB\u0005\u0006\u0000\u0000BC\u0005\u0002\u0000\u0000CD\u0005\u0006\u0000"+
		"\u0000DE\u0005\b\u0000\u0000E\t\u0001\u0000\u0000\u0000FH\u0005\t\u0000"+
		"\u0000GI\u0003\f\u0006\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IL\u0001\u0000\u0000\u0000JL\u0005\u000f\u0000\u0000KF\u0001\u0000"+
		"\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u000b\u0001\u0000\u0000\u0000"+
		"MN\u0005\n\u0000\u0000NP\u0005\t\u0000\u0000OQ\u0003\f\u0006\u0000PO\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q^\u0001\u0000\u0000\u0000"+
		"RS\u0005\u000b\u0000\u0000SU\u0005\t\u0000\u0000TV\u0007\u0002\u0000\u0000"+
		"UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V^\u0001\u0000\u0000"+
		"\u0000W^\u0005\f\u0000\u0000XZ\u0005\r\u0000\u0000Y[\u0003\f\u0006\u0000"+
		"ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000"+
		"\u0000\\^\u0005\u000e\u0000\u0000]M\u0001\u0000\u0000\u0000]R\u0001\u0000"+
		"\u0000\u0000]W\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000]\\\u0001"+
		"\u0000\u0000\u0000^\r\u0001\u0000\u0000\u0000\r\u0010\u0016\u0018\u001c"+
		"!(.HKPUZ]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}