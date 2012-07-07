package ar.com.scriptorum.aspects.adder;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice {
	static Logger _logger = Logger.getLogger(LogAfterReturningAdvice.class);
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		_logger.debug("After Normal Return from Method: " + method.getName());
	}

}