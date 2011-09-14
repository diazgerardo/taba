package com.scriptorum.abstractions;

import java.math.BigDecimal;
import java.util.LinkedList;

import android.location.Location;

import com.scriptorum.singletons.Movil;

public class Ruta extends Grafo {

	protected LinkedList<Vertice> ruta = new LinkedList<Vertice>();

	private static final long serialVersionUID = -6633290557437173334L;

	@Override
	public void update() {
		Movil movil = Movil.getInstance();
		Location movilLocation = movil.getVertice().getLocation();
		float results[] = { 0, 0, 0 };
		boolean inicio=true, cambio=true, cambioAnterior=true;
		Vertice rutaLocationAnterior = null;
		for ( Vertice rutaLocation : ruta) {
			Location.distanceBetween(movilLocation.getLatitude(),movilLocation.getLongitude(), rutaLocation.getLatitud().doubleValue(),rutaLocation.getLongitud().doubleValue(), results);
			rutaLocation.setDistanciaAlMovil(new BigDecimal(results[0]));
			if (null!=movil.getVelocidadPromedioReal() && movil.getVelocidadPromedioReal().doubleValue()>0) {
				double velocidad = (double) movil.getVelocidadPromedioReal().doubleValue();
				rutaLocation.setTiempoEstimado(getTiempoEstimado(rutaLocation, velocidad));
			}
			cambio = rutaLocation.isDistanciaAlMovilCreciente();
			if(inicio) {
				rutaLocationAnterior = rutaLocation;
				cambioAnterior = cambio;
				inicio = false;
			}
			if(cambio != cambioAnterior) { 
					movil.setAnterior(rutaLocationAnterior);
					movil.setSiguiente(rutaLocation);
			}
			cambioAnterior = cambio;
			rutaLocationAnterior = rutaLocation;
		}

	}

	private long getTiempoEstimado(Vertice rutaLocation, double velocidad) {
		// Metros (velocidad esta en km hora)
		double distanciaAlMovil = rutaLocation.getDistanciaAlMovil().doubleValue();
		long vEnMetrosXSegundo = (long) (velocidad/3.6);
		long tiempoEstimadoEnMillis = (long) ((distanciaAlMovil / vEnMetrosXSegundo) * 1000); 
		return tiempoEstimadoEnMillis;
	}

	public LinkedList<Vertice> getRuta() {
		return ruta;
	}

	public void setRuta(LinkedList<Vertice> ruta) {
		this.ruta = ruta;
	}

}
