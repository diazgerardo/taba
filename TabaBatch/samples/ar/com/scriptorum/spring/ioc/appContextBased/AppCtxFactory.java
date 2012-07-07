package ar.com.scriptorum.spring.ioc.appContextBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppCtxFactory {

	static ApplicationContext context = new FileSystemXmlApplicationContext("./samples/ar/com/scriptorum/spring/ioc/appContextBased/appContext.xml");

	private AppCtxFactory() {};
	
	public static ApplicationContext getAppContext() {
		return context;
	}

	
}
