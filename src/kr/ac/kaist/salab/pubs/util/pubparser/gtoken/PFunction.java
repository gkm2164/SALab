package kr.ac.kaist.salab.pubs.util.pubparser.gtoken;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Queue;

import kr.ac.kaist.salab.pubs.util.pubparser.SBibTeXReader;
import kr.ac.kaist.salab.pubs.util.pubparser.Token;
import kr.ac.kaist.salab.pubs.util.pubparser.Token.ValueChar;

public class PFunction implements TokenParser {
	SBibTeXReader dict = null;
	
	public PFunction(SBibTeXReader reader) {
		// TODO Auto-generated constructor stub
		dict = reader;
	}

	@Override
	public Object parse(Queue<Token> token) throws PParseErrorException {
		// TODO Auto-generated method stub
		Token first = token.remove();
		if (first.getState() != ValueChar.EXCLAMATION_MARK) {
			throw new PParseErrorException ("Not function start" + first.getState().name());
		}
		
		Token funcName = token.remove();
		if (funcName.getState() != ValueChar.VALUE) {
			throw new PParseErrorException ("Not function name" + funcName.getState().name ());
		}
		
		PArguments tp = new PArguments (dict);
		Queue<Object> argsList = tp.parse(token);
		return funcCall (funcName.getValue (), argsList);
	}

	private Object funcCall(String value, Queue<Object> argsList) {
		String ret = null;
		// TODO Auto-generated method stub
		if (value.equals ("DATE")) {
			PFDate pfdate = new PFDate ();
			ret = (String)pfdate.doFuncCall(argsList);
		}
		return ret;
	}

	public class PFDate implements FunctionCall {

		@Override
		public String doFuncCall(Queue<Object> arguments) {
			// TODO Auto-generated method stub
			String format = (String)arguments.remove();
			String fmt = format.substring(1, format.length () - 1);
			Map<?, ?> dates = (Map<?, ?>)arguments.remove ();
			
			long year = (Long)(dates.get("year"));
			long month = (Long)(dates.get("month"));
			long day = (Long)(dates.get("day"));
			
			DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
			String dateStr = String.format ("%4d-%02d-%02d", year, month, day);
			Date d = null;
			try {
				d = df.parse(dateStr);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				d = new Date ();
			}
			
			DateFormat rdf = new SimpleDateFormat (fmt);
			return rdf.format(d);
		}
	}
}
