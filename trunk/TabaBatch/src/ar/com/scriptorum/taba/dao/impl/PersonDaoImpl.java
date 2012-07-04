package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class PersonDaoImpl <T> extends GenericDao {
	
	private T t;

	public PersonDaoImpl(T t) {
		this.t = t;
	}

	public T findByName(String name) {
		try {
			String queryString = "from "+t.getClass().getName()+" where name = :name";
			Query query = getCurrentSession().createQuery(queryString);
			query.setString("name", name);
			return (T) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getCurrentSession().close();
		}
		return null;
	}
	
	public boolean delete(T t) {
		boolean result = true;
		try {
			getCurrentSession().delete(t);
		} catch (HibernateException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
