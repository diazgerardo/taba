package ar.com.scriptorum.spring.ioc.appContextBased;

import org.springframework.beans.factory.annotation.Autowired;

public class PrintServiceImpl implements PrintService {
	@Autowired
	Printer printer;
	
	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void print(Object o) {
		printer.print(o);
	}

}
