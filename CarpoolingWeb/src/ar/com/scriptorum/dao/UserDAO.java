package ar.com.scriptorum.dao;

import java.util.List;

import ar.com.scriptorum.domain.User;

public interface UserDAO {

	public void saveOrUpdateUser(User user);
	public List<User> listUser();
	public User listUserById(Long userId);
	public void deleteUser(Long userId);
}
