				
package ar.com.scriptorum.pruebas.aspects;

import org.aopalliance.intercept.*;

public class LogAroundAdvice implements MethodInterceptor{

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object arguments[] = methodInvocation.getArguments();
        int number1 = ((Integer)arguments[0]).intValue();
        int number2 = ((Integer)arguments[1]).intValue();

        if (number1 == 0 && number2 == 0){
            throw new Exception("Dont know how to add 0 and 0!!!");
        }
        return methodInvocation.proceed();
    }
}