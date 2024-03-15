// Generated from D:/IdeaProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.vsu.dnlkkandco;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DnlkkRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, KEYWORDS=8, IDENT=9, 
		NUM=10, ADD=11, MULT=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "KEYWORDS", "IDENT", 
			"NUM", "ADD", "MULT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "'if'", "'('", "')'", "'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "KEYWORDS", "IDENT", 
			"NUM", "ADD", "MULT", "WS"
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


	public DnlkkRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DnlkkRules.g4"; }

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
		"\u0004\u0000\rP\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007=\b\u0007\u0001\b\u0004\b@\b\b\u000b\b\f\bA\u0001\t\u0004\tE\b\t"+
		"\u000b\t\f\tF\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u0001\u0000\u0005\u0002\u0000AZaz\u0001\u000009\u0002"+
		"\u0000++--\u0002\u0000**//\u0002\u0000\t\t  T\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001d\u0001\u0000\u0000\u0000"+
		"\u0005\u001f\u0001\u0000\u0000\u0000\u0007!\u0001\u0000\u0000\u0000\t"+
		"$\u0001\u0000\u0000\u0000\u000b&\u0001\u0000\u0000\u0000\r(\u0001\u0000"+
		"\u0000\u0000\u000f<\u0001\u0000\u0000\u0000\u0011?\u0001\u0000\u0000\u0000"+
		"\u0013D\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000\u0000\u0017J"+
		"\u0001\u0000\u0000\u0000\u0019L\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"{\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000\u001d\u001e\u0005}\u0000"+
		"\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001f \u0005=\u0000\u0000 "+
		"\u0006\u0001\u0000\u0000\u0000!\"\u0005i\u0000\u0000\"#\u0005f\u0000\u0000"+
		"#\b\u0001\u0000\u0000\u0000$%\u0005(\u0000\u0000%\n\u0001\u0000\u0000"+
		"\u0000&\'\u0005)\u0000\u0000\'\f\u0001\u0000\u0000\u0000()\u0005w\u0000"+
		"\u0000)*\u0005h\u0000\u0000*+\u0005i\u0000\u0000+,\u0005l\u0000\u0000"+
		",-\u0005e\u0000\u0000-\u000e\u0001\u0000\u0000\u0000./\u0005i\u0000\u0000"+
		"/=\u0005f\u0000\u000001\u0005e\u0000\u000012\u0005l\u0000\u000023\u0005"+
		"s\u0000\u00003=\u0005e\u0000\u000045\u0005w\u0000\u000056\u0005h\u0000"+
		"\u000067\u0005i\u0000\u000078\u0005l\u0000\u00008=\u0005e\u0000\u0000"+
		"9:\u0005f\u0000\u0000:;\u0005o\u0000\u0000;=\u0005r\u0000\u0000<.\u0001"+
		"\u0000\u0000\u0000<0\u0001\u0000\u0000\u0000<4\u0001\u0000\u0000\u0000"+
		"<9\u0001\u0000\u0000\u0000=\u0010\u0001\u0000\u0000\u0000>@\u0007\u0000"+
		"\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0012\u0001\u0000\u0000"+
		"\u0000CE\u0007\u0001\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0014"+
		"\u0001\u0000\u0000\u0000HI\u0007\u0002\u0000\u0000I\u0016\u0001\u0000"+
		"\u0000\u0000JK\u0007\u0003\u0000\u0000K\u0018\u0001\u0000\u0000\u0000"+
		"LM\u0007\u0004\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\f\u0000\u0000"+
		"O\u001a\u0001\u0000\u0000\u0000\u0004\u0000<AF\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}