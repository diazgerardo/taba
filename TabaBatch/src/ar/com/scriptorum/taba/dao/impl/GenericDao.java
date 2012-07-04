package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.Session;

import ar.com.scriptorum.taba.util.HibernateUtil;

public class GenericDao {

	protected Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
}
