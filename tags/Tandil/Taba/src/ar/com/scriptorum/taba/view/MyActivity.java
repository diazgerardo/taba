package ar.com.scriptorum.taba.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import ar.com.scriptorum.taba.abstractions.Ruta;
import ar.com.scriptorum.taba.singletons.Movil;
import ar.com.scriptorum.taba.singletons.RutaParser;


public class MyActivity extends Activity implements PropertyChangeListener {
	static final File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/buenosAires-Cordoba.xml");
	protected LocationManager myLocationManager;
	protected static Movil movil;
	protected static TextView myVelocidadParcial;
	protected static TextView myVelocidadReal;
	protected static TextView myAltitude;
	protected static TextView myAnterior;
	protected static TextView mySiguiente;
	protected static TextView myTiempoEstimado;
	protected static TextView myTiempoEstimadoFin;
	protected static TextView myVelocidad;
	protected static Ruta ruta = getRuta();
	
	@Override 
	public void onCreate(Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		movil = Movil.getInstance();
		myLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 1000, movil);
		movil.addChangeListener(this);
	}

	
	private static Ruta getRuta() {
		Ruta ruta = new Ruta();
		RutaParser dpe = RutaParser.getInstance();
		dpe.runExample(xml);
		ruta.setRuta(dpe.getRuta());
		return ruta;
	}


	public void propertyChange(PropertyChangeEvent arg0) {
		if(null!= movil.getVelocidadPromedioParcial()) 
			myVelocidadParcial.setText("Vel. Prom. Parc:" + movil.getVelocidadPromedioParcial().toString());
		if(null!= movil.getVelocidadPromedioReal()) 
			myVelocidadReal.setText("Vel. Prom. Real:" + movil.getVelocidadPromedioReal().toString());
		if(null!= movil.getAnterior()) 
			myAnterior.setText("Entre: "+movil.getAnterior().toString());
		if(null!= movil.getSiguiente()) 
			mySiguiente.setText("Y: " +  movil.getSiguiente().toString());
		ruta.update();
		View v = this.getCurrentFocus();
		v.postInvalidate();
	}

}
