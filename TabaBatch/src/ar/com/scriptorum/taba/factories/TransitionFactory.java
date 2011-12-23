package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.util.state.TransitionImpl;

public class TransitionFactory {

	public static Transition newSimpleTransition(State from, CustomSet<Condition> conditions, State to) {

		return new TransitionImpl(from, conditions, to);

	}

}