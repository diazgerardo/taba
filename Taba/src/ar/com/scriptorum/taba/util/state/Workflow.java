package ar.com.scriptorum.taba.util.state;

import java.util.List;

import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.interfaces.Transition;

public interface Workflow {

	public List<Transition> getWorkflow();
	public void add(Transition t);
	public State getCurrentState();
	public Transition getLastTransition();

}
