package ar.com.scriptorum.taba.util;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import ar.com.scriptorum.taba.beans.Carpooler;

public class PersonSwapperTest {

	@Test
	public void testPersonSwappingBag() {
		Carpooler p1 = new Carpooler();
		p1.setId(25);
		p1.setNombre("gerardo");
		
		Carpooler p2 = new Carpooler();
		p2.setId(50);
		p2.setNombre("horacio");
		
		PersonSwappingBag psb = new PersonSwappingBag(p1, p2).swap();
		
		Carpooler p3 = psb.firstSwapee(); 
		Carpooler p4 = psb.getSecond();
		
		assertTrue(p3.getId()==25);
		assertTrue("horacio".equals(p3.getNombre()));
		
		assertTrue(p4.getId()==50);
		assertTrue("gerardo".equals(p4.getNombre()));
		
	}
}
