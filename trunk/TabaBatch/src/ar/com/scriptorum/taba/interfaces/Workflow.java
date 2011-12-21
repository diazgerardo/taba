package ar.com.scriptorum.taba.interfaces;

import java.util.List;


public interface Workflow {

	public List<Transition> getWorkflow();
	public void add(Transition t);
	public State getCurrentState();
	public Transition getLastTransition();
	public boolean transicionate();

}
