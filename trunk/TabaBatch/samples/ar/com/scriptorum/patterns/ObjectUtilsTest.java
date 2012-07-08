package ar.com.scriptorum.patterns;

import junit.framework.TestCase;

public class ObjectUtilsTest extends TestCase {


	public void test() {
		
		Object anObject = null;
		Object o = new ObjectUtils<Object>(Object.class).safeGet(anObject);
		assertNotNull(o);
		assertTrue(o instanceof Object);
		
		anObject = new Object();
		o = new ObjectUtils<Object>(Object.class).safeGet(anObject);
		assertNotNull(o);
		assertTrue(o instanceof Object);
		
		anObject = new String();
		o = new ObjectUtils<Object>(Object.class).safeGet(anObject);
		assertNotNull(o);
		assertTrue(o instanceof String);
		
		anObject = new StringBuffer();
		o = new ObjectUtils<Object>(Object.class).safeGet(anObject);
		assertNotNull(o);
		assertTrue(o instanceof StringBuffer);
		
		//try {
		ComplexObject co = new ComplexObject();
		//co.setCo(new ComplexObject());
		co.getCo().setCo(new ComplexObject());
		co.getCo().getCo().setCo(new ComplexObject());
		co.getCo().getCo().getCo().setCo(co);
		
		o = new ObjectUtils<ComplexObject>(ComplexObject.class).safeGet(co.getCo().getCo().getCo());
		assertNotNull(o);
		assertTrue(o instanceof ComplexObject);
		//} catch(Throwable t) {
		//	t.printStackTrace();
		//}
		
	}
	
}
