package ar.com.scriptorum.taba.util;

import ar.com.scriptorum.taba.beans.Person;

public class PersonSwappingBag extends SwappingBag<Person, Person> {

	public PersonSwappingBag(Person r, Person t) {
		super(r, t);
	}

	@Override
	PersonSwappingBag swap() {
		holder = t.getName();
		t.setName(r.getName());
		r.setName((String)holder);
		return this;
	}

}
