package ar.com.scriptorum.taba.managers;

import java.io.File;

import android.os.Environment;
import ar.com.scriptorum.taba.abstractions.Ruta;
import ar.com.scriptorum.taba.abstractions.Vertice;
import ar.com.scriptorum.taba.singletons.RutaParser;

public class RutaManager extends AbstractManager {

	private static Ruta ruta;
	
	private static RutaManager rutaManager;

	private double southernMost = +180;

	private double westernMost = +180;
	
	private double northernMost = -180;
	
	private double easternMost = -180;
	
	private RutaManager() {	
		
	}
	
	public static RutaManager getInstance(){
		
		if(null == rutaManager) {
			rutaManager = new RutaManager();
		}
		return rutaManager;
		
	}
	
	public void setRuta(Ruta ruta) {
		RutaManager.ruta = ruta;
	}
	
	public double getNorthernMost(){
		return northernMost;
	}
	
	public double getSouthernMost() {
		return southernMost;
	}
	
	public double getEasternMost() {
		return easternMost;
	}
	
	public double getWesternMost() {
		return westernMost;
	}

	public Ruta getRuta(String fileName) {
		
		if(null == fileName){
		
			return new Ruta();
		
		}
		
		File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + fileName);
		RutaParser.getInstance().parse(xml);
		ruta = (RutaParser.getInstance().getRuta());
		Double latitude, longitude;
		for(Vertice v: ruta.getVertices()) {
			
			latitude = v.getLatitud().doubleValue();
			longitude = v.getLongitud().doubleValue();
			
			if( latitude < southernMost) 
				southernMost = latitude;
			if( latitude > northernMost) 
				northernMost = latitude;
			if( longitude < westernMost) 
				westernMost = longitude;
			if( longitude > easternMost) 
				easternMost = longitude;
			
		}
		
		return ruta;
		
	}
	
}
