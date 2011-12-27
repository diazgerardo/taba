package ar.com.scriptorum.taba.workflows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ar.com.scriptorum.taba.factories.ConditionFactory;
import ar.com.scriptorum.taba.factories.StateBuilder;
import ar.com.scriptorum.taba.factories.TransitionFactory;
import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.SimpleTransition;
import ar.com.scriptorum.taba.interfaces.Workflow;
import ar.com.scriptorum.taba.util.documents.AbstractDocument;
import ar.com.scriptorum.taba.util.state.Action;
import ar.com.scriptorum.taba.util.state.AsignadorImpl;
import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.util.state.StateMachine;

public class IngenieriaDocWkfl implements Workflow<AbstractDocument> {

	LinkedList <SimpleTransition> workflows = new LinkedList<SimpleTransition>();
	HashMap<State, SimpleTransition> validTransitions;
	
	State first, second, third, fourth;
	HashMap<State, CustomSet<Condition>> conditionsForState;
	StateMachine stateMachine;
	State currentState;
	private AbstractDocument target;
	public IngenieriaDocWkfl(AbstractDocument target) {
		
		this.target = target;
		// 1st, setup all states known
		first = new StateBuilder().createState("edited").build();
		second = new StateBuilder().createState("checked").build();
		third = new StateBuilder().createState("validated").build();
		fourth = new StateBuilder().createState("finalized").build();
		
		// 2nd, setup their associated conditions
		conditionsForState = new HashMap<State, CustomSet<Condition>>();
		conditionsForState.put(first, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canCheck")));
		conditionsForState.put(second, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canValidate")));
		conditionsForState.put(third, new CustomSet<Condition>(ConditionFactory.newSimpleCondition("canFinalize")));
		
		// 3rd, setup transitions based on states and conditions
		validTransitions = new HashMap<State, SimpleTransition>();
		validTransitions.put(first, TransitionFactory.newActionTransition(first, conditionsForState.get(first), null, second));
		validTransitions.put(second, TransitionFactory.newSimpleTransition(second, conditionsForState.get(second), third));
		validTransitions.put(third, TransitionFactory.newActionTransition(third, conditionsForState.get(third), new CustomSet<Action>(new AsignadorImpl<AbstractDocument>("boton", null, null, null, this.target)), fourth));
		
		// 4th, create the state machine with all previous data
		stateMachine = new StateMachine(first,validTransitions);
		
		// 5th, setup workflow initial state
		currentState = first;
		
	}
	
	public List<SimpleTransition> getWorkflow() {
		return workflows;
	}

	public void add(SimpleTransition t) {
		workflows.add(t);
	}

	public State getCurrentState() {
		return this.currentState;
	}

	public SimpleTransition getLastTransition() {
		return workflows.getLast();
	}

	public boolean transicionate() {
		State previous = this.currentState;
		this.currentState = stateMachine.apply(conditionsForState.get(previous));
		return !previous.equals(this.currentState);
	}

	@Override
	public AbstractDocument getTarget() {
		return target;
	}

}
