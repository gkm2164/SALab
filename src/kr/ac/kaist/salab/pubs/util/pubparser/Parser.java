package kr.ac.kaist.salab.pubs.util.pubparser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import kr.ac.kaist.salab.pubs.util.pubparser.Token.ValueChar;

public class Parser {
	public class Gather {
		StringReader source;
		
		public Gather (StringReader sr) {
			source = sr;
		}
		public char readByte () throws IOException {
			char ch = (char) source.read();
			return ch;
		}
	};
		
	public class Tokenizer {
		Gather g;
		Processor p;
		static final public char EOF = (char)-1;
		
 		public Tokenizer (Gather g_, Processor p_) {
			g = g_;
			p = p_;
		} 
		
 		private StringBuffer sendValueToken (StringBuffer sb) {
 			if (sb.length() > 0) {
 				String str = sb.toString();
 				p.sendToken(Token.getNewToken(ValueChar.VALUE, str));
 				return new StringBuffer ();
 			}
 			
 			/* re-use */
 			return sb;
 		}
 		
		public void tokenize () {
			char val = 0;
			boolean escape = false;
			boolean indoublequotes = false;
			StringBuffer sb = new StringBuffer ();
			try {
				while ((val = g.readByte()) != EOF) {
					if (escape == true) {
						sb.append(val);
						escape = false;
						continue;
					} else if (val == '\\') {
						escape = true;
						continue;
					} else if (indoublequotes == true) {
						if (val != '"') {
							sb.append(val);
						} else if (val == '"') {
							sb = sendValueToken (sb);
							indoublequotes = false;
						}
						continue;
					} else if (indoublequotes != true && val == '"') {
						indoublequotes = true;
						continue;
					} else if (val == ' ') {
						continue;
					}
					
					int v = -1;
					if ((v = getDelimValue (val)) == -1) {
						if (val == '"') {
							indoublequotes = true;
						} else {
							sb.append (val);
						}
						continue;
					} else {	// Its' a token.
						sb = sendValueToken (sb);
						p.sendToken(Token.getNewToken(v));
						continue;
					}
				}
				
				p.sendToken(Token.getNewToken(ValueChar.CLOSE, null));
				p.processToken ();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int getDelimValue (char c) {
			String delim = "[](),.!";
			byte[] b = delim.getBytes();
			for (int i = 0; i < b.length; i++) {
				if (b[i] == c) {
					return i;
				}
			}
			
			return -1;
		}
	};
	
	
	
	public class Writer {
		String str = "";
		public void writeString (String str) {
			this.str += str;
			System.out.println (str);
		}
		
		public String read () {
			return str;
		}
	};
	
	public String parseToFormat (String fmt, Reader r) {
		Gather g = new Gather (new StringReader (fmt));
		Writer w = new Writer ();
		Processor p = new Processor (r, w);
		Tokenizer t = new Tokenizer (g, p);
		t.tokenize();
		
		return w.read();
	}
}
