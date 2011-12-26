package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.SimpleTransition;

public class SimpleTransitionImpl extends NullTransition implements SimpleTransition {

	private State from;
	private CustomSet<Condition> conditions;
	private State to;

	public SimpleTransitionImpl(State from, CustomSet<Condition> conditions, State to) {
		this.from = from;
		this.conditions = conditions;
		this.to = to;
	}

	public String toString() {
		return "[From=" + from + "] " + "[Condition="+conditions.toString() + "] [To="+to+"] " ;
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