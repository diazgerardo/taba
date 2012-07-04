package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.taba.dao.UserDao;
import ar.com.scriptorum.taba.interfaces.User;

public class UserDaoImpl extends GenericDao implements UserDao {

	@Override
	public User findByName(String name) {
		try {
			String queryString = "from User where name :name";
			Query query = getCurrentSession().createQuery(queryString);
			query.setString("name", name);
			return (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getCurrentSession().close();
		}
		return null;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
