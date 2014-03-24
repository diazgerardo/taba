package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Itinerario;

public class ItinerarioDaoImpl extends GenericDaoImpl<Itinerario, Long> implements ItinerarioDao {

	@Override
	protected Class<Itinerario> getEntityClass() {
		return Itinerario.class;
	}

}
