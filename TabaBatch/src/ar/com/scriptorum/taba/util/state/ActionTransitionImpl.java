package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.Condition;

public class ActionTransitionImpl extends SimpleTransitionImpl implements ActionTransition {

	CustomSet<Action> actions;
	
	public ActionTransitionImpl(State from, CustomSet<Condition> conditions, CustomSet<Action> actions, State to) {
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
