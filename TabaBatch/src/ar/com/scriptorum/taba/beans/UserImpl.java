package ar.com.scriptorum.taba.beans;

import ar.com.scriptorum.taba.interfaces.User;

public class UserImpl implements User {

	private String name;
	private String surName;
	private String address;
	private String emailAddress;

	public UserImpl(String name, String surName, String address, String emailAddress) {
		this.name=name;
		this.surName=surName;
		this.address=address;
		this.emailAddress=emailAddress;
	}
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSurName() {
		return this.surName;
	}

	@Override
	public String getFullName() {
		return getName() + " " + getSurName();
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public String getEmailAddress() {
		return this.emailAddress;
	}

}
