package ar.com.scriptorum.stringutils;

import org.apache.commons.lang.StringUtils;

public class StringUtilsExample {

	public static void main(String [] args ) {
		StringBuffer sb = new StringBuffer()
		.append(";;;;abcd: abcd; agaga, adgags afgaga")
		.append("oaudugaf, oapdga paodogaga.;;;");
		String st = sb.toString();
		st = StringUtils.strip(st,";" );
	}
	
	
}
