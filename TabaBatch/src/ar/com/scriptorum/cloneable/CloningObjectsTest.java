package ar.com.scriptorum.cloneable;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;
public class CloningObjectsTest {

	@Test
	public void testMain() {
		Foo a = new Foo();
		Foo b = (Foo) a.clone();
		assertTrue(a.equals(b));
	}

	public class Foo {
		private int aPrimitive;
		public int getaPrimitive() {
			return aPrimitive;
		}
		public void setaPrimitive(int aPrimitive) {
			this.aPrimitive = aPrimitive;
		}
		public Object getAnObject() {
			return anObject;
		}
		public void setAnObject(Object anObject) {
			this.anObject = anObject;
		}
		
		private Object anObject;
		Foo() {
			aPrimitive = 25252;
			anObject = new Object();
		}
		@Override
		public Foo clone() {
			Foo foo = new Foo();
			foo.setaPrimitive(this.getaPrimitive());
			foo.setAnObject(this.getAnObject());
			return foo;
		}
		
		@Override
		public boolean equals(Object o) {
			return true;
		}

	}

}
