package ar.com.scriptorum.workflow;

import java.util.Set;

public class ChoiceTransitionImpl extends SimpleTransitionImpl implements ChoiceTransition {

	public ChoiceTransitionImpl(State from, Set<Condition> conditions, State to, State alternate) {
		super(from, conditions, to);
		this.alternate = alternate;
	}

	private State alternate;

	@Override
	public State eval(Set<Condition> conditions) {
	if(conditions.equals(this.conditions())) {
		_logger.debug("this.to():"+this.to());
		return this.to();
	}
	else {
		_logger.debug("this.alternate():"+this.alternate());
		return this.alternate();
	}
	}

	@Override
	public State alternate() {
		return this.alternate;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName());
		sb.append(" from:"+this.from());
		sb.append(" alternate:"+this.alternate());
		sb.append(" conditions:"+this.conditions());
		return sb.toString();
	}

}
