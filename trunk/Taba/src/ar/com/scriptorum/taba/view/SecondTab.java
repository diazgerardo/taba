package ar.com.scriptorum.taba.view;


import android.os.Bundle;
import android.widget.TextView;
import ar.com.scriptorum.taba.singletons.Calculator;

public class SecondTab extends MyActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.main);
			
			myVelocidadParcial = (TextView) findViewById(R.id.VelocidadParcial);
			myVelocidadReal = (TextView) findViewById(R.id.VelocidadReal);
			myAnterior = (TextView) findViewById(R.id.Anterior);
			mySiguiente = (TextView) findViewById(R.id.Siguiente);
			myTiempoEstimado = (TextView) findViewById(R.id.TiempoEstimado);
			myTiempoEstimadoFin = (TextView) findViewById(R.id.TiempoEstimadoFin);
			
			if(null!= movil.getVelocidadPromedioParcial()) 
				myVelocidadParcial.setText("Vel. Prom. Parc: " + Calculator.redondear(movil.getVelocidadPromedioParcial()));
			if(null!= movil.getVelocidadPromedioReal()) 
				myVelocidadReal.setText("Vel. Prom. Real: " + Calculator.redondear(movil.getVelocidadPromedioReal()));
			if(null!= movil.getAnterior()) 
				myAnterior.setText("Entre: "+movil.getAnterior().toString());
			if(null!= movil.getSiguiente()) 
				mySiguiente.setText("Y: " +  movil.getSiguiente().toString());
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}