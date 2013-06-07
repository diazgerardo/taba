package ar.com.scriptorum.workflow;

import java.util.Set;

public class TransitionFactory {

	public static Transition newSimpleTransition(State from, Set<Condition> conditions, State to) {

		return new SimpleTransitionImpl(from, conditions, to);

	}

	public static Transition newActionTransition(State from, Set<Condition> conditions, CustomSet<Action> actions, State to) {

		return new ActionTransitionImpl(from, conditions, actions, to);

	}

	public static Transition newSimpleTransition(State from, Set<Condition> conditions, State to, State alternate) {

		return new ChoiceTransitionImpl(from, conditions, to, alternate);

	}


}