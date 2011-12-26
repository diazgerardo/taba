package ar.com.scriptorum.taba.workflows;

import java.util.List;

import ar.com.scriptorum.taba.interfaces.SimpleTransition;
import ar.com.scriptorum.taba.interfaces.Workflow;
import ar.com.scriptorum.taba.util.documents.AbstractDocument;
import ar.com.scriptorum.taba.util.state.State;

public class WorkflowImpl implements Workflow<AbstractDocument> {

	@Override
	public List<SimpleTransition> getWorkflow() {
		throw new Error("unimplemented");
	}

	@Override
	public void add(SimpleTransition t) {
		throw new Error("unimplemented");
	}

	@Override
	public State getCurrentState() {
		throw new Error("unimplemented");
	}

	@Override
	public SimpleTransition getLastTransition() {
		throw new Error("unimplemented");
	}

	@Override
	public boolean transicionate() {
		throw new Error("unimplemented");
	}

	@Override
	public AbstractDocument getTarget() {
		throw new Error("unimplemented");
	}

}
