package ar.com.scriptorum.taba.util.state;

import java.util.HashMap;
import java.util.Set;

import ar.com.scriptorum.taba.interfaces.ChoiceTransition;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.SimpleTransition;

public class StateMachine {
	
	State current;
	HashMap<State, SimpleTransition> transitions;

	public StateMachine(State start, HashMap<State, SimpleTransition> validTransitions) {
		this.current = start;
		this.transitions = validTransitions;
	}

	public State apply(Set<Condition> conditions) {
		current = getNextState(conditions); 
		return current;
	}

	public State getNextState(Set<Condition> conditions) {

		try {
			return eval(conditions, transitions.get(current)); 
		} catch(Exception e) {
			// not found? anything else? just print stacktrace and shutup
			e.printStackTrace();
		}
		
		return current;
	}

	private State eval(Set<Condition> conditions, SimpleTransition transition) {
		if(transition.conditions().equals(conditions)) {
			return transition.to();
		}
		return current;
	}

	private State eval(Set<Condition> conditions, ChoiceTransition transition ) {
		if(transition.conditions().equals(conditions)) 
			return transition.to();
		else 
			return transition.alternate();
	}
}
