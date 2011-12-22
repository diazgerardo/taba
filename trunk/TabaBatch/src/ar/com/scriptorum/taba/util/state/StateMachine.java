package ar.com.scriptorum.taba.util.state;

import java.util.List;
import java.util.Set;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.Transition;

public class StateMachine {
	
	State current;
	List<Transition> transitions;

	public StateMachine(State start, List<Transition> transitions) {
		this.current = start;
		this.transitions = transitions;
	}

	public State apply(Set<Condition> conditions) {
		return getNextState(conditions);
	}

	public State getNextState(Set<Condition> conditions) {
		for (Transition transition : transitions) {
			boolean currentStateMatches = transition.from().equals(current);
			boolean conditionsMatch = transition.conditions()
					.equals(conditions);
			if (currentStateMatches && conditionsMatch) {
				return transition.to();
			}
		}
		return current;
	}
}
