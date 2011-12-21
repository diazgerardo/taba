package ar.com.scriptorum.taba.main;

import java.lang.reflect.Method;

import ar.com.scriptorum.taba.beans.SimpleBean;

public class Serializer {
	
	public static void main(String [] args) {
		SimpleBean sb = new SimpleBean();
		sb.setDescripcion("abc");
		String s = toXMLString(sb);
		System.out.println("s="+s);
	}
	public static String toXMLString(SimpleBean s) {
		StringBuffer xmlString = new StringBuffer();
		Method [] methods = s.getClass().getMethods();
		for(Method m : methods) {
			xmlString.append("<"+m.getName()+">"+"</"+m.getName()+">");
		}
		return xmlString.toString();
	}

}
