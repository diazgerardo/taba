package ar.com.scriptorum.pruebas.aspects.adder;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class LogAroundAdvice implements MethodInterceptor {
	static Logger _logger = Logger.getLogger(LogAroundAdvice.class);

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		_logger.debug(methodInvocation.getArguments().toString());
		try {
			Object arguments[] = methodInvocation.getArguments();
			int number1 = ((Integer) arguments[0]).intValue();
			int number2 = ((Integer) arguments[1]).intValue();

			if (number1 == 0 && number2 == 0) {
				throw new Exception("Dont know how to add 0 and 0!!!");
			}
			return methodInvocation.proceed();
		} catch (Exception e) {
			_logger.debug("Exception caught: " + e.getMessage());
			throw new Exception("Dont know what to do next: Rethrowing...");
		}
	}
}