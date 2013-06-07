package ar.com.scriptorum.workflow;

import java.util.List;
import java.util.Set;


public interface StateMachine {

	public abstract State apply(Set<Condition> conditions);

	public abstract State getNextState(Set<Condition> conditions);
	
	public abstract List<State> getStates();

	public abstract Set<Condition> getConditionsForState(State currentState);

	public abstract State getCurrent();

	public abstract void setCurrent(State current);
	

}