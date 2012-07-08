package ar.com.scriptorum.threads.multithreading.basic;

import java.math.BigInteger;

public class A extends Letra {

	@Override
	void call() throws Exception {
		BigInteger total = multiply(new BigInteger("2"), new BigInteger("2"));
		if(0!=total.compareTo(new BigInteger("4"))) {
			throw new Exception("invalid result found " + total);
		}
		System.out.println("total: "+total);
		try {
			long pausa = (long) ((Math.random()*1000)+500);
			System.out.println("pausa por "+pausa +" millis.." );
			Thread.currentThread();
			Thread.sleep((long)Math.random()*1000+100);
		} catch (InterruptedException e) {
		}
	}

}
