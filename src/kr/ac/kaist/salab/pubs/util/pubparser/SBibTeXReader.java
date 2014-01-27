package kr.ac.kaist.salab.pubs.util.pubparser;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Map;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.jbibtex.Value;

public class SBibTeXReader {
	private Boolean ready = false;
	private SBibTeXParser parser = null;
	private BibTeXDatabase db = null;
	private BibTeXEntry btxe = null;

	public SBibTeXReader() {
		parser = new SBibTeXParser();
	}

	public SBibTeXReader(SBibTeXParser thisParser) {
		parser = thisParser;
	}

	public void prepareEntries(Reader reader) {
		try {
			db = parser.parse(reader);
			synchronized (ready) {
				ready = true;
			}

			System.out.println("BibTeX is ready to read");
			
			Map<Key, BibTeXEntry> map = db.getEntries();
			Collection<BibTeXEntry> btxecoll = map.values();
			btxe = btxecoll.iterator().next();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			synchronized (ready) {
				ready = false;
			}
		}
	}

	public String readEntry(String key) {
		Key k = new Key(key);
		Value value = btxe.getField(k);
		String ret = (value != null ? value.toUserString() : null);
		if (key.equals("pages") && ret != null) {
			ret.replaceFirst("--", "~");
		}
		return ret;
	}

}
