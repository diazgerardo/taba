package ar.com.scriptorum.taba.util.state;

import java.util.List;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.factories.ConditionFactory;
import ar.com.scriptorum.taba.factories.StateFactory;
import ar.com.scriptorum.taba.factories.TransitionFactory;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.Transition;

public class StateMachineTest extends TestCase {

	State first, second, third, fourth;
	Condition sunday, rainy, sunny;
	List<Transition> transitions;
	CustomSet<Condition> sunnySundaySet, rainySundaySet;
	StateMachine machine;
	
	@Override
	public void setUp() {

		// states
		first = StateFactory.newState("preparando");
		second = StateFactory.newState("pintando");

		// conditions
		sunday = ConditionFactory.newSimpleCondition("Sunday");
		rainy = ConditionFactory.newSimpleCondition("Rainy");
		sunny = ConditionFactory.newSimpleCondition("Sunny");

		// sets
		sunnySundaySet = new CustomSet<Condition>(sunday);
		sunnySundaySet.add(sunny);

		rainySundaySet = new CustomSet<Condition>(sunday);
		rainySundaySet.add(rainy);

		// transitions
		transitions = TransitionFactory.newSimpleTransition(first, sunnySundaySet, second);
		
		// machine creation
		machine = new StateMachine(first, transitions);

	}
	
	public void testPaintInSunnyDay() {

		State current = machine.current;
		assertNotNull(current);
		State next = machine.apply(sunnySundaySet);
		assertFalse(current.equals(next)); // ok, starts painting 

	}
	
	public void testPaintInRainyDay() {


		State current = machine.current;
		assertNotNull(current);
		State next = machine.apply(rainySundaySet);
		assertTrue(current.equals(next)); // => cannot paint
	
	}

}
