package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.ChoiceTransition;
import ar.com.scriptorum.taba.interfaces.Condition;

public class ChoiceTransitionImpl extends SimpleTransitionImpl implements ChoiceTransition {

	private State alternate;

	public ChoiceTransitionImpl(State from, CustomSet<Condition> conditions, State to, State alternate) {
		super(from, conditions, to);
		this.alternate = alternate;
	}

	@Override
	public State alternate() {
		return alternate;
	}
	
	@Override 
	public String toString() { 
		return super.toString() + "[Alternate="+alternate+"] ";
	}

}
