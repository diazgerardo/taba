				
package ar.com.scriptorum.aspects.adder;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeCallAdvice implements MethodBeforeAdvice{
	static Logger _logger = Logger.getLogger(LogBeforeCallAdvice.class);
    public void before(Method method, Object[] args, Object target) {
        _logger.debug("Before calling the method: " + method.getName());
    }

}
