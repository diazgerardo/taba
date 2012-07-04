package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.taba.beans.Person;

public class PersonDaoImpl extends GenericDao {

	public Person findByName(String name) {
		try {
			String queryString = "from Person where name = :name";
			Query query = getCurrentSession().createQuery(queryString);
			query.setString("name", name);
			return (Person) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getCurrentSession().close();
		}
		return null;
	}

}
