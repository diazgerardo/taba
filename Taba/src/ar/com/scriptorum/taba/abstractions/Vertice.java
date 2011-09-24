package ar.com.scriptorum.taba.abstractions;

import java.math.BigDecimal;
import java.sql.Timestamp;

import android.location.Location;
import ar.com.scriptorum.taba.singletons.Calculator;
import ar.com.scriptorum.taba.singletons.StringUtil;


public class Vertice {
	private Location location;
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

	public Vertice(Location location) {
		this.location = location;
		this.latitud = new BigDecimal(location.getLatitude());
		this.longitud = new BigDecimal(location.getLongitude());
		this.altitud = new BigDecimal(location.getAltitude());
		this.bearing = location.getBearing();
		this.creacion = new Timestamp(System.currentTimeMillis());
		this.tiempoEstimado = 0;
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
	
	public Location getLocation() {
		return location;
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
		sb.append(":"+Calculator.metrosAStrKm(getDistanciaAlMovil()));
		sb.append(" Faltan: "+format(tiempoEstimado));
		return sb.toString();
	}

	private String format(long tiempoEstimado2) {
		
		StringBuffer sb = new StringBuffer();
		long hh = tiempoEstimado2/3600000;
		long mm = (tiempoEstimado2%3600000)/60000;
		long ss = ((tiempoEstimado2%3600000)%60000)/1000;
		
		return sb.append(StringUtil.strZero(hh)).append(":").append(StringUtil.strZero(mm)).append(":").append(StringUtil.strZero(ss)).toString();
	}

	public String toXmlString() {
		
		StringBuffer string = new StringBuffer();
		string.append("<Vertice>" +
				"<Nombre>" + getNombre() + "</Nombre>" +
				"<Longitud>"+ getLongitud() + "</Longitud>" +
				"<Latitud>"+ getLatitud() + "</Latitud>" +
				"<Altitud>"+ getAltitud() + "</Altitud>" +
				"<TiempoEstimado>"+ getTiempoEstimado() + "</TiempoEstimado>" + 
				"<DistanciaAlMovil>"+ getDistanciaAlMovil() + "</DistanciaAlMovil>" + 
				"<Bearing>"+ getBearing() + "</Bearing>" + 
				"<Creacion>"+ getCreacion() + "</Creacion>" + 
				"</Vertice>");
		return string.toString();
	}

}
