package ar.com.scriptorum.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface ExtendedValidator extends Validator {
	public Errors getErrors();
	public void setErrors(Errors e);
}
