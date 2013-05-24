package com.scriptorum.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Master {
	
	public static void main(String[] args) {
		List<CSVReader> readers = new ArrayList<CSVReader>();
		readers.add(new PorfinReader());
		readers.add(new EdealerReader());
		
		Slave slave = new Slave();
		for(CSVReader reader : readers) {
			Order order = reader.getOrder();
			slave.print(order);
		}
		
	}
	

}
