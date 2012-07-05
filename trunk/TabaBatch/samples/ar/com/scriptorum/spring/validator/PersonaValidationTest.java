package ar.com.scriptorum.spring.validator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonaValidationTest {


	@Test
	public void personaCreation() {
		Person person = new Person();
		person.setValidator(new PersonValidator());
		assertTrue(person.getValidator().supports(Person.class));
		person.setAge(151); // 1st error
		person.setNombre("gerardo");
		person.getValidator().validate(person, person.getValidator().getErrors());
		assertTrue(person.getValidator().getErrors().getErrorCount() == 1);

	}
}
