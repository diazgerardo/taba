package com.gerardo.concepts.multithreading;

public class Head extends Part {
	public Head() {
		this.id = ClavoFactory.getInstance().serial;
	}
	
}
