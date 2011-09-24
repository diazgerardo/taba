package ar.com.scriptorum.taba.abstractions;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import android.location.Location;
import android.view.View;
import android.view.View.OnClickListener;
import ar.com.scriptorum.taba.singletons.Movil;
import ar.com.scriptorum.taba.xml.TrayectoriaSerializer;


public class Trayectoria implements OnClickListener, PropertyChangeListener {
	private static final long serialVersionUID = -5433997207358050284L;
	protected static LinkedList<Vertice> trayectoria;
	private static BigDecimal distanciaTotalRecorrida;
	private static Trayectoria _instance;
	
	private Trayectoria() {
		trayectoria = new LinkedList<Vertice>();
		distanciaTotalRecorrida = new BigDecimal(0);
	}
	
	public static Trayectoria getInstance() {
		if(_instance == null) {
			_instance = new Trayectoria();
		}
		return _instance;
	}

	public void update() {
		Movil movil = Movil.getInstance();
		Vertice locationAnterior, locationInicial;
		Vertice currentLocation = movil.getVertice();
		try {
			locationAnterior = trayectoria.getLast();
			locationInicial = trayectoria.getFirst();
		} catch (NoSuchElementException e) {
			// Ups, primera vez! 
			trayectoria.add(currentLocation);
			return;
		}
		
		float results[] = { 0, 0, 0 };
		Location.distanceBetween(currentLocation.getLatitud().doubleValue(),currentLocation.getLongitud().doubleValue(), locationAnterior.getLatitud().doubleValue(),locationAnterior.getLongitud().doubleValue(), results);
		BigDecimal distanciaCubierta = new BigDecimal(results[0]);
		BigDecimal tiempoEmpleado = new BigDecimal(currentLocation.getCreacion().getTime() - locationAnterior.getCreacion().getTime());
		BigDecimal tiempoTotalEmpleado = new BigDecimal((long)currentLocation.getCreacion().getTime() - locationInicial.getCreacion().getTime());
		distanciaTotalRecorrida = distanciaTotalRecorrida.add(distanciaCubierta);
		if(tiempoEmpleado.compareTo(new BigDecimal(0))!= 0)
			movil.setVelocidadPromedioParcial(new BigDecimal((distanciaCubierta.doubleValue()/tiempoEmpleado.doubleValue())*3600));
		if(tiempoTotalEmpleado.compareTo(new BigDecimal(0))!= 0)
			movil.setVelocidadPromedioReal(new BigDecimal((distanciaTotalRecorrida.doubleValue()/tiempoTotalEmpleado.doubleValue())*3600));
		trayectoria.add(currentLocation);
	}
	
	public void reset() {
		_instance = null;
	}
	
	public void save() {
		TrayectoriaSerializer.save(trayectoria);
	}

	public void onClick(View v) {
		save();
		reset();
	}

	public void propertyChange(PropertyChangeEvent event) {
		update();
	}
}
