package ar.com.scriptorum.taba.util.state;

import java.util.List;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.factories.ConditionFactory;
import ar.com.scriptorum.taba.factories.StateFactory;
import ar.com.scriptorum.taba.factories.TransitionFactory;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.State;
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
		sunnySundaySet = new CustomSet<Condition>();
		sunnySundaySet.add(sunday);
		sunnySundaySet.add(sunny);

		rainySundaySet = new CustomSet<Condition>();
		rainySundaySet.add(sunday);
		rainySundaySet.add(rainy);

		// transitions
		transitions = TransitionFactory.newSimpleTransition(first, sunnySundaySet, second);
		
		// machine creation
		machine = new StateMachine(first, transitions);

	}
	
	public void testPaintInSunnyDay() {

		// of course we can paint in a sunny sunday! 
		machine.apply(sunnySundaySet);
		assertTrue("pintando".equals(machine.current.toString()));

	}
	
	public void testPaintInRainyDay() {

		// cannot paint in a rainy sunday 
		machine.apply(rainySundaySet);
		assertFalse("pintando".equals(machine.current.toString()));
	
	}

}
