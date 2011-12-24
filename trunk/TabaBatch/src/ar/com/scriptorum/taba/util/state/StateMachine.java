package ar.com.scriptorum.taba.util.state;

import java.util.HashMap;
import java.util.Set;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.Transition;

public class StateMachine {
	
	State current;
	HashMap<State, Transition> transitions;

	public StateMachine(State start, HashMap<State, Transition> validTransitions) {
		this.current = start;
		this.transitions = validTransitions;
	}

	public State apply(Set<Condition> conditions) {
		current = getNextState(conditions); 
		return current;
	}

	public State getNextState(Set<Condition> conditions) {

		try {
		Transition transition = transitions.get(current); 
		if(transition.conditions().equals(conditions))
			return transition.to();
		} catch(Exception e) {
			// not found? anything else? just print stacktrace and shutup
			e.printStackTrace();
		}
		
		return current;
	}
}
