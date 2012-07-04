package com.gerardo.concepts.multithreading;

public class Part {

	protected int id;
	@Override
	public String toString() {
		return " Component: "+ this.getClass().getSimpleName()+"("+this.id+")";
	}
}
