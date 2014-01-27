package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.io.Reader;
import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.SBibTeXReader;
import kr.ac.kaist.salab.pubs.util.pubparser.Token;

public class Start implements TokenParser {
	private SBibTeXReader dict = null;

	public Start (Reader reader) {
		super ();
		SBibTeXReader sbtxr = new SBibTeXReader ();
		sbtxr.prepareEntries(reader);
		dict = sbtxr;
	}
	
	@Override
	public String parse(Queue<Token> token) throws PParseErrorException {
		// TODO Auto-generated method stub
		String result = "";
		outer: while (token.isEmpty() != true) {
			Token first = token.element();
			TokenParser tp = null;
			switch (first.getState()) {
			case BIG_BRACKET_OPEN:
				tp = new PReference (dict);
				result += (String)tp.parse(token);
				break;
			case EXCLAMATION_MARK:
				tp = new PFunction (dict);
				result += (String)tp.parse(token);
				break;
			case VALUE:
				tp = new PValue ();
				result += (String)tp.parse(token);
				break;
			case CLOSE:
				break outer;
			default: throw new PParseErrorException ("Token can't be parse: " + first.getState().name());
			}
		}
		
		return result;
	}
}
