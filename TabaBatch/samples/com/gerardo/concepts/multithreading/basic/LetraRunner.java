package com.gerardo.concepts.multithreading.basic;

public class LetraRunner {

	public static void main(String args[]) {
		Thread a = new Thread(new A());
		Thread b = new Thread(new B());
		a.start();
		b.start();
	}
}
