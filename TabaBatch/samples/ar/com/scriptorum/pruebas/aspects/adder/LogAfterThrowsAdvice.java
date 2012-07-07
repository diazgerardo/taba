				
package ar.com.scriptorum.pruebas.aspects.adder;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowsAdvice implements ThrowsAdvice{
	static Logger _logger = Logger.getLogger(LogAfterThrowsAdvice.class);
    public void afterThrowing(Method method, Object[] args, Object target,Exception exception){        
        _logger.debug("Exception is thrown on method " + method.getName());
        _logger.debug("Message " + exception.getMessage());
    }    

}