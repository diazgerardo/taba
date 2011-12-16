package ar.com.scriptorum.taba.util.state;

import java.util.Set;

class Transition {
    public Transition(State from, Set<Condition> conditions, State to) {
		this.from = from;
		this.conditions = conditions;
		this.to = to;
	}
	State from;
    Set<Condition> conditions;
    State to;
}
