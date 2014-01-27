package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.util.LinkedList;
import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.SBibTeXReader;
import kr.ac.kaist.salab.pubs.util.pubparser.Token;
import kr.ac.kaist.salab.pubs.util.pubparser.Token.ValueChar;

public class PArguments implements TokenParser {
	private SBibTeXReader dict = null;
	
	public PArguments (SBibTeXReader dict) {
		this.dict = dict;
	}
	@Override
	public Queue<Object> parse(Queue<Token> token) throws PParseErrorException {
		// TODO Auto-generated method stub
		Token argStart = token.remove();
		Queue<Object> ret = new LinkedList<Object> ();
		if (argStart.getState () != ValueChar.BRACKET_OPEN) {
			throw new PParseErrorException ("Parse error '(' should come but, " + argStart.getState().name());
		}
		
		outer: while (true) {
			Token tok = token.element ();
			TokenParser tp = null;
			switch (tok.getState()) {
			
			case VALUE: tp = new PValue ();	break;
			case BIG_BRACKET_OPEN: tp = new PReference (dict); break;
			case EXCLAMATION_MARK: tp = new PFunction (dict); break;
			case COMMA: token.remove (); continue;
			
			default: break outer;
			
			}
			ret.add (tp.parse(token));
		}
		
		Token argEnd = token.remove();
		if (argEnd.getState () != ValueChar.BRACKET_CLOSE) {
			throw new PParseErrorException ("Parse error ')' should come but, " + argEnd.getState().name ());
		}
		
		return ret;
	}

}
