				
package ar.com.scriptorum.pruebas.aspects;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class AdderTest {

    public static void main(String args[]){

        Resource resource = new FileSystemResource("./src/aop-test.xml");
        BeanFactory factory = new XmlBeanFactory(resource);        
        Adder adder = (Adder)factory.getBean("adder");
        int result = adder.add(10,10);
        System.out.println("Result = " + result);

        result = adder.noArgs();
        System.out.println("Result = " + result);

        result = adder.add(0,0);
        System.out.println("Result = " + result);        
        result = adder.noArgs();
    }
}
				