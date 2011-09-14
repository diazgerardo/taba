package com.scriptorum.singletons;

import java.text.DecimalFormat;

public class MathUtil {
	private static DecimalFormat _decimalFormat = new DecimalFormat("##.####");
	
	private MathUtil() {}
	
	public static String round(double d) {
		
		//return String.valueOf(Double.valueOf(_decimalFormat.format(d)));
		return String.valueOf(Double.valueOf(d));
	}

}
