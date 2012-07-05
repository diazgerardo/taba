package ar.com.scriptorum.taba.dao;

import java.util.List;
import java.util.Map;

import ar.com.scriptorum.taba.interfaces.User;

public interface UserDao {
	public User findByName(String name);
	public List<User> listUsersLike(Map<String, Object> map);
}
