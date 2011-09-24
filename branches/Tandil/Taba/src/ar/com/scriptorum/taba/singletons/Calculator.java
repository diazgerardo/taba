package ar.com.scriptorum.taba.singletons;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calculator {
	private Calculator() {}
	
	public static BigDecimal redondear(BigDecimal valor) {
		// 4 decimales, se redondea "hacia arriba" si el 5to decimal es >= 5, y "hacia abajo" si el 5to decimal es < 5 
		MathContext mc = new MathContext(5);
		valor = valor.round(mc);
		return valor;
	}
	
	public static BigDecimal metrosAKm(BigDecimal metros) {
		return redondear(metros.divide(new BigDecimal(1000)));
	}
	
	public static String metrosAStrKm(BigDecimal metros) {
		return null!= metros ? String.valueOf(metrosAKm(metros))+"Km.":"";
	}

}
