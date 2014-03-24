package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Vehiculo;

public class VehiculoDaoImpl extends GenericDaoImpl<Vehiculo, Long> implements VehiculoDao {

	@Override
	protected Class<Vehiculo> getEntityClass() {
		return Vehiculo.class;
	}

}
