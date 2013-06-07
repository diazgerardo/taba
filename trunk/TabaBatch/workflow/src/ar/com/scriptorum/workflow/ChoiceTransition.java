package ar.com.scriptorum.workflow;

public interface ChoiceTransition extends SimpleTransition {

	public State alternate();

}
