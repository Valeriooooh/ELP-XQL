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
		LOAD=1, TO=2, SAVE=3, EQUALS=4, SPACE=5, NEWLINE=6, COMMENT=7, TEXT=8, 
		ARGUMENT=9, NAME=10, DOT=11, ARROW=12, COUNT=13, OFFSET=14, SUM=15, TEMPLATE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOAD", "TO", "SAVE", "EQUALS", "SPACE", "NEWLINE", "COMMENT", "TEXT", 
			"ARGUMENT", "NAME", "DOT", "ARROW", "COUNT", "OFFSET", "SUM", "TEMPLATE"
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
		"\u0004\u0000\u0010e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0004"+
		"\u00042\b\u0004\u000b\u0004\f\u00043\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007<\b\u0007\u000b\u0007"+
		"\f\u0007=\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\tE\b\t\n\t\f\t"+
		"H\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"]\b\u000f\n\u000f\f\u000f`\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001^\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000\u0006"+
		"\u0002\u0000\t\t  \u0001\u0000\n\n\u0001\u000019\u0001\u0000az\u0002\u0000"+
		"AZaz\u0001\u000009h\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0001!\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005"+
		")\u0001\u0000\u0000\u0000\u0007.\u0001\u0000\u0000\u0000\t1\u0001\u0000"+
		"\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000\u0000"+
		"\u000f;\u0001\u0000\u0000\u0000\u0011?\u0001\u0000\u0000\u0000\u0013B"+
		"\u0001\u0000\u0000\u0000\u0015I\u0001\u0000\u0000\u0000\u0017K\u0001\u0000"+
		"\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bP\u0001\u0000\u0000\u0000"+
		"\u001dT\u0001\u0000\u0000\u0000\u001fW\u0001\u0000\u0000\u0000!\"\u0005"+
		"l\u0000\u0000\"#\u0005o\u0000\u0000#$\u0005a\u0000\u0000$%\u0005d\u0000"+
		"\u0000%\u0002\u0001\u0000\u0000\u0000&\'\u0005t\u0000\u0000\'(\u0005o"+
		"\u0000\u0000(\u0004\u0001\u0000\u0000\u0000)*\u0005s\u0000\u0000*+\u0005"+
		"a\u0000\u0000+,\u0005v\u0000\u0000,-\u0005e\u0000\u0000-\u0006\u0001\u0000"+
		"\u0000\u0000./\u0005=\u0000\u0000/\b\u0001\u0000\u0000\u000002\u0007\u0000"+
		"\u0000\u000010\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u00004\n\u0001\u0000\u0000\u0000"+
		"56\u0005\n\u0000\u00006\f\u0001\u0000\u0000\u000078\u0005/\u0000\u0000"+
		"89\u0005/\u0000\u00009\u000e\u0001\u0000\u0000\u0000:<\b\u0001\u0000\u0000"+
		";:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000=>\u0001\u0000\u0000\u0000>\u0010\u0001\u0000\u0000\u0000?@\u0005"+
		"$\u0000\u0000@A\u0007\u0002\u0000\u0000A\u0012\u0001\u0000\u0000\u0000"+
		"BF\u0007\u0003\u0000\u0000CE\u0007\u0004\u0000\u0000DC\u0001\u0000\u0000"+
		"\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000G\u0014\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"IJ\u0005.\u0000\u0000J\u0016\u0001\u0000\u0000\u0000KL\u0005-\u0000\u0000"+
		"LM\u0005>\u0000\u0000M\u0018\u0001\u0000\u0000\u0000NO\u0005#\u0000\u0000"+
		"O\u001a\u0001\u0000\u0000\u0000PQ\u0005[\u0000\u0000QR\u0007\u0005\u0000"+
		"\u0000RS\u0005]\u0000\u0000S\u001c\u0001\u0000\u0000\u0000TU\u0005+\u0000"+
		"\u0000UV\u0005+\u0000\u0000V\u001e\u0001\u0000\u0000\u0000WX\u0005*\u0000"+
		"\u0000XY\u0005*\u0000\u0000YZ\u0005*\u0000\u0000Z^\u0001\u0000\u0000\u0000"+
		"[]\t\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_a\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005*\u0000\u0000bc\u0005*\u0000"+
		"\u0000cd\u0005*\u0000\u0000d \u0001\u0000\u0000\u0000\u0005\u00003=F^"+
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