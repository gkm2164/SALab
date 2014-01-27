package kr.pe.imarch.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLDocument {
	Document thisDoc;

	public XMLDocument(Document doc) {
		// TODO Auto-generated constructor stub
		thisDoc = doc;
	}

	public NodeList readTag(String tag) {
		return thisDoc.getElementsByTagName(tag);
	}

	public Element readTagOne(String tag) {
		return (Element) (readTag(tag).item(0));
	}

	public NodeList readTag(Element from, String tag) {
		return from.getElementsByTagName(tag);
	}

	public Element readTagOne(Element from, String tag) {
		return (Element) (readTag(from, tag).item(0));
	}
}
