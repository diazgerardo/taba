package ar.com.scriptorum.workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Cartography {
	
	public State getStart();
	public Map<State, ? extends Transition> getValidTransitions();
	public abstract List<State> getStates();
	public Cartography getCartography();
	public Set<Condition> getConditionsForState(State state);
}
