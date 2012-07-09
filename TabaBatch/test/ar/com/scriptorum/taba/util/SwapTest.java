package ar.com.scriptorum.taba.util;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
public class SwapTest {
	
	@Test
	public void testSwap() {
		Object a = new Object();
		Object b = new Object();
		Object [] objects = new SwappingBag(a).swapWith(b).andReturnBoth(); 
		assertNotNull(objects[0]);
		assertNotNull(objects[1]);
	}
	
	
	public class SwappingBag {
		Object object1;
		Object object2;
		SwappingBag(Object o) {
			this.object1 = o;
		}
		
		public SwappingBag swapWith(Object o) {
			this.object2 = o;
			return this;
		}
		
		public Object[] andReturnBoth() {
			return new Object[] {object2, object1};
		}
		
	}

}
