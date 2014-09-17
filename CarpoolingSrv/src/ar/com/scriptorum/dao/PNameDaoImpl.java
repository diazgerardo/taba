package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.PName;
import ar.com.scriptorum.beans.PersistentEntity;

public class PNameDaoImpl extends GenericDaoImpl<PName, Long> implements PNameDao {

    @Override
    protected Class<? extends PersistentEntity> getEntityClass() {
        return PName.class;
    }
    
}
