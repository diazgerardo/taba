package ar.com.scriptorum.taba.util.state;

import java.util.HashMap;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.factories.ConditionFactory;
import ar.com.scriptorum.taba.factories.StateBuilder;
import ar.com.scriptorum.taba.factories.TransitionFactory;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.SimpleTransition;

public class StateMachineTest extends TestCase {

	State first, second, third, fourth;
	Condition sunday, rainy, sunny;
	HashMap<State, SimpleTransition> transitions;
	HashMap<State, CustomSet<Condition>> sunnySundaySet, rainySundaySet;
	StateMachine machine;
	
	@Override
	public void setUp() {

		// states
		first = new StateBuilder().createState("preparando").build();
		second = new StateBuilder().createState("pintando").build();

		// conditions
		sunday = ConditionFactory.newSimpleCondition("Sunday");
		rainy = ConditionFactory.newSimpleCondition("Rainy");
		sunny = ConditionFactory.newSimpleCondition("Sunny");

		// sets
		sunnySundaySet = new HashMap<State, CustomSet<Condition>>();
		sunnySundaySet.put(first, new CustomSet<Condition>(sunday));
		sunnySundaySet.get(first).add(sunny);

		rainySundaySet = new HashMap<State, CustomSet<Condition>>();
		rainySundaySet.put(first, new CustomSet<Condition>(sunday));
		rainySundaySet.get(first).add(rainy);

		// transitions
		transitions = new HashMap<State, SimpleTransition>();
		transitions.put(first, TransitionFactory.newSimpleTransition(first, sunnySundaySet.get(first), second));
		
		// machine creation
		machine = new StateMachine(first, transitions);

	}
	
	public void testPaintInSunnyDay() {

		State current = machine.current;
		assertNotNull(current);
		State next = machine.apply(sunnySundaySet.get(machine.current));
		assertFalse(current.equals(next)); // ok, starts painting 

	}
	
	public void testPaintInRainyDay() {

		State current = machine.current;
		assertNotNull(current);
		State next = machine.apply(rainySundaySet.get(current));
		assertTrue(current.equals(next)); // => cannot paint
	
	}

}
