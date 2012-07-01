package ar.com.scriptorum.taba.beans;

import java.io.Serializable;

/**
 * source : www.javabeat.net
 */
public class Person implements Serializable {

	private static final long serialVersionUID = -7460746969529717870L;
	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}