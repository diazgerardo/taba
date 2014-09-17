package ar.com.scriptorum.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericDao<E, PK extends Serializable> {

	@Transactional
	Serializable save(E newInstance);

    @Transactional
    void update(E transientObject);

    @Transactional
    void saveOrUpdate(E transientObject);

    @Transactional
    void delete(E persistentObject);

    E findById(PK id);

    List<E> findAll();

    List<E> findAllByProperty(String propertyName,Object value);
    
    E findUnique(String propertyName, Object value);

}