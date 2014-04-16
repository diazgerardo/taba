package ar.com.scriptorum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.scriptorum.domain.User;


public class UserDAOImpl implements UserDAO {
	
	private static Map<Long, User> set = new HashMap<Long, User>();

	private static long id;
	/**
	 * Used to save or update a user.
	 */
	@Override
	public void saveOrUpdateUser(User user) {
		user.setId(++id);
		set.put(id, user);
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void deleteUser(Long userId) {
			set.remove(userId);
	}
	
	/**
	 * Used to list all the users.
	 */
	@Override
	public List<User> listUser() {
		return new ArrayList<User>(set.values());
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public User listUserById(Long userId) {
		return set.get(userId);
	}

}
