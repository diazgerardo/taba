package ar.com.scriptorum.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E, PK extends Serializable> {

    Serializable save(E newInstance);

    void update(E transientObject);

    void saveOrUpdate(E transientObject);

    void delete(E persistentObject);

    E findById(PK id);

    List<E> findAll();

    List<E> findAllByProperty(String propertyName,Object value);

}