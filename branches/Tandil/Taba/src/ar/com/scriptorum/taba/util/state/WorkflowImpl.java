package ar.com.scriptorum.taba.util.state;

import java.util.List;

import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.interfaces.Transition;

public class WorkflowImpl implements Workflow {

	public List<Transition> getWorkflow() {
		throw new Error("unimplemented");
	}

	public void add(Transition t) {
		throw new Error("unimplemented");
	}

	public State getCurrentState() {
		throw new Error("unimplemented");
	}

	public Transition getLastTransition() {
		throw new Error("unimplemented");
	}

}
