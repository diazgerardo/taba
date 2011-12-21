package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.util.state.State;

public class StateFactory {

	public static State newState(String state) {
		return new State(state);
	}

}
