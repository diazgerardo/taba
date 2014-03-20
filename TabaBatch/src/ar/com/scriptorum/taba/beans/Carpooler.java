package ar.com.scriptorum.taba.beans;

import java.io.Serializable;

import ar.com.scriptorum.interfaces.PersistentEntity;

/**
 * source : www.javabeat.net
 */
public class Carpooler implements PersistentEntity, Serializable {

	private static final long serialVersionUID = -7460746969529717870L;
	private int id;
	private String nombre;
	private String dni;
	private String telefono;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	}