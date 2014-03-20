package ar.com.scriptorum.taba.beans;

import java.io.Serializable;
import java.util.Date;

import ar.com.scriptorum.interfaces.PersistentEntity;

/**
 * source : www.javabeat.net
 */
public class Group implements PersistentEntity, Serializable {

	private static final long serialVersionUID = -7460746969529717870L;
	private int id;
	private String nombre;
	private Date creacion;
	
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
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

}
