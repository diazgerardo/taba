package ar.com.scriptorum.concetps;

import junit.framework.TestCase;

import org.apache.commons.lang.builder.CompareToBuilder;


public class CompareToBuilderTest extends TestCase {
	
	public static final void testCompareTo() {
		
		CompareToBuilder cb = new CompareToBuilder();
		assertTrue(cb != null);		
	}

}
