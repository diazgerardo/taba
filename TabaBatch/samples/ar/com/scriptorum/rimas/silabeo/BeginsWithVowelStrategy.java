package ar.com.scriptorum.rimas.silabeo;

public class BeginsWithVowelStrategy extends FinalizerStrategy {

	@Override
	int findLenght(String st) {
		// TODO implement this method
		if(st.length() == 1) {
			// just one vowel
			return 1;
		}
		try {
			String substring = st.substring(1,3);
			if(Silabeador.CONSONANTES_INSEPARABLES.contains(substring) ||
					Silabeador.VOCALES.contains(substring.substring(0, 1))||
				Silabeador.VOCALES_INSEPARABLES.contains(substring))
				return 1;
			if(Silabeador.CONSONANTES.contains(substring.substring(0,1))&&
					Silabeador.CONSONANTES.contains(substring.substring(1,2)))
					return 2;
			return 1;
		}catch(IndexOutOfBoundsException e) {
			return st.length();
		}

	}

}
