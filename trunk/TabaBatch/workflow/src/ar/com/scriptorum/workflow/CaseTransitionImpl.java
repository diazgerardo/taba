package ar.com.scriptorum.workflow;

import java.util.Set;

public class CaseTransitionImpl extends Transition implements CaseTransition {

	private State defaultState;
	private SuiteCase suiteCase;
	
	public CaseTransitionImpl(SuiteCase suiteCase, State defaultState) {
		this.suiteCase = suiteCase;
		this.defaultState = defaultState;
	}

	@Override
	public State eval(Set<Condition> conditions) {
		State state = this.suiteCase.fetch(conditions); 
		return state != null ? state : this.defaultState;
	}

	@Override
	public State defaultState() {
		
		return defaultState;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName());
		sb.append(" suiteCase:"+this.suiteCase);
		sb.append(" defaultState:"+this.defaultState);
		return sb.toString();
	}
	
	@Override
	public Set<Condition> conditions() {
		return this.suiteCase.getSuite().keySet().iterator().next();
	}

}
