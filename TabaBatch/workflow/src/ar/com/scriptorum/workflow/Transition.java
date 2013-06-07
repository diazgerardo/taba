package ar.com.scriptorum.workflow;

import java.util.Set;

import org.apache.log4j.Logger;

public abstract class Transition {
	
	static Logger _logger = Logger.getLogger(Transition.class);

	protected Set<Condition> conditions;

	public Set<Condition> conditions() {
		return this.conditions;
	}

	/**
	 * 
	 * Rafa, Nico, thanks for sharing 
	 * 
	 * @param conditions
	 * @return State to if conditions are met, null or alternate states otherwise
	 * 
	 * (please refer to the specific implementation for more details about implementation
	 * and/or to StateMachineImpl/OrderTest for usage)
	 * 
	 */
	abstract State eval(Set<Condition> conditions);
	
}
