package ar.com.scriptorum.taba.cartografia;

import junit.framework.TestCase;

public class CoordConverterTest extends TestCase {

       @SuppressWarnings("unused")
	public void testConv() {

               CoordConverter c = new CoordConverter().
               							latUpLeft(-31.05764). 		// La Falda  	y=0
               							longUpLeft(-64.507141). 	//  "   "    	x=0
               							latDownRight(-34.538812).	// Buenos Aires y=250
               							longDownRight(-58.475763).	//    "     "	y=600
               							imgHeight(250).
               							imgWidht(600);
               // Rosario
               int y = c.getY(-32.92686);
               int x = c.getX(-60.897446);
               
       }

}
