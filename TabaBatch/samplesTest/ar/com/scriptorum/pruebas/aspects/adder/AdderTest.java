				
package ar.com.scriptorum.pruebas.aspects.adder;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.UndeclaredThrowableException;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import ar.com.scriptorum.pruebas.aspects.adder.Adder;

public class AdderTest {

	@Test
    public void testAdder(){
    	
        try {
			Resource resource = new FileSystemResource("./samples/ar/com/scriptorum/pruebas/aspects/adder/adder.xml");
			BeanFactory factory = new XmlBeanFactory(resource);        
			Adder adder = (Adder)factory.getBean("adder");
			int result = adder.add(110,10);
			System.out.println("Result = " + result);

			result = adder.noArgs();
			System.out.println("Result = " + result);

			result = adder.add(0,0);
			System.out.println("Result = " + result);        
			result = adder.noArgs();
		} catch (Exception e) {
			assertTrue(e instanceof UndeclaredThrowableException);
		}
    }
}
				