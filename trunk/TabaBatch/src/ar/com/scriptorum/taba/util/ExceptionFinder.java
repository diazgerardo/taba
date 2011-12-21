package ar.com.scriptorum.taba.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExceptionFinder {

	private static Boolean [] rec = new Boolean[] {
		Boolean.TRUE, // field 1
		Boolean.TRUE, // field 2
		Boolean.TRUE, // field 3
		Boolean.TRUE, // field 4
		Boolean.TRUE, // field 5
		Boolean.TRUE, // field 6
		Boolean.TRUE, // field 7
		Boolean.TRUE, // field 8
		Boolean.TRUE, // field 9
		Boolean.TRUE, // field 10
		Boolean.TRUE, // field 11
		Boolean.TRUE  // field 12, and so on
	};
	private static Boolean [] mot = new Boolean[] {
		Boolean.TRUE, // field 1
		Boolean.TRUE, // field 2
		Boolean.TRUE, // field 3
		Boolean.TRUE, // field 4
		Boolean.TRUE, // field 5
		Boolean.TRUE, // field 6
		Boolean.TRUE, // field 7
		Boolean.TRUE, // field 8
		Boolean.TRUE, // field 9
		Boolean.TRUE, // field 10
		Boolean.TRUE, // field 11
		Boolean.TRUE  // field 12, and so on
	};
	private static Boolean [] ind = new Boolean[] {
		Boolean.TRUE, // field 1
		Boolean.TRUE, // field 2
		Boolean.TRUE, // field 3
		Boolean.TRUE, // field 4
		Boolean.TRUE, // field 5
		Boolean.TRUE, // field 6
		Boolean.TRUE, // field 7
		Boolean.TRUE, // field 8
		Boolean.TRUE, // field 9
		Boolean.TRUE, // field 10
		Boolean.TRUE, // field 11
		Boolean.TRUE  // field 12, and so on
	};
	private static Boolean [] mob = new Boolean[] {
		Boolean.TRUE, // field 1
		Boolean.TRUE, // field 2
		Boolean.TRUE, // field 3
		Boolean.TRUE, // field 4
		Boolean.TRUE, // field 5
		Boolean.TRUE, // field 6
		Boolean.TRUE, // field 7
		Boolean.TRUE, // field 8
		Boolean.TRUE, // field 9
		Boolean.TRUE, // field 10
		Boolean.TRUE, // field 11
		Boolean.TRUE  // field 12, and so on
	};
	
	private static ExceptionFinder exceptionFinder;
	private static HashMap<String, List> hm;
	private ExceptionFinder () {
		hm = new HashMap<String, List>();
		hm.put("REC|",Arrays.asList(rec));
		hm.put("MOT|",Arrays.asList(rec));
		hm.put("IND|",Arrays.asList(rec));
		hm.put("MOB|",Arrays.asList(rec));
	}
	public static ExceptionFinder getInstance() {
		if(exceptionFinder == null) {
			exceptionFinder = new ExceptionFinder();
		}
		return exceptionFinder;
	}

	/** toda la app usara esta exception de negocio
	 * 
	 * @return BuzzException con mensaje segun el caso
	 * @throws BuzzException 
	 */
	public void validateRecord(String recType, int order, Boolean present) throws BuzzException {
		if(!hm.containsKey(recType))
			// unknown record type!
			throw new BuzzException("Bad record type!");
		
		// ok, record type has been recognized. now check
		// mandatory parameters presence
		ArrayList <Boolean> parameters = (ArrayList<Boolean>) hm.get(recType);
		if((Boolean)parameters.get(order) && !present.booleanValue()) 
			// mandatory parameter not found!
			throw new BuzzException("Mandatory parameter #" + order + " not found!");
			
	}

}
