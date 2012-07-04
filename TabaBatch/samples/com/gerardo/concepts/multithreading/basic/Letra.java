package com.gerardo.concepts.multithreading.basic;

import java.math.BigInteger;

public abstract class Letra implements Runnable {

	protected static BigInteger multiply(BigInteger a, BigInteger b) {
		
		
		return a.multiply(b);
	}
	@Override
	public void run() {
		for(int i = 1; i <10000; i ++) {
			try {
				call();
			} catch (Exception e) {
				break;
			}
		}
	}
	abstract void call() throws Exception;
}
