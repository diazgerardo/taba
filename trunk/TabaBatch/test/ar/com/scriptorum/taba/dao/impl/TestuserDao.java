package ar.com.scriptorum.taba.dao.impl;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.dao.UserDao;

public class TestuserDao extends TestCase {
	
	public void testDao() {
		UserDao userDao = UserDaoMock.getInstance();
		assertNotNull(userDao);
	}

}
