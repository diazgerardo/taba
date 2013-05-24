package ar.com.scriptorum.spring.ioc.appContextBased;

public class Printer {
	
	public void print(Object o) {
		System.out.println(this.getClass().getName()+" is printing "+o+" ...");
	}

}
