package ar.com.scriptorum.taba.workflows;

import java.util.ArrayList;
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
	Condition condition1, condition2;
	CustomSet<Condition> set1, set2;
	StateMachine machine;
	
	public IngenieriaDocWkfl() {

		first = StateFactory.newState("maker");
		condition1 = ConditionFactory.newSimpleCondition("initial");
		set1 = new CustomSet<Condition>();
		set1.add(condition1);
		validTransitions.addAll(TransitionFactory.newSimpleTransition(first, set1, second));
		
		second = StateFactory.newState("checker");
		condition2 = ConditionFactory.newSimpleCondition("maker");
		set2 = new CustomSet<Condition>();
		set2.add(condition2);
		validTransitions.addAll(TransitionFactory.newSimpleTransition(second, set2, third));

		machine = new StateMachine(first,validTransitions);

	}
	
	public List<Transition> getWorkflow() {
		return workflows;
	}

	public void add(Transition t) {
		workflows.add(t);
	}

	public State getCurrentState() {
		return workflows.getLast().from();
	}

	public Transition getLastTransition() {
		return workflows.getLast();
	}

	public boolean transicionate() {
		machine.apply(set2);
		return !true;
	}

}
