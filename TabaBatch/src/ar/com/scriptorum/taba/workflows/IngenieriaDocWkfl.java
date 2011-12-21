package ar.com.scriptorum.taba.workflows;

import java.util.LinkedList;
import java.util.List;

import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.interfaces.Workflow;
import ar.com.scriptorum.taba.util.state.StateMachine;

public class IngenieriaDocWkfl implements Workflow {

	LinkedList <Transition> workflows = new LinkedList<Transition>();
	
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
		State from = getLastTransition().from();
		StateMachine sm = new StateMachine(from,workflows);
		return !from.equals(getLastTransition().from());
	}

}
