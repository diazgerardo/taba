package ar.com.scriptorum.taba.util.state;

import java.util.Set;

import ar.com.scriptorum.taba.interfaces.Condition;

class Transition {
    public Transition(State from, Set<Condition> conditions, State to) {
		this.from = from;
		this.conditions = conditions;
		this.to = to;
	}
	public State from;
    public Set<Condition> conditions;
    public State to;
}
