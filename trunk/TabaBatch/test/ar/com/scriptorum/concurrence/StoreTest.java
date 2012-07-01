package ar.com.scriptorum.concurrence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class StoreTest {

	Store store;

	@Before
	public void setUp() {
		store = new Store();
	}

	@Test
	public void testPushAndPop() {

		for (int i = 0; i < 10; i++) {
			assertTrue(store.push(new Object()));
		}

		for (int i = 0; i < 10; i++) {
			assertNotNull(store.pop());
		}

		assertNull(store.pop());

	}

}
