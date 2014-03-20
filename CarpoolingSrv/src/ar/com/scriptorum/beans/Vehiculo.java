package ar.com.scriptorum.beans;

import java.util.Date;

/**
 * source : www.javabeat.net
 */
public class Vehiculo implements PersistentEntity {

	private static final long serialVersionUID = -7460746969529717870L;
	private long id;
	private String patente;
	private Date alta;
	private int plazas;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
}
