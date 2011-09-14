package com.scriptorum.singletons;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.scriptorum.abstractions.Ruta;
import com.scriptorum.abstractions.Vertice;

public class RutaParser {

	static Ruta ruta;
	static Document dom;
	static RutaParser rutaParser;


	private RutaParser(){
		ruta = new Ruta();
	}
	
	public static RutaParser getInstance() {
		if(null == rutaParser) {
			rutaParser = new RutaParser();
		}
		return rutaParser;
	}

	public void runExample(File xml) {
		parseXmlFile(xml);
		parseDocument();
	}
	
	
	private void parseXmlFile(File xml){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(xml);
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	private void parseDocument(){
		Element docEle = dom.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("Vertice");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				Element el = (Element)nl.item(i);
				Vertice e = getVertice(el);
				ruta.getRuta().add(e);
			}
		}
	}

	private Vertice getVertice(Element empEl) {
		return new Vertice(getTextValue(empEl,"Nombre"),getDoubleValue(empEl, "Latitud"),getDoubleValue(empEl, "Longitud"),getDoubleValue(empEl, "Altitud"));
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	private double getDoubleValue(Element ele, String tagName) {
		return Double.parseDouble(getTextValue(ele,tagName));
	}
	

	
	public LinkedList<Vertice> getRuta() {
		return ruta.getRuta();
	}
}
