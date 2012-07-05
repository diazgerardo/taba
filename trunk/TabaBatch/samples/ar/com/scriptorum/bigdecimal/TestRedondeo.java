package ar.com.scriptorum.bigdecimal;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Before;
import org.junit.Test;

public class TestRedondeo {
	static BigDecimal numero;
	@Before
	public void setUp() throws Exception {
		numero = new BigDecimal(1.234567);
	}
	
	@Test
	public void redondeaHaciaAbajo() {
		MathContext mc = new MathContext(3);
		numero = numero.round(mc);
		assertTrue(1.23D == numero.doubleValue());
	}
	
	@Test
	public void qPasaCon5() {
		MathContext mc = new MathContext(5);
		numero = numero.round(mc);
		assertTrue(1.2346D == numero.doubleValue());
	}
	
	@Test
	public void redondeaHaciaArriba() {
		MathContext mc = new MathContext(6);
		numero = numero.round(mc);
		assertTrue(1.23457D == numero.doubleValue());
	}

}
