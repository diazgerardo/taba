package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.Asignador;

public class AsignadorImpl <T> implements Asignador <T>, Action {

	private String name;
	private String address;
	private String emailAddress;
	private String surName;
	private T asignee;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getFullName() {
		return this.getName() + " " + this.getSurName();
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public String getEmailAddress() {
		return this.emailAddress;
	}

	@Override
	public String getSurName() {
		return this.surName;
	}

	@Override
	public boolean asignar(T t) {
		this.asignee = t;
		return true;
	}

	@Override
	public T getAsignee() {
		return this.asignee;
	}

	@Override
	public boolean execute() {
		return false;
	}
	
	

}
