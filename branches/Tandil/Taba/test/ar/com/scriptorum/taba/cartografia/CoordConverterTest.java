package ar.com.scriptorum.taba.cartografia;

import java.io.File;
import java.util.LinkedList;

import junit.framework.TestCase;
import android.os.Environment;
import ar.com.scriptorum.taba.abstractions.Vertice;
import ar.com.scriptorum.taba.singletons.RutaParser;

public class CoordConverterTest extends TestCase {
		final static int IMG_SIZE = 256;

       public void testConv() {

    	   LinkedList<Vertice> ruta = getRuta();
               CoordConverter c = new CartesianConverter().
					latUpLeft(-31.05764). 		// La Falda  	y=0
					longUpLeft(-64.507141). 	//  "   "    	x=0
					latDownRight(-34.538812).	// Buenos Aires y=250
					longDownRight(-58.475763).	//    "     "	y=600
					imgHeight(IMG_SIZE).
					imgWidht(IMG_SIZE);
               
               int[] xy;
               for(Vertice v : ruta ) {
               	
               		xy = c.getXY(v);
               		assertTrue( xy[0] <= IMG_SIZE && xy[0]>=0 );
               		assertTrue( xy[1] <= IMG_SIZE && xy[1]>=0 );
               	   
               }               
       }

	private LinkedList<Vertice> getRuta() {
		
		File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/buenosAires-Cordoba.xml");
		RutaParser dpe = RutaParser.getInstance();
		dpe.runExample(xml);
		return dpe.getRuta();

	}

}