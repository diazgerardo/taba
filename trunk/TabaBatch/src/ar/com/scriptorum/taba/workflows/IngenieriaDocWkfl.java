package ar.com.scriptorum.taba.workflows;

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
	HashMap<State, Transition> validTransitions;
	
	State first, second, third, fourth;
	HashMap<State, CustomSet<Condition>> conditionsForState;
	StateMachine stateMachine;
	State currentState;
	public IngenieriaDocWkfl() {
		
		// 1st, setup all states known
		first = StateFactory.newState("edited");
		second = StateFactory.newState("checked");
		third = StateFactory.newState("validated");
		fourth = StateFactory.newState("finalized");
		
		// 2nd, setup their associated conditions
		conditionsForState = new HashMap<State, CustomSet<Condition>>();
		conditionsForState.put(first, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canCheck")));
		conditionsForState.put(second, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canValidate")));
		conditionsForState.put(third, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canFinalize")));
		
		// 3rd, setup transitions based on states and conditions
		validTransitions = new HashMap<State, Transition>();
		validTransitions.put(first, TransitionFactory.newSimpleTransition(first, conditionsForState.get(first), second));
		validTransitions.put(second, TransitionFactory.newSimpleTransition(second, conditionsForState.get(second), third));
		validTransitions.put(third, TransitionFactory.newSimpleTransition(third, conditionsForState.get(third), fourth));
		
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
		State previous = this.currentState;
		this.currentState = stateMachine.apply(conditionsForState.get(previous));
		return !previous.equals(this.currentState);
	}

}
