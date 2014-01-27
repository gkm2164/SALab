package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.Token;

public class PValue implements TokenParser {

	@Override
	public Object parse(Queue<Token> token) {
		// TODO Auto-generated method stub
		Token value = token.remove();
		return value.getValue();
	}

}
