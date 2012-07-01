package ar.com.scriptorum.taba.util;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import ar.com.scriptorum.taba.beans.Person;

public class PersonSwapperTest {

	@Test
	public void testPersonSwappingBag() {
		Person p1 = new Person();
		p1.setId(25);
		p1.setName("gerardo");
		
		Person p2 = new Person();
		p2.setId(50);
		p2.setName("horacio");
		
		PersonSwappingBag psb = new PersonSwappingBag(p1, p2).swap();
		
		Person p3 = psb.firstSwapee(); 
		Person p4 = psb.getSecond();
		
		assertTrue(p3.getId()==25);
		assertTrue("horacio".equals(p3.getName()));
		
		assertTrue(p4.getId()==50);
		assertTrue("gerardo".equals(p4.getName()));
		
	}
}
