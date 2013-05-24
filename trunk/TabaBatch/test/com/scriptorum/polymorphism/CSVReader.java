package com.scriptorum.polymorphism;

import java.util.StringTokenizer;

public abstract class CSVReader {

	abstract Order getOrder();
	
	protected String readNext() {
		return "gerardo; diaz; campana";
	}
	
	protected String[] nextRecord() {
		StringTokenizer st = new StringTokenizer(readNext(), ";");
		String[] tokens = new String[st.countTokens()];
		int i = 0;
		while(st.hasMoreTokens())
			tokens[i++] = st.nextToken();
		return tokens;
	}
	
}
