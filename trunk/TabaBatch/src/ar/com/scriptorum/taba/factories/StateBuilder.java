package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.util.state.State;

public class StateBuilder {

	State state;
	
	public StateBuilder createState(String state) {
		this.state = new State(state);
		return this;
	}
	
	public State build() {
		return state;
	}
}
