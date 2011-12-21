package ar.com.scriptorum.taba.main;

public class Matematico {

	public static void main(String args[]) {
	
		for(int i = 0; i<200; i++) {
			new Thread(new Cliente((1+(int)(Math.random()*10)))).start();
		}
	}
	
	public static synchronized int sumar(int a, int b) {
		return a + b;
	}

	public static synchronized int duplicar(int value) {
		return 2 * value;
	}

}
