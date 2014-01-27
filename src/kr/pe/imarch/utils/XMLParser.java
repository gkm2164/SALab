package kr.pe.imarch.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {
	public XMLParser() {
	}

	public XMLDocument parseXML(String filename)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File(filename);
		Document doc = db.parse(file);
		XMLDocument xmldoc = new XMLDocument(doc);
		return xmldoc;
	}
}
