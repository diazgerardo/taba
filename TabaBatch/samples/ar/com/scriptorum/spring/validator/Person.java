package ar.com.scriptorum.spring.validator;


public class Person implements Validable {

	public String nombre;
	public int age;
	private ExtendedValidator validator;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setValidator(ExtendedValidator e) {
		this.validator = e;
		
	}

	@Override
	public ExtendedValidator getValidator() {
		return this.validator;
	}
	
}
