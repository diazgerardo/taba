package ar.com.scriptorum.taba.dao;

import ar.com.scriptorum.taba.interfaces.User;

public interface UserDao {
	public User findByName(String name);
	public boolean saveUser(User user);
	public boolean modifyUser(User user);
}
