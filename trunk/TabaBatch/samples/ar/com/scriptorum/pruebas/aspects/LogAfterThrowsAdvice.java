				
package ar.com.scriptorum.pruebas.aspects;

import java.lang.reflect.Method;
import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowsAdvice implements ThrowsAdvice{

    public void afterThrowing(Method method, Object[] args, Object target, 
    Exception exception){        

        System.out.println("Exception is thrown on method " + method.getName());
    }    

}