package ar.com.scriptorum.clonable;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import ar.com.scriptorum.cloneable.ClonableFoo;
public class CloningObjectsTest {

	@Test
	public void testMain() {
		ClonableFoo a = new ClonableFoo();
		ClonableFoo b = (ClonableFoo) a.clone();
		assertTrue(a.equals(b));
	}

}
