package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

@SuppressWarnings("serial")
public class PParseErrorException extends Exception {
	String msg = "";
	public PParseErrorException (String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage () {
		return msg;
	}
}
