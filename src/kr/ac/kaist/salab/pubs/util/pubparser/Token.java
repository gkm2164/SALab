package kr.ac.kaist.salab.pubs.util.pubparser;

public class Token {
	static public enum ValueChar {
		BIG_BRACKET_OPEN, BIG_BRACKET_CLOSE, BRACKET_OPEN,
		BRACKET_CLOSE, COMMA, EXCLAMATION_MARK,
		VALUE, CLOSE, EMPTY;
	};
	private ValueChar state;
	private String value;
	
	private Token (ValueChar state, String value) {
		this.state = state;
		this.value = value;
	}
	public ValueChar getState() {
		return state;
	}
	public void setState(ValueChar state) {
		this.state = state;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	static public Token getNewToken (int idx) {
		Token tok = new Token (ValueChar.values()[idx], null);
		return tok;
	}
	
	static public Token getNewToken (ValueChar state, String value) {
		Token tok = new Token (state, value);
		return tok;
	}
};