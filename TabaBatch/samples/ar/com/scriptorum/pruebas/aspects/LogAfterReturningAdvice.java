package ar.com.scriptorum.pruebas.aspects;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice{    

    public void afterReturning(Object returnValue, Method method, Object[] args, 
    Object target) throws Throwable {

        System.out.println("After Normal Return from Method: " + method.getName());
    }

}