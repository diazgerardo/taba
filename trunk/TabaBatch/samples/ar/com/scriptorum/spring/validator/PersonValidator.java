package ar.com.scriptorum.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "nombre", "nombre.empty");
        Person p = (Person) arg0;
        if (p.getAge() < 0) {
            arg1.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            arg1.rejectValue("age", "too.darn.old");
        }	
        
    }

}
