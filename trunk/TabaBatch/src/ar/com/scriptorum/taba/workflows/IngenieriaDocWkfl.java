package ar.com.scriptorum.taba.workflows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ar.com.scriptorum.taba.factories.ConditionFactory;
import ar.com.scriptorum.taba.factories.StateFactory;
import ar.com.scriptorum.taba.factories.TransitionFactory;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.interfaces.Workflow;
import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.util.state.StateMachine;

public class IngenieriaDocWkfl implements Workflow {

	LinkedList <Transition> workflows = new LinkedList<Transition>();
	List<Transition> validTransitions = new ArrayList<Transition>();
	
	State first, second, third, fourth;
	static HashMap<State, CustomSet<Condition>> conditionsForEachState;
	StateMachine stateMachine;
	State currentState;
	public IngenieriaDocWkfl() {
		
		// 1st, setup all states known
		first = StateFactory.newState("maker");
		second = StateFactory.newState("checker");
		third = StateFactory.newState("validated");
		fourth = StateFactory.newState("finalized");
		
		// 2nd, setup their associated conditions
		conditionsForEachState = new HashMap<State, CustomSet<Condition>>();
		conditionsForEachState.put(first, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("initial")));
		conditionsForEachState.put(second, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("maker")));
		conditionsForEachState.put(third, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("checker")));
		
		// 3rd, setup transitions based on states and conditions 
		validTransitions.addAll(TransitionFactory.newSimpleTransition(first, conditionsForEachState.get(first), second));
		validTransitions.addAll(TransitionFactory.newSimpleTransition(second, conditionsForEachState.get(second), third));
		validTransitions.addAll(TransitionFactory.newSimpleTransition(third, conditionsForEachState.get(third), fourth));
		
		// 4th, create the state machine with all previous data
		stateMachine = new StateMachine(first,validTransitions);
		
		// 5th, setup workflow initial state
		currentState = first;
		
	}
	
	public List<Transition> getWorkflow() {
		return workflows;
	}

	public void add(Transition t) {
		workflows.add(t);
	}

	public State getCurrentState() {
		return this.currentState;
	}

	public Transition getLastTransition() {
		return workflows.getLast();
	}

	public boolean transicionate() {
		State previous = getCurrentState();
		this.currentState = stateMachine.apply(conditionsForEachState.get(getCurrentState()));
		return !previous.equals(currentState);
	}

}
