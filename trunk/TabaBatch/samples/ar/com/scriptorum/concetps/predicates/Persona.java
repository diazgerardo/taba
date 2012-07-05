package ar.com.scriptorum.concetps.predicates;

import java.util.Date;

public class Persona {
	private String nombre;
	private String apellido;
	private int sueldo;
	private Date alta;

	public Date getAlta() {
		return alta;
	}


	public void setAlta(Date alta) {
		this.alta = alta;
	}


	public Persona(String nombre, String apellido, int sueldo, Date alta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.alta = alta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getSueldo() {
		return sueldo;
	}


	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}


	@Override
	public String toString() {
		return "Apellido:" + getApellido() + " Nombre:" + getNombre()
				+ " Sueldo:" + getSueldo() + " Alta:" + getAlta(); 
	}
}