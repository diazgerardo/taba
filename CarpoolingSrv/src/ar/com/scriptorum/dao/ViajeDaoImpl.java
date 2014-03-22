package ar.com.scriptorum.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.beans.Viaje;

public class ViajeDaoImpl extends GenericDaoImpl {
	
	private static ViajeDaoImpl _instance;
	
	private ViajeDaoImpl() {
		super();
	}
	
	public static synchronized ViajeDaoImpl getInstance() {
		if(_instance == null ) {
			_instance = new ViajeDaoImpl();
		}
		return _instance;
	}


	@SuppressWarnings("unchecked")
	public List<Viaje> findAll() {
		try {
			String queryString = "from Viaje";
			Query query = getSession().createQuery(queryString);
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
