package com.citigroup.gerardo;

import java.util.ArrayList;
import java.util.List;

public class Jaula {
	List <Animal> animals;
	public Jaula() {
		
		this.animals = new ArrayList<Animal>();
	}

	public void add(Animal animal) {
		this.animals.add(animal);
	}
}
