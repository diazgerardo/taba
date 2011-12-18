package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.State;

public class StateImpl extends NullState implements State {
    public StateImpl(String state) {
		this.state=state;
	}

	String state;
	
	public String toString() {
		return state;
	}
}

