package ar.com.scriptorum.workflow;

import java.util.Date;
import java.util.List;

import com.citigroup.workflow.strategy.ConditionStrategy;

public interface Workflow <W> {
	public Long getId();
	public void setId(Long id);
	public WorkflowAble <W> getTarget();
	public Workflow <W> setTarget(WorkflowAble<W> target);
	public List<? extends Transition> getWorkflow();
	public void add(Transition t);
	public State getCurrentState();
	public Workflow<W> setCurrentState(Workflow<W> workflow);
	public Workflow<W> setCurrentState(State state);
	public Transition getLastTransition();
	public boolean transitionate();
	public List<State> getStates();
	public void initializeWorkflow(WorkflowAble t, CartographyFactory cartographyFactory, ConditionStrategy strategy);	
	public Date getDateModif();
	public void setDateModif(Date dateModif);
}
