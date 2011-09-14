package com.scriptorum.singletons;

import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.scriptorum.abstractions.Trayectoria;
import com.scriptorum.abstractions.Vertice;

public class Movil implements LocationListener, OnClickListener {
	
	private static Movil _movil;

	private static Vertice vertice;
	private static Vertice anterior;
	private static Vertice siguiente;
	private static List<PropertyChangeListener> listeners;
	private static BigDecimal velocidadPromedioParcial;
	private static BigDecimal velocidadPromedioReal;
	private static long tiempoEstimado;
	private static long tiempoEstimadoFin;
	
	private Movil() {
		vertice = new Vertice("inicial", 0D, 0D, 0D);
		anterior  = new Vertice("anterior", 0D, 0D, 0D);;
		siguiente  = new Vertice("siguiente", 0D, 0D, 0D);;
		listeners = new ArrayList<PropertyChangeListener>();
		velocidadPromedioParcial = new BigDecimal(0);
		velocidadPromedioReal = new BigDecimal(0);
		tiempoEstimado = 0;
		tiempoEstimadoFin = 0; 
	}
	
	public static Movil getInstance() {
		if(null == _movil) {
			_movil = new Movil();
			_movil.addChangeListener(Trayectoria.getInstance());
		}
		return _movil;
	}
	public void onLocationChanged(Location loc) {
		try {
			vertice = new Vertice(loc);
			notifyListeners(); // TODO listeners son 1er y 2do tab, quizás debieran ser Ruta y Trayectoria.. 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	public String getLatitud() {
		return Calculator.redondear(vertice.getLatitud()).toString();
	}

	public String getLongitud() {
		return Calculator.redondear(vertice.getLongitud()).toString();
	}

	public String getAltitud() {
		return Calculator.redondear(vertice.getAltitud()).toString();
	}

	private void notifyListeners() {
		for (PropertyChangeListener listener : listeners) {
			listener.propertyChange(null);
		}
	}

	public void addChangeListener(PropertyChangeListener newListener) {
		//listeners.removeAll(listeners);
		listeners.add(newListener);
	}

	public List<PropertyChangeListener> getListeners() {
		return listeners;
	}

	public Vertice getVertice() {
		return vertice;
	}
	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	public Vertice getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Vertice siguiente) {
		this.siguiente = siguiente;
	}

	public long getTiempoEstimado() {
		return tiempoEstimado;
	}

	public long getTiempoEstimadoFin() {
		return tiempoEstimadoFin;
	}

	public BigDecimal getVelocidadPromedioParcial() {
		return Calculator.redondear(velocidadPromedioParcial);
	}

	public void setVelocidadPromedioParcial(
			BigDecimal velocidadPromedioParcial) {
		this.velocidadPromedioParcial = velocidadPromedioParcial;
	}

	public BigDecimal getVelocidadPromedioReal() {
		return Calculator.redondear(velocidadPromedioReal);
	}

	public void setVelocidadPromedioReal(BigDecimal velocidadPromedioReal) {
		this.velocidadPromedioReal = velocidadPromedioReal;
	}

	public void setTiempoEstimado(long tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public void setTiempoEstimadoFin(long tiempoEstimadoFin) {
		this.tiempoEstimadoFin = tiempoEstimadoFin;
	}

	public void save() {
		MovilSerializer.save(_movil);
	}
	
	public void reset() {
		_movil = null;
	}
	public void onClick(View v) {
		save();
		reset();
	}

	public String toXmlString() {
		
		StringBuffer string = new StringBuffer();
		string.append("<Movil>" +  
				"<Altitud>" + getAltitud()+ "</Altitud>" +
				"<Latitud>" + getLatitud() + "</Latitud>" +
				"<tLongitud>" + getLongitud() + "</tLongitud>" +
				"<TiempoEstimado>" + getTiempoEstimado() + "</TiempoEstimado>" +
				"<TiempoEstimadoFin>" + getTiempoEstimadoFin() + "</TiempoEstimadoFin>" +
				"<Anterior>" + getAnterior() .toXmlString() + "</Anterior>" +
				"<Siguiente>" + getSiguiente().toXmlString() +  "</Siguiente>" +
				"<VelocidadPromedioParcial>" + getVelocidadPromedioParcial() + "</VelocidadPromedioParcial>" +
				"<VelocidadPromedioReal>" + getVelocidadPromedioReal() + "</VelocidadPromedioReal>" +
				"</Movil>");
		return string.toString();
	}

};