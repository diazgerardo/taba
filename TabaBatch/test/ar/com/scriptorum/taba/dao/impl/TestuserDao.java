package ar.com.scriptorum.taba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.dao.UserDao;

public class TestuserDao extends TestCase {
	
	public void testDao() {
		UserDao userDao = UserDaoMock.getInstance();
		assertNotNull(userDao);
	}
	
	public void testListUsers(){
		UserDao userDao = UserDaoMock.getInstance();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "gerardo");
		userDao.listUsersLike(map);
	}

}
