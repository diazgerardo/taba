package ar.com.scriptorum.aspects.boot;


public class DefaultFooService implements FooService {

	public Foo getFoo(String name, int age) {
		return new Foo(name, age);
	}
}