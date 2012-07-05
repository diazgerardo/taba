package ar.com.scriptorum.xml;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.impl.xs.opti.NodeImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

class RutaSerializer {
	
	static Document documentXML;
	static Element element;

	
	
	public static void main(String args[]) {        
		// A. Crear el objeto(s) a Descarga

		Vertice v1 = new Vertice("gerardo",2.1D,2.2D,0.0D);        
		Vertice v2 = new Vertice("claudia",2.1D,2.2D,0.0D);        
		List elementList = new ArrayList();        
		elementList.add(v1);        
		elementList.add(v2);
		//        elementList.add(user);        
		        
		startDocumentXML();    
		populateDocumentXML(elementList);
		generateTextXML();
		saveDocumentXML("file.txt");
		
	}
	
	
	public static void startDocumentXML() {
		try {        // 1. Crear objeto DocumentBuilderFactory       
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
			// 2. A partir del objeto DocumentBuilderFactory crear         
			//    un objeto DocumentBuilder        
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();        
			// 3. Generar el documento XML            
			documentXML = docBuilder.newDocument();        
			
		} catch (Exception e) {            
				System.out.println("Error : " + e);        
			}        
		// 4. Crear el elemento "descargas"        
		element = documentXML.createElement(getRootName());       
		// 5. Agregar al documento principal        
		documentXML.appendChild(element);    
	}
		
	
	private static String getRootName() {
		return "Root";
	}


	private static void populateDocumentXML(List elements) {   
		Node newChild = new NodeImpl();
		Element nElement, item;        
		// 1. Crear elemento        
		nElement = documentXML.createElement(getRootName());    
		// iteramos sobre la lista de objetos que se recibe se     
		//construirá un elemento por cada objeto recibido        
		for (int a = 0; a < elements.size(); a++) {            
				Object value = "";            
				Method met;            
				Class obj;            
				Field[] stra;            
				obj = elements.get(a).getClass();            
				stra = obj.getDeclaredFields();    
				// posteriormente obtenemos una lista con los atributos que tiene cada objeto    
				// y de forma similar creamos nuevos nodos por cada atributo del objeto            
				for (int i = 0; i < stra.length; i++) {                
					try {           
						// utilizamos algo de reflection para obtener los valores de los atributos                    
						met = obj.getMethod(getterFind(stra[i].getName()), new Class[]{});                    
						value = (String) met.invoke(elements.get(a), new Object[]{});                
					} catch (Exception ex) {                
					}        
					// Si este es el primer elemento le asignamos el nombre del         
					// objeto como nombre del nodo en XML y le añadimos el primer        
					// atributo como identificador de atributo  al nodo                
					if (i == 0) {                    
						String tempSt = obj.getSimpleName().toLowerCase();                    
						// 1. Crear elemento                    
						nElement = documentXML.createElement(tempSt);                    
						// 2. Asignar un atributo                    
						nElement.setAttribute(stra[i].getName(), "" + value.toString());                   
						// 3. Añadir elemento al documento
						documentXML.insertBefore(newChild, nElement);                
					} else {                    
						// a. Crear item                    
						item = documentXML.createElement(stra[i].getName());                    
						// b. Asignar un dato al item                   
						item.appendChild(documentXML.createTextNode(value.toString()));                    
						// c. Aniadir el item                    
						nElement.appendChild(item);                
					}            
				}        
			}    
		}

	
	private static String generateTextXML() {        
		StringWriter strWriter = null;        
		XMLSerializer serializeXML = null;        
		OutputFormat ouputFormat = null;        
		try {            
			serializeXML = new XMLSerializer();            
			strWriter = new StringWriter();            
			ouputFormat = new OutputFormat();            
			// 1. Establecer el formato            
			ouputFormat.setEncoding(getEncodingXML());            
			ouputFormat.setVersion(getVersionXML());            
			ouputFormat.setIndenting(true);            
			ouputFormat.setIndent(4);            
			// 2. Definir un objeto donde se generara el codigo            
			serializeXML.setOutputCharStream(strWriter);            
			// 3. Aplicar el formato            
			serializeXML.setOutputFormat(ouputFormat);            
			// 4. Serializar documento XML            
			serializeXML.serialize(documentXML);            
			strWriter.close();        
		} catch (IOException ioEx) {            
			System.out.println("Error : " + ioEx);        
		}        
		return strWriter.toString();    
		
	}
		
	public static void saveDocumentXML(String texto) {        
		try {            
			OutputStream fout = new FileOutputStream(getFileName());            
			OutputStream bout = new BufferedOutputStream(fout);            
			OutputStreamWriter out = new OutputStreamWriter(bout, getEncodingJava());            
			out.write(texto);            
			out.flush();            
			out.close();        
			} catch (UnsupportedEncodingException e) {            
				System.out.println("Error encoding");        
			} catch (IOException e) {            
				System.out.println(e.getMessage());        
			} catch (Exception e) {            
				System.out.println("Error : " + e);        
			}    
	}	

	private static String getEncodingJava() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getVersionXML() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getEncodingXML() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getterFind(String name) {
		
		return name;
	}
	
	
	
}
