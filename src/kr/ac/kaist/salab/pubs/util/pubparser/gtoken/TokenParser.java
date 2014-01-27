package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.Token;

public interface TokenParser {
	public Object parse (Queue<Token> token) throws PParseErrorException;
}
