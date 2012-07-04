package com.gerardo.concepts.multithreading.basic;

import java.math.BigInteger;

public class B extends Letra {

	@Override
	void call() throws Exception {
		BigInteger total = multiply(new BigInteger("5"), new BigInteger("5"));
		if(0!=total.compareTo(new BigInteger("25"))) {
			throw new Exception("invalid result found " + total);
		}	
		System.out.println("							total: "+total);
		try {
			long pausa = (long) ((Math.random()*1000)+100);
			System.out.println("							pausa por "+pausa +" millis.." );
			Thread.currentThread().sleep((long)Math.random()*1000+2000);
		} catch (InterruptedException e) {
		}
	}


}
