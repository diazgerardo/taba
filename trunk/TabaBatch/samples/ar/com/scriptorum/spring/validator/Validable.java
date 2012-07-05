package ar.com.scriptorum.spring.validator;


public interface Validable {
	void setValidator(ExtendedValidator e);
	ExtendedValidator getValidator();
}
