package ar.com.scriptorum.taba.beans;

import java.io.Serializable;
import java.util.Date;

import ar.com.scriptorum.interfaces.PersistentEntity;

/**
 * source : www.javabeat.net
 */
public class Vehiculo implements PersistentEntity, Serializable {

	private static final long serialVersionUID = -7460746969529717870L;
	private int id;
	private String patente;
	private Date alta;
	private int plazas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
