package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.SBibTeXReader;
import kr.ac.kaist.salab.pubs.util.pubparser.Token;
import kr.ac.kaist.salab.pubs.util.pubparser.Token.ValueChar;

public class PReference implements TokenParser {
	SBibTeXReader dict = null;
	public PReference(SBibTeXReader dict) {
		// TODO Auto-generated constructor stub
		this.dict = dict;
	}
	
	@Override
	public Object parse(Queue<Token> tokens) throws PParseErrorException {
		// TODO Auto-generated method stub
		Token refStart = tokens.remove();
		Token refKey = tokens.remove();
		Token refEnd = tokens.remove();
		
		if (refStart.getState() != ValueChar.BIG_BRACKET_OPEN) {
			throw new PParseErrorException ("Parse error. '[' should come, but, " + refStart.getState().name());
		}
		if (refKey.getState() != ValueChar.VALUE) {
			throw new PParseErrorException ("Parse error. VALUE token should come, but, " + refKey.getState().name());
		}
		if (refEnd.getState() != ValueChar.BIG_BRACKET_CLOSE) {
			throw new PParseErrorException ("Parse error. ']' should come, but, " + refEnd.getState().name());
		}
		
		String ret = dict.readEntry(refKey.getValue());
		
		ret = (ret != null ? ret : "");
		return dict.readEntry(refKey.getValue ());
	}
	

}
