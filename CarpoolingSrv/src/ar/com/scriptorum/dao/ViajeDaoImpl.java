package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Viaje;

public class ViajeDaoImpl extends GenericDaoImpl<Viaje, Long> implements ViajeDao {

	@Override
	protected Class<Viaje> getEntityClass() {
		return Viaje.class;
	}

}
