package ar.com.scriptorum.threads.multithreading;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Carpintero {
	
	@Test
	public void iterar() {
		ClavoFactory factory = ClavoFactory.getInstance();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
		}
		for(Clavo clavo : factory.clavos) {
			assertNotNull(clavo.head);
			assertNotNull(clavo.tip);
			assertNotNull(clavo.body);
			assertTrue(clavo.id==clavo.tip.id);
			assertTrue(clavo.id==clavo.head.id);
			assertTrue(clavo.id==clavo.body.id);
			System.out.println("Excelente clavo!\n" + clavo.toString());
		}
		System.out.println("ok!");
	}
	
	@Test
	public void clavetear() throws InterruptedException {
		while(true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println(Thread.currentThread().getName());
			Clavo clavo = null;
			while(clavo == null) {
				System.out.println("Dame un clavo please!");
				clavo = ClavoFactory.getInstance().getNewClavo();
			}
			System.out.println("Gracias. A ver? ");
			assertNotNull(clavo.head);
			assertNotNull(clavo.tip);
			assertNotNull(clavo.body);
			assertTrue(clavo.id==clavo.tip.id);
			assertTrue(clavo.id==clavo.head.id);
			assertTrue(clavo.id==clavo.body.id);
			System.out.println("Excelente clavo!\n" + clavo.toString());
		}
	}
}
