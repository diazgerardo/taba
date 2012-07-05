package ar.com.scriptorum.spring.validator;

import org.springframework.validation.Errors;

public class PersonValidator implements ExtendedValidator {

	private Errors errors;

	public PersonValidator() {
		this.errors = new PersonErrors();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// ValidationUtils.rejectIfEmpty(arg1, "nombre", "nombre.empty");
		Person p = (Person) arg0;
		if (p.getAge() < 0) {
			arg1.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			arg1.rejectValue("age", "too.darn.old");
		}
		if (null == p.getNombre() || "".equals(p.getNombre()))
			arg1.rejectValue("nombre", "nombre.empty");

	}

	@Override
	public Errors getErrors() {
		return errors;
	}

	@Override
	public void setErrors(Errors e) {
		this.errors = e;
	}

}
