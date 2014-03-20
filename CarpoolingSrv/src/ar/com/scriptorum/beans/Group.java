package ar.com.scriptorum.beans;

import java.util.Date;

/**
 * source : www.javabeat.net
 */
public class Group implements PersistentEntity {

	private static final long serialVersionUID = -7460746969529717870L;
	private long id;
	private String nombre;
	private Date creacion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
