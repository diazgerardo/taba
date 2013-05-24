package ar.com.scriptorum.spring.ioc.appContextBased;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Main {
	
	public static void main(String ... args) {
		Map<Integer, PrintService> store = new HashMap<Integer, PrintService>();
		ApplicationContext ctx = AppCtxFactory.getAppContext();
		PrintService prnService = (PrintService) ctx.getBean("prnService");
		store.put(prnService.hashCode(), prnService);
		assertTrue(checkBean(ctx, prnService));
		PrintService prnService2 = new PrintServiceImpl();
		store.put(prnService2.hashCode(), prnService2);
		assertFalse(checkBean(ctx, prnService2));
	
	}

	@SuppressWarnings("deprecation")
	private static boolean checkBean(ApplicationContext ctx,PrintService prnService) {
		assertNotNull(prnService);
		int firstHash = prnService.hashCode();
		try {
			prnService.print(ctx);
			fail("printer was expected to be null after getBean");
		} catch(NullPointerException ex) {
			// normal
			System.out.println("expected null pointer has been caught...");
		}
		((AbstractApplicationContext)ctx).getBeanFactory().autowireBeanProperties(prnService,AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT , true);
		try {
			prnService.print(ctx);
			System.out.println("printer was not expected to be null after autowiring properties");
		} catch(NullPointerException ex) {
			// not normal
			fail("non expected null pointer has been caught!!!");
		}
		
		// ok, now ask again the context to provide another reference to the context managed prnService bean
		PrintService prnService2 = (PrintService) ctx.getBean("prnService");
		return firstHash == prnService2.hashCode();
	}

}
