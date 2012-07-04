package ar.com.scriptorum.puzzler;

import java.util.HashSet;

public class Volkswagen {
	private static final int CAPACITY = 5;
	private HashSet<Clown> clowns = new HashSet<Clown>();

	public synchronized void add(Clown clown) {
		if (clowns.size() >= CAPACITY) {
			throw new IllegalStateException("I'm full");
		} else {
			clowns.add(clown);
		}
	}

	public synchronized void done() {
		if (clowns.size() == 20) {
			// The goal is to reach this line
			System.out.println("I'm a Volkswagen with 20 clowns!");
		}
	}
}
