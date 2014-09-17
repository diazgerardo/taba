package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.PUnit;

public class PUnitDaoImpl extends GenericDaoImpl<PUnit, Long> implements PUnitDao {

    @Override
	protected Class<PUnit> getEntityClass() {
		return PUnit.class;
	}
	
}
