package ar.com.scriptorum.taba.interfaces;

import ar.com.scriptorum.taba.util.state.State;

public interface ChoiceTransition extends SimpleTransition {
	public State alternate();
}
