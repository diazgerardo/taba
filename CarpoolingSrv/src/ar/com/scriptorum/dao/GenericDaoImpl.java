package ar.com.scriptorum.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.scriptorum.beans.PersistentEntity;
import ar.com.scriptorum.exceptions.BusinessException;

public abstract class GenericDaoImpl<E, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<E,PK> {

	@SuppressWarnings("unchecked")
	public PK save(E newInstance) {

		return (PK) getHibernateTemplate().save(newInstance);

	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(PK id) {

		return (E) getHibernateTemplate().get(getEntityClass(), id);

	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {

		return (List<E>) getHibernateTemplate().findByCriteria(createDetachedCriteria());

	}

	@SuppressWarnings("unchecked")
	public List<E> findAllByProperty(String propertyName, Object value) {

		DetachedCriteria criteria = createDetachedCriteria();

		criteria.add(Restrictions.eq(propertyName, value));

		return (List<E>) getHibernateTemplate().findByCriteria(criteria);

	}

    @SuppressWarnings("unchecked")
    public E findUnique(String propertyName, Object value) {

        DetachedCriteria criteria = createDetachedCriteria();

        criteria.add(Restrictions.eq(propertyName, value));

        List<E> list = (List<E>) getHibernateTemplate().findByCriteria(criteria);
        if(list == null|| list.size()==0)
            return null;
        
        if(list.size()>1) 
            throw new BusinessException("Received more results("+list.size()+") than expected (1).");
        
        return list.iterator().next();

    }

    public List<E> findByExample(E object) {

		List<E> resultList = getHibernateTemplate().findByExample(object, 0, 1);

		return resultList;

	}

	public List<E> findByExample(E object, int firstResult, int maxResults) {

		List<E> resultList = getHibernateTemplate().findByExample(object,
				firstResult, maxResults);

		return resultList;

	}

	public void update(E transientObject) {

		getHibernateTemplate().update(transientObject);

	}

	public void saveOrUpdate(E transientObject) {

		getHibernateTemplate().saveOrUpdate(transientObject);

	}

	public void delete(E persistentObject) {

		getHibernateTemplate().delete(persistentObject);

	}

	

	protected DetachedCriteria createDetachedCriteria() {

		return DetachedCriteria.forClass(getEntityClass());

	}

	protected abstract Class<? extends PersistentEntity> getEntityClass();

}