package com.scriptorum.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {

	public static void main( String ... strings ) {
		Polymorphism p = new Polymorphism();
		p.showSwitchDemo();
		p.showPolymorphicDemo();
		
	}
	
	private void showSwitchDemo() {
		System.out.println("Switch Demo");
		List<Typed> list = new ArrayList<Typed>();
		list.add(new Typed(1));
		list.add(new Typed(2));
		for(Typed t : list) {
			switch(t.getLetter()) {
				case 1:
					System.out.println("A");
					break;
				case 2:
					System.out.println("B");
			}
		}
	}

	private void showPolymorphicDemo() {
		System.out.println("Polimorphic Refactor Demo");
		List<Polymorphic> list = new ArrayList<Polymorphic>();
		list.add(new A());
		list.add(new B());
		for(Polymorphic p : list) {
			p.print();
		}
		
	}


	class Typed {
		private int letter;
		public Typed(int letter) {
			this.letter = letter;
		}
		public int getLetter() {
			return this.letter;
		}
	}
	
	abstract class Polymorphic {
		abstract void print();
	}
	
	class A extends Polymorphic {

		@Override
		void print() {
			System.out.println("A");
		}
		
	}

	class B extends Polymorphic {

		@Override
		void print() {
			System.out.println("B");
		}
		
	}
}
