package ar.com.scriptorum.taba.util.state;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String [] args) {
		State one = new State("one");
		State two = new State("two");
		State three = new State("three");

		Condition sunday = new Condition("Sunday");
		Condition raining = new Condition("Raining");
		Condition notSunday = new Condition("Not Sunday");
		Condition notRaining = new Condition("Not Raining");

		List<Transition> transitions = new ArrayList<Transition>();
		Set<Condition> sundaySet = new HashSet<Condition>();
		sundaySet.add(sunday);
		transitions.add(new Transition(one,  sundaySet, three));
		transitions.add(new Transition(one, sundaySet, two)); // <<--- Invalid, cant go to two and three
		Set<Condition> rainingSet = new HashSet<Condition>();
		rainingSet.add(raining);
		transitions.add(new Transition(one, rainingSet, three));
		Set<Condition> sundayAndRaining = new HashSet<Condition>();
		sundayAndRaining.add(sunday);
		sundayAndRaining.add(raining);
		transitions.add(new Transition(one, sundayAndRaining, three));
		Set<Condition> notSundayNotRaining = new HashSet<Condition>();
		notSundayNotRaining.add(notSunday);
		notSundayNotRaining.add(notRaining);
		transitions.add(new Transition(one, notSundayNotRaining, three));

		StateMachine machine = new StateMachine(one, transitions);
		System.out.println(machine.current); // "one"
		machine.apply(sundayAndRaining);
		System.out.println(machine.current); // "three

	}
}
