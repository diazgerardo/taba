package ar.com.scriptorum.spring.ioc.appContextBased;

public class PrintServiceImpl implements PrintService {

	@Override
	public void print(Object o) {
		System.out.println("printing "+o+" ...");
	}

}
