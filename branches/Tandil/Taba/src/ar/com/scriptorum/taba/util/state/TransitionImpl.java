package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.interfaces.Transition;

public class TransitionImpl extends NullTransition implements Transition {

	private State from;
	private CustomSet<Condition> conditions;
	private State to;

	public TransitionImpl(State from, CustomSet<Condition> conditions, State to) {
		this.from = from;
		this.conditions = conditions;
		this.to = to;
	}

	public String toString() {
		return from + conditions.toString() + to;
	}

	public State from() {
		return this.from;
	}

	public State to() {
		return this.to;
	}

	public CustomSet<Condition> conditions() {
		return this.conditions;
	}

}