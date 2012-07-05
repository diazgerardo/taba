package ar.com.scriptorum.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.stat.SessionStatistics;

import ar.com.scriptorum.interfaces.PersistentEntity;
import ar.com.scriptorum.stringutils.StringUtilsExample;
import ar.com.scriptorum.taba.util.HibernateUtil;



public class GenericDaoImpl {

	private static final Object DUMMY_TRUE_WHERE_CLAUSE = null;
	private static GenericDaoImpl _instance = null;
	private static Logger _logger = Logger.getLogger(GenericDaoImpl.class);


	protected GenericDaoImpl() {
	}

	static synchronized GenericDaoImpl getInstance() {
		if (_instance == null) {
			_instance = new GenericDaoImpl();
		}
		return _instance;
	}

	public boolean create( Object obj, boolean bFlush ) {
		_logger.debug(obj.getClass());
		boolean outcome = true;
		Session session = getSession();
		try {
			session.save(obj);
			if (bFlush)
				session.flush();
			_logger.debug("Insertion - Entity: " + obj.getClass().getSimpleName() + " NewId: " + ((PersistentEntity) obj).getId());
		}
		catch (HibernateException ex) {
			_logger.debug("got HibernateException");
			_logger.debug("Failed insertion - Entity: " + StringUtilsExample.getSimpleClassName(obj.getClass()) + " Id: " +
					((PersistentEntity) obj).getId());
			outcome = false;
		}
		return outcome;
	}

