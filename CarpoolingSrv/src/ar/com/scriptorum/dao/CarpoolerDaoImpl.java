package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Carpooler;

public class CarpoolerDaoImpl extends GenericDaoImpl<Carpooler, Long> implements CarpoolerDao {

	@Override
	protected Class<Carpooler> getEntityClass() {
		return Carpooler.class;
	}

}
