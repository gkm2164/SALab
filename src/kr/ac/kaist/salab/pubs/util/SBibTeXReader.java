package kr.ac.kaist.salab.pubs.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Set;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.jbibtex.Value;

public class SBibTeXReader {
	private Boolean ready = false;
	private SBibTeXParser parser = null;
	private BibTeXDatabase db = null;

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
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			synchronized (ready) {
				ready = false;
			}
		}
	}

	public void debugMap(Map<Key, ?> map) {
		Set<Key> set = map.keySet();
		for (Key k : set) {
			System.out.println(k.getValue());
		}
	}

	public String readEntry(String key) {
		Key k = new Key(key);
		Map<Key, BibTeXEntry> map = db.getEntries();
		debugMap(map);
		BibTeXEntry btxe = map.get(new Key("jbibtex-1"));

		Value value = btxe.getField(k);
		return value.toUserString();
	}

}
