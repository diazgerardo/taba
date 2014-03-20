package ar.com.scriptorum.taba.beans;

import java.io.Serializable;

import ar.com.scriptorum.interfaces.PersistentEntity;

/**
 * source : www.javabeat.net
 */
public class Itinerario implements PersistentEntity, Serializable {

	private static final long serialVersionUID = -7460746969529717870L;
	private int id;
	private int googleMapId;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoogleMapId() {
		return googleMapId;
	}
	public void setGoogleMapId(int googleMapId) {
		this.googleMapId = googleMapId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
