package ar.com.scriptorum.taba.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

import ar.com.scriptorum.taba.beans.UserImpl;
import ar.com.scriptorum.taba.dao.UserDao;
import ar.com.scriptorum.taba.interfaces.User;
import ar.com.scriptorum.taba.util.documents.AbstractDocument;
import ar.com.scriptorum.taba.util.state.AsignadorImpl;

public class UserDaoMock implements UserDao {

	static HashMap<String, User> users;
	private static UserDao _instance;
	
	@Override
	public User findByName(String name) {
		return users.get(name);
	}
	
	public static UserDao getInstance() {
		if(_instance == null)
			_instance = new UserDaoMock();
		return _instance;
	}

	private UserDaoMock() {
		users  = new HashMap<String,User>();
		users.put("gerardo", new UserImpl("gerardo", "diaz", "pueyrredon 951", "gerardo.diaz@gmail.com"));
		users.put("horacio", new UserImpl("horacio", "swidzinski", "ortiz de zarate 4567", "swidzinski@gmail.com"));
		users.put("boton", new AsignadorImpl<AbstractDocument>("boton", "del orto", "algun lugar", "flordeboton@gmail.com", null));
	}

	@Override
	public List<User> listUsersLike( Map<String, Object> map ) {
		List<User> resultList = new ArrayList<User>();
		try {
			for(User user : users.values()) {
				for(Entry<String, Object> e : map.entrySet()) {
					if(BeanUtils.getSimpleProperty(user, e.getKey()).equals(e.getValue())) {
						resultList.add(user);
					}
				}
			}
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
