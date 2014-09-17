package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.PMethod;

public class PMethodDaoImpl extends GenericDaoImpl<PMethod, Long> implements PMethodDao {

	@Override
	protected Class<PMethod> getEntityClass() {
		return PMethod.class;
	}
}