	public boolean update( Object obj, boolean bFlush ) {
		_logger.debug(obj.getClass());
		boolean outcome = true;
		Session session = getSession();
		try {
			session.update(obj);
			if (bFlush)
				session.flush();
			_logger.debug("Updated - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
		}
		catch (HibernateException ex) {
			_logger.debug("got HibernateException");
			_logger.debug("Failed update - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
			outcome = false;
		}
		return outcome;
	}

	public boolean createOrUpdate( Object obj, boolean bFlush ) {
		_logger.debug(obj.getClass());
		boolean outcome = true;
		Session session = getSession();
		try {
			session.saveOrUpdate(obj);
			if (bFlush)
				session.flush();
			_logger.debug("savedOrUpdated - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
		}
		catch (HibernateException ex) {

			_logger.debug("got HibernateException");
			_logger.debug("Failed create/update - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
			outcome = false;
		}
		return outcome;
	}

	public boolean delete( Object obj, boolean bFlush ) {
		_logger.debug(obj.getClass());
		boolean outcome = true;
		Session session = getSession();
		try {
			session.delete(obj);
			if (bFlush)
				session.flush();
			_logger.debug("deleted - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
		}
		catch (HibernateException ex) {
			_logger.debug("got HibernateException");
			_logger.error("Failed delete - Entity: " + obj.getClass().getSimpleName() + " Id: " + ((PersistentEntity) obj).getId());
			outcome = false;
		}
		return outcome;
	}

	public Object getEntity( Class clazz, Serializable id ) {
		_logger.debug("id" + id);
		Object result = getSession().get(clazz, id);
		_logger.debug("Entity Id found: " + (result != null ? ((PersistentEntity) result).getId().toString() : "NONE"));
		return result;
	}

	public Object getUniqueEntity( Class clazz, Map equalProps ) {
		_logger.debug(clazz);

		Query query = createQuery(clazz, equalProps, null);

		Object result = query.uniqueResult();
		_logger.debug("Entity Id found: " + (result != null ? ((PersistentEntity) result).getId().toString() : "NONE"));
		return result;
	}

	public List getEntities( Class clazz, Map equalProps, List orderBy ) {
		_logger.debug(clazz);

		Query query = createQuery(clazz, equalProps, orderBy);

		List result = query.list();
		_logger.debug("Result size: " + result.size());
		return result;
	}


	private Query createQuery( Class clazz, Map equalProps, List orderBy ) {
		_logger.debug(clazz);

		Session session = getSession();
		String className = clazz.getSimpleName();
		StringBuffer fromClause = new StringBuffer("FROM ");
		fromClause.append(className + " ");
		StringBuffer whereClause = new StringBuffer();
		addToWhereClause(null, whereClause, equalProps);
		StringBuffer orderByClause = new StringBuffer();
		addToOrderByClause(orderBy, orderByClause);

		String hql = fromClause.append(whereClause).append(orderByClause).toString();
		_logger.debug("HQL String: " + hql);
		Query query = session.createQuery(hql);
		query.setProperties(equalProps);
		_logger.debug("PARAMETERS: ");
		logPropParams(equalProps);
		return query;
	}

	void addToOrderByClause( List orderBy, StringBuffer orderByClause ) {
		_logger.debug(orderByClause);

		if (orderBy != null && !orderBy.isEmpty()) {
			orderByClause.append(" ORDER BY ");
			String currProp;
			String propName;
			for (Iterator props = orderBy.iterator(); props.hasNext();) {
				currProp = (String) props.next();
				propName = currProp.substring(currProp.indexOf("_") + 1);
				orderByClause.append(propName + ", ");
			}
			orderByClause.delete(orderByClause.length() - 2, orderByClause.length() - 1);
		}
	}

	protected void addToWhereClause( String alias, StringBuffer whereClause, Map equalProps ) {
		_logger.debug(alias);

		if (equalProps != null && !equalProps.isEmpty()) {
			whereClause.append(DUMMY_TRUE_WHERE_CLAUSE);
			String tablePrefix = "";
			if (alias != null && !"".equals(alias)) {
				tablePrefix = alias + ".";
			}

			String currPropKey;
			String propName;
			for (Iterator propKeys = equalProps.keySet().iterator(); propKeys.hasNext();) {
				currPropKey = (String) propKeys.next();
				if (equalProps.get(currPropKey) != null) {
					propName = currPropKey.substring(currPropKey.indexOf("_") + 1);
					whereClause.append(" AND (" + tablePrefix + propName + " = :" + currPropKey + ") ");
					_logger.debug("whereClause.append( \" AND (" + tablePrefix + propName + " = :\" + currPropKey + \") \" );");
				} else {
					_logger.warn("Ignoring property '" + currPropKey + "' due to a NULL value found to compare by equality.");
				}
			}
		}
	}

	protected static void logPropParams( Map equalProps ) {
		if (equalProps != null && !equalProps.isEmpty()) {
			String currPropKey;
			Object currPropValue;
			for (Iterator propKeys = equalProps.keySet().iterator(); propKeys.hasNext();) {
				currPropKey = (String) propKeys.next();
				currPropValue = equalProps.get(currPropKey);
				if (currPropValue != null) {
					_logger.debug(" :" + currPropKey + "->" + currPropValue.toString());
				}
			}
		}
	}

	public List getEntitiesLike( Class clazz, Object exampleEntity ) {
		// TODO: could add ignoreCase and MatchMode to the parameter set
		Session session = getSession();
		Example example = getExampleForStringProps(clazz, exampleEntity, true, null);
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(example);

		List result = criteria.list();
		_logger.debug("Result size: " + result.size());
		return result;
	}


	private Example getExampleForStringProps( Class clazz, Object exampleEntity, boolean ignoreCase, MatchMode mode ) {
		Example example = Example.create(exampleEntity).excludeZeroes();
		if (ignoreCase) {
			example.ignoreCase();
		}
		if (mode == null) {
			mode = MatchMode.ANYWHERE;
		}
		example.enableLike(mode).setEscapeCharacter(new Character('/'));

		_logger.debug("PARAMETERS: ");

		Class currClass = clazz;
		Field currField;
		while (currClass != null) {
			Field[] fields = currClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				currField = fields[i];
				currField.setAccessible(true);
				if (!Modifier.isStatic(currField.getModifiers())) {
					excludeNonStringField(exampleEntity, example, currClass, currField);
				}
			}
			currClass = currClass.getSuperclass();
		}
		_logger.debug("example Criterion: " + example.toString());
		return example;
	}

	private void excludeNonStringField( Object exampleEntity, Example example, Class currClass, Field currField ) {
		try {
			Object currValue = currField.get(exampleEntity);
			if (currValue instanceof String) {
				_logger.debug("          :" + currField.getName() + " --> " + currValue.toString());
			} else {
				example.excludeProperty(currField.getName());
				if (currValue != null && !currField.getType().isPrimitive()) {
					_logger.warn(currClass.getSimpleName() + " example entity is not supposed to include a NON-String property (it will be ignored): " +
							currField.getName() + " --> " + currValue.toString());
				}
			}
		}
		catch (IllegalArgumentException e) {
			_logger.error(e);
		}
		catch (IllegalAccessException e) {
			_logger.error(e);
		}
	}

	protected Session getSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SessionStatistics stats = session.getStatistics();
		if (stats.getEntityCount() >= HibernateUtil.MAX_ENTITIES_BY_SESSION) {
			_logger.debug("Now entityCount() = " + stats.getEntityCount() + ", then max number of " + HibernateUtil.MAX_ENTITIES_BY_SESSION + " entities per session has been reached.");
			if (session.isDirty()) {
				_logger.debug("Session is also dirty, flushing...");
				session.flush();
			}
			_logger.debug("Clearing...");
			session.clear();
			_logger.debug("Now entityCount() = " + stats.getEntityCount() + " entities. (If cero, it is clear now).");
		}
		return session;
	}

}
