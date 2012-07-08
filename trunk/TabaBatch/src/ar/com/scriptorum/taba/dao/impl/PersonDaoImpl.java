package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.dao.GenericDaoImpl;

public class PersonDaoImpl <T> extends GenericDaoImpl<Object> {
	
	private T t;

	public PersonDaoImpl(T t) {
		this.t = t;
	}

	@SuppressWarnings("unchecked")
	public T findByName(String name) {
		try {
			String queryString = "from "+t.getClass().getName()+" where name = :name";
			Query query = getSession().createQuery(queryString);
			query.setString("name", name);
			return (T) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getSession().close();
		}
		return null;
	}
	
	public boolean delete(T t) {
		boolean result = true;
		try {
			getSession().delete(t);
		} catch (HibernateException e) {
			e.printStackTrace();
			result = false;
		}finally {
		getSession().close();
	}
		return result;
	}

}
