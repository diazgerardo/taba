package ar.com.scriptorum.taba.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import ar.com.scriptorum.taba.abstractions.Ruta;
import ar.com.scriptorum.taba.singletons.Movil;
import ar.com.scriptorum.taba.singletons.RutaParser;


public class MyActivity extends Activity implements PropertyChangeListener {
	protected File xml;
	protected static Movil movil;
	protected static TextView myVelocidadParcial;
	protected static TextView myVelocidadReal;
	protected static TextView myAltitude;
	protected static TextView myAnterior;
	protected static TextView mySiguiente;
	protected static TextView myTiempoEstimado;
	protected static TextView myTiempoEstimadoFin;
	protected static TextView myVelocidad;
	protected static String mChosenFile;
	protected static Ruta ruta;
	
	@Override 
	public void onCreate(Bundle savedInstanceState ) {
		
		super.onCreate(savedInstanceState);
		movil = Movil.getInstance();
		getRuta();
		
		// <chorch>
		Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		String bestProvider = ((LocationManager) getSystemService(Context.LOCATION_SERVICE)).getBestProvider(criteria, false);
		((LocationManager) getSystemService(Context.LOCATION_SERVICE)).requestLocationUpdates(bestProvider,60000, 1000, movil);
		// </chorch>
		
		movil.addChangeListener(this);
		
	}

	
	protected void getRuta() {
		
		if(null == mChosenFile){
			ruta = new Ruta();
			return;
		}
		
		xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + mChosenFile);
		RutaParser dpe = RutaParser.getInstance();
		dpe.runExample(xml);
		ruta.setRuta(dpe.getRuta());
		
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

	}

}
