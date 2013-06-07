package ar.com.scriptorum.workflow;

import java.util.Set;

public class SimpleTransitionImpl extends Transition implements SimpleTransition {

	private State from;
	private State to;

	public SimpleTransitionImpl(State from, Set<Condition> conditions, State to) {
		this.from = from;
		this.conditions = conditions;
		this.to = to;
	}

	public String toString() {
		return "[From=" + from + "] " + "[Condition="+conditions.toString() + "] [To="+to+"] " ;
	}

	public State from() {
		return this.from;
	}

	public State to() {
		return this.to;
	}
	@Override
	public State eval(Set<Condition> conditions) {
			 
		if(conditions.equals(this.conditions())) {
			_logger.debug("this.to():"+this.to());
			return this.to();
		}
		return null;
	}

}