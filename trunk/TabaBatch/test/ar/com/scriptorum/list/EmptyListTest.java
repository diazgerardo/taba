package ar.com.scriptorum.list;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class EmptyListTest {

	@Test
	public void test() {
		List<Object> list = null;
		for(Object o : list) {
			
		}
		assertTrue(list.isEmpty());
	}
}
