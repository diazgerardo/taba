package ar.com.scriptorum.workflow;

import java.util.Set;

import ar.com.scriptorum.workflow.CaseTransitionTest;

/**
 * CaseTransition implements a transition from a known state to several other possible states 
 * based on an associated set of conditions
 * 
 * @see CaseTransitionTest junit for sample usage
 * 
 * @author GD21367
 *
 */
public interface CaseTransition {
	public State defaultState();
}
