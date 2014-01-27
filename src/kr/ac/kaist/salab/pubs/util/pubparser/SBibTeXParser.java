package kr.ac.kaist.salab.pubs.util.pubparser;

import java.io.IOException;
import java.io.Reader;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.ParseException;

public class SBibTeXParser extends BibTeXParser {

	@Override
	public void checkCrossReferenceResolution(Key key, BibTeXEntry entry) {
		// TODO Auto-generated method stub
		if (entry == null) {
			System.err.println("Can't find " + key.getValue() + ".");
		}
	}

	@Override
	public void checkStringResolution(Key key, BibTeXString string) {
		// TODO Auto-generated method stub
		if (string == null) {
			System.err.println("Can't find " + key.getValue() + ".");
		}
	}

	static public BibTeXDatabase parseBibTeX(Reader reader) {
		BibTeXDatabase ret = null;
		SBibTeXParser parser = new SBibTeXParser();
		try {
			ret = parser.parse(reader);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = null;
		}

		return ret;
	}
}
