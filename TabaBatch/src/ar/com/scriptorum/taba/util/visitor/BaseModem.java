package ar.com.scriptorum.taba.util.visitor;

import ar.com.scriptorum.taba.util.state.State;

public class BaseModem {
	private State state;
	
	public State setState() {
		return this.state;
	}
	public void getState(State state ) {
		this.state = state;
	}
}
