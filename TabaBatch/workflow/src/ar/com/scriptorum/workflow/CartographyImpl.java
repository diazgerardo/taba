package ar.com.scriptorum.workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartographyImpl implements Cartography {

	private State start;
	private List<State> states;
	private Map<State, Transition> validTransitions;
	
	public void setStart(State state) {
		this.start = state;
	}
	
	@Override
	public State getStart() {
		return start;
	}

	public void setValidTransitions(Map<State, Transition> transitions) {
		this.validTransitions = transitions;
	}
	
	@Override
	public Map<State, Transition> getValidTransitions() {
		return validTransitions;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public List<State> getStates() {
		return this.states;
	}

	@Override
	public Cartography getCartography() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Condition> getConditionsForState(State state) {
		return validTransitions.get(state).conditions();
	}	
	
	

}
