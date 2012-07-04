package com.citigroup.gerardo;

import org.junit.Test;



public class JaulaTest {


	@Test
	public void enjaular() {
		Jaula jaula = new Jaula();
		jaula.add(new Oso());
		jaula.add(new Vaca());
	}

}
