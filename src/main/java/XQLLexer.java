// Generated from /home/datom/Projects/UNI/ELP/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
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
		"\u0004\u0000\u000fs\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"\u0006\u0001\u0007\u0001\u0007\u0004\u0007I\b\u0007\u000b\u0007\f\u0007"+
		"J\u0001\b\u0001\b\u0005\bO\b\b\n\b\f\bR\t\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f]\b\f\u000b"+
		"\f\f\f^\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000ek\b\u000e\n\u000e\f\u000e"+
		"n\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u00024l\u0000"+
		"\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u0001\u0000\u0005\u0002\u0000\t\t  \u0001\u000019\u0001\u0000"+
		"az\u0002\u0000AZaz\u0001\u000009z\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f"+
		"\u0001\u0000\u0000\u0000\u0003$\u0001\u0000\u0000\u0000\u0005\'\u0001"+
		"\u0000\u0000\u0000\u0007,\u0001\u0000\u0000\u0000\t.\u0001\u0000\u0000"+
		"\u0000\u000b@\u0001\u0000\u0000\u0000\rD\u0001\u0000\u0000\u0000\u000f"+
		"F\u0001\u0000\u0000\u0000\u0011L\u0001\u0000\u0000\u0000\u0013S\u0001"+
		"\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017X\u0001\u0000\u0000"+
		"\u0000\u0019Z\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001d"+
		"e\u0001\u0000\u0000\u0000\u001f \u0005l\u0000\u0000 !\u0005o\u0000\u0000"+
		"!\"\u0005a\u0000\u0000\"#\u0005d\u0000\u0000#\u0002\u0001\u0000\u0000"+
		"\u0000$%\u0005t\u0000\u0000%&\u0005o\u0000\u0000&\u0004\u0001\u0000\u0000"+
		"\u0000\'(\u0005s\u0000\u0000()\u0005a\u0000\u0000)*\u0005v\u0000\u0000"+
		"*+\u0005e\u0000\u0000+\u0006\u0001\u0000\u0000\u0000,-\u0005=\u0000\u0000"+
		"-\b\u0001\u0000\u0000\u0000./\u0005/\u0000\u0000/0\u0005/\u0000\u0000"+
		"04\u0001\u0000\u0000\u000013\t\u0000\u0000\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u00005=\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000079\u0003\r\u0006"+
		"\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<>\u0005"+
		"\u0000\u0000\u0001=8\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000"+
		">\n\u0001\u0000\u0000\u0000?A\u0007\u0000\u0000\u0000@?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000C\f\u0001\u0000\u0000\u0000DE\u0005\n\u0000\u0000E\u000e\u0001"+
		"\u0000\u0000\u0000FH\u0005$\u0000\u0000GI\u0007\u0001\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000K\u0010\u0001\u0000\u0000\u0000LP\u0007\u0002"+
		"\u0000\u0000MO\u0007\u0003\u0000\u0000NM\u0001\u0000\u0000\u0000OR\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"Q\u0012\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0005.\u0000"+
		"\u0000T\u0014\u0001\u0000\u0000\u0000UV\u0005-\u0000\u0000VW\u0005>\u0000"+
		"\u0000W\u0016\u0001\u0000\u0000\u0000XY\u0005#\u0000\u0000Y\u0018\u0001"+
		"\u0000\u0000\u0000Z\\\u0005[\u0000\u0000[]\u0007\u0004\u0000\u0000\\["+
		"\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005]\u0000"+
		"\u0000a\u001a\u0001\u0000\u0000\u0000bc\u0005+\u0000\u0000cd\u0005+\u0000"+
		"\u0000d\u001c\u0001\u0000\u0000\u0000ef\u0005*\u0000\u0000fg\u0005*\u0000"+
		"\u0000gh\u0005*\u0000\u0000hl\u0001\u0000\u0000\u0000ik\t\u0000\u0000"+
		"\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000op\u0005*\u0000\u0000pq\u0005*\u0000\u0000qr\u0005*"+
		"\u0000\u0000r\u001e\u0001\u0000\u0000\u0000\t\u00004:=BJP^l\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}