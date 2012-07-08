package ar.com.scriptorum.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GenericTemplateBasedDaoImp extends HibernateDaoSupport {
	
	public Serializable save(Object obj) {
		return getHibernateTemplate().save(obj);
	}

}
