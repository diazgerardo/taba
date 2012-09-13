package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.dao.GenericDaoImpl;
import ar.com.scriptorum.taba.beans.*;

public class PersonDaoImpl extends GenericDaoImpl {
	
	private static PersonDaoImpl _instance;
	
	private PersonDaoImpl() {
		super();
	}
	
	public static synchronized PersonDaoImpl getInstance() {
		if(_instance == null ) {
			_instance = new PersonDaoImpl();
		}
		return _instance;
	}

	@SuppressWarnings("unchecked")
	public Person findByName(String name) {
		try {
			String queryString = "from Person where name = :name";
			Query query = getSession().createQuery(queryString);
			query.setString("name", name);
			return (Person) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getSession().close();
		}
		return null;
	}
	
	public boolean delete(Person t) {
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
