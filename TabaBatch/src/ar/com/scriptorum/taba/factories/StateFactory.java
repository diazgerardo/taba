package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.util.state.StateImpl;

public class StateFactory {

	public static State newState(String state) {
		return new StateImpl(state);
	}

}
