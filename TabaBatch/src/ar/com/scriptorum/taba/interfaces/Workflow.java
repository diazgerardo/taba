package ar.com.scriptorum.taba.interfaces;

import java.util.List;

import ar.com.scriptorum.taba.util.state.State;


public interface Workflow <T>{
	
	public T getTarget();
	public List<SimpleTransition> getWorkflow();
	public void add(SimpleTransition t);
	public State getCurrentState();
	public SimpleTransition getLastTransition();
	public boolean transicionate();

}
