package ar.com.scriptorum.taba.main;

public class RutaDrawer {
	static int i = 0;
	public static void main(String [] args) {
		
		System.out.println("alglo" + ++i);
		
	}

	static {
		System.out.println("static se ejecuta incluso antes q main! (i++=" +i+++")" );
	}
}
