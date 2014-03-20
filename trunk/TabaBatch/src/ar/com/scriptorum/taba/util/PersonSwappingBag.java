package ar.com.scriptorum.taba.util;

import ar.com.scriptorum.taba.beans.Carpooler;

public class PersonSwappingBag extends SwappingBag<Carpooler, Carpooler> {

	public PersonSwappingBag(Carpooler r, Carpooler t) {
		super(r, t);
	}

	@Override
	PersonSwappingBag swap() {
		holder = t.getNombre();
		t.setNombre(r.getNombre());
		r.setNombre((String)holder);
		return this;
	}

}
