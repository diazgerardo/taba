package ar.com.scriptorum.taba.workflows;

import java.util.List;

import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.util.state.Workflow;

public class WorkflowImpl implements Workflow {

	@Override
	public List<Transition> getWorkflow() {
		throw new Error("unimplemented");
	}

	@Override
	public void add(Transition t) {
		throw new Error("unimplemented");
	}

	@Override
	public State getCurrentState() {
		throw new Error("unimplemented");
	}

	@Override
	public Transition getLastTransition() {
		throw new Error("unimplemented");
	}

}
