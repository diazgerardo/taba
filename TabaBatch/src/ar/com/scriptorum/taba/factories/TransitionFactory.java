package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.SimpleTransition;
import ar.com.scriptorum.taba.util.state.Action;
import ar.com.scriptorum.taba.util.state.ActionTransition;
import ar.com.scriptorum.taba.util.state.ActionTransitionImpl;
import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.util.state.SimpleTransitionImpl;

public class TransitionFactory {

	public static SimpleTransition newSimpleTransition(State from, CustomSet<Condition> conditions, State to) {

		return new SimpleTransitionImpl(from, conditions, to);

	}

	public static ActionTransition newActionTransition(State from, CustomSet<Condition> conditions, CustomSet<Action> actions, State to) {

		return new ActionTransitionImpl(from, conditions, actions, to);

	}

}