package ar.com.scriptorum.patterns.decorator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DecoratorTests {
	@Test
    public void testDecorator() {
        assertTrue(null != new Decorator());
	}
	@Test
	public void testSubNumber() {
        assertTrue(null!=new SubNumber());
    }
}
