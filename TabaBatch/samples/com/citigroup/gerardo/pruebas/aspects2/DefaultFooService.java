package com.citigroup.gerardo.pruebas.aspects2;


public class DefaultFooService implements FooService {

	public Foo getFoo(String name, int age) {
		return new Foo(name, age);
	}
}