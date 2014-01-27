package kr.ac.kaist.salab.pubs.util.pubparser;

import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.Parser.Writer;
import kr.ac.kaist.salab.pubs.util.pubparser.gtoken.PParseErrorException;
import kr.ac.kaist.salab.pubs.util.pubparser.gtoken.Start;
import kr.ac.kaist.salab.pubs.util.pubparser.gtoken.TokenParser;


/**
 * @author Gyeongmin
 *
 * Language explanation.
 * 
 * START := (VALUE | REFERENCES | FUNCTION)*;
 * VALUE := [Any Character]*;
 * 
 * REFERENCES := "["REFS"]";
 * REFS := REF("."REFS)*;
 * REF := VALUE;
 * 
 * FUNC := "!" VALUE "(" ARGUMENTS ")";
 * ARGUMENTS := ARG( "," ARGS)* | e;
 * ARG := VALUE | REFERENCE;
 * 
 * Parser type: LL(1)
 */

public class Processor {
	Queue<Token> tokens;
	Reader r = null;
	Writer w = null;

	public Processor (Reader r, Writer w) {
		this.r = r;
		this.w = w;
		tokens = new LinkedList<Token> ();
	}
	public void processToken() {
		// TODO Auto-generated method stub
		TokenParser start = new Start(r);
		String result = "Parse error";
		try {
			result = (String)start.parse(tokens);
		} catch (PParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.writeString(result);
	}

	public void sendToken (Token tok) {
		tokens.offer(tok);
		//System.out.println ("token - " + tok.getState().name());
	}
}