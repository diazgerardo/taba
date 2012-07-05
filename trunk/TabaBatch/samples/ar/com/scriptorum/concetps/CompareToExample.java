package ar.com.scriptorum.concetps;

import org.apache.commons.lang.builder.CompareToBuilder;

public class CompareToExample {

	public static void main(String[] args) {
		Fruit orange = new Fruit("Orange", "Orange");
		Fruit watermelon = new Fruit("Watermelon", "Red");
		if (orange.compareTo(watermelon) == 0) {
			System.out
					.println(orange.getName() + " == " + watermelon.getName());
		} else {
			System.out
					.println(orange.getName() + " != " + watermelon.getName());
		}
	}
}

class Fruit {
	String name;
	private String colour;

	public Fruit(String name, String colour) {
		this.name = name;
		this.colour = colour;
	}

	public String getName() {

		return name;

	}

	public int compareTo(Object o) {

		Fruit f = (Fruit) o;

		return new CompareToBuilder()

		.append(this.name, f.name)

		.append(this.colour, f.colour)

		.toComparison();

	}
}
