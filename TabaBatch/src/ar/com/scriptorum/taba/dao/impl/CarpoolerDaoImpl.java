package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;

import ar.com.scriptorum.dao.GenericDaoImpl;
import ar.com.scriptorum.taba.beans.*;

public class CarpoolerDaoImpl extends GenericDaoImpl {
	
	private static CarpoolerDaoImpl _instance;
	
	private CarpoolerDaoImpl() {
		super();
	}
	
	public static synchronized CarpoolerDaoImpl getInstance() {
		if(_instance == null ) {
			_instance = new CarpoolerDaoImpl();
		}
		return _instance;
	}

	@SuppressWarnings("unchecked")
	public List<Carpooler> findByName(String nombre) {
		try {
			String queryString = "from Carpooler where nombre = :nombre";
			Query query = getSession().createQuery(queryString);
			query.setString("nombre", nombre);
			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			getSession().close();
		}
		return null;
	}
	
	public boolean delete(Carpooler t) {
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
