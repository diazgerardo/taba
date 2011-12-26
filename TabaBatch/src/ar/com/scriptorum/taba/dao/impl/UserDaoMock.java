package ar.com.scriptorum.taba.dao.impl;

import java.util.HashMap;

import ar.com.scriptorum.taba.dao.UserDao;
import ar.com.scriptorum.taba.interfaces.User;

public class UserDaoMock implements UserDao {

	static HashMap<String, User> users = new HashMap<String,User>();
	private static UserDao _instance;
	
	@Override
	public User findByName(String name) {
		return users.get(name);
	}

	@Override
	public boolean saveUser(User user) {
		boolean result = false;
		try {
			users.put(user.getName(), user);
			result = true;
		}catch(Exception e) {
			// don't do anything, just return false instead
		}
		return result;
	}

	@Override
	public boolean modifyUser(User user) {
		boolean result = false;
		if(null!=users.remove(user.getName())) {
			users.put(user.getName(),user);
			result = true;
		}
		return result;
	}
	
	public static UserDao getInstance() {
		if(_instance == null)
			_instance = new UserDaoMock();
		return _instance;
	}

}
