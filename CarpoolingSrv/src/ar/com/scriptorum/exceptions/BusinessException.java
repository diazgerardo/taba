package ar.com.scriptorum.exceptions;

public class BusinessException extends RuntimeException {

	public BusinessException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
