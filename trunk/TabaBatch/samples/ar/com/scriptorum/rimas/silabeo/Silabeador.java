package ar.com.scriptorum.rimas.silabeo;

import java.util.Arrays;
import java.util.List;

public class Silabeador {

	FinalizerStrategy _finalStrategy;
	
	public static List<String> CONSONANTES_INSEPARABLES = Arrays.asList(new String[] {"br","bl","cr","cl","dr","fr","fl","gr","gl","kr","ll","pr","pl","ps", "tr","rr","ch"}); 
	public static List<String> VOCALES_INSEPARABLES = Arrays.asList(new String[] {"ai", "au", "ei", "eu", "io", "ou", "ia", "ua", "ie", "ue", "oi", "uo", "ui", "iu", "ay", "ey", "oy", "iai", "iei", "uai", "uei", "uau", "iau", "uay", "uey"}); 
	public static List<String> CONSONANTES = Arrays.asList(new String[]{"b","c","d","f","g","h","j","k","l","m","n","ñ","p","q","r","s","t","v","w","x","y","z"});
	public static List<String> VOCALES = Arrays.asList(new String[]{"a","e","i","o","u","á","é","í","ó","ú"});
	
	public Silabeador() {
		
	}
	
	public Silabeador evalBeginning(String palabra) throws Exception {
		try {
		if(palabra.length() ==1 ) 
			_finalStrategy = new MonosilaboStrategy();
		else if(VOCALES.contains(palabra.substring(0,1).toLowerCase()))
			_finalStrategy = new BeginsWithVowelStrategy();
		else if(CONSONANTES.contains(palabra.substring(0,1).toLowerCase())&&VOCALES.contains(palabra.substring(1,2).toLowerCase()))
			_finalStrategy = new BeginsWithConsonantAndVowelStrategy();
		else if(CONSONANTES.contains(palabra.substring(0,1).toLowerCase())&&CONSONANTES.contains(palabra.substring(1,2).toLowerCase()))
			_finalStrategy = new BeginsWithTwoConsonantsStrategy();
		else
			_finalStrategy = new UnknownWordStrategy();
		return this;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	public int findStop(String palabra) throws Exception {
		if(_finalStrategy == null) 
			throw new Exception("call evalBeginning first.");
		
		return _finalStrategy.findLenght(palabra);
	}
	
	public Silaba nextSilaba(Palabra palabra) {
		try {
			evalBeginning(palabra.getPalabra());
			return new Silaba(palabra.getPalabra().substring(0,findStop(palabra.getPalabra())));
			//palabra = palabra.substring(lenght);

		} catch (Exception e) {
			System.out.println("<E>");
			//e.printStackTrace();
		}
		return new Silaba("");
	}
	
	public Palabra silabear(Palabra palabra) {
		
		Silaba silaba;
		while(!"".equals((silaba = this.nextSilaba(palabra)).toString())) {
			palabra.getSilabas().add(silaba);
			palabra.setPalabra(palabra.getPalabra().substring(silaba.toString().length()));
		}
		return palabra;
	}
}
