package ar.com.scriptorum.taba.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.dao.GenericDaoImpl;
import ar.com.scriptorum.taba.dao.UserDao;
import ar.com.scriptorum.taba.interfaces.User;

public class UserDaoImpl extends GenericDaoImpl<Object> implements UserDao {

	@Override
	public User findByName(String name) {
		try {
			String queryString = "from User where name :name";
			Query query = getSession().createQuery(queryString);
			query.setString("name", name);
			return (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getSession().close();
		}
		return null;
	}

	@Override
	public List<User> listUsersLike( Map<String, Object> map ) {
		throw new RuntimeException("unimplemented yet");
	}

}
