package com.scriptorum.polymorphism;

public class Slave {

	public void print(Order o) {
		System.out.println("field1="+o.getNombre()+" field2="+o.getApellido()+" field3="+o.getDireccion());
	}
	
}
