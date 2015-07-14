package ar.com.scriptorum.spring.ioc.appContextBased;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	@Autowired
	@Qualifier("holder")
	MyPropertyHolder holder;
	private static Logger _logger = Logger.getLogger(Printer.class);
	public void print(Object o) {
		showCfg();
		System.out.println(this.getClass().getName()+" is printing "+o+" ...");
	}
	
	@PostConstruct
	public void showCfg() {
		for(String key: holder.getResolvedProps().keySet()){
			_logger.debug(key+holder.getResolvedProps().get(key));
		}
	}

}
