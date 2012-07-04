package ar.com.scriptorum.rimas.silabeo;

public class BeginsWithConsonantAndVowelStrategy extends FinalizerStrategy {

	@Override
	int findLenght(String st) {
		try {
			String substring = st.substring(2,4);
			if(Silabeador.CONSONANTES_INSEPARABLES.contains(substring) ||
					Silabeador.VOCALES.contains(substring.substring(0, 1))||
				Silabeador.VOCALES_INSEPARABLES.contains(substring))
				return 2;
			if(Silabeador.CONSONANTES.contains(substring.substring(0,1))&&
					Silabeador.CONSONANTES.contains(substring.substring(1,2)))
					return 3;
			// default
			return 2;
		}catch(IndexOutOfBoundsException e) {
			// make sure we don't loose any string
			return st.length();
		}
	
	}

}
