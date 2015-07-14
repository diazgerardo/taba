package ar.com.scriptorum.spring.ioc.appContextBased;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class IoC_Test {

	static Foo foo;
	static PrintService prnService;
	static ApplicationContext context;
	
	@BeforeClass
	public static void doPrepare() {
		context = AppCtxFactory.getAppContext(); 
	}
	
	@Test
	public void testHidrateFoo() {
		try {
			foo = (Foo) context.getBean("unknownFoo");	
			fail(" unknownFoo is not a valid foo, you know?");
		} catch(Exception e) {
			assertTrue(foo == null);
		}
		
		foo = (Foo) context.getBean("foo");
		assertTrue(foo != null);
	}
	
	@Test 
	public void testHidrateService() {
		
		try {
			prnService = (PrintService) context.getBean("unknownPrnService");
			fail(" unknownPrnService is not a valid service, you know?");
		} catch (BeansException e) {
			assertTrue(prnService == null);
		}
		prnService = (PrintService) context.getBean("prnService");
		assertNotNull(prnService);
		prnService.setPrinter((Printer) context.getBean("printer"));
	}
	
	@Test 
	public void runService() {
		prnService.print(foo);
	}

}
