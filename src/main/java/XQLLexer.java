// Generated from /home/goncalo/Development/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LOAD=1, TO=2, SAVE=3, EQUALS=4, COMMENT=5, SPACE=6, NEWLINE=7, ARGUMENT=8, 
		NAME=9, DOT=10, ARROW=11, COUNT=12, OFFSET=13, SUM=14, TEMPLATE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOAD", "TO", "SAVE", "EQUALS", "COMMENT", "SPACE", "NEWLINE", "ARGUMENT", 
			"NAME", "DOT", "ARROW", "COUNT", "OFFSET", "SUM", "TEMPLATE"
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


	public XQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000fl\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u00043\b\u0004\n\u0004\f\u00046\t\u0004\u0001\u0004\u0004"+
		"\u00049\b\u0004\u000b\u0004\f\u0004:\u0001\u0004\u0003\u0004>\b\u0004"+
		"\u0001\u0005\u0004\u0005A\b\u0005\u000b\u0005\f\u0005B\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bL\b"+
		"\b\n\b\f\bO\t\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000ed\b\u000e"+
		"\n\u000e\f\u000eg\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u00024e\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0005\u0002\u0000\t\t  \u0001"+
		"\u000019\u0001\u0000az\u0002\u0000AZaz\u0001\u000009q\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0003$\u0001\u0000\u0000\u0000"+
		"\u0005\'\u0001\u0000\u0000\u0000\u0007,\u0001\u0000\u0000\u0000\t.\u0001"+
		"\u0000\u0000\u0000\u000b@\u0001\u0000\u0000\u0000\rD\u0001\u0000\u0000"+
		"\u0000\u000fF\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000\u0013"+
		"P\u0001\u0000\u0000\u0000\u0015R\u0001\u0000\u0000\u0000\u0017U\u0001"+
		"\u0000\u0000\u0000\u0019W\u0001\u0000\u0000\u0000\u001b[\u0001\u0000\u0000"+
		"\u0000\u001d^\u0001\u0000\u0000\u0000\u001f \u0005l\u0000\u0000 !\u0005"+
		"o\u0000\u0000!\"\u0005a\u0000\u0000\"#\u0005d\u0000\u0000#\u0002\u0001"+
		"\u0000\u0000\u0000$%\u0005t\u0000\u0000%&\u0005o\u0000\u0000&\u0004\u0001"+
		"\u0000\u0000\u0000\'(\u0005s\u0000\u0000()\u0005a\u0000\u0000)*\u0005"+
		"v\u0000\u0000*+\u0005e\u0000\u0000+\u0006\u0001\u0000\u0000\u0000,-\u0005"+
		"=\u0000\u0000-\b\u0001\u0000\u0000\u0000./\u0005/\u0000\u0000/0\u0005"+
		"/\u0000\u000004\u0001\u0000\u0000\u000013\t\u0000\u0000\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u00005=\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000079\u0003\r\u0006\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;>\u0001\u0000"+
		"\u0000\u0000<>\u0005\u0000\u0000\u0001=8\u0001\u0000\u0000\u0000=<\u0001"+
		"\u0000\u0000\u0000>\n\u0001\u0000\u0000\u0000?A\u0007\u0000\u0000\u0000"+
		"@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000C\f\u0001\u0000\u0000\u0000DE\u0005\n"+
		"\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FG\u0005$\u0000\u0000GH\u0007"+
		"\u0001\u0000\u0000H\u0010\u0001\u0000\u0000\u0000IM\u0007\u0002\u0000"+
		"\u0000JL\u0007\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0012"+
		"\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005.\u0000\u0000"+
		"Q\u0014\u0001\u0000\u0000\u0000RS\u0005-\u0000\u0000ST\u0005>\u0000\u0000"+
		"T\u0016\u0001\u0000\u0000\u0000UV\u0005#\u0000\u0000V\u0018\u0001\u0000"+
		"\u0000\u0000WX\u0005[\u0000\u0000XY\u0007\u0004\u0000\u0000YZ\u0005]\u0000"+
		"\u0000Z\u001a\u0001\u0000\u0000\u0000[\\\u0005+\u0000\u0000\\]\u0005+"+
		"\u0000\u0000]\u001c\u0001\u0000\u0000\u0000^_\u0005*\u0000\u0000_`\u0005"+
		"*\u0000\u0000`a\u0005*\u0000\u0000ae\u0001\u0000\u0000\u0000bd\t\u0000"+
		"\u0000\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hi\u0005*\u0000\u0000ij\u0005*\u0000\u0000j"+
		"k\u0005*\u0000\u0000k\u001e\u0001\u0000\u0000\u0000\u0007\u00004:=BMe"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}