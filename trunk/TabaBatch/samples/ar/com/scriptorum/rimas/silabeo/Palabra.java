package ar.com.scriptorum.rimas.silabeo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Palabra {

	private String palabra;
	private List<Silaba> silabas;
	public Palabra(String s) {
		this.palabra = s;
		this.silabas = new ArrayList<Silaba>();
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public List<Silaba> getSilabas() {
		return silabas;
	}
	public void setSilabas(List<Silaba> silabas) {
		this.silabas = silabas;
	}

	public String toString() {
		return "Palabra: "+ toString(getSilabas(), null) + "\n Silabas ("+getSilabas().size()+"): " + toString(getSilabas(),"-") +"\n";
		
	}
	
	private String toString(List<Silaba> silabas, String separator) {
		StringBuffer sb = new StringBuffer();
		Iterator<Silaba> it = silabas.iterator();
		Silaba s;
		while(it.hasNext()) {
			s = it.next();
			sb.append(s.toString());
			if(it.hasNext()&& separator!=null) {
				sb.append(separator);
			}
		}
		return sb.toString();
	}
}
