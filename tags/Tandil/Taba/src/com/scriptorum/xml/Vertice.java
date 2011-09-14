package com.scriptorum.xml;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Vertice {
	private String nombre;
	private BigDecimal latitud = new BigDecimal(0);
	private BigDecimal longitud = new BigDecimal(0);
	private BigDecimal altitud = new BigDecimal(0);
	private float bearing;
	private BigDecimal distanciaAlMovil = new BigDecimal(0);
	private BigDecimal distanciaAlMovilAnterior  = new BigDecimal(0);
	private long tiempoEstimado;
	private Timestamp creacion;

	public Timestamp getCreacion() {
		return creacion;
	}

	public Vertice(String nombre, double latitud, double longitud, double altitud ) {
		this.nombre=nombre;
		this.latitud=new BigDecimal(latitud);
		this.longitud=new BigDecimal(longitud);
		this.altitud=new BigDecimal(altitud);
		this.creacion = new Timestamp(System.currentTimeMillis());
		this.tiempoEstimado = 0;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public float getBearing() {
		return bearing;
	}

	public BigDecimal getAltitud() {
		return altitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public void setAltitud(BigDecimal altitud) {
		this.altitud = altitud;
	}

	public void setBearing(float bearing) {
		this.bearing = bearing;
	}
	
	public BigDecimal getDistanciaAlMovil() {
		return distanciaAlMovil;
	}

	public void setDistanciaAlMovil(BigDecimal distanciaAlMovil) {
		this.distanciaAlMovilAnterior = this.distanciaAlMovil;
		this.distanciaAlMovil = distanciaAlMovil;
	}
	
	public boolean isDistanciaAlMovilCreciente() {
		return this.distanciaAlMovilAnterior.doubleValue() < this.distanciaAlMovil.doubleValue(); 
	}

	public long getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(long tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(null!=getNombre()) {
			sb.append(getNombre());
		}else {
			sb.append(getLatitud())
			.append(" : ")
			.append(getLongitud());
		}
		return sb.toString();
	}

}
