package ar.com.scriptorum.mgr;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ar.com.scriptorum.exceptions.BusinessException;
import ar.com.scriptorum.mgr.impl.RequestManagerImpl;

public class ManagerTest {
	
	RequestManager rq;
	
	@Before
	public void init() {
		rq = new RequestManagerImpl();
	}

	@Test
	public void testRequestmanager() {
		try {
			String st = rq.readViajes();
			assertNotNull(st);
		}catch(BusinessException e) {
			fail("unexpected exception happened");
		}

	}
	
}
