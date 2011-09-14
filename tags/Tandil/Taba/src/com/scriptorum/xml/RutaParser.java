package com.scriptorum.xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.os.Environment;

import com.scriptorum.abstractions.Vertice;

public class RutaParser {

	static List <Vertice> vertices;
	Document dom;


	public RutaParser(){
		vertices = new ArrayList();
	}

	public void runExample() {
		parseXmlFile();
		parseDocument();
	}
	
	
	private void parseXmlFile(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			final File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/buenosAires-Cordoba.xml"); 
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
				vertices.add(e);
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
	

	
	public static List<Vertice> getVertices() {
		return vertices;
	}
}
