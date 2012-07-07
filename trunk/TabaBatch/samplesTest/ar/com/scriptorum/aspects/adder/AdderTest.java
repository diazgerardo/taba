				
package ar.com.scriptorum.aspects.adder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.UndeclaredThrowableException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import ar.com.scriptorum.aspects.adder.Adder;

public class AdderTest {

	Logger _logger = Logger.getLogger(AdderTest.class);
	@Test
    public void testAdder(){
    	
        try {
			Resource resource = new FileSystemResource("./samples/ar/com/scriptorum/aspects/adder/adder.xml");
			BeanFactory factory = new XmlBeanFactory(resource);        
			Adder adder = (Adder)factory.getBean("adder");
			int result = adder.add(110,10);
			_logger.debug("Result = " + result);

			result = adder.noArgs();
			_logger.debug("Result = " + result);

			result = adder.add(0,0);
			_logger.debug("Result = " + result);        
			result = adder.noArgs();
			fail("Expected UndeclaredThrowableException didn't happen!");
		} catch (Exception e) {
			assertTrue(e instanceof UndeclaredThrowableException);
		}
    }
}
				