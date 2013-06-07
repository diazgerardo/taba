package ar.com.scriptorum.workflow;

import java.util.Set;

public class ActionTransitionImpl extends SimpleTransitionImpl implements ActionTransition {

	CustomSet<Action> actions;
	
	public ActionTransitionImpl(State from, Set<Condition> conditions, CustomSet<Action> actions, State to) {
		super(from, conditions, to);
		this.actions = actions;
	}

	@Override
	public boolean execute() {
		return false;
	}

	public CustomSet<Action> getActions() {
		return actions;
	}

}
